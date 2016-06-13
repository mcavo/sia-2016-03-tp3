package model.character;

import java.util.List;

import model.item.Item;

public class Archer extends Character {

	private static final double attackModifier = 0.9 ;
	private static final double defenseModifier = 0.1 ;
	
	
	public Archer(double strengthItemModifier, double agilityItemModifier,
			double expertiseItemModifier, double resistanceItemModifier,
			double lifeItemModifier, double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, attackModifier,
				defenseModifier, height, equipment);
	}
	
	
	
}
