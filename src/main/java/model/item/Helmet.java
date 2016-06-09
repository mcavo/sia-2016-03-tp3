package model.item;

public class Helmet extends Item{

	public Helmet(double strength, double agility, double expertice,
			double resistanse, double life) {
		super(strength, agility, expertice, resistanse, life, ItemType.HELMET);
	}

}
