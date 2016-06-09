package genetic_algorithm.selection;

import java.util.List;

import model.chromosome.CharacterChromosome;

public interface Selection {

	
	
	public void setAlgorithm();
	
	public void initialize();
	
	public List<CharacterChromosome> select(int n);
	
	
	
	
}
