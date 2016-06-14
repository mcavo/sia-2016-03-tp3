package model.chromosome;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import model.character.*;
import model.character.Character;
import model.item.Item;
import model.item.ItemType;
import repo.ItemsRepo;
import config.Configuration;

public class CharacterChromosome implements Chromosome, Comparable<CharacterChromosome> {

	public static int HEIGHT_INDEX = 5;
	private static double EPSILON = 1E-1;
	private static double MIN_HEIGHT = 1.3;
	private static double MAX_HEIGHT = 2.0;
	
	private Double fitness;

	// Contains the height and the index of the equipment on the list
	// Order is : BOOTS-> WEAPON-> HELMET-> GLOVES-> CHEST-> HEIGHT
	List<Double> genes;

	public CharacterChromosome(List<Double> genes) {
		this.genes = genes;
		calculateFitness();
	}
	
	public List<Double> getGenes() {
		return genes;
	}



	public Double fitness(){
		return fitness;
	}
	
	public void calculateFitness() {
		ItemsRepo itemsRepo = ItemsRepo.getInstance();
		List<Item> equipment = new ArrayList<>();
		for (ItemType itemType : ItemType.values()) {
			equipment.add(itemsRepo.get(itemType,
					(int) (genes.get(itemType.ordinal()) + EPSILON)));
		}
		Character character = CharacterFactory
				.create(Configuration.DEFAULT_CLASS, genes.get(HEIGHT_INDEX),
						equipment);
		fitness = character.getPerformance();
		return;
	}

	@Override
	public int compareTo(CharacterChromosome o) {
		return -(fitness().compareTo(o.fitness()));
	}

	public static CharacterChromosome getRandomChromosome() {
		ItemsRepo itemsRepo = ItemsRepo.getInstance();
		double height = getRandomHeight();
		List<Double> genes = new ArrayList<>();
		for(ItemType itemType : ItemType.values()){
			genes.add(itemsRepo.getRandomIndex(itemType));
		}
		genes.add(height);
		return new CharacterChromosome(genes);
	}
	
	public static double getRandomHeight(){
		return Math.random()*(MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT;
	}
}
