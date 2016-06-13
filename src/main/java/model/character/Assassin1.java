package model.character;
import java.util.List;

import model.item.Item;

public class Assassin1 extends Assassin {
	

	private static final double strengthItemModifier = 0.6;
	private static final double agilityItemModifier = 1.5;
	private static final double expertiseItemModifier = 1.3;
	private static final double resistanceItemModifier = 1.2;
	private static final double lifeItemModifier =  0.2;
	
	
	public Assassin1(double height, List<Item> equipment) {
		super(strengthItemModifier, agilityItemModifier, expertiseItemModifier,
				resistanceItemModifier, lifeItemModifier, height, equipment);
	}
	
	
	
}
