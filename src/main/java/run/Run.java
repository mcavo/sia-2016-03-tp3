package run;

import genetic_algorithm.Algorithm;
import genetic_algorithm.crossover.AnularCrossover;
import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.crossover.OnePointCrossover;
import genetic_algorithm.crossover.TwoPointCrossover;
import genetic_algorithm.crossover.UniformCrossover;
import genetic_algorithm.diversity.DiversityCalculator;
import genetic_algorithm.diversity.ItemDiversityCalculator;
import genetic_algorithm.diversity.StatDiversityCalculator;
import genetic_algorithm.mutation.ClassicMutation;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.mutation.NotUniformMutation;
import genetic_algorithm.populator.CharacterChromosomePopulator;
import genetic_algorithm.populator.CharacterChromosomePopulatorN;
import genetic_algorithm.selection.BoltzmannSelection;
import genetic_algorithm.selection.CompoundSelection;
import genetic_algorithm.selection.DeterministicTournamentSelection;
import genetic_algorithm.selection.EliteSelection;
import genetic_algorithm.selection.ProbabilisticTournamentSelection;
import genetic_algorithm.selection.RankingSelection;
import genetic_algorithm.selection.RouletteSelection;
import genetic_algorithm.selection.Selection;
import genetic_algorithm.selection.UniversalSelection;
import genetic_algorithm.stop_condition.AlgorithmStopCondition;
import genetic_algorithm.stop_condition.AlgorithmStopConditionContent;
import genetic_algorithm.stop_condition.AlgorithmStopConditionMinStructure;
import genetic_algorithm.stop_condition.AlgorithmStopConditionNGenerations;
import genetic_algorithm.stop_condition.AlgorithmStopConditionNStructure;
import genetic_algorithm.stop_condition.AlgorithmStopConditionNearOptimum;
import genetic_algorithm.substitution.Substitution;
import genetic_algorithm.substitution.Substitution1;
import genetic_algorithm.substitution.Substitution2;
import genetic_algorithm.substitution.Substitution3;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;

import model.data.Data;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

import config.Configuration;

public class Run {
	
	private Properties prop;
	
	public static void main(String[] args) {

		Run run = new Run();
		run.run();

	}

