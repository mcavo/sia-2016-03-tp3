package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class RankingSelection implements Selection {

	private Algorithm algorithm;
	
	private List<Double> orders;
	private double fitnessSum;
	
	
	public RankingSelection() {
		orders = new ArrayList<>();
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void initialize() {
		fitnessSum = 0;
		int size = algorithm.getChromosomes().size();
		Collections.sort(algorithm.getChromosomes());
		orders.clear();
		for(int i=0; i<size ;i++){
			fitnessSum += size - i + 1;
			orders.add(fitnessSum);
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
