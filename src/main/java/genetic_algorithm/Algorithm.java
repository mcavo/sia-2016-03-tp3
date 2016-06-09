package genetic_algorithm;

import genetic_algorithm.populator.CharacterChromosomePopulator;
import genetic_algorithm.stop_condition.AlgorithmStopCondition;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;
import model.chromosome.Chromosome;

public class Algorithm {

	private AlgorithmStopCondition stopCondition;
	private CharacterChromosomePopulator populator;

	private List<CharacterChromosome> chromosomes;

	private CharacterChromosome bestChromosome;
	private int generation;

	public Algorithm(CharacterChromosomePopulator populator,
			AlgorithmStopCondition stopCondition) {
		super();
		this.generation = 1;
		this.populator = populator;
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
