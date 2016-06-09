package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public class AlgorithmStopConditionNGenerations implements AlgorithmStopCondition{

	private Algorithm algorithm;
	
	
	
	public AlgorithmStopConditionNGenerations() {
	}
	
	
	
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasToContinue() {
		// TODO Auto-generated method stub
		return false;
	}

}
