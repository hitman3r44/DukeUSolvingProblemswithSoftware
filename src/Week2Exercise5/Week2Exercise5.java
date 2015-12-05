/**
 * 
 */
package Week2Exercise5;

import edu.duke.StorageResource;
import edu.duke.URLResource;

/**
 * @author Andy McCall
 *
 */
public class Week2Exercise5 {

	public static StorageResource  findURLs(String url) {
		
		StorageResource urls = new StorageResource();
		URLResource resource = new URLResource(url);
		
		for (String word : resource.words()) {
			int foundLink = word.indexOf("href");
			if (foundLink > -1) {
				
				int startOfLink = word.indexOf("\"", foundLink);

				// Rules state must start with a "
				if (startOfLink != -1) {

					int endOfLink = word.indexOf("\"", startOfLink + 1);

					// Rules state must end with a "
					if (endOfLink != -1) {

						// Check for the presence of http(s)
						int externalLink = word.substring(startOfLink, endOfLink + 1).indexOf("http");

						// If its not an external link, ignore
						if (externalLink > -1) {
							urls.add(word.substring(startOfLink, endOfLink + 1));
						}

					}

				}
			}

        }
		
		
		return urls;
	}
	
	public static void testURLWithStorage() {
		
		StorageResource urls = new StorageResource();
		int https=0;
		int http=0;
		int com=0;
		int dot=0;
		int endsCom=0;
	
		urls = findURLs("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		
		
		for (String url : urls.data()) {
			if (url.indexOf("https") > -1 ) {
				https++;
			} else {
				http++;
			}
			if (url.indexOf(".com") > -1 ) {
				com++;
			}
			
			// TODO count how many strings end with .com or .com/
			
			for (int i=0; i < url.length(); i++) {
				if (url.charAt(i) == '.') {
					dot++;
				}
			}
			System.out.println(url);
		}
		
		System.out.println("urls: " + urls.size());
		System.out.println("http urls: " + http);
		System.out.println("https urls: " + https);
		System.out.println(".com urls: " + com);
		System.out.println("Ending with .com or .com/ urls: " + endsCom);
		System.out.println(". :" + dot);
		
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		testURLWithStorage();

	}

}
