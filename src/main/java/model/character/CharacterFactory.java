package model.character;

import java.util.List;

import model.item.Item;

public class CharacterFactory {

	public static Character create(String characterClass, double height, List<Item> equipment){
		switch(characterClass){
		case "Warrior1" :
			return new Warrior1(height, equipment);
		case "Warrior2" :
			return new Warrior2(height, equipment);
		case "Warrior3" :
			return new Warrior3(height, equipment);
		case "Archer1" :
			return new Archer1(height, equipment);
		case "Archer2" :
			return new Archer2(height, equipment);
		case "Assassin1" :
			return new Assassin2(height, equipment);
		case "Assassin2" :
			return new Assassin2(height, equipment);
		case "Defensor1" :
			return new Defensor1(height, equipment);
		case "Defensor2" :
			return new Defensor2(height, equipment);
		}
		return null;
	}
	
	
	
	
}
