package model.data;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class Data {
	
	private CharacterChromosome bestChromosome;
	private List<Double> fitness;
	private List<Double> diversity;
	private int generations;
	
	public Data() {
		super();
		fitness = new ArrayList<>();
		diversity = new ArrayList<>();
		generations = 1;
	}
	
	public void addFitnessValue(double fitting) {
		this.fitness.add(fitting);
	}
	
	public void addDiversityValue(double diversity) {
		this.diversity.add(diversity);
	}
	
	public void addGeneration() {
		this.generations++;
	}

	public void setBestChromosome(CharacterChromosome bestChromosome) {
		this.bestChromosome = bestChromosome;
	}

	public List<Double> getFitness() {
		return fitness;
	}
	
	public List<Double> getDiversity() {
		return diversity;
	}

	public int getGenerations() {
		return generations;
	}

	public CharacterChromosome getBestChromosome() {
		return bestChromosome;
	}

}
