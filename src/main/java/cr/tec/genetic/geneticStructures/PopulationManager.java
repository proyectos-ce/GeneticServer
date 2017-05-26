package cr.tec.genetic.geneticStructures;

import java.util.Vector;

/**
 * Created by joseph on 5/17/17.
 */
public class PopulationManager {

	final private float mutation = 0.005f;
	private int generation = 0;
	private Vector<DNA> population = new Vector<DNA>();
	private int maxPopulation;
	public PopulationManager() {
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public Vector<DNA> getPopulation() {
		return population;
	}

	public void setPopulation(Vector<DNA> population) {
		this.population = population;
	}

	public void initialize(int maxPopulation) {
		this.maxPopulation = maxPopulation;

		this.population.clear();

		for (int i = 0; i < maxPopulation; i++) {
			this.population.add(DNAManager.getInstance().createRandomDNA());
		}
	}

	private void sortbyFitness() {
		sortByFitness(0, this.population.size() - 1);
	}

	private void sortByFitness(int left, int right) {
		int i = left, j = right;
		DNA tmp;

		double pivot = this.population.get((left + right) / 2).getFitness();

		while (i <= j) {
			while (this.population.get(i).getFitness() < pivot)
				i++;
			while (this.population.get(j).getFitness() > pivot)
				j--;
			if (i <= j) {
				tmp = this.population.get(i);
				this.population.set(i, this.population.get(j));
				this.population.set(j, tmp);
				i++;
				j--;
			}
		}

		if (left < j) {
			sortByFitness(left, j);
		}
		if (i < right) {
			sortByFitness(i, right);
		}
	}

	private void setProbabilityForEach() {
		int sumFit = 0;

		for (DNA aPopulation1 : this.population) {
			sumFit += aPopulation1.getFitness();
		}
		for (DNA aPopulation : this.population) {
			aPopulation.setProbability(aPopulation.getFitness() / sumFit);
		}
	}

	public void createNextGeneration() {
		sortbyFitness();
		setProbabilityForEach();
		Vector<DNA> nextGeneration = new Vector<DNA>();
		for (int i = 0; i < maxPopulation; ++i) {
			DNA parent1 = obtainRandomFromPool();
			DNA parent2 = obtainRandomFromPool();
			DNA child = DNAManager.getInstance().crossover(parent1, parent2, mutation);
			nextGeneration.add(child);
		}
		setPopulation(nextGeneration);
		this.generation++;
	}

	private DNA obtainRandomFromPool() {
		double prob = Math.random();
		DNA randomMate = new DNA();
		for (DNA aPopulation : this.population) {
			prob -= aPopulation.getProbability();
			if (prob <= 0) {
				randomMate = aPopulation;
				break;
			}
		}
		return randomMate;
	}
}
