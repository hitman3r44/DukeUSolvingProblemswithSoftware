/**
 * 
 */
package Week3Exercise2;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import edu.duke.FileResource;

/**
 * @author Andy McCall
 *
 */
public class Week3Exercise2 {

	/**
	 * 
	 * Method to test coldestHourInFile and print out
	 * information about that coldest temperature,
	 * such as the time of its occurrence.
	 * 
	 */
	public void testColdestHourInFile() {
		
	}
	
	/**
	 * 
	 * @param parser
	 * @return
	 * 
	 * This method returns the CSVRecord with the coldest
	 * temperature in the file and thus all the information
	 * about the coldest temperature, such as the hour of
	 * the coldest temperature.
	 * 
	 * NOTE: Sometimes there was not a valid reading at a
	 * specific hour, so the temperature field says -9999.
	 * You should ignore these bogus temperature values
	 * when calculating the lowest temperature.
	 * 
	 */
	public CSVRecord coldestHourInFile(CSVParser parser) {
		
		CSVRecord record = null;
		
		return record;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
