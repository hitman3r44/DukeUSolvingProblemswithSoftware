/**
 * 
 */
package Week3Exercise2;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
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
	
		FileResource file = new FileResource("C:\\Users\\Andy\\DukeUSolvingProblemswithSoftware\\DukeUSolvingProblemswithSoftware\\src\\Week3Exercise2\\nc_weather\\2013\\weather-2013-01-23.csv");
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
		
		System.out.println("Coldest day was in file " + fileWithColdestTemperature());
		
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
	
		DirectoryResource dir = new DirectoryResource();
		String coldestFile="";
		CSVRecord coldestRecord = null;
		double coldest=0;
		
		for (File selectedFile : dir.selectedFiles()) {
			FileResource file = new FileResource(selectedFile);
			CSVParser parser = file.getCSVParser();
			
			CSVRecord tempColdestRecord = null;
			double tempColdest=0;
			
			if (coldestRecord == null) {
				coldestRecord = coldestHourInFile(parser);
				parser = file.getCSVParser();
				coldest = Double.parseDouble(coldestRecord.get("TemperatureF"));
				coldestFile = selectedFile.getName();
			}
			
				tempColdestRecord = coldestHourInFile(parser);
				tempColdest = Double.parseDouble(tempColdestRecord.get("TemperatureF"));
				
				if ( tempColdest < coldest ) {
							coldestRecord=tempColdestRecord;
							coldest = tempColdest;
							coldestFile = selectedFile.getName();
						}
		}
	
		return coldestFile;
		
	}
	
	/**
	 * 
	 * Method to test lowestHumidityInFile and print
	 * out information about the file.
	 * 
	 */
	public static void testLowestHumidityInFile() {
		
		FileResource file = new FileResource("C:\\Users\\Andy\\DukeUSolvingProblemswithSoftware\\DukeUSolvingProblemswithSoftware\\src\\Week3Exercise2\\nc_weather\\2013\\weather-2013-03-10.csv");
		CSVParser parser = file.getCSVParser();
		
		CSVRecord record = lowestHumidityInFile(parser);
		
		System.out.println(record.toString());
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
		
		CSVRecord lowestRecord = null;
		
		for (CSVRecord record : parser) {
			
			double humidityLowest=0;
			
			if (lowestRecord == null) {
				lowestRecord = record;
			}
			
			humidityLowest = Double.parseDouble(record.get("Humidity"));
			
			if (humidityLowest != -9999) {
				if (humidityLowest < Double.parseDouble(lowestRecord.get("Humidity"))) {
					lowestRecord = record;
				}
			}
		}
		
		return lowestRecord;
	}
	
	/**
	 * 
	 * Method to test fileWithColdestTemperature and print
	 * out information about the file.
	 * 
	 */
	public static void testFileWithLowestHumidity() {
		
		System.out.println("Lowest humidity day was in file " + fileWithLowestHumidity());
		
		return;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * This method should return a string that is the name of
	 * the file from selected files that has the lowest
	 * humidity.
	 * 
	 */
	public static String fileWithLowestHumidity() {
	
		DirectoryResource dir = new DirectoryResource();
		String lowestFile="";
		CSVRecord lowestRecord = null;
		double lowest=0;
		
		for (File selectedFile : dir.selectedFiles()) {
			FileResource file = new FileResource(selectedFile);
			CSVParser parser = file.getCSVParser();
			
			CSVRecord tempLowestRecord = null;
			double tempLowest=0;
			
			if (lowestRecord == null) {
				lowestRecord = lowestHumidityInFile(parser);
				parser = file.getCSVParser();
				lowest = Double.parseDouble(lowestRecord.get("Humidity"));
				lowestFile = selectedFile.getName();
			}
			
				tempLowestRecord = lowestHumidityInFile(parser);
				tempLowest = Double.parseDouble(tempLowestRecord.get("Humidity"));
				
				if ( tempLowest < lowest ) {
					lowestRecord=tempLowestRecord;
					lowest = tempLowest;
					lowestFile = selectedFile.getName();
						}
		}
	
		return lowestFile;
		
	}
	
	/**
	 * 
	 * Method to test fileWithColdestTemperature and print
	 * out information about the file.
	 * 
	 */
	public static void testAverageTemperatureInFile() {
		
		FileResource file = new FileResource("C:\\Users\\Andy\\DukeUSolvingProblemswithSoftware\\DukeUSolvingProblemswithSoftware\\src\\Week3Exercise2\\nc_weather\\2013\\weather-2013-08-10.csv");
		CSVParser parser = file.getCSVParser();
		
		System.out.println(averageTemperatureInFile(parser));
		
		return;
	}
	
	public static double averageTemperatureInFile(CSVParser parser) {
		
		double averageTemperature=0;
		int numberOfSamples=0;
		
		CSVRecord lowestRecord = null;
		
		for (CSVRecord record : parser) {
			
			numberOfSamples++;
			
			double tempAT = Double.parseDouble(record.get("TemperatureF"));
			System.out.println(numberOfSamples + "," + tempAT);
			
			averageTemperature =averageTemperature+tempAT;

		}
		
		return averageTemperature/numberOfSamples;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//testColdestHourInFile();
		
		//testFileWithColdestTemperature();
		
		//testLowestHumidityInFile();
		
		//testFileWithLowestHumidity();

		testAverageTemperatureInFile();

	}

}
