package model.character;

import java.util.List;

import model.item.Item;

public class Archer1 extends Archer {


	private static final double strengthItemModifier = 0.6;
	private static final double agilityItemModifier = 1.3;
	private static final double expertiseItemModifier = 1.2;
	private static final double resistanceItemModifier = 0.6;
	private static final double lifeItemModifier =  0.5;
	
	
	public Archer1(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
	
	
}
