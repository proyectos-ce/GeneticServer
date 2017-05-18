package cr.tec.genetic.geneticStructures;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by joseph on 5/17/17.
 */
public class DNAManager {
	private static DNAManager ourInstance = new DNAManager();

	private DNAManager() {
	}

	public static DNAManager getInstance() {
		return ourInstance;
	}

	private int getRandomGen(int geneNumber) {
		// TODO: DE 0 A 100? Fijarse en structures
		return ThreadLocalRandom.current().nextInt(0, 100 + 1);
	}


	public DNA createRandomDNA() {
		DNA randomDNA = new DNA();
		for (int i = 0; i < 11; i++) {
			randomDNA.setGen(i, getRandomGen(i));
		}
		return randomDNA;
	}

	public DNA crossover(DNA parent1, DNA parent2, float mutation) {
		DNA child = new DNA();
		for (int i = 0; i < 11; i++) {
			if(ThreadLocalRandom.current().nextInt(0, 100 + 1) <= mutation){
				child.setGen(i, getRandomGen(i));
			}
			else {
				if(i%2==0){
					child.setGen(i, parent1.getGen(i));
				}
				else{
					child.setGen(i, parent2.getGen(i));
				}
			}
		}
		return child;
	}


}
