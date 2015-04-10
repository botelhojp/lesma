package lemas.trust.metrics;

import jade.lang.acl.ACLMessage;
import lemas.agent.LemasAgent;
import lemas.trust.data.RatingCache;
import lesma.annotations.Metrics;
import openjade.ontology.Rating;
import openjade.ontology.RatingAttribute;
import weka.core.Instance;

@Metrics(name = "Points Value")
public class PointsMetrics extends AbstractIMetric {

	private double cost = 0.0;
	private double benefit = 0.0;
	
	public PointsMetrics() {
		super();
		LemasAgent.resetCountMessage();		
	}

	public void preProcess(Instance instance) {
	}
	
	@Override
	public double prosProcess(ACLMessage msg) {
		if (msg.getContent().contains(";")) {
			System.out.println(msg.getContent());
			String[] tokens = msg.getContent().split(";");
			String options = tokens[0];
			Integer id = Integer.parseInt(tokens[1]);
			Rating r = RatingCache.remove(id);
			Clazz clazz = Classes.getClass(r.getValue());
			if (options.equals("AGREE")){
				RatingAttribute ra = (RatingAttribute) r.getAttributes().get(5);
				double value = Double.parseDouble(ra.getValue());
				cost+= value;
				benefit+= (value * clazz.getValue());
			}			
		}		
		double value = 100 * (benefit/cost);
		return super.put(value);
	}
}