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

public class Algorithm {

	private AlgorithmStopCondition stopCondition;
	private CharacterChromosomePopulator populator;
	private Mutation mutation;
	private Selection selection;
	private Crossover crossover;
	private Substitution substitution;

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
		this.selection.setAlgorithm(this);
		this.crossover = crossover;
		this.crossover.setAlgorithm(this);
		this.stopCondition = stopCondition;
		this.stopCondition.setAlgorithm(this);
		this.substitution = substitution;
		this.substitution.setAlgorithm(this);
	}

	public CharacterChromosome run() {

		chromosomes = populator.getInitialPopulation();

		Collections.sort(chromosomes);
		bestChromosome = chromosomes.get(0);

		while (stopCondition.hasToContinue()) {
			Collections.sort(chromosomes);
			bestChromosome = chromosomes.get(0);
			chromosomes = substitution.substitute();
			generation++;
		}

		return bestChromosome;
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
