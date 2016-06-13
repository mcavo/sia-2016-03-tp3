package model.character;

import java.util.List;

import model.item.Item;

public class Warrior extends Character {

	private static final double attackModifier = 0.6 ;
	private static final double defenseModifier = 0.4 ;
	
	
	public Warrior(double strengthItemModifier, double agilityItemModifier,
			double expertiseItemModifier, double resistanceItemModifier,
			double lifeItemModifier, double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, attackModifier,
				defenseModifier, height, equipment);
	}
	
	
	
	
}
