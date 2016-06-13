package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class UniversalSelection implements Selection {
	
	
	private List<Double> orders;
	private double fitnessSum;

	private Algorithm algorithm;
	
	public UniversalSelection() {
		orders = new ArrayList<>();
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
			fitnessSum += chromosome.fitness();
			orders.add(fitnessSum);
		}
	}

	@Override
	public List<CharacterChromosome> select(int n) {
		double r = Math.random()*fitnessSum;
		List<CharacterChromosome> selection = new ArrayList<>();
		int j=0;
		for(int i=1; i<=n; i++){
			double rj = (r+i-1)/n;
			while(orders.get(j)>rj){
				j++;
			}
			selection.add(algorithm.getChromosomes().get(j));
		}
		return selection;
	}

}
