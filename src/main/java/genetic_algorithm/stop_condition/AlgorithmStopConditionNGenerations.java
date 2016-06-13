package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public class AlgorithmStopConditionNGenerations implements AlgorithmStopCondition{

	private Algorithm algorithm;
	private int maxGenerations;
	
	
	public AlgorithmStopConditionNGenerations(int maxGenerations) {
		this.maxGenerations = maxGenerations;
	}
		
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public boolean hasToContinue() {
		return algorithm.getGeneration() < maxGenerations;
	}

}
