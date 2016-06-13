package model.character;

import java.util.List;

import model.item.Item;

public class Defensor1 extends Defensor {

	private static final double strengthItemModifier = 1.1;
	private static final double agilityItemModifier = 0.7;
	private static final double expertiseItemModifier = 0.4;
	private static final double resistanceItemModifier = 1.4;
	private static final double lifeItemModifier =  1.2;
	
	
	public Defensor1(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
}
