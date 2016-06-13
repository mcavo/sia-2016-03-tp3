package run;

import genetic_algorithm.Algorithm;
import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.crossover.OnePointCrossover;
import genetic_algorithm.mutation.ClassicMutation;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.populator.CharacterChromosomePopulator;
import genetic_algorithm.populator.CharacterChromosomePopulatorN;
import genetic_algorithm.selection.BoltzmannSelection;
import genetic_algorithm.selection.CompoundSelection;
import genetic_algorithm.selection.DeterministicTournamentSelection;
import genetic_algorithm.selection.Selection;
import genetic_algorithm.stop_condition.AlgorithmStopCondition;
import genetic_algorithm.stop_condition.AlgorithmStopConditionNGenerations;
import genetic_algorithm.substitution.Substitution;
import genetic_algorithm.substitution.Substitution3;
import model.chromosome.CharacterChromosome;
import repo.ItemsRepo;

public class Run {
	public static void main(String[] args) {
		ItemsRepo itemsRepo =ItemsRepo.getInstance();
		CharacterChromosomePopulator populator = new CharacterChromosomePopulatorN(200);
		Selection selection = new CompoundSelection(0.7, new BoltzmannSelection(400),new DeterministicTournamentSelection(2));
		Mutation mutation = new ClassicMutation(0.3);
		Crossover crossover = new OnePointCrossover();
		AlgorithmStopCondition stopCondition = new AlgorithmStopConditionNGenerations((int)1E3);
		Substitution substitution = new Substitution3(100, new CompoundSelection(0.7, new BoltzmannSelection(400),new DeterministicTournamentSelection(2)));
		Algorithm algorithm = new Algorithm(populator, stopCondition, mutation, crossover, selection, substitution);
		CharacterChromosome ans = algorithm.run();
		System.out.println(ans.getGenes());
		System.out.println(ans.fitness());
	}
}
