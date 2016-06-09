package genetic_algorithm.crossover;

import genetic_algorithm.Algorithm;

import java.util.List;

import model.chromosome.CharacterChromosome;

public interface Crossover {
	
	public void setAlgorithm(Algorithm algorithm);
	
	public List<CharacterChromosome> crossover(CharacterChromosome c1, CharacterChromosome c2);
	
}
