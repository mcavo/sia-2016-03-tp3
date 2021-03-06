package model.character;

import java.util.List;

import model.item.Item;

public class Warrior3 extends Warrior {

	private static final double strengthItemModifier = 1.1;
	private static final double agilityItemModifier = 0.6;
	private static final double expertiseItemModifier = 0.5;
	private static final double resistanceItemModifier = 1.2;
	private static final double lifeItemModifier =  1.1;
	
	
	public Warrior3(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
	
	
}
