package model.character;
import java.util.List;

import model.item.Item;

public class Assassin2 extends Assassin {
	

	private static final double strengthItemModifier = 0.7;
	private static final double agilityItemModifier = 1.1;
	private static final double expertiseItemModifier = 1.5;
	private static final double resistanceItemModifier = 1.1;
	private static final double lifeItemModifier =  0.7;
	
	
	public Assassin2(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
	
	
}
