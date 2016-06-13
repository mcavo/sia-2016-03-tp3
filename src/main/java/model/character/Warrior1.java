package model.character;

import java.util.List;

import model.item.Item;

public class Warrior1 extends Warrior {

	private static final double strengthItemModifier = 1.2;
	private static final double agilityItemModifier = 0.6;
	private static final double expertiseItemModifier = 0.3;
	private static final double resistanceItemModifier = 1.0;
	private static final double lifeItemModifier =  0.9;
	
	
	public Warrior1(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
	
	
}
