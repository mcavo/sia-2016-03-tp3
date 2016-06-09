package genetic_algorithm.mutation;

import model.chromosome.CharacterChromosome;

public class ClassicMutation implements Mutation {

	//Chance for a chromosome to mutate
	private double pm;
	
	public ClassicMutation(double pm){
		this.pm = pm;
	}
	
	@Override
	public CharacterChromosome mutate(CharacterChromosome chromosome) {
		if(Math.random()<pm){
			return CharacterChromosome.getRandomChromosome();
		}
		return chromosome;
	}

}
