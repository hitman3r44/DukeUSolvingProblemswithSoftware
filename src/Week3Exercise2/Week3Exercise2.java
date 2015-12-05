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
	public static void testColdestHourInFile() {
	
		FileResource file = new FileResource("C:\\Users\\Andy\\DukeUSolvingProblemswithSoftware\\DukeUSolvingProblemswithSoftware\\src\\Week3Exercise2\\nc_weather\\2015\\weather-2015-01-04.csv");
		CSVParser parser = file.getCSVParser();
		
		CSVRecord record = coldestHourInFile(parser);
		
		System.out.println(record.toString());
				
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
	public static CSVRecord coldestHourInFile(CSVParser parser) {
		
		CSVRecord coldestRecord = null;
		
		for (CSVRecord record : parser) {
			
			double tempColdest=0;
			
			if (coldestRecord == null) {
				coldestRecord = record;
			}
			
			tempColdest = Double.parseDouble(record.get("TemperatureF"));
			
			if (tempColdest != -9999) {
				if (tempColdest < Double.parseDouble(coldestRecord.get("TemperatureF"))) {
					coldestRecord = record;
				}
			}
		}
		
		return coldestRecord;
	}
	
	/**
	 * 
	 * Method to test fileWithColdestTemperature and print
	 * out information about the file.
	 * 
	 */
	public static void testFileWithColdestTemperature() {
		
		return;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * This method should return a string that is the name of
	 * the file from selected files that has the coldest
	 * temperature.
	 * 
	 */
	public static String fileWithColdestTemperature() {
	
		String filename="";
		
		return filename;
		
	}
	
	/**
	 * 
	 * Method to test lowestHumidityInFile and print
	 * out information about the file.
	 * 
	 */
	public static void testLowestHumidityInFile() {
		
		return;
	}
	
	/**
	 * 
	 * @param parser
	 * @return
	 * 
	 * This method returns the CSVRecord that has the lowest
	 * humidity. If there is a tie, then return the first
	 * such record that was found.
	 * 
	 */
	
	public static CSVRecord lowestHumidityInFile(CSVParser parser) {
		
		CSVRecord record=null;
		
		return record;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		testColdestHourInFile();
		
		testFileWithColdestTemperature();
		
		testLowestHumidityInFile();

	}

}
