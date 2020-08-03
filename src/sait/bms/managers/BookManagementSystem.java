package sait.bms.managers;

import sait.bms.problemdomain.*;
import java.io.*;
import java.util.*;
/**
 * This program loads the file and reads from it. Also displays a menu with
 * the following options:
 * -Checkout a book
 * -Find books by title
 * -Display books of a specific type
 * -Produce a list of random books
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 12, 2020
 */

public class BookManagementSystem {
	/**
	 * The constant String that contains the path to the file
	 */
	private static final String PATH = "res//books.txt";

	/**
	 * This is the scanner we use to read from the file
	 */
	Scanner inFile = new Scanner(new File(PATH));
	//attributes
	/**
	 * The bookType variable, used to access the ISBN of the books
	 */
	long bookType;

	/**
	 * Used to temporarily store the books
	 */
	Book tmpBook;

	/**
	 * Scanner for inputs in the program
	 */
	private Scanner input;

	/**
	 * The array used to store each column of the file, divided by semicolons
	 */
	String[] columns;

	/**
	 * This arrayList stores all the books.
	 */
	ArrayList<Book> books;

	//Constructor
	/**
	 * This is the default constructor.
	 * @throws FileNotFoundException
	 */

	public BookManagementSystem () throws FileNotFoundException {
		input = new Scanner(System.in);

		books = new ArrayList<Book>();

		loadBookList();
	}

	//Methods
	/**
	 * The displayMenu method. Prompts the user with the menu. Each option calls a specific different method.
	 * @throws IOException
	 */
	public void displayMenu() throws IOException {
		int option = -1;

		while (option != 5) {
			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.println("1     Checkout Book");
			System.out.println("2     Find Books by Title");
			System.out.println("3     Display Books by Type");
			System.out.println("4     Produce Random Book List");
			System.out.println("5     Save & Exit");

			System.out.print("Enter an option: ");
			option = input.nextInt();

			switch (option) {
			case 1:
				checkoutBook();
				break;

			case 2:
				bookByTitle();
				break;

			case 3:
				bookByType();
				break;

			case 4:
				randomBookList();
				break;

			case 5:
				System.out.println("Closing...");
				break;

			default:
				System.out.println("Invalid option!");
			}
		}

	}

	/**
	 * checkoutBook method checks out the book title by using the ISBN 
	 * @throws FileNotFoundException 
	 */
	public void checkoutBook() throws FileNotFoundException{

		System.out.print("Enter ISBN of book: ");
		long isbn = input.nextLong();

		while(inFile.hasNextLine()) {
			String line = inFile.nextLine();
			columns = line.split(";");

			bookType = Long.parseLong(columns[0]);

			if (isbn == bookType) {
				System.out.println("The book \"" + columns[4] + "\" has been checked out.");
				System.out.println("It can be located using a call number: " + columns[1]);
				System.out.println("");
			}

		}
	}

	/**
	 * bookByTitle method checks for the book that matches the title search
	 * Instructor Khosro Salmani gave us his advice on this method
	 */
	public void bookByTitle() {

		System.out.print("Enter title to search for: ");
		String search = input.next();

		System.out.println("Matching Books: ");

		for (Book b :books) {

			if (b.getTitle().toLowerCase().contains(search.toLowerCase())) {

				System.out.println(b);
				System.out.println("");
			}
		}


	}

