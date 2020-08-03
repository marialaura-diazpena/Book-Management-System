package sait.bms.problemdomain;

/**
 * This is the program to identify "ChildrensBook" objects inherited from "Book"
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 12, 2020
 *
 */
public class ChildrensBook extends Book{

	//Attributes
	/**
	 * Two attributes of the ChildrensBook object
	 */
	private String authors;
	
	private char format;
	
	/**
	 * @param ISBN
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param authors
	 * @param format
	 */
	public ChildrensBook (long ISBN, String callNumber, int available, int total, String title, String authors, char format) {
		super(ISBN, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
		
	}
	
	/**
	 * this is the getter of the attribute autors
	 * @return the authors attribute of Paperback object
	 */
	public String getAuthors() {
		return authors;
	}
	
	/**
	 * this is the setter of the attribute authors
	 * @param authors to set
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	/**
	 * this is the getter of the attribute format
	 * @return the format attribute of Paperback object
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * this is the setter of the attribute format
	 * @param format to set
	 */
	public void setFormat(char format) {
		this.format = format;
	}
	
	/**
	 * This method formats each line in the file so it can be read by humans
	 */
	public String toString () {
		
		return String.format("%s %d \n%s %s \n%s %d \n%s %d \n%s %s \n%s %s \n%s %s", 
				"ISBN:             ", getISBN(), 
				"Call Number:      ", getCallNumber(), 
				"Available:        ", getAvailable(),
				"Total:            ", getTotal(), 
				"Title:            ", getTitle(), 
				"Author:           ", authors, 
				"Format:           ", format);  
	}
	
	/**
     * This is the method that enters strings into the file with the correct format.
     */
	public String formatToFile () {
		
		return String.format("%f;%s;%d;%d;%s;%s;%s", getISBN(), getCallNumber(), getAvailable(), getTotal(), getTitle(), authors, ( (format == 'P')? "Picture Book": (format == 'E')? "Early Readers": "Chapter Book") );  
	}
}