	private void run() {
		prop = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"config.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Configuration.DEFAULT_CLASS = prop.getProperty("character.class");



		CharacterChromosomePopulator populator = new CharacterChromosomePopulatorN(
				Integer.valueOf(prop.getProperty("population.size")));
		
		Selection selection = null;
		String type = prop.getProperty("selection.type");
		String parameter = prop.getProperty("selection.parameter");
		String method1Type = prop.getProperty("selection.method1.type");
		String method1Parameter = prop.getProperty("selection.method1.parameter");
		String method2Type = prop.getProperty("selection.method2.type");
		String method2Parameter = prop.getProperty("selection.method2.parameter");
		switch(type){
		case "CompoundSelection" :
			double a = Double.valueOf(parameter);
			Selection method1 = null;
			Selection method2 = null;
			switch(method1Type){
			case "BoltzmannSelection" :
				method1 = new BoltzmannSelection(Double.valueOf(method1Parameter));
				break;
			case "DeterministicTournamentSelection" :
				method1 = new DeterministicTournamentSelection(Integer.valueOf(method1Parameter));
				break;
			case "EliteSelection" :
				method1 = new EliteSelection();
				break;
			case "ProbabilisticTournamentSelection" :
				method1 = new ProbabilisticTournamentSelection(Double.valueOf(method1Parameter));
				break;
			case "RankingSelection" :
				method1 = new RankingSelection();
				break;
			case "RouletteSelection" :
				method1 = new RouletteSelection();
				break;
			case "UniversalSelection" :
				method1 = new UniversalSelection();
				break;
			}
			switch(method2Type){
			case "BoltzmannSelection" :
				method2 = new BoltzmannSelection(Double.valueOf(method2Parameter));
				break;
			case "DeterministicTournamentSelection" :
				method2 = new DeterministicTournamentSelection(Integer.valueOf(method2Parameter));
				break;
			case "EliteSelection" :
				method2 = new EliteSelection();
				break;
			case "ProbabilisticTournamentSelection" :
				method2 = new ProbabilisticTournamentSelection(Double.valueOf(method2Parameter));
				break;
			case "RankingSelection" :
				method2 = new RankingSelection();
				break;
			case "RouletteSelection" :
				method2 = new RouletteSelection();
				break;
			case "UniversalSelection" :
				method2 = new UniversalSelection();
				break;
			}
			selection = new CompoundSelection(a, method1, method2);
			break;
		case "BoltzmannSelection" :
			selection = new BoltzmannSelection(Double.valueOf(parameter));
			break;
		case "DeterministicTournamentSelection" :
			selection = new DeterministicTournamentSelection(Integer.valueOf(parameter));
			break;
		case "EliteSelection" :
			selection = new EliteSelection();
			break;
		case "ProbabilisticTournamentSelection" :
			selection = new ProbabilisticTournamentSelection(Double.valueOf(parameter));
			break;
		case "RankingSelection" :
			selection = new RankingSelection();
			break;
		case "RouletteSelection" :
			selection = new RouletteSelection();
			break;
		case "UniversalSelection" :
			selection = new UniversalSelection();
			break;
		}
		
		Mutation mutation = null;
		type = prop.getProperty("mutation.type");
		parameter = prop.getProperty("mutation.parameter");
		
		switch(type){
		case "ClassicMutation" :
			mutation = new ClassicMutation(Double.valueOf(parameter));
			break;
		case "NotUniformMutation" :
			mutation = new NotUniformMutation(Double.valueOf(parameter));
			break;
		}

		Crossover crossover = null;
		
		type = prop.getProperty("crossover.type");
		parameter = prop.getProperty("crossover.parameter");
		
		switch(type){
		case "AnularCrossover" :
			crossover = new AnularCrossover();
			break;
		case "OnePointCrossover" :
			crossover = new OnePointCrossover();
			break;
		case "TwoPointCrossover" :
			crossover = new TwoPointCrossover();
			break;
		case "UniformCrossover" :
			crossover = new UniformCrossover(Double.valueOf(parameter));
			break;
		}
		
		AlgorithmStopCondition stopCondition = null;
		
		type = prop.getProperty("algorithmStopCondition.type");
		parameter = prop.getProperty("algorithmStopCondition.parameter");
		
		switch(type){
		case "NGenerations" :
			stopCondition = new AlgorithmStopConditionNGenerations( (Integer.valueOf(parameter)));
			break;
		case "Content" :
			stopCondition = new AlgorithmStopConditionContent((Integer.valueOf(parameter)));
			break;
		case "NearOptimum" :
			stopCondition = new AlgorithmStopConditionNearOptimum(Double.valueOf(parameter));
			break;
		case "NStructure" :
			stopCondition = new AlgorithmStopConditionNStructure(Integer.valueOf(parameter));
			break;
		case "MinStructure" :
			stopCondition = new AlgorithmStopConditionMinStructure(Double.valueOf(parameter));
			break;
		}
		Substitution substitution = null;
		Selection substitutionSelection = null;
		
		type = prop.getProperty("substitution.type");
		parameter = prop.getProperty("substitution.parameter");
		
		String selectionType = prop.getProperty("substitution.selection.type");
		String selectionParameter = prop.getProperty("substitution.selection.parameter");
		method1Type = prop.getProperty("substitution.selection.method1.type");
		method1Parameter = prop.getProperty("substitution.selection.method1.parameter");
		method2Type = prop.getProperty("substitution.selection.method2.type");
		method2Parameter = prop.getProperty("substitution.selection.method2.parameter");
		
		if(type.equals("Substitution1")){
			substitution = new Substitution1();
		} else {
			switch(selectionType){
			case "CompoundSelection":
				double a = Double.valueOf(selectionParameter);
				Selection method1 = null;
				Selection method2 = null;
				switch(method1Type){
				case "BoltzmannSelection" :
					method1 = new BoltzmannSelection(Double.valueOf(method1Parameter));
					break;
				case "DeterministicTournamentSelection" :
					method1 = new DeterministicTournamentSelection(Integer.valueOf(method1Parameter));
					break;
				case "EliteSelection" :
					method1 = new EliteSelection();
					break;
				case "ProbabilisticTournamentSelection" :
					method1 = new ProbabilisticTournamentSelection(Double.valueOf(method1Parameter));
					break;
				case "RankingSelection" :
					method1 = new RankingSelection();
					break;
				case "RouletteSelection" :
					method1 = new RouletteSelection();
					break;
				case "UniversalSelection" :
					method1 = new UniversalSelection();
					break;
				}
				switch(method2Type){
				case "BoltzmannSelection" :
					method2 = new BoltzmannSelection(Double.valueOf(method2Parameter));
					break;
				case "DeterministicTournamentSelection" :
					method2 = new DeterministicTournamentSelection(Integer.valueOf(method2Parameter));
					break;
				case "EliteSelection" :
					method2 = new EliteSelection();
					break;
				case "ProbabilisticTournamentSelection" :
					method2 = new ProbabilisticTournamentSelection(Double.valueOf(method2Parameter));
					break;
				case "RankingSelection" :
					method2 = new RankingSelection();
					break;
				case "RouletteSelection" :
					method2 = new RouletteSelection();
					break;
				case "UniversalSelection" :
					method2 = new UniversalSelection();
					break;
				}
				substitutionSelection = new CompoundSelection(a, method1, method2);
				break;
			case "BoltzmannSelection" :
				substitutionSelection = new BoltzmannSelection(Double.valueOf(selectionParameter));
				break;
			case "DeterministicTournamentSelection" :
				substitutionSelection = new DeterministicTournamentSelection(Integer.valueOf(selectionParameter));
				break;
			case "EliteSelection" :
				substitutionSelection = new EliteSelection();
				break;
			case "ProbabilisticTournamentSelection" :
				substitutionSelection = new ProbabilisticTournamentSelection(Double.valueOf(selectionParameter));
				break;
			case "RankingSelection" :
				substitutionSelection = new RankingSelection();
				break;
			case "RouletteSelection" :
				substitutionSelection = new RouletteSelection();
				break;
			case "UniversalSelection" :
				substitutionSelection = new UniversalSelection();
				break;
			}
			switch(type){
			case "Substitution2":
				double aux = Double.valueOf(parameter);
				if(aux > 1){
					substitution = new Substitution2((int) aux, substitutionSelection);				
				} else {
					substitution = new Substitution2(substitutionSelection,  aux);
				}
				break;
			case "Substitution3":
				substitution = new Substitution3(Integer.valueOf(parameter), substitutionSelection);
				break;
			}
		}
		
		DiversityCalculator diversityCalculator = null;
		
		type = prop.getProperty("diversityCalculator.type");
		
		switch(type){
		case "StatDiversityCalculator":
			diversityCalculator = new StatDiversityCalculator();
			break;
		case "ItemDiversityCalculator":
			diversityCalculator = new ItemDiversityCalculator();
			break;
		}

		Algorithm algorithm = new Algorithm(populator, stopCondition, mutation,
				crossover, selection, substitution, diversityCalculator);
		Data ans = algorithm.run();
		System.out.println(ans.getBestChromosome());
		
		plot(ans);
	}
	
