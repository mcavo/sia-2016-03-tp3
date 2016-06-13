package genetic_algorithm.substitution;

import genetic_algorithm.Algorithm;
import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.selection.Selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class Substitution3 implements Substitution {


	private int k;
	private Algorithm algorithm;
	private Selection substitutionSelection;

	public Substitution3(int k, Selection substitutionSelection) {
		this.k = k;
		this.substitutionSelection = substitutionSelection;
	}

	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
		substitutionSelection.setAlgorithm(algorithm);
	}

	@Override
	public List<CharacterChromosome> substitute() {
		List<CharacterChromosome> chromosomes = algorithm.getChromosomes();
		List<CharacterChromosome> newMembers = new ArrayList<>();

		substitutionSelection.initialize();
		newMembers.addAll(substitutionSelection.select(algorithm.getChromosomes().size()-k));

		
		
		Selection selection = algorithm.getSelection();
		selection.initialize();
		Crossover crossover = algorithm.getCrossover();

		List<CharacterChromosome> chosenToReproduce = selection.select(k);
		Collections.shuffle(chosenToReproduce);
		for (int i = 0; i < chosenToReproduce.size() / 2; i++) {
			chromosomes.addAll(crossover.crossover(chosenToReproduce.get(i),
					chosenToReproduce.get(chosenToReproduce.size() - 1 - i)));
		}
		substitutionSelection.initialize();
		newMembers.addAll(substitutionSelection.select(k));

		return newMembers;
	}

}
