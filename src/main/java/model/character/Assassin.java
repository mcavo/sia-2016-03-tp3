package model.character;

import java.util.List;

import model.item.Item;

public class Assassin extends Character {

	private static final double attackModifier = 0.7 ;
	private static final double defenseModifier = 0.3 ;
	
	
	public Assassin(double strengthItemModifier, double agilityItemModifier,
			double expertiseItemModifier, double resistanceItemModifier,
			double lifeItemModifier, double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, attackModifier,
				defenseModifier, height, equipment);
	}
	
	
}