	private void plot(Data data) {
		double[] x = new double[data.getGenerations()];
		double[] fitness = new double[data.getGenerations()];
		double[] diversity = new double[data.getGenerations()];
		
		Plot2DPanel plotFitness = new Plot2DPanel();
		Plot2DPanel plotDiversity = new Plot2DPanel();
		
		for(int i = 0 ; i < data.getGenerations() ; i++ ) {
			x[i] = i+1;
			fitness[i] = data.getFitness().get(i);
			diversity[i] = data.getDiversity().get(i);
		}
		
		plotFitness.addLinePlot("Best chromosome fitness", x, fitness);
		plotDiversity.addLinePlot("Diversity", x, diversity);
		
		BaseLabel title = new BaseLabel("Best chromosome fitness", Color.BLACK, 0.5, 1.1);
        title.setFont(new Font("Courier", Font.BOLD, 20));
        plotFitness.addPlotable(title);
        
        BaseLabel titleD = new BaseLabel("Diversity", Color.BLACK, 0.5, 1.1);
        titleD.setFont(new Font("Courier", Font.BOLD, 20));
        plotDiversity.addPlotable(titleD);
        
        
        // change name of axes
        plotFitness.setAxisLabels("Generations", "Fitness");
        plotDiversity.setAxisLabels("Generations", "Diversity");

        // customize X axe
        // change axe title position relatively to the base of the plot
        plotFitness.getAxis(0).setLabelPosition(0.5, -0.15);
        plotDiversity.getAxis(0).setLabelPosition(0.5, -0.15);
        
        
        // customize Y axe
        // change axe title position relatively to the base of the plot
        plotFitness.getAxis(1).setLabelPosition(-0.15, 0.5);
        plotDiversity.getAxis(1).setLabelPosition(-0.15, 0.5);


		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frameFitness = new JFrame("a plot panel");
		frameFitness.setSize(600, 600);
		frameFitness.setContentPane(plotFitness);
		frameFitness.setVisible(true);
		
		JFrame frameDiversity = new JFrame("a plot panel2");
		frameDiversity.setSize(600, 600);
		frameDiversity.setContentPane(plotDiversity);
		frameDiversity.setVisible(true);
	}
}
