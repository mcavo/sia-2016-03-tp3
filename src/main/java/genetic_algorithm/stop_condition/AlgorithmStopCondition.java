package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public interface AlgorithmStopCondition {

	//must be called before using the instance
	public void setAlgorithm(Algorithm algorithm);
	
	public boolean hasToContinue();

}

