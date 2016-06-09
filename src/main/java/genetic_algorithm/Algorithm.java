package genetic_algorithm;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.populator.CharacterChromosomePopulator;
import genetic_algorithm.stop_condition.AlgorithmStopCondition;

import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class Algorithm {

	private AlgorithmStopCondition stopCondition;
	private CharacterChromosomePopulator populator;
	private Mutation mutation;
	private Crossover crossover;

	private List<CharacterChromosome> chromosomes;

	private CharacterChromosome bestChromosome;
	private int generation;

	public Algorithm(CharacterChromosomePopulator populator,
			AlgorithmStopCondition stopCondition, Mutation mutation,
			Crossover crossover) {
		super();
		this.generation = 1;
		this.populator = populator;
		this.mutation = mutation;
		this.crossover = crossover;
		this.crossover.setAlgorithm(this);
		this.stopCondition = stopCondition;
		this.stopCondition.setAlgorithm(this);
	}

	public CharacterChromosome run() {

		chromosomes = populator.getInitialPopulation();

		Collections.sort(chromosomes);
		bestChromosome = chromosomes.get(0);

		while (stopCondition.hasToContinue()) {
			// SELECCIONO PARA REPRODUCIR
			// LOS CRUZO ( VEO DE MUTAR HIJOS )
			// EVALUO FITNESS DE LOS NUEVOS
			// FILTRO PARA NUEVA GENERACION
			generation++;
		}

		return null;
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

}
