package run;

import genetic_algorithm.Algorithm;
import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.crossover.UniformCrossover;
import genetic_algorithm.mutation.ClassicMutation;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.mutation.NotUniformMutation;
import genetic_algorithm.populator.CharacterChromosomePopulator;
import genetic_algorithm.populator.CharacterChromosomePopulatorN;
import genetic_algorithm.selection.RouletteSelection;
import genetic_algorithm.selection.Selection;
import genetic_algorithm.stop_condition.AlgorithmStopCondition;
import genetic_algorithm.stop_condition.AlgorithmStopConditionNGenerations;
import genetic_algorithm.substitution.Substitution;
import genetic_algorithm.substitution.Substitution1;
import repo.ItemsRepo;

public class Run {
	public static void main(String[] args) {
		ItemsRepo itemsRepo =ItemsRepo.getInstance();
		CharacterChromosomePopulator populator = new CharacterChromosomePopulatorN(20);
		Selection selection = new RouletteSelection();
		Mutation mutation = new ClassicMutation(0.2);
		Crossover crossover = new UniformCrossover(0.5);
		AlgorithmStopCondition stopCondition = new AlgorithmStopConditionNGenerations((int)1E6);
		Substitution substitution = new Substitution1();
		Algorithm algorithm = new Algorithm(populator, stopCondition, mutation, crossover, selection, substitution);
		System.out.println(algorithm.run().fitness());
	}
}
