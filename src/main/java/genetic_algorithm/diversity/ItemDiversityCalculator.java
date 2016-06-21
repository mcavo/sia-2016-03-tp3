package genetic_algorithm.diversity;

import genetic_algorithm.Algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import repo.ItemsRepo;
import model.chromosome.CharacterChromosome;
import model.item.ItemType;

public class ItemDiversityCalculator implements DiversityCalculator {

	private Algorithm algorithm;

	public ItemDiversityCalculator() {

	}

	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public double calculateDiversity() {
		List<CharacterChromosome> chromosomes = algorithm.getChromosomes();
		Map<Integer, Set<Double>> equipment = new HashMap<>();
		for (ItemType itemType : ItemType.values()) {
			equipment.put(itemType.ordinal(), new HashSet<Double>());
		}
		for (CharacterChromosome chromosome : chromosomes) {
			for (ItemType itemType : ItemType.values()) {
				Set<Double> set = equipment.get(itemType.ordinal());
				set.add(chromosome.getGenes().get(itemType.ordinal()));
			}
		}
		double diversity = 0;
		ItemsRepo itemsRepo = ItemsRepo.getInstance();
		for (Entry<Integer, Set<Double>> itemSlotDiversity : equipment
				.entrySet()) {
			diversity += ((double)itemSlotDiversity.getValue().size()-1)
					/ itemsRepo.size(ItemType.values()[itemSlotDiversity
							.getKey()]);
		}
		return diversity/equipment.size();
	}

}
