package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class EliteSelection implements Selection {

	private Algorithm algorithm;
	
	public EliteSelection() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void initialize() {
		Collections.sort(algorithm.getChromosomes());
	}

	@Override
	public List<CharacterChromosome> select(int n) {
		return algorithm.getChromosomes().subList(0, n);
	}

}
