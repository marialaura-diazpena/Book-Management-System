package sait.bms.problemdomain;

/**
 * This is the program to identify "Cookbook" objects inherited from "Book"
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 12, 2020
 *
 */
public class Cookbook extends Book{

	//Attributes
	/**
	 * Three attributes of the Cookbook object
	 */
	private String publisher;
	
	private char diet;
	
	/**
	 * This is the constructor of the Cookbook class
	 * @param ISBN
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param publisher
	 * @param diet
	 */
	public Cookbook(long ISBN, String callNumber, int available, int total, String title, String publisher, char diet) {
		super(ISBN, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
		
	}
	
	/**
	 * this is the getter of the attribute publisher
	 * @return the publisher attribute of Paperback object
	 */
	public String getPublisher() {
		return publisher;
		
	}
	
	/**
	 * this is the setter of the attribute publisher
	 * @param publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
		
	}
	
	/**
	 * this is the getter of the attribute diet
	 * @return the diet attribute of Paperback object
	 */
	public char getDiet() {
		return diet;
		
	}
	
	/**
	 * this is the setter of the attribute diet
	 * @param diet to set
	 */
	public void setDiet(char diet) {
		this.diet = diet;
	}
	
	/**
	 * This method formats each line in the file so it can be read by humans
	 */
	public String toString () {
		
		return String.format ("%s %d \n%s %s \n%s %d \n%s %d \n%s %s \n%s %s \n%s %s", 
				"ISBN:             ", getISBN(), 
				"Call Number:      ", getCallNumber(), 
				"Available:        ", getAvailable(),
				"Total:            ", getTotal(), 
				"Title:            ", getTitle(), 
				"Publisher:        ", publisher, 
				"Diet:             ", diet);	
	}

	/**
     * This is the method that enters strings into the file with the correct format.
     */
	public String formatToFile () {
		
		return String.format("%f;%s;%d;%d;%s;%s;%s", getISBN(), getCallNumber(), getAvailable(), getTotal(), getTitle(), publisher, ( (diet == 'D')? "Diabetic": (diet == 'V')? "Vegetarian": (diet == 'G')? "Gluten-free": (diet == 'I')? "International" : "None") );  
	}
}
