package genetic_algorithm.mutation;

import java.util.ArrayList;
import java.util.List;

import repo.ItemsRepo;
import model.chromosome.CharacterChromosome;
import model.item.ItemType;

public class NotUniformMutation implements Mutation {

	//Chance for a gene in a chromoson to mutate
	private double pg;
	
	public NotUniformMutation(double pg) {
		this.pg = pg;
	}
	
	@Override
	public CharacterChromosome mutate(CharacterChromosome chromosome) {
		ItemsRepo itemsRepo = ItemsRepo.getInstance();
		List<Double> sampleGenes = chromosome.getGenes();
		List<Double> mutationGenes = new ArrayList<>();
		for(ItemType itemType : ItemType.values()){
			if(Math.random()<pg){
				mutationGenes.add(itemsRepo.getRandomIndex(itemType));
			}else{
				mutationGenes.add(sampleGenes.get(itemType.ordinal()));
			}
		}
		if(Math.random()<pg){
			mutationGenes.add(CharacterChromosome.getRandomHeight());
		} else {
			mutationGenes.add(sampleGenes.get(CharacterChromosome.HEIGHT_INDEX));
		}
		return new CharacterChromosome(mutationGenes);
	}
}
