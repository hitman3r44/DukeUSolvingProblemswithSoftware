/**
 * 
 */
package Week2Assignent1;
import edu.duke.*;
import java.io.*;

/**
 * @author Andy
 *
 */

public class Week2Assignment1 {

	/**
	 * @param args
	 */
	public static String findProtein(String dna) {
		int start = dna.indexOf("atg");
		if (start == -1) {
			return "";
		}
		int stop = dna.indexOf("tag", start+3);
		if ((stop - start) % 3 == 0) {
			return dna.substring(start, stop+3);
		}
		else {
			return "";
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String a = "cccatggggtttaaataataataggagagagagagagagttt";
		String ap = "atggggtttaaataataatag";
		//String a = "atgcctag";
		//String ap = "";
		//String a = "ATGCCCTAG";
		//String ap = "ATGCCCTAG";
		String result = findProtein(a);
		if (ap.equals(result)) {
			System.out.println("success for " + ap + " length " + ap.length());
		}
		else {
			System.out.println("mistake for input: " + a);
			System.out.println("got: " + result);
			System.out.println("not: " + ap);
		}

	}

}
