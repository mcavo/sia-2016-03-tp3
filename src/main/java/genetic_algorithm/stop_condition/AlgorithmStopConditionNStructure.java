package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public class AlgorithmStopConditionNStructure implements AlgorithmStopCondition {
	
	private double minDiversity;
	private Algorithm algorithm;
	private int counter = 0;
	private final int LIMIT = 5;

	public AlgorithmStopConditionNStructure(double minDiversity) {
		this.minDiversity = minDiversity;
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public boolean hasToContinue() {
		if (algorithm.getDiversity() < minDiversity) {
			counter++;
		} else {
			counter = 0;
		}
		return counter < LIMIT;
	}

}
