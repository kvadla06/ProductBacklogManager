package edu.ncsu.csc216.product_backlog.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * Reads the file of products and processes it
 * @author Kavya Vadla
 */
public class ProductsReader {
	
	/** 
	 * Constructor of ProductsReader
	 */
	public ProductsReader() {
		
	}
	
	/**
	 * reads the file and processes it for products
	 * @param fileName file being read form
	 * @return products ArrayList of products
	 * @throw IllegalArgumentException if file is unable to be read
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
		productReader.useDelimiter("\\\\r?\\\\n?[#]");
		ArrayList<Product> products = new ArrayList<Product>(); 
		while (productReader.hasNextLine()) {
			String product = productReader.nextLine();
			Product productReturn = processProduct(product);
			products.add(productReturn);
			
		}
		productReader.close();
		return products;
	}
	
	/**
	 * helper method for readProductsFile to process products
	 * @param line product being processed
	 * @return product to be added to ArrayList
	 */
	private static Product processProduct(String line) {
		Scanner productReader = new Scanner(line);
		if (!productReader.hasNext()) {
			productReader.close();
			throw new IllegalArgumentException();
		}
		String productName = productReader.nextLine();
		Product product = new Product(productName);
		productReader.useDelimiter("\\\\r?\\\\n?[*]");
		while(productReader.hasNextLine()) {
			String task = productReader.nextLine();
			Task taskReturn = processTask(task);
			product.addTask(taskReturn);			
		}
		productReader.close();
		return product;
	}
	
	/**
	 * helper method for processProduct to process tasks of products
	 * @param line task being processed
	 * @throws theow
	 * @return task to be added to product's tasks list
	 */
	private static Task processTask(String line) {
		Scanner taskReader = new Scanner(line);
		taskReader.useDelimiter(",");
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
			id = taskReader.nextInt();
			state = taskReader.next();
			title = taskReader.next();
			type = taskReader.next();
			creator = taskReader.next();
			owner = taskReader.next();
			verified = taskReader.next();
		} catch (IllegalArgumentException e) {
			taskReader.close();
			throw new IllegalArgumentException();
		}
		taskReader.useDelimiter("\\\\r?\\\\n?[-]");
		if (!taskReader.hasNext()) {
			taskReader.close();
			throw new IllegalArgumentException();
		}
		while (taskReader.hasNext()) {
			note = taskReader.next();
			notes.add(note);
		}
		taskReader.close();
		return new Task(id, state, title, type, creator, owner, verified, notes);
	}
}
