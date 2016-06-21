package genetic_algorithm.diversity;

import genetic_algorithm.Algorithm;

import java.util.List;

import utils.ErrorDispersion;
import model.chromosome.CharacterChromosome;

public class StatDiversityCalculator implements DiversityCalculator{

	private Algorithm algorithm;
	
	public StatDiversityCalculator() {
	}
	
	
	@Override
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public double calculateDiversity() {
		List<CharacterChromosome> chromosomes = algorithm.getChromosomes();
		double strengthDiv[] = new double[chromosomes.size()];
		double expertiseDiv[] = new double[chromosomes.size()];
		double agilityDiv[] = new double[chromosomes.size()];
		double lifeDiv[] = new double[chromosomes.size()];
		double resistanseDiv[] = new double[chromosomes.size()];
		double heightDiv[] = new double[chromosomes.size()];
		for(int i = 0 ; i < chromosomes.size() ; i++) {
			strengthDiv[i] = chromosomes.get(i).getStrength();
			expertiseDiv[i] = chromosomes.get(i).getExpertise();
			agilityDiv[i] = chromosomes.get(i).getAgility();
			lifeDiv[i] = chromosomes.get(i).getLife();
			resistanseDiv[i] = chromosomes.get(i).getResistanse();
			heightDiv[i] = chromosomes.get(i).getHeight();
		}
		ErrorDispersion strengthDisp = new ErrorDispersion(strengthDiv);
		ErrorDispersion expertiseDisp = new ErrorDispersion(expertiseDiv);
		ErrorDispersion agilityDisp = new ErrorDispersion(agilityDiv);
		ErrorDispersion lifeDisp = new ErrorDispersion(lifeDiv);
		ErrorDispersion resistanseDisp = new ErrorDispersion(resistanseDiv);
		ErrorDispersion heightDisp = new ErrorDispersion(heightDiv);
		
		double ret = strengthDisp.getStdDev() / strengthDisp.getMean();
		ret += expertiseDisp.getStdDev() / expertiseDisp.getMean();
		ret += agilityDisp.getStdDev() / agilityDisp.getMean();
		ret += lifeDisp.getStdDev() / lifeDisp.getMean();
		ret += resistanseDisp.getStdDev() / resistanseDisp.getMean();
		ret += heightDisp.getStdDev() / heightDisp.getMean();
		
		return ret / 6;
	}

}
