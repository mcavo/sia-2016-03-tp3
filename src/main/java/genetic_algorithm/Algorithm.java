package genetic_algorithm;

import java.util.Collections;
import java.util.List;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.diversity.DiversityCalculator;
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
	private DiversityCalculator diversityCalculator;
	private Data data;

	private List<CharacterChromosome> chromosomes;

	public Algorithm(CharacterChromosomePopulator populator,
			AlgorithmStopCondition stopCondition, Mutation mutation,
			Crossover crossover, Selection selection,
			Substitution substitution, DiversityCalculator diversityCalculator) {
		super();
		this.populator = populator;
		this.mutation = mutation;
		this.selection = selection;
		this.crossover = crossover;
		this.stopCondition = stopCondition;
		this.substitution = substitution;
		this.diversityCalculator = diversityCalculator;
		this.data = new Data();
	}

	public Data run() {

		chromosomes = populator.getInitialPopulation();
		this.selection.setAlgorithm(this);
		this.substitution.setAlgorithm(this);
		this.crossover.setAlgorithm(this);
		this.stopCondition.setAlgorithm(this);
		this.diversityCalculator.setAlgorithm(this);
		
		Collections.sort(chromosomes);

		data.setBestChromosome(chromosomes.get(0));
		data.addDiversityValue(refreshDiversity());
		data.addFitnessValue(chromosomes.get(0).fitness());
		while (stopCondition.hasToContinue()) {
			Collections.sort(chromosomes);
			if (data.getBestChromosome().fitness() < chromosomes.get(0)
					.fitness()) {
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
		return data.getDiversity().get(data.getDiversity().size() - 1);
	}

	private double refreshDiversity() {

		return diversityCalculator.calculateDiversity();
	}

	public Crossover getCrossover() {
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
