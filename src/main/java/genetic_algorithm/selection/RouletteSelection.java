package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class RouletteSelection implements Selection {

	private Algorithm algorithm;
	
	private List<Double> orders;
	private double fitnessSum;
	
	public RouletteSelection() {
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
		List<CharacterChromosome> selection = new ArrayList<>();

		for(int i=1; i<=n; i++){
			double r = Math.random()*fitnessSum;
			int j=0;
			while(j<orders.size()-1 && orders.get(j)>r){
				j++;
			}
			selection.add(algorithm.getChromosomes().get(j));
		}
		return selection;
	}

}
