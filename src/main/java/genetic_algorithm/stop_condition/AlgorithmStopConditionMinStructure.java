package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public class AlgorithmStopConditionMinStructure implements AlgorithmStopCondition {
	
	private double minDiversity;
	private Algorithm algorithm;

	public AlgorithmStopConditionMinStructure(double minDiversity) {
		this.minDiversity = minDiversity;
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public boolean hasToContinue() {
		return minDiversity < algorithm.getDiversity();
	}

}
