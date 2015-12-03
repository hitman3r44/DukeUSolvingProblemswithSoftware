package Week2Exercise4;

import edu.duke.FileResource;
import edu.duke.StorageResource;

/**
 * @author Andy McCall
 *
 */
public class Week2Exercise4 {

	public static double cgRatio() {
		
		//TODO 
		double ratio = 4.5;
		
		return ratio;
	}
	
	public static int findStopIndex(String dna, int index) {
		
		int[] lengthArray = {0,0,0};

		// Look for TAG Codon
		int stopTAG = dna.indexOf("tag", index + 3);
		if (stopTAG != -1) {
			if ((stopTAG - index) % 3 == 0) {
				lengthArray[0] = dna.substring(index, stopTAG + 3).length();
			}
		}

		// Look for TGA Codon
		int stopTGA = dna.indexOf("tga", index + 3);
		if (stopTGA != -1) {
			if ((stopTGA - index) % 3 == 0) {
				lengthArray[1] = dna.substring(index, stopTGA + 3).length();
			}
		}

		// Look for TAA Codon
		int stopTAA = dna.indexOf("taa", index + 3);
		if (stopTAA != -1) {
			if ((stopTAA - index) % 3 == 0) {
				lengthArray[2] = dna.substring(index, stopTAA + 3).length();
			}
		}

		int smallestGene = Integer.MAX_VALUE;
		for (int i = 0; i < lengthArray.length; i++) {
			if (lengthArray[i] > 0 && lengthArray[i] < smallestGene) {
				smallestGene = lengthArray[i];
			}
		}

		if (smallestGene != Integer.MAX_VALUE) {
			return index + smallestGene - 3;
		}
	    
	    return -1;
	    	
	}
	
	
	public static StorageResource storeAll(String dna) {
		
		int startCodon=0;
		int stopCodon=0;
		StorageResource codonStorage = new StorageResource();
		
		while (startCodon != -1) {
			
			// Find the start codon
			startCodon = dna.toLowerCase().indexOf("atg", startCodon);
			
			// Find the stop codon
			if (startCodon != -1) {
				stopCodon = findStopIndex(dna.toLowerCase(), startCodon);
				if (stopCodon != -1) {
					codonStorage.add(dna.substring(startCodon, stopCodon+3));
				}
				if ((stopCodon == -1) && (startCodon < dna.length())) {
					startCodon = startCodon+3;
				} else {
					startCodon = stopCodon;
				}
			}
		
		}

		return codonStorage;
	}
	
	
	public static void testStorageFinder(String filePath) {
		
		FileResource file = new FileResource(filePath);
		
		String dna = file.asString();
		
		StorageResource dnaStorage = storeAll(dna);
			
		System.out.println(dnaStorage.size());
	
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		testStorageFinder("C:\\Users\\Andy\\DukeUSolvingProblemswithSoftware\\DukeUSolvingProblemswithSoftware\\src\\Week2Exercise4\\GRch38dnapart.fa");
	}

}
