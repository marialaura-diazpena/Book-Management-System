package sait.bms.problemdomain;

/**
 * This is the program to identify "Periodical" objects inherited from "Book"
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 12, 2020
 *
 */
public class Paperback extends Book{

	//Attributes
	/**
	 * Three attributes of the Paperback object
	 */
	private String authors;
	
	private String year;
	
	private char genre;
	
	
	/**
	 * This is the constructor of the Paperback class
	 * @param ISBN
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param authors
	 * @param year
	 * @param genre
	 */
	public Paperback(long ISBN, String callNumber, int available, int total, String title, String authors, String year, char genre) {
		super(ISBN, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
	
	}
	
	/**
	 * this is the getter of the attribute authors
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
	 * this is the getter of the attribute year
	 * @return the year attribute of Paperback object
	 */
	public String getYear() {
		return year;
	}

	/**
	 * this is the setter of the attribute year
	 * @param year to set
	 */
	public void setYear(String year) {
		this.year = year;
	
	}
	/**
	 * this is the getter of the attribute genre
	 * @return the genre attribute of Paperback object
	 */
	public char getGenre() {
		return genre;
	}

	/**
	 * this is the setter of the attribute genre
	 * @param genre to set
	 */
	public void setGenre(char genre) {
		this.genre = genre;
	}
	
	/**
	 * This method formats each line in the file so it can be read by humans
	 */
	public String toString () {
		
		return String.format("%s %d \n%s %s \n%s %d \n%s %d \n%s %s \n%s %s \n%s %s \n%s %s", 
				"ISBN:             ", getISBN(), 
				"Call Number:      ", getCallNumber(), 
				"Available:        ", getAvailable(),
				"Total:            ", getTotal(), 
				"Title:            ", getTitle(), 
				"Authors:          ", authors, 
				"Year:             ", year, 
				"Genre             ", genre);
	}
	
	/**
     * This is the method that enters strings into the file with the correct format.
     */
	public String formatToFile () {
		
		return String.format("%f;%s;%d;%d;%s;%s;%s;%s", getISBN(), getCallNumber(), getAvailable(), getTotal(), getTitle(), authors, year, ( (genre == 'A')? "Adventure": (genre == 'D')? "Drama": (genre == 'E')? "Education": (genre == 'C')? "Classic" : (genre == 'F')? "Fantasy" : "Science Fiction") );
	}

	
}
