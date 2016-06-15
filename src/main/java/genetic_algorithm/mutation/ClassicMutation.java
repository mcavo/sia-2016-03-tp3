package genetic_algorithm.mutation;

import repo.ItemsRepo;
import model.chromosome.CharacterChromosome;
import model.item.ItemType;

public class ClassicMutation implements Mutation {

	//Chance for a chromosome to mutate
	private double pm;
	
	public ClassicMutation(double pm){
		this.pm = pm;
	}
	
	@Override
	public CharacterChromosome mutate(CharacterChromosome chromosome) {
		if(Math.random()<pm){
			int position =(int)Math.random()*chromosome.getGenes().size();
			chromosome.getGenes().remove(position);
			chromosome.getGenes().add(position, ItemsRepo.getInstance().getRandomIndex(ItemType.values()[position]));
		}
		return chromosome;
	}

}
