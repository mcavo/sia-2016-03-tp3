package genetic_algorithm.diversity;

import genetic_algorithm.Algorithm;

import java.util.List;

import utils.ErrorDispersion;
import model.chromosome.CharacterChromosome;

public class FitnessDiversityCalculator implements DiversityCalculator {

	private Algorithm algorithm;
	
	public FitnessDiversityCalculator() {
	}
	
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public double calculateDiversity() {
		List<CharacterChromosome> chromosomes = algorithm.getChromosomes();
		double[] fitness = new double[chromosomes.size()];
		for(int i=0; i<chromosomes.size(); i++){
			fitness[i] = chromosomes.get(i).fitness();
		}
		ErrorDispersion errorDispersion = new ErrorDispersion(fitness);
		return errorDispersion.getStdDev()/errorDispersion.getMean();
	}

}
