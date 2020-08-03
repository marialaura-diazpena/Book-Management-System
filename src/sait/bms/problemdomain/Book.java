package sait.bms.problemdomain;

/**
 * This is the program to identify Book objects
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 12, 2020
 *
 */
public class Book {

	//Attributes
	/**
	 * This is the book's ISBN number
	 */
	private long ISBN;
	/**
	 * This is the book's Call Number
	 */
	private String callNumber;
	/**
	 * This is the number of 
	 * availability of the book
	 */
	private int available;
	/**
	 * This is the total number 
	 * of the book
	 */
	private int total;
	/**
	 * This is the title of the book
	 */
	private String title;
	
	/**
	 * @param ISBN
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 */
	public Book (long ISBN, String callNumber, int available, int total, String title) {
		this.ISBN = ISBN;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
		
	}
	
	/**
	 * this is the getter of the attribute ISBN
	 * @return the ISBN attribute of Book object
	 */
	public long getISBN() {
		return ISBN;
	}
	
	
	/**
	 * this is the setter of the attribute ISBN
	 * @param ISBN to set 
	 */
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
	/**
	 * this is the getter of the attribute ISBN
	 * @return the ISBN attribute of Book object
	 */
	public String getCallNumber() {
		return callNumber;
	}
	
	/**
	 * this is the setter of the attribute callNumber
	 * @param callNumber to set
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
	/**
	 * this is the getter of the attribute int available
	 * @return the available attribute of Book object
	 */
	public int getAvailable() {
		return available;
	}
	
	/**
	 * this is the setter of the attribute available
	 * @param available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}
	
	/**
	 * this is the getter of the attribute int total
	 * @return the total attribute of Book object
	 */
	public int getTotal() {
		return total;
	}
	
	/**
	 * this is the setter of the attribute total
	 * @param total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
	/**
	 * this is the getter of the attribute string title
	 * @return the title attribute of Book object
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * this is the setter of the attribute title
	 * @param title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * This method formats each line in the file so it can be read by humans
	 */
	public String toString() {
        return String.format("%s %d \n%s %s \n%s %d \n%s %d \n%s %s", 
        		"ISBN:             ", ISBN, 
        		"Call Number:      ", callNumber, 
        		"Available:        ", available, 
        		"Total:            ", total, 
        		"Title:            ",  title);
    }
    /**
     * This is the method that enters strings into the file with the correct format.
     * @return
     */
    public String formatToFile() {
        return String.format("%d;%s;%d;%d;%s", ISBN, callNumber, available, total, title);
    }
	
}
