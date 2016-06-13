package model.character;

import java.util.List;

import model.item.Item;

public class Warrior2 extends Warrior {

	private static final double strengthItemModifier = 1.3;
	private static final double agilityItemModifier = 0.5;
	private static final double expertiseItemModifier = 0.3;
	private static final double resistanceItemModifier = 1.1;
	private static final double lifeItemModifier =  0.8;
	
	
	public Warrior2(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
	
	
}
