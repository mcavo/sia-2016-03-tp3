package genetic_algorithm.diversity;

import genetic_algorithm.Algorithm;

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
		// TODO Auto-generated method stub
		return 0;
	}

}
