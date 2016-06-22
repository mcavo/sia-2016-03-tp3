# sia-2016-03-tp3
El algoritmo lee los parámetros de un archivo de configuración llamado config.properties

Parámetros:
 - Tipo de personaje: el valor debe estar comprendido en el conjunto
 	{ Assassin1 , Assassin2 , Warrior1 , Warrior2 , Warrior3 , Archer1 , Archer2 , Defensor1 , Defensor2 }

 - Población inicial: número entero que indica la cantidad de individuos en la primera generación

 - Método de selección: Se debe elegir un valor dentro del conjunto
 	{ CompoundSelection, BoltzmannSelection, DeterministicTournamentSelection , EliteSelection
      ProbabilisticTournamentSelection , RankingSelection , RouletteSelection , UniversalSelection }

    Los métodos CompoundSelection, BoltzmannSelection, DeterministicTournamentSelection, ProbabilisticTournamentSelection
    requieren un parámetro númerico adicional que también debe ser dado.

    En caso de elegir el método CompoundSelection es necesario elegir dos métodos dentro del mismo conjunto
    (exceptuando CompoundSelection) que serán utilizados en la composición. Si son métodos que requieren
    parametrización, este valor debe ser informado.

 - Método de mutación: Se debe elegir un valor dentro del conjunto
 	{ ClassicMutation , NotUniformMutation }

 	Es necesario ofrecer como parámetro un valor que represente la probabilidad de realizar la mutación.

 - Método de cruza: Se debe elegir un valor dentro del conjunto
 	{ AnularCrossover , OnePointCrossover , TwoPointCrossover , UniformCrossover }

 	En caso de elegir UniformCrossover es necesario ofrecer como parámetro un valor de probabilidad.

 - Condición de corte: Se debe elegir un valor dentro del conjunto
 	{ NGenerations NearOptimum Structure Content }

 	En caso de elegir NGenerations es necesario informar un número entero que representa la cantidad
 	de generaciones a ser analizadas.

 - Algoritmo de sustitución: Se debe elegir un valor dentro del conjunto
 	{ Substitution1 , Substitution2 , Substitution3 }

 	Es necesario elegir un método de selección. Las condiciones son las mismas que para el parámetro
 	"Método de selección" mencionado más arriba.

Archivo de Ejemplo:

	#Tipo de personaje
	character.class = Defensor1

	#Población inicial
	population.size = 200

	#Selección
	selection.type = CompoundSelection
	selection.parameter = 0.8
	selection.method1.type = RouletteSelection
	selection.method1.parameter = 400
	selection.method2.type = EliteSelection
	selection.method2.parameter = 2

	#Mutación
	mutation.type = NotUniformMutation
	mutation.parameter = 0.01

	#Cruza
	crossover.type = UniformCrossover
	crossover.parameter = 0.5

	#Condición de corte
	algorithmStopCondition.type = Content
	algorithmStopCondition.parameter = 1000

	#Reemplazo
	substitution.type = Substitution1
	substitution.parameter = 0.5	
	substitution.selection.type = CompoundSelection
	substitution.selection.parameter = 0.8
	substitution.selection.method1.type = BoltzmannSelection
	substitution.selection.method1.parameter = 400
	substitution.selection.method2.type = EliteSelection
	substitution.selection.method2.parameter = 2
