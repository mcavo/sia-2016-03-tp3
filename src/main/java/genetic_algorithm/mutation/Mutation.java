package genetic_algorithm.mutation;

import model.chromosome.CharacterChromosome;

public interface Mutation {

	public CharacterChromosome mutate(CharacterChromosome chromosome);
	
}
