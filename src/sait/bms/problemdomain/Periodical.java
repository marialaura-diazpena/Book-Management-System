package sait.bms.problemdomain;

/**
 * This is the program to identify "Periodical" objects inherited from "Book"
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 12, 2020
 *
 */
public class Periodical extends Book{

	//Attributes
	/**
	 * This is the attribute of the subclass Periodical
	 */
	private char frequency;
	
	/** This is the constructor of the Periodical class
	 * @param ISBN
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param frequency
	 */
	public Periodical(long ISBN, String callNumber, int available, int total, String title, char frequency) {
		super(ISBN, callNumber, available, total, title);
		this.frequency = frequency;
	}
	
	/**
	 * this is the getter of the attribute frequency
	 * @return the frequency attribute of Paperback object
	 */
	public char getFrequency() {
		return frequency;
	}
	
	/**
	 * this is the setter of the attribute frequency
	 * @param frequency to set
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * This method formats each line in the file so it can be read by humans
	 */
	public String toString() {
        return String.format("%s %d \n%s %s \n%s %d \n%s %d \n%s %s \n%s %s", 
        		"ISBN:             ", getISBN(), 
        		"Call Number:      ", getCallNumber(), 
        		"Available:        ", getAvailable(),
        		"Total:            ", getTotal(), 
        		"Title:            ", getTitle(),
        		"Frequency:        ", frequency);    
    }
	
	/**
     * This is the method that enters strings into the file with the correct format.
     */
    public String formatToFile() {
        return String.format("%f;%s;%d;%d;%s;%s", getISBN(), getCallNumber(), getAvailable(), getTotal(), getTitle(), ( (frequency == 'D')? "Daily": (frequency == 'W')? "Weekly": (frequency == 'M')? "Monthly": (frequency == 'B')? "Bimonthly" : "Quarterly"));
    }
}
