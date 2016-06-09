package repo;

import java.util.List;

import model.item.Item;
import model.item.ItemType;

public class ItemsRepo {

	private static ItemsRepo instance;
		
	private List<Item> boots;
	private List<Item> helmets;
	private List<Item> weapons;
	private List<Item> gloves;
	private List<Item> chests;
	
	
	private ItemsRepo(){
		this.boots = getBoots();
		this.helmets = getHelmets();
		this.weapons = getWeapons();
		this.gloves = getGloves();
		this.chests = getChest();
	}
	
	public static ItemsRepo getInstance(){
		if(instance == null){
			instance = new ItemsRepo();
		}
		return instance;
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
		// abro el archivo filename en el path de filemanager, y creo los items de itemtype
		return null;
	}
	
	
	
}
