package model.chromosome;

import java.util.ArrayList;
import java.util.List;

import model.character.*;
import model.character.Character;
import model.item.Item;
import model.item.ItemType;
import repo.ItemsRepo;
import config.Configuration;

public class CharacterChromosome implements Chromosome, Comparable<CharacterChromosome> {

	private static int HEIGHT_INDEX = 5;
	private static double EPSILON = 1E-1;
	
	private Double fitness;

	// Contains the height and the index of the equipment on the list
	// Order is : BOOTS-> WEAPON-> HELMET-> GLOVES-> CHEST-> HEIGHT
	List<Double> genes;

	public CharacterChromosome(List<Double> genes) {
		this.genes = genes;
		calculateFitness();
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
}
