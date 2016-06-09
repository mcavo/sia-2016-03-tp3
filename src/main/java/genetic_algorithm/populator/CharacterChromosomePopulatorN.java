package genetic_algorithm.populator;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;
import model.item.ItemType;
import repo.ItemsRepo;

public class CharacterChromosomePopulatorN implements CharacterChromosomePopulator {

	
	private static double MIN_HEIGHT = 1.3;
	private static double MAX_HEIGHT = 2.0;
	
	
	private int n;

	public CharacterChromosomePopulatorN(int n) {
		super();
		this.n = n;
	}
	
	public List<CharacterChromosome> getInitialPopulation(){
		ItemsRepo itemsRepo = ItemsRepo.getInstance();
		List<CharacterChromosome> initialPopulation = new ArrayList<>();
		for(int i=0; i<n; i++){
			double height = Math.random()*(MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT;
			List<Double> genes = new ArrayList<>();
			for(ItemType itemType : ItemType.values()){
				genes.add(itemsRepo.getRandomIndex(itemType));
			}
			genes.add(height);
			initialPopulation.add(new CharacterChromosome(genes));
		}
		return initialPopulation;
	}
	
	
}
