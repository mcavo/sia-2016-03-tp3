package model.item;

public class Weapon extends Item{

	public Weapon(double strength, double agility, double expertice,
			double resistanse, double life) {
		super(strength, agility, expertice, resistanse, life, ItemType.WEAPON);
	}

}
