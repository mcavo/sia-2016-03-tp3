package model.character;

import java.util.List;

import model.item.Item;

public class CharacterFactory {

	public static Character create(String characterClass, double height, List<Item> equipment){
		switch(characterClass){
		case "Assassin2" :
			return new Assassin2(height, equipment);
		}
		return null;
	}
	
	
	
	
}
