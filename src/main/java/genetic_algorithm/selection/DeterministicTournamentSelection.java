package genetic_algorithm.selection;

import genetic_algorithm.Algorithm;

import java.util.ArrayList;
import java.util.List;

import model.chromosome.CharacterChromosome;

public class DeterministicTournamentSelection implements Selection{
	
	int m;
	
	private Algorithm algorithm;
	
	public DeterministicTournamentSelection(int m) {
		this.m = m;
	}
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CharacterChromosome> select(int n) {
		List<CharacterChromosome> selection = new ArrayList<>();
		int size = algorithm.getChromosomes().size();
		for(int i=0; i<n; i++){
			
			List<CharacterChromosome> fight = new ArrayList<>();
			for(int j=0; j<m; j++){
				int rand =(int)(Math.random()*size);				
				fight.add(algorithm.getChromosomes().get(rand));
			}
			
			int index = 0;
			for(int j=0; j<m; j++){
				if(fight.get(j).fitness()>fight.get(j).fitness()){
					index = j;
				}
			}
			selection.add(fight.get(index));
		}
		return selection;
		
	}
}
