package repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.item.Boots;
import model.item.Item;
import model.item.ItemType;

public class ItemsRepo {

	private static ItemsRepo instance;

	private List<Item> boots;
	private List<Item> helmets;
	private List<Item> weapons;
	private List<Item> gloves;
	private List<Item> chests;

	private ItemsRepo() {
		this.boots = getBoots();
		this.helmets = getHelmets();
		this.weapons = getWeapons();
		this.gloves = getGloves();
		this.chests = getChest();
	}

	public static ItemsRepo getInstance() {
		if (instance == null) {
			instance = new ItemsRepo();
		}
		return instance;
	}

	public Item get(ItemType itemType, int index) {
		switch (itemType) {
		case BOOTS:
			return boots.get(index);
		case HELMET:
			return helmets.get(index);
		case WEAPON:
			return weapons.get(index);
		case CHEST:
			return chests.get(index);
		case GLOVES:
			return gloves.get(index);
		}
		return null;
	}
	
	public Item getRandom(ItemType itemType) {
		double rand = Math.random();
		switch (itemType) {
		case BOOTS:
			return boots.get((int)(rand*boots.size()));
		case HELMET:
			return helmets.get((int)(rand*helmets.size()));
		case WEAPON:
			return weapons.get((int)(rand*weapons.size()));
		case CHEST:
			return chests.get((int)(rand*chests.size()));
		case GLOVES:
			return gloves.get((int)(rand*gloves.size()));
		}
		return null;
	}
	
	public double getRandomIndex(ItemType itemType){
		double rand = Math.random();
		switch (itemType) {
		case BOOTS:
			return ((int)(rand*boots.size()))*1.0;
		case HELMET:
			return ((int)(rand*helmets.size()))*1.0;
		case WEAPON:
			return ((int)(rand*weapons.size()))*1.0;
		case CHEST:
			return ((int)(rand*chests.size()))*1.0;
		case GLOVES:
			return ((int)(rand*gloves.size()))*1.0;
		}
		return -1.0;
	}

	private List<Item> getChest() {
		return readItems("pecheras.tsv", ItemType.CHEST);
	}

	private List<Item> getGloves() {
		return readItems("guantes.tsv", ItemType.GLOVES);
	}

	private List<Item> getWeapons() {
		return readItems("armas.tsv", ItemType.WEAPON);
	}

	private List<Item> getHelmets() {
		return readItems("cascos.tsv", ItemType.HELMET);
	}

	private List<Item> getBoots() {
		return readItems("botas.tsv", ItemType.BOOTS);
	}

	private List<Item> readItems(String filename, ItemType itemType) {
		File file = new File(FileManager.DATA_PATH+"/"+filename);
		List<Item> items = new ArrayList<>();
		try {
			Scanner sc = new Scanner(file);
			sc.nextLine();
			int i = 0;
			while(sc.hasNextInt()){
				sc.nextInt();
				switch(itemType){
				case BOOTS:
					items.add(new Boots(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),sc.nextDouble()));
					break;
				case HELMET:
					items.add(new Boots(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),sc.nextDouble()));
					break;
				case WEAPON:
					items.add(new Boots(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),sc.nextDouble()));
					break;
				case GLOVES:
					items.add(new Boots(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),sc.nextDouble()));
					break;
				case CHEST:
					items.add(new Boots(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(),sc.nextDouble()));
					break;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
}
