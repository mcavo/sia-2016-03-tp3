package genetic_algorithm;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.populator.CharacterChromosomePopulator;
import genetic_algorithm.selection.Selection;
import genetic_algorithm.stop_condition.AlgorithmStopCondition;
import genetic_algorithm.substitution.Substitution;

import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;
import utils.ErrorDispersion;

public class Algorithm {

	private AlgorithmStopCondition stopCondition;
	private CharacterChromosomePopulator populator;
	private Mutation mutation;
	private Selection selection;
	private Crossover crossover;
	private Substitution substitution;
	private double diversity;

	private List<CharacterChromosome> chromosomes;

	private CharacterChromosome bestChromosome;
	private int generation;

	public Algorithm(CharacterChromosomePopulator populator,
			AlgorithmStopCondition stopCondition, Mutation mutation,
			Crossover crossover, Selection selection, Substitution substitution) {
		super();
		this.generation = 1;
		this.populator = populator;
		this.mutation = mutation;
		this.selection = selection;
		this.crossover = crossover;		
		this.stopCondition = stopCondition;		
		this.substitution = substitution;
	}

	public CharacterChromosome run() {

		chromosomes = populator.getInitialPopulation();
		this.selection.setAlgorithm(this);
		this.substitution.setAlgorithm(this);
		this.crossover.setAlgorithm(this);
		this.stopCondition.setAlgorithm(this);

		Collections.sort(chromosomes);
		bestChromosome = chromosomes.get(0);

		refreshDiversity();
		
		while (stopCondition.hasToContinue()) {
			Collections.sort(chromosomes);
			if(bestChromosome.fitness()< chromosomes.get(0).fitness()){
				bestChromosome = chromosomes.get(0);				
			}
			chromosomes = substitution.substitute();
			generation++;
			refreshDiversity();
		}

		return bestChromosome;
	}
	
	public double getDiversity() {
		return diversity;
	}

	private void refreshDiversity() {
		
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
		
		diversity = strengthDisp.getStdDev() / strengthDisp.getMean();
		diversity += expertiseDisp.getStdDev() / expertiseDisp.getMean();
		diversity += agilityDisp.getStdDev() / agilityDisp.getMean();
		diversity += lifeDisp.getStdDev() / lifeDisp.getMean();
		diversity += resistanseDisp.getStdDev() / resistanseDisp.getMean();
		diversity += heightDisp.getStdDev() / heightDisp.getMean();
		
		diversity /= 6;
		
		System.out.println(diversity);
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

	public int getGeneration() {
		return generation;
	}

	public List<CharacterChromosome> getChromosomes() {
		return chromosomes;
	}

	public CharacterChromosome getBestChromosome() {
		return bestChromosome;
	}

	public void setChromosomes(List<CharacterChromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}
	
	

}
