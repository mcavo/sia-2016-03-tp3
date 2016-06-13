package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class BoltzmannSelection implements Selection {

	private double fitnessSum;
	private List<Double> orders;
	
	private double t;
	
	private Algorithm algorithm;
	
	public BoltzmannSelection(double t) {
		this.t = t;
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void initialize() {
		fitnessSum = 0;
		Collections.sort(algorithm.getChromosomes());
		orders.clear();
		for(CharacterChromosome chromosome : algorithm.getChromosomes()){
			fitnessSum += Math.exp(chromosome.fitness()/t);
			orders.add(fitnessSum);
		}
		t--;
		if(t<1){
			t=1;
		}
	}

	@Override
	public List<CharacterChromosome> select(int n) {
		List<CharacterChromosome> selection = new ArrayList<>();

		for(int i=1; i<=n; i++){
			double r = Math.random()*fitnessSum;
			int j=0;
			while(orders.get(j)>r){
				j++;
			}
			selection.add(algorithm.getChromosomes().get(j));
		}
		return selection;
	}

}
