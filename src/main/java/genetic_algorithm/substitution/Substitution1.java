package genetic_algorithm.substitution;

import genetic_algorithm.Algorithm;
import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.selection.Selection;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class Substitution1 implements Substitution {

	
	private Algorithm algorithm;
	
	public Substitution1(){
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}


	@Override
	public List<CharacterChromosome> substitute() {
		Selection selection = algorithm.getSelection();
		Crossover crossover = algorithm.getCrossover();
		selection.initialize();
		List<CharacterChromosome> newGeneration = new ArrayList<>();
		while(newGeneration.size() < algorithm.getChromosomes().size()){
			List<CharacterChromosome> pair = selection.select(2);
			newGeneration.addAll(crossover.crossover(pair.get(0),pair.get(1)));
		}
		return newGeneration;
		
	}

}