	/**
	 * bookByType method checks for books by type entered
	 * Instructor Khosro Salmani gave us his advice on this method
	 * @param book 
	 * @throws FileNotFoundException 
	 */
	public void bookByType() throws FileNotFoundException {


		System.out.println("#     Type");
		System.out.println("1     Children's Books");
		System.out.println("2     Cookbooks");
		System.out.println("3     Paperbacks");
		System.out.println("4     Periodicals");
		System.out.println("");
		System.out.print("Enter type of book: ");
		int type = input.nextInt();


		switch(type) {

		case 1:
			System.out.print("Enter a format (P for Picture Book, E for Early Reader or C for Chapter Book): ");
			String bmsFormat = input.next().toUpperCase();

			for (Book tmpBook :books) {

				if (tmpBook instanceof ChildrensBook) {

					ChildrensBook childB = (ChildrensBook) tmpBook;

					if (((ChildrensBook)tmpBook).getFormat() == bmsFormat.charAt(0)) {

						System.out.println(tmpBook);
						System.out.println("");
					}

				}

			}

			break;

		case 2:
			System.out.print("Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
			String bmsDiet = input.next().toUpperCase();

			for (Book tmpBook :books) {

				if (tmpBook instanceof Cookbook) {

					Cookbook cookB = (Cookbook) tmpBook;

					if (((Cookbook)tmpBook).getDiet() == bmsDiet.charAt(0)) {

						System.out.println(tmpBook);
						System.out.println("");
					}

				}

			}

			break;

		case 3:
			System.out.print("Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
			String bmsGenre = input.next().toUpperCase();

			for (Book tmpBook :books) {

				if (tmpBook instanceof Paperback) {

					Paperback Paper = (Paperback) tmpBook;

					if (((Paperback)tmpBook).getGenre() == bmsGenre.charAt(0)) {

						System.out.println(tmpBook);
						System.out.println("");
					}

				}

			}


			break;

		case 4:
			System.out.print("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
			String bmsFreq = input.next().toUpperCase();

			for (Book tmpBook :books) {

				if (tmpBook instanceof Periodical) {

					Periodical Period = (Periodical) tmpBook;

					if (((Periodical)tmpBook).getFrequency() == bmsFreq.charAt(0)) {

						System.out.println(tmpBook);
						System.out.println("");
					}

				}

			}
			break;

		default:
			System.out.println("Invalid Option!");

			break;
		}

	}



	/**
	 * randomBookList method generates a list of random books, as many as you 
	 * specify, and displays the information of the books.
	 * @throws FileNotFoundException 
	 */
	public void randomBookList() throws FileNotFoundException{

		System.out.print("Enter number of books: ");
		int numBooks = input.nextInt();
		System.out.println("");
		System.out.println("Random Book:");
		for (int i = numBooks; i > 0; i--) {

			Collections.shuffle(books);
			System.out.println(books.get(0).toString());
			System.out.println("");
		}

	}

	/**
	 * loadBookList method loads the books into the program and adds them into categories based on their ISBN
	 * @throws FileNotFoundException 
	 */
	public void loadBookList() throws FileNotFoundException {

		String line = "";


		while(inFile.hasNextLine()) {
			line = inFile.nextLine();
			columns = line.split(";");

			bookType = Long.parseLong(columns[0]);

			if ((bookType%10) == 0 || (bookType%10) == 1) {

				books.add(new ChildrensBook(Long.parseLong(columns[0]), columns[1], Integer.parseInt(columns[2]), Integer.parseInt(columns[3]), columns[4], columns[5], columns[6].charAt(0)));
			}
			else if ((bookType%10) == 2 || (bookType%10) == 3) {

				books.add(new Cookbook(Long.parseLong(columns[0]), columns[1], Integer.parseInt(columns[2]), Integer.parseInt(columns[3]), columns[4], columns[5], columns[6].charAt(0)));
			}
			else if ((bookType%10) == 4 || (bookType%10) == 7) {

				books.add(new Paperback(Long.parseLong(columns[0]), columns[1], Integer.parseInt(columns[2]), Integer.parseInt(columns[3]), columns[4], columns[5], columns[6], columns[7].charAt(0)));
			}
			else {

				books.add(new Periodical(Long.parseLong(columns[0]), columns[1], Integer.parseInt(columns[2]), Integer.parseInt(columns[3]), columns[4], columns[5].charAt(0)));
			}

		}
		inFile.close();
		System.out.println("File is loaded!");
	}


}
