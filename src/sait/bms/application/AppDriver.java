package sait.bms.application;

import java.io.IOException;

import sait.bms.managers.*;

/**
 * This is the program where BookManagementSystem class runs the menu
 * and the options
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version June 12, 2020
 *
 */
public class AppDriver {

	/**
	 * This is the main method, where the book management system program starts
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/**
		 * We created a BookManagementSystem object
		 */
		BookManagementSystem bms = new BookManagementSystem();
		
		/**
		 * We call the displayMenu instance method from the BookManagementSystem
		 */
		bms.displayMenu();
	}
}
