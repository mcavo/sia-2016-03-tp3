package genetic_algorithm.crossover;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class OnePointCrossover implements Crossover {

	private Algorithm algorithm;

	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public List<CharacterChromosome> crossover(CharacterChromosome c1,
			CharacterChromosome c2) {
		List<Double> genes1 = c1.getGenes();
		List<Double> genes2 = c2.getGenes();
		List<CharacterChromosome> children = new ArrayList<>();
		int chromosomeSize = algorithm.getChromosomes().get(0).getGenes()
				.size();
		int locus = (int) (Math.random() * chromosomeSize);
		List<Double> genesFromCross1 = new ArrayList<>();
		List<Double> genesFromCross2 = new ArrayList<>();
		for(int i = 0; i<locus ; i++){
			genesFromCross1.add(genes1.get(i));
			genesFromCross2.add(genes2.get(i));			
		}
		for(int i=locus; i<chromosomeSize; i++){
			genesFromCross2.add(genes1.get(i));
			genesFromCross1.add(genes2.get(i));	
		}
		children.add(new CharacterChromosome(genesFromCross1));
		children.add(new CharacterChromosome(genesFromCross2));
		return children;
	}

}
