package model.item;

public abstract class Item {

	private final double strength;
	private final double agility;
	private final double expertice;
	private final double resistanse;
	private final double life;
	
	private final ItemType itemType;

	public Item(double strength, double agility, double expertice,
			double resistanse, double life, ItemType itemType) {
		super();
		this.strength = strength;
		this.agility = agility;
		this.expertice = expertice;
		this.resistanse = resistanse;
		this.life = life;
		this.itemType = itemType;
	}

	public double getStrength() {
		return strength;
	}

	public double getAgility() {
		return agility;
	}

	public double getExpertice() {
		return expertice;
	}

	public double getResistanse() {
		return resistanse;
	}

	public double getLife() {
		return life;
	}

	public ItemType getItemType() {
		return itemType;
	}
	
	
	
}
