package lemas.agent;

import java.util.List;

import jade.content.ContentElement;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.util.leap.Iterator;
import lemas.agent.behaviour.SendMessageBehavior;
import lemas.model.LemasLog;
import lemas.model.Runner;
import lemas.trust.metrics.Classes;
import openjade.core.OpenAgent;
import openjade.core.OpenJadeException;
import openjade.core.annotation.ReceiveMatchMessage;
import openjade.core.annotation.ReceiveSimpleMessage;
import openjade.ontology.Rating;
import openjade.ontology.RequestRating;
import openjade.ontology.SendRating;
import openjade.ontology.WitnessResponse;
import openjade.trust.ITrustModel;

public class LemasAgent extends OpenAgent {

	private static final long serialVersionUID = 1L;
	public static final String SERVICE = "LEMAS";
	private SendMessageBehavior tb;
	protected static long countMessages = 0;
	protected boolean iamMalicious = false;

	/**
	 * Inicialização
	 */
	@SuppressWarnings("unchecked")
	protected void setup() {
		super.setup();
		loadTrustModel((Class<ITrustModel>) getArguments()[0]);
		trustModel.setProperties(Runner.currentProject.getProperties());
		LemasLog.info("agent setup: " + _getLocalName());
		tb = new SendMessageBehavior(this);
		addBehaviour(tb);
		registerService(SERVICE);
		defineMalicious(_getLocalName());
	}

	private void defineMalicious(String localName) {
		String[] tokens = localName.toLowerCase().split("_");
		if (tokens != null && tokens.length > 1){
			String lastToken = tokens[tokens.length-1];
			if (lastToken.equals("m")){
				iamMalicious = true;
			}
		}
	}

	/**
	 * Se destroi quando solicitado pelo agente loader
	 * 
	 * @param message
	 */
	@ReceiveSimpleMessage(performative = ACLMessage.REQUEST, conversationId = ConversationId.DO_DELETE)
	public void dead(ACLMessage message) {
		super.deregister(SERVICE);
		sendMessage(message.getSender(), ACLMessage.INFORM, ConversationId.DO_DELETE, "");
		this.doDelete();
	}
	
	public String _getLocalName(){
		return getLocalName();
	}
	
	public AID _getAID(){
		return getAID();
	}
	
	// Operacoes assincronas
	
	public void test(AID aid){
		tb.test(aid);
	}	
	
	public void requestDossie(AID aid){
		tb.requestDossie(aid);
	}
	
	public void findWitness(AID aid) {
		tb.findWitness(aid);
	}

	public void wantWitness(AID aid) {
//		tb.wantWitness(aid);
	}

	// ==== GERAL ====
	
	/**
	 * Cliente envia feedback ao servidor e ao loader
	 * 
	 * @param message
	 * @param ce
	 */
	@ReceiveMatchMessage(conversationId = ConversationId.START_ITERATE, action = SendRating.class)
	public void receiveTestIterate(ACLMessage message, ContentElement ce) {
		SendRating sr = (SendRating) ce;
		Rating rating = (Rating) sr.getRating().get(0);
		sendMessage(rating.getServer(), ACLMessage.REQUEST, ConversationId.SEND_FEEDBACK, sr);
		//TODO verificar porque não é adicionado
		//trustModel.addRating(rating);
		trustModel.setTest(rating);
	}
	
	/**
	 * Servidor recebendo um feedback e quarda referencia da testemunha e
	 * avaliacao se do modelo dossie
	 * 
	 * @param message
	 * @param ce
	 */
	@ReceiveMatchMessage(conversationId = ConversationId.SEND_FEEDBACK, action = SendRating.class)
	public void receiveFeedback(ACLMessage message, ContentElement ce) {
		SendRating sr = (SendRating) ce;
		Rating rating = (Rating) sr.getRating().get(0);
		trustModel.addRating(rating);
		if (!rating.getServer().equals(_getAID())) {
			throw new OpenJadeException("Esta avaliacao nao he minha: " + message.toString());
		}
	}
	
