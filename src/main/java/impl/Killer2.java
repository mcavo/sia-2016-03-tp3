package impl;
import interfaces.Character;

public class Killer2 implements Character {
	
	private double attack;
	private double defense;
	private double force;
	private double expertise;
	private double life;
	private double resistance;
	private double agility;
	private double height;

	public double fitness() {
		return 0.7*attack + 0.3*defense;
	}
	
	public void calculateAttack(){
		this.attack = (this.agility + this.expertise) * force * calculateAttackModifier();
	}
	
	private double calculateAttackModifier() {
		return 0.5 - Math.pow((3*this.height -5),4) + Math.pow((3*this.height -5), 2) + this.height/2;
	}

	public void calculateDefense(){
		this.defense = (this.resistance + this.expertise) * this.life * calculateDefenseModifier();
	}
	
	private double calculateDefenseModifier(){
		return 2 + Math.pow((3*this.height - 5),4) - Math.pow((3*height - 5),2) - this.height/2;
	}
}
