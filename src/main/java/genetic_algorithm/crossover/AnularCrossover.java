package genetic_algorithm.crossover;

import genetic_algorithm.Algorithm;
import genetic_algorithm.mutation.Mutation;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class AnularCrossover implements Crossover {

	private Algorithm algorithm;
	private Mutation mutation;

	public AnularCrossover() {
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
		this.mutation = algorithm.getMutation();
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
		int l = (int) (Math.random() * (chromosomeSize/2)+1);
		List<Double> genesFromCross1 = new ArrayList<>();
		List<Double> genesFromCross2 = new ArrayList<>();
		int locusAux = locus + l >= chromosomeSize ?locus+l-chromosomeSize : locus+l;
		
		if(locusAux > locus){
			for(int i = 0; i<locus ; i++){
				genesFromCross1.add(genes1.get(i));
				genesFromCross2.add(genes2.get(i));			
			}
			for(int i=locus; i<=locusAux; i++){
				genesFromCross2.add(genes1.get(i));
				genesFromCross1.add(genes2.get(i));	
			}
			for(int i=locusAux+1; i<chromosomeSize; i++){
				genesFromCross1.add(genes1.get(i));
				genesFromCross2.add(genes2.get(i));	
			}
		} else {
			for(int i = 0; i<=locusAux ; i++){
				genesFromCross2.add(genes1.get(i));
				genesFromCross1.add(genes2.get(i));			
			}
			for(int i=locusAux+1; i<locus; i++){
				genesFromCross1.add(genes1.get(i));
				genesFromCross2.add(genes2.get(i));	
			}
			for(int i=locus; i<chromosomeSize; i++){
				genesFromCross2.add(genes1.get(i));
				genesFromCross1.add(genes2.get(i));	
			}
			
		}
		
		children.add(mutation.mutate(new CharacterChromosome(genesFromCross1)));
		children.add(mutation.mutate(new CharacterChromosome(genesFromCross2)));
		return children;
	}


}
