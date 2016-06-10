package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.List;

import model.chromosome.CharacterChromosome;

public class RankingSelection implements Selection {

	private Algorithm algorithm;
	
	public RankingSelection() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CharacterChromosome> select(int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
