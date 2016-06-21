package genetic_algorithm.diversity;

import genetic_algorithm.Algorithm;

public interface DiversityCalculator {

	
	public void setAlgorithm(Algorithm algorithm);
	public double calculateDiversity();
	
}
