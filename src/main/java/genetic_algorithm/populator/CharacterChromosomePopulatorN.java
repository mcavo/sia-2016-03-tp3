package genetic_algorithm.populator;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;
import model.item.ItemType;
import repo.ItemsRepo;

public class CharacterChromosomePopulatorN implements CharacterChromosomePopulator {

	

	
	
	private int n;

	public CharacterChromosomePopulatorN(int n) {
		super();
		this.n = n;
	}
	
	public List<CharacterChromosome> getInitialPopulation(){
		List<CharacterChromosome> initialPopulation = new ArrayList<>();
		for(int i=0; i<n; i++){
			initialPopulation.add(CharacterChromosome.getRandomChromosome());
		}
		return initialPopulation;
	}
	
	
}
