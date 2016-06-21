package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public class AlgorithmStopConditionNStructure implements AlgorithmStopCondition {
	
	private final static double minDiversity = 1E-6;
	private Algorithm algorithm;
	private int counter = 0;
	private final int limit;

	public AlgorithmStopConditionNStructure(int limit) {
		this.limit = limit;
		this.counter = 0 ;
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
		return counter < limit;
	}

}
