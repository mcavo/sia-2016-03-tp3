package genetic_algorithm.stop_condition;

import genetic_algorithm.Algorithm;

public class AlgorithmStopConditionContent implements
		AlgorithmStopCondition {

	private Algorithm algorithm;
	
	private double lastMaxFitness;
	private int maxGenerationsWithoutImprovement;
	
	private int generationsWithoutImprovement;
	
	public  AlgorithmStopConditionContent(int maxGenerationsWithoutImprovement) {
		this.maxGenerationsWithoutImprovement = maxGenerationsWithoutImprovement;
		this.lastMaxFitness = 0;
	}
	
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;		
	}

	@Override
	public boolean hasToContinue() {
		if(lastMaxFitness >= algorithm.getBestChromosome().fitness()){
			generationsWithoutImprovement++;
			if(generationsWithoutImprovement >= maxGenerationsWithoutImprovement){
				return false;
			}
		} else {
			generationsWithoutImprovement = 0;
			lastMaxFitness = algorithm.getBestChromosome().fitness();
		}
		return true;
	}


}
