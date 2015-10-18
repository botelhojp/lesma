package lemas.agent;

import jade.content.ContentElement;
import jade.core.AID;
import jade.lang.acl.ACLMessage;

import java.util.List;

import lemas.Round;
import lemas.agent.behaviour.LoaderBehaviour;
import lemas.db.LemasDB;
import lemas.form.DialogResult;
import lemas.form.FrameProject;
import lemas.trust.metrics.IMetrics;
import openjade.core.OpenAgent;
import openjade.core.annotation.ReceiveMatchMessage;
import openjade.core.annotation.ReceiveSimpleMessage;
import openjade.ontology.RequestRating;
import openjade.ontology.WitnessResponse;
import openjade.trust.ITrustModel;
import openjade.trust.WitnessUtil;

public class AgentLoader extends OpenAgent {

	private static AgentLoader instance;
	private static final long serialVersionUID = 1L;
	private int wait = 0;;
	private static int executions = -1;
	private LoaderBehaviour loader;
	private LemasDB db;
	private double sum;
	private Round round = Round.getInstance();;
	
	public static AgentLoader getInstance(){
		return instance;
	}

	@Override
	public void setup() {
		super.setup();
		wait = 0;
		round.clear();
		round.setRange(500);
		sum=0;
		executions++;
		db = new LemasDB(FrameProject.getInstance().getSaveDB());
		db.connect();
		loader = new LoaderBehaviour(this, getTrustModelClass(), getMetricsClass());
		addBehaviour(loader);
		instance = this;
	}

	/**
	 * Recebe confirmacao de destruicao do agente
	 * 
	 * @param message
	 */
	@ReceiveSimpleMessage(conversationId = ConversationId.DO_DELETE)
	public void dead(ACLMessage message) {
		loader.removerCache(message.getSender());
	}

	/**
	 * 
	 * @param msg
	 */
	@ReceiveSimpleMessage(conversationId = ConversationId.TEST)
	public void getTestMessage(ACLMessage msg) {
		if (round.changed()){
			addResult(executions, round.getRound()-1, sum/round.getRange());
			sum = 0;
		}else{
			sum += loader.posProcess(msg);
		}
		wait--;
	}
	
	@ReceiveSimpleMessage(conversationId = ConversationId.NEXT)
	public void getNextMessage(ACLMessage msg) {
		System.out.println(msg.toString());
	}
	
	/**
	 * Recebe um pedido para informar testemunhas de um agente
	 * @param message
	 */
	@ReceiveMatchMessage(performative = ACLMessage.REQUEST, conversationId = ConversationId.GET_INDIRECT, action = RequestRating.class)
	public void requestWitness(ACLMessage message, ContentElement ce) {
		RequestRating sr = (RequestRating) ce;
		List<AID> list = WitnessUtil.getWitness(sr.getAid());
		WitnessResponse wr = new WitnessResponse();
		wr.setServer(sr.getAid());
		for (AID aid : list) {
			wr.addWitnesses(aid);	
		}
		sendMessage(message.getSender(), ACLMessage.INFORM, ConversationId.GET_INDIRECT, wr);
	}
	
	public void addResult(int executions, double round, double value){
		if (FrameProject.getInstance().getVerResult()){
			DialogResult dl = DialogResult.getInstance();
			dl.addResult(executions, round, value);			
		}
		db.save(executions, round, value);
	}

	public void waiting() {
		wait++;
	}

	public boolean nowait() {
		return (wait==0);
	}

	@SuppressWarnings("unchecked")
	private Class<ITrustModel> getTrustModelClass() {
		try {
			return (Class<ITrustModel>) Class.forName(FrameProject.getInstance().getCurrentProject().getClazz());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Modelo de Confiancao nao selecionado", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private Class<IMetrics> getMetricsClass() {
		try {
			return (Class<IMetrics>) Class.forName(FrameProject.getInstance().getCurrentProject().getMetricsClass());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Metrica nao selecionada", e);
		}
	}

	public void stop() {
		db.close();
		loader.stop();		
	}
}
