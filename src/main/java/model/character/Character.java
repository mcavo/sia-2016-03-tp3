package model.character;

import java.util.List;

import model.chromosome.Chromosome;
import model.item.Item;

public abstract class Character {
	
	private final double strengthItemModifier;
	private final double agilityItemModifier;
	private final double expertiseItemModifier;
	private final double resistanceItemModifier;
	private final double lifeItemModifier;	
	
	private final double attackModifier;
	private final double defenseModifier;
		
	private double itemStrenght;
	private double itemResistanse;
	private double itemLife;
	private double itemExpertise;
	private double itemAgility;
		
	private final double height;	
	private final List<Item> equipment;
	
	private double performance;

		
	public Character(double strengthItemModifier, double agilityItemModifier,
			double expertiseItemModifier, double resistanceItemModifier,
			double lifeItemModifier, double attackModifier, double defenseModifier, 
			double height, List<Item> equipment) {
		super();
		this.strengthItemModifier = strengthItemModifier;
		this.agilityItemModifier = agilityItemModifier;
		this.expertiseItemModifier = expertiseItemModifier;
		this.resistanceItemModifier = resistanceItemModifier;
		this.lifeItemModifier = lifeItemModifier;
		this.attackModifier = attackModifier;
		this.defenseModifier = defenseModifier;
		this.height = height;
		this.equipment = equipment;
		loadItemStats();
		calculatePerformance();
	}
	

	private void loadItemStats() {
		itemAgility = 0;
		itemExpertise = 0;
		itemLife = 0;
		itemStrenght = 0;
		itemResistanse = 0;
		for(Item item : equipment){
			itemAgility += item.getAgility();
			itemExpertise += item.getExpertice();
			itemLife += item.getLife();
			itemStrenght += item.getStrength();
			itemResistanse += item.getResistanse();
		}
	}
	
	public double getPerformance(){
		return performance;
	}

	private void calculatePerformance() {
		performance = attackModifier * getAttack() + defenseModifier * getDefense();
	}
	
	
	public double getStrength() {
		return 100*Math.tanh(0.01*itemStrenght*strengthItemModifier);
	}


	public double getExpertise() {
		return 0.6*Math.tanh(0.01*itemExpertise*expertiseItemModifier);
	}


	public double getAgility() {
		return Math.tanh(0.01*itemAgility*agilityItemModifier);
	}

	public double getLife() {
		return 100*Math.tanh(0.01*itemLife*lifeItemModifier);
	}

	public double getResistanse() {
		return Math.tanh(0.01*itemResistanse*resistanceItemModifier);
	}
	
	public double getAttack(){
		return (getAgility() + getExpertise()) * getStrength() * getItemAttackModifier();
	}

	public double getDefense(){
		return (getResistanse() + getExpertise()) * getLife() * getItemDefenseModifier();
	}
	
	private double getItemAttackModifier() {
		return 0.5 - Math.pow((3*height -5),4) + Math.pow((3*height -5), 2) + height/2;
	}

	private double getItemDefenseModifier() {
		return 2 + Math.pow((3*height - 5),4) - Math.pow((3*height - 5),2) - height/2;
	}
	
	public String getCaracteristics() {
		String ret = "Tanh coeficients:";
		ret += "\n\tStregth:\t" + 0.01*itemStrenght*strengthItemModifier;
		ret += "\n\tExpertise:\t" + 0.01*itemExpertise*expertiseItemModifier;
		ret += "\n\tAgility:\t" + 0.01*itemAgility*agilityItemModifier;
		ret += "\n\tLife:\t\t" + 0.01*itemLife*lifeItemModifier;
		ret += "\n\tResistanse:\t" + 0.01*itemResistanse*resistanceItemModifier;
		return ret;
	}
	
}
