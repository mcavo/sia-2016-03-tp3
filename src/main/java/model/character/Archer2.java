package model.character;

import java.util.List;

import model.item.Item;

public class Archer2 extends Archer{

	private static final double strengthItemModifier = 0.5;
	private static final double agilityItemModifier = 1.2;
	private static final double expertiseItemModifier = 1.3;
	private static final double resistanceItemModifier = 0.7;
	private static final double lifeItemModifier =  0.6;
	
	
	public Archer2(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
	
}
