package edu.ncsu.csc216.product_backlog.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * Reads the file of products and processes it
 * @author Kavya Vadla
 */
public class ProductsReader {
		
	/**
	 * reads the file and processes it for products
	 * @param fileName file being read form
	 * @return products ArrayList of products
	 * @throws IllegalArgumentException if file is unable to be read
	 */
	public static ArrayList<Product> readProductsFile(String fileName) {
		String file = "";
		try {
			Scanner fileReader = new Scanner(new FileInputStream(fileName)); 
		   
		    while (fileReader.hasNextLine()) { 
		            file += fileReader.nextLine() + "\n";
		    }    
	    } catch (FileNotFoundException e) {
	    	throw new IllegalArgumentException("Unable to load file.");
	    }   
		Scanner productReader = new Scanner(file);
		productReader.useDelimiter("\\r?\\n?[#] ");
		ArrayList<Product> products = new ArrayList<Product>(); 
		while (productReader.hasNext()) {
			String product = productReader.next();
			Product productReturn = processProduct(product);
			products.add(productReturn);
			
		}
		productReader.close();
		return products;
	}
	
	/**
	 * helper method for readProductsFile to process products
	 * @param line product being processed
	 * @throws IllegalArgumentException if product reader has nothing to read
	 * @return product to be added to ArrayList
	 */
	private static Product processProduct(String line) {
		Scanner productReader = new Scanner(line);
		String productName = productReader.nextLine();
		Product product = new Product(productName);
		productReader.useDelimiter("\\r?\\n?[*] ");
		while(productReader.hasNext()) {
			String task = productReader.next();
			Task taskReturn = processTask(task);
			product.addTask(taskReturn);			
		}
		productReader.close();
		return product;
	}
	
	/**
	 * helper method for processProduct to process tasks of products
	 * @param line task being processed
	 * @throws throws IllegalArgumentException if task cannot be added
	 * @return task to be added to product's tasks list
	 */
	private static Task processTask(String line) {
		Scanner taskReader = new Scanner(line);
		String line2 = taskReader.nextLine();
		Scanner taskReaderValue = new Scanner(line2);
		taskReaderValue.useDelimiter("\\r?\\n?[,]");
		int id = 0;
		String state = "";
		String title = "";
		String type = "";
		String creator = "";
		String owner = "";
		String verified = "";
		String note = "";
		ArrayList<String> notes = new ArrayList<String>();
		try {
			id = taskReaderValue.nextInt();
			state = taskReaderValue.next();
			title = taskReaderValue.next();
			type = taskReaderValue.next();
			creator = taskReaderValue.next();
			owner = taskReaderValue.next();
			verified = taskReaderValue.next();
			taskReaderValue.close();
		} catch (InputMismatchException | IllegalArgumentException e) {
			taskReader.close();
			throw new IllegalArgumentException("Task cannot be added.");
		}
		if (!taskReader.hasNext()) {
			taskReader.close();
			throw new IllegalArgumentException();
		} else {
			while (taskReader.hasNext()) {
				taskReader.useDelimiter("\\r?\\n?[-] ");
				note = taskReader.next();
				notes.add(note);
			}
		}
		taskReader.close();
		return new Task(id, state, title, type, creator, owner, verified, notes);
	}
}
