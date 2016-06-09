package genetic_algorithm.populator;

import java.util.List;

import model.chromosome.CharacterChromosome;
import model.chromosome.Chromosome;

public interface CharacterChromosomePopulator {

	public List<CharacterChromosome> getInitialPopulation();

}
