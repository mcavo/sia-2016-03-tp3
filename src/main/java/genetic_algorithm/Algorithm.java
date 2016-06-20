package genetic_algorithm;

import java.util.Collections;
import java.util.List;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.populator.CharacterChromosomePopulator;
import genetic_algorithm.selection.Selection;
import genetic_algorithm.stop_condition.AlgorithmStopCondition;
import genetic_algorithm.substitution.Substitution;
import model.chromosome.CharacterChromosome;
import model.data.Data;
import utils.ErrorDispersion;

public class Algorithm {

	private AlgorithmStopCondition stopCondition;
	private CharacterChromosomePopulator populator;
	private Mutation mutation;
	private Selection selection;
	private Crossover crossover;
	private Substitution substitution;
	private Data data;

	private List<CharacterChromosome> chromosomes;

	public Algorithm(CharacterChromosomePopulator populator,
			AlgorithmStopCondition stopCondition, Mutation mutation,
			Crossover crossover, Selection selection, Substitution substitution) {
		super();
		this.populator = populator;
		this.mutation = mutation;
		this.selection = selection;
		this.crossover = crossover;		
		this.stopCondition = stopCondition;		
		this.substitution = substitution;
		this.data = new Data();
	}

	public Data run() {

		chromosomes = populator.getInitialPopulation();
		this.selection.setAlgorithm(this);
		this.substitution.setAlgorithm(this);
		this.crossover.setAlgorithm(this);
		this.stopCondition.setAlgorithm(this);

		Collections.sort(chromosomes);
		
		data.setBestChromosome(chromosomes.get(0));
		data.addDiversityValue(refreshDiversity());
		data.addFitnessValue(chromosomes.get(0).fitness());
		
		while (stopCondition.hasToContinue()) {
			Collections.sort(chromosomes);
			if(data.getBestChromosome().fitness()< chromosomes.get(0).fitness()){
				data.setBestChromosome(chromosomes.get(0));
			}
			data.addFitnessValue(data.getBestChromosome().fitness());
			chromosomes = substitution.substitute();
			data.addGeneration();
			data.addDiversityValue(refreshDiversity());
		}

		return data;
	}
	
	public double getDiversity() {
		return data.getDiversity().get(data.getDiversity().size()-1);
	}

	private double refreshDiversity() {
		
		double strengthDiv[] = new double[chromosomes.size()];
		double expertiseDiv[] = new double[chromosomes.size()];
		double agilityDiv[] = new double[chromosomes.size()];
		double lifeDiv[] = new double[chromosomes.size()];
		double resistanseDiv[] = new double[chromosomes.size()];
		double heightDiv[] = new double[chromosomes.size()];
		for(int i = 0 ; i < chromosomes.size() ; i++) {
			strengthDiv[i] = chromosomes.get(i).getStrength();
			expertiseDiv[i] = chromosomes.get(i).getExpertise();
			agilityDiv[i] = chromosomes.get(i).getAgility();
			lifeDiv[i] = chromosomes.get(i).getLife();
			resistanseDiv[i] = chromosomes.get(i).getResistanse();
			heightDiv[i] = chromosomes.get(i).getHeight();
		}
		ErrorDispersion strengthDisp = new ErrorDispersion(strengthDiv);
		ErrorDispersion expertiseDisp = new ErrorDispersion(expertiseDiv);
		ErrorDispersion agilityDisp = new ErrorDispersion(agilityDiv);
		ErrorDispersion lifeDisp = new ErrorDispersion(lifeDiv);
		ErrorDispersion resistanseDisp = new ErrorDispersion(resistanseDiv);
		ErrorDispersion heightDisp = new ErrorDispersion(heightDiv);
		
		double ret = strengthDisp.getStdDev() / strengthDisp.getMean();
		ret += expertiseDisp.getStdDev() / expertiseDisp.getMean();
		ret += agilityDisp.getStdDev() / agilityDisp.getMean();
		ret += lifeDisp.getStdDev() / lifeDisp.getMean();
		ret += resistanseDisp.getStdDev() / resistanseDisp.getMean();
		ret += heightDisp.getStdDev() / heightDisp.getMean();
		
		return ret / 6;
	}

	public Crossover getCrossover(){
		return crossover;
	}

	public Selection getSelection() {
		return selection;
	}

	public Mutation getMutation() {
		return mutation;
	}

	public int getGenerations() {
		return data.getGenerations();
	}

	public List<CharacterChromosome> getChromosomes() {
		return chromosomes;
	}

	public CharacterChromosome getBestChromosome() {
		return data.getBestChromosome();
	}

	public void setChromosomes(List<CharacterChromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}
	
	

}
