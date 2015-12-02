/**
 * 
 */
package Week2Exercise3;

/**
 * @author Andy McCall
 *
 */
public class Week2Exercise3 {

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
	
	public static void printAll(String dna) {
		
		int startCodon=0;
		int stopCodon=0;
		
		while (startCodon != -1) {
			
			// Find the start codon
			startCodon = dna.toLowerCase().indexOf("atg", startCodon);

			
			// Find the stop codon
			if (startCodon != -1) {

				stopCodon = findStopIndex(dna.toLowerCase(), startCodon);

				if (stopCodon != -1) {
					System.out.println("Found gene: " + dna.substring(startCodon, stopCodon+3));
				}
				
				if ((stopCodon == -1) && (startCodon < dna.length())) {
					startCodon = startCodon+3;
				} else {
					startCodon = stopCodon;
				}
			}
		
		}
		
		System.out.println();
		return;
	}
	
	public static void testFinder(String dna) {
		
		System.out.println("DNA string is: " + dna);
		printAll(dna);
		
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		testFinder("ATGAAATGAAAA");
		
		testFinder("ccatgccctaataaatgtctgtaatgtaga");
	
		testFinder("CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA");
		
	}

}
