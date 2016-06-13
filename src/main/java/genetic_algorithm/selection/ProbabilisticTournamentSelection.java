package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class ProbabilisticTournamentSelection implements Selection {

	private double r;
	
	
	private Algorithm algorithm;
	
	public ProbabilisticTournamentSelection(double r) {
		this.r = r;
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void initialize() {
	}

	@Override
	public List<CharacterChromosome> select(int n) {
		List<CharacterChromosome> selection = new ArrayList<>();
		int size = algorithm.getChromosomes().size();
		for(int i=0; i<n; i++){
			int rand1 =(int)(Math.random()*size);
			int rand2 =(int)(Math.random()*size);
			CharacterChromosome chromosome1 = algorithm.getChromosomes().get(rand1);
			CharacterChromosome chromosome2 = algorithm.getChromosomes().get(rand2);
			CharacterChromosome aux;
			if(chromosome2.fitness() > chromosome1.fitness()){
				aux = chromosome1;
				chromosome1 = chromosome2;
				chromosome2 = aux;
			}
			if(Math.random()<r){
				selection.add(chromosome1);
			} else{
				selection.add(chromosome2);
			}
		}
		return selection;
		
	}

}
