package model.character;

import java.util.List;

import model.item.Item;

public class Defensor2 extends Defensor {

	private static final double strengthItemModifier = 1.3;
	private static final double agilityItemModifier = 0.6;
	private static final double expertiseItemModifier = 0.6;
	private static final double resistanceItemModifier = 1.2;
	private static final double lifeItemModifier =  1.1;
	
	
	public Defensor2(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
}
