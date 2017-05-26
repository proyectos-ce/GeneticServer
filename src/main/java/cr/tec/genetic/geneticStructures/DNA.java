package cr.tec.genetic.geneticStructures;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by joseph on 5/17/17.
 */
public class DNA {

	private final static int genNumber = 11;

	public static int getGenNumber() {
		return genNumber;
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
		calculateHash();
	}

	private int[] genes = new int[genNumber];
	private double probability;
	private double fitness;
	private String nameHash;

	public int getGen(int num) {
		return genes[num];
	}

	public void setGen(int num, int value) {
		this.genes[num] = value;
		calculateHash();

	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
		calculateHash();
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
		calculateHash();
	}

	public String getHash() {
		return nameHash;
	}

	private void calculateHash() {
		String result = "";

		for (int gen : genes) {
			result += String.valueOf(gen);
		}

		result += String.valueOf(probability);

		result+= String.valueOf(fitness);

		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");


		m.reset();
		m.update(result.getBytes());

		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);

		while(hashtext.length() < 32 ){
			hashtext = "0"+hashtext;
		}



		this.nameHash = hashtext;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public void DNA() {

	}
}