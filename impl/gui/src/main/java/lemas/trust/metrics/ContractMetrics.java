package lemas.trust.metrics;

import java.util.ArrayList;
import java.util.List;

import jade.lang.acl.ACLMessage;
import lesma.annotations.Metrics;
import weka.core.Instance;

@Metrics(name = "Contract Value", file = "contract_value")
public class ContractMetrics extends AbstractIMetric {

	private List<Instance> instances = new ArrayList<Instance>();
	private String currentContract = null;
	double valorTotal = 0;

	@Override
	public void preProcess(Instance instance) {
		String contrato = instance.toString(3);
		if (currentContract != null && !currentContract.equals(contrato) && !instances.isEmpty()) {
			calcular(instances);
			instances.clear();
		}
		instances.add(instance);
		currentContract = contrato;
	}
	
	public double prosProcess(ACLMessage msg) {
		return valorTotal;
	}

	private void calcular(List<Instance> instances) {
		System.out.println("============================");
		System.out.println("Contrato............: " + instances.get(0).toString(3));
		double total = 0;
		for (Instance instance : instances) {
			total += Long.parseLong(instance.toString(6));
		}
		
		valorTotal = 0;
		for (Instance instance : instances) {
			double peso = (double) Long.parseLong(instance.toString(6)) / total;
			double nota = nota(instance.toString(7));
			double notaponderada = peso*nota;
			valorTotal+= notaponderada;
			System.out.println(instance.toString(5) + "............: peso = " + peso + " nota = " + nota + " valor = " + notaponderada) ;
		}
		System.out.println("Valor total: " + valorTotal);
		System.out.println("============================");

	}

	private double nota(String value) {
		if (value.equalsIgnoreCase("pessimo")){
			return 0.0;
		}
		if (value.equalsIgnoreCase("ruim")){
			return 0.25;
		}
		if (value.equalsIgnoreCase("regular")){
			return 0.50;
		}
		if (value.equalsIgnoreCase("bom")){
			return 0.75;
		}
		if (value.equalsIgnoreCase("otimo")){
			return 1.0;
		}
		throw new RuntimeException("item invalido[" + value + "]");
	}

	

}
