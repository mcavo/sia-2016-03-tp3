package genetic_algorithm.substitution;

import genetic_algorithm.Algorithm;

import java.util.List;

import model.chromosome.CharacterChromosome;

public interface Substitution {
	
	public void setAlgorithm(Algorithm algorithm);
	
	
	public List<CharacterChromosome> substitute();
	
}
