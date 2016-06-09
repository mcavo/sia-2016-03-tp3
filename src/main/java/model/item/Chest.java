package model.item;

public class Chest extends Item{

	public Chest(double strength, double agility, double expertice,
			double resistanse, double life) {
		super(strength, agility, expertice, resistanse, life, ItemType.CHEST);
	}

}
