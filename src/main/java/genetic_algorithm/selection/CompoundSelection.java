package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.List;

import model.chromosome.CharacterChromosome;

public class CompoundSelection implements Selection {

	private Algorithm algorithm;

	private double a;
	private Selection method1;
	private Selection method2;
	
	
	public CompoundSelection(double a, Selection method1, Selection method2) {
		this.a = a;
		this.method1 = method1;
		this.method2 = method2;
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
