package run;

import model.item.ItemType;
import repo.ItemsRepo;

public class Run {
	public static void main(String[] args) {
		ItemsRepo itemsRepo =ItemsRepo.getInstance();
		
		System.out.println(itemsRepo.get(ItemType.BOOTS, 4).getAgility());
	}
}
