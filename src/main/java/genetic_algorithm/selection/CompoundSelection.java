package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
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
		method1.setAlgorithm(algorithm);
		method2.setAlgorithm(algorithm);
	}

	@Override
	public void initialize() {
		method1.initialize();
		method2.initialize();

	}

	@Override
	public List<CharacterChromosome> select(int n) {
		
		List<CharacterChromosome> selection;
		int method1Amount =(int)(n*a);
		int method2Amount = n - method1Amount;
		selection = method1.select(method1Amount);
		selection.addAll(method2.select(method2Amount));
		return selection;
	}


}