	// ==== DOSSIE ====
	
	/**
	 * Recebe um pedido para enviar seu dossie
	 * 
	 * @param message
	 */
	@ReceiveSimpleMessage(performative = ACLMessage.REQUEST, conversationId = ConversationId.GET_DOSSIE)
	public void requestDossie(ACLMessage message) {
		SendRating sr = new SendRating();
		List<Rating> rs = trustModel.getDossie();
		for (Rating rating : rs) {
			if (iamMalicious){
				rating.setValue(Classes.getClass(1).getName());
			}
			sr.addRating(rating);
		}
		sendMessage(message.getSender(), ACLMessage.INFORM, ConversationId.GET_DOSSIE, sr);
	}

	/**
	 * Recebe o dossie solicitado
	 * 
	 * @param message
	 */
	@ReceiveMatchMessage(performative = ACLMessage.INFORM, conversationId = ConversationId.GET_DOSSIE, action = SendRating.class)
	public void responseDossie(ACLMessage message, ContentElement ce) {
		SendRating sr = (SendRating) ce;
		Iterator it = sr.getAllRating();
		while (it.hasNext()) {			
			Rating rating = (Rating) it.next();
			if (!rating.getClient().equals(this._getAID())){
				trustModel.addRatingFromWitness(rating);	
			}
		}
		tb.test(message.getSender());
	}

	// ==== INDIRETO ====

	/**
	 * Recebe do loader um conjunto de testemunhas
	 * 
	 * @param message
	 * @param ce
	 */
	private static int done = 0;
	@ReceiveMatchMessage(conversationId = ConversationId.GET_INDIRECT, performative = ACLMessage.INFORM, action = WitnessResponse.class)
	public void responseWitnessRequest2(ACLMessage message, ContentElement ce) {
		WitnessResponse wr = (WitnessResponse) ce;
		Iterator it = wr.getAllWitnesses();
		while (it.hasNext()) {
			AID aid = (AID) it.next();
			RequestRating rr = new RequestRating();
			rr.setAid(wr.getServer());
			done++;
			sendMessage(aid, ACLMessage.REQUEST, ConversationId.REQUEST_REPUTATION, rr);
		}
	}

	/**
	 * Informa, como uma testemunha, a reputação de um certo agente.
	 * 
	 * @param message
	 * @param ce
	 */
	
	@ReceiveMatchMessage(conversationId = ConversationId.REQUEST_REPUTATION, performative = ACLMessage.REQUEST, action = RequestRating.class)
	public void responseWitnessRequest3(ACLMessage message, ContentElement ce) {
//		RequestRating rr = (RequestRating) ce;
//		List<Rating> list = getTrustModel().getRatings(rr.getAid());
//		SendRating sr = new SendRating();
//		for (Rating rating : list) {
//			sr.addRating(rating);
//		}
//		sendMessage(message.getSender(), ACLMessage.INFORM, ConversationId.REQUEST_REPUTATION, sr);
	}
	
	/**
	 * Recebe testemunhos sobre o agente solicitado
	 * 
	 * @param message
	 * @param ce
	 */
	@ReceiveMatchMessage(conversationId = ConversationId.REQUEST_REPUTATION, performative = ACLMessage.INFORM, action = SendRating.class)
	public void responseWitnessRequest4(ACLMessage message, ContentElement ce) {
		done--;
		SendRating rr = (SendRating) ce;
		Iterator it = rr.getAllRating();
		while (it.hasNext()) {
//			Rating rt = (Rating) it.next();
//			listPendingRating.add(rt);
		}
		if (done == 0){
			tb.resume();
		}
	}
	
	@Override
	public void sendMessage(ACLMessage msg) {
		countMessages++;
		super.sendMessage(msg);
	}
	
	public static void resetCountMessage(){
		countMessages = 0;
	}
	
	public static long countMessage(){
		return countMessages;
	}
}
