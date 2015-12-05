package Week2Exercise4;

import edu.duke.FileResource;
import edu.duke.StorageResource;

/**
 * @author Andy McCall
 *
 */
public class Week2Exercise4 {

	public static float cgRatio(String dna) {
		
		int countCG = 0;
	
		for (int i=0; i<dna.length(); i++) {
			if (dna.toLowerCase().charAt(i) == 'c' || dna.toLowerCase().charAt(i) == 'g') {
				countCG++;
			}
		}
		
		return ((float)countCG/dna.length());
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
			return index + smallestGene -3;
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
					startCodon = stopCodon+3;
				}
			}
		
		}

		return codonStorage;
	}
	
	public static void printGenes(StorageResource sr) {
		
		int count60=0;
		int countCG=0;
		int length=0;
		int count=0;
		
		for (String sequence : sr.data()) {
			count++;
			System.out.println(count + ": " + sequence);
			if (sequence.length() > length) {
				length = sequence.length();
			}
			if (sequence.length() > 60) {
				//System.out.println("Sequence with length greater than 60 found: " + sequence);
				count60++;
			}
			if (cgRatio(sequence) > 0.35) {
				//System.out.println("CG Ratio greater than 0.35 found: " + sequence);
				countCG++;
			}
		}
		
		System.out.println("Longest sequence: " + length);
		System.out.println("Total sequences with length greater than 60: " + count60);
		System.out.println("Total sequences with CG ratio greater than 3.5: " + countCG);
		
		return;
	}
	
	public static void testStorageFinder(String filePath) {
		
		FileResource file = new FileResource(filePath);
		
		String dna = file.asString();
		System.out.println(dna.length());
		
		StorageResource dnaStorage = storeAll(dna);
			
		System.out.println("Total sequences: " + dnaStorage.size());
	
		printGenes(dnaStorage);
		
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		testStorageFinder("C:\\Users\\Andy\\DukeUSolvingProblemswithSoftware\\DukeUSolvingProblemswithSoftware\\src\\Week2Exercise4\\GRch38dnapart.fa");
	}

}
