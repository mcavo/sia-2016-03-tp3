package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.List;

import model.chromosome.CharacterChromosome;

public interface Selection {

	
	
	public void setAlgorithm(Algorithm algorithm);
	
	public void initialize();
	
	public List<CharacterChromosome> select(int n);
	
	}
