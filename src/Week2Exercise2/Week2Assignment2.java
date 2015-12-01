/**
 * 
 */
package Week2Exercise2;

import edu.duke.*;
import java.io.File;

/**
 * @author Andy McCall
 *
 */
public class Week2Assignment2 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String page = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
		
		URLResource resource = new URLResource(page);
        for (String word : resource.words()) {
    		int foundLink = word.indexOf("youtube.com");
    		if (foundLink > -1) {
    			int startOfLink = word.indexOf("\"");
    			int endOfLink = word.indexOf("\"", startOfLink+1);
    			System.out.println(word.substring(startOfLink,endOfLink+1));
    		}

        }
		
	}

}
