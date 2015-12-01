/**
 * 
 */
package Week2Exercise1;
import edu.duke.*;
import java.io.*;

/**
 * @author Andy McCall
 *
 */

public class Week2Assignment1 {

	/**
	 * @param args
	 */
	public static String findProtein(String dna) {
		
		int startATG = dna.indexOf("atg");
		if (startATG == -1) {
			return "";
		}
		
		//TAG Codon
		int stopTAG = dna.indexOf("tag", startATG+3);
		if ((stopTAG - startATG) % 3 == 0) {
			return dna.substring(startATG, stopTAG+3);
		}
	
		//TGA Codon
		int stopTGA = dna.indexOf("tga", startATG+3);
		if ((stopTGA - startATG) % 3 == 0) {
			return dna.substring(startATG, stopTGA+3);
		}
			
		//TAA Codon
		int stopTAA = dna.indexOf("taa", startATG+3);
		if ((stopTAA - startATG) % 3 == 0) {
			return dna.substring(startATG, stopTAA+3);
		}
		else {
			return "";
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String test1 = "AATGCTAGTTTAAATCTGA";
		String result1 = "ATGCTAGTTTAAATCTGA";
		
		String test2 = "ataaactatgttttaaatgt";
		String result2 = "atgttttaa";

		
		String test3 = "acatgataacctaag";
		String result3 = "";

		
		String result = findProtein(test1.toLowerCase());
		
		if (result1.toLowerCase().equals(result)) {
			System.out.println("success for " + result1 + " length " + result1.length());
		}
		else {
			System.out.println("mistake for input: " + test1);
			System.out.println("got: " + result);
			System.out.println("not: " + result1);
		}

		result = findProtein(test2);
		
		if (result2.equals(result)) {
			System.out.println("success for " + result2 + " length " + result2.length());
		}
		else {
			System.out.println("mistake for input: " + test2);
			System.out.println("got: " + result);
			System.out.println("not: " + result2);
		}
		
		result = findProtein(test3);
		
		if (result3.equals(result)) {
			System.out.println("success for " + result3 + " length " + result3.length());
		}
		else {
			System.out.println("mistake for input: " + test3);
			System.out.println("got: " + result);
			System.out.println("not: " + result3);
		}
		
	}

}
