package cr.tec.genetic.geneticStructures;

/**
 * Created by joseph on 5/17/17.
 */
public class DNA {

	private final static int genNumber = 11;
	private int[] genes = new int[genNumber];
	private double probability;
	private double fitness;
	private String nameHash;

	public int getGen(int num) {
		return genes[num];
	}

	public void setGen(int num, int value) {
		this.genes[num] = value;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public String getNameHash() {
		return nameHash;
	}

	public void setNameHash(String nameHash) {
		this.nameHash = nameHash;
	}

	public void DNA() {

	}
}