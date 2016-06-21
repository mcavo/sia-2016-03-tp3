package model.chromosome;

import java.util.ArrayList;
import java.util.List;

import config.Configuration;
import model.character.Character;
import model.character.CharacterFactory;
import model.item.Item;
import model.item.ItemType;
import repo.ItemsRepo;

public class CharacterChromosome implements Chromosome, Comparable<CharacterChromosome> {

	public static int HEIGHT_INDEX = 5;
	private static double EPSILON = 1E-1;
	private static double MIN_HEIGHT = 1.3;
	private static double MAX_HEIGHT = 2.0;
	
	private Character character;
	
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
		character = CharacterFactory
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
	
	public String toString() {
		String ret = "Rol: " + Configuration.DEFAULT_CLASS + "\n\n";
		ret += "Equipment:\n";
		for (ItemType item : ItemType.values()) {
			ret += "\t" + item.name() + ":\t" + genes.get(item.ordinal()) + "\n";
		}
		ret += "\nHeight: " + genes.get(HEIGHT_INDEX);
		ret += "\n\nStats:";
		ret += "\n\tAttack:\t" + character.getAttack();
		ret += "\n\tDefense: " + character.getDefense();
		ret+= "\n\nFitness: " + fitness;
		return ret;
	}
	
	public double getStrength() {
		return character.getStrength();
	}


	public double getExpertise() {
		return character.getExpertise();
	}


	public double getAgility() {
		return character.getAgility();
	}

	public double getLife() {
		return character.getLife();
	}

	public double getResistanse() {
		return character.getResistanse();
	}
	
	public double getHeight() {
		return genes.get(HEIGHT_INDEX);
	}
}
