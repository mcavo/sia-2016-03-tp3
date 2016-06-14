package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public class AlgorithmStopConditionNearOptimum implements
		AlgorithmStopCondition {

	private Algorithm algorithm;
	
	private double maxFitness;
	
	
	public AlgorithmStopConditionNearOptimum(double maxFitness) {
		this.maxFitness = maxFitness;
	}
	
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public boolean hasToContinue() {
		return maxFitness > algorithm.getBestChromosome().fitness();
	}

}
