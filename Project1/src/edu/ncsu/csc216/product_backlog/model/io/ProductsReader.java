package edu.ncsu.csc216.product_backlog.model.io;

import java.util.ArrayList;

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
		return null;
	}
	
	/**
	 * helper method for readProductsFile to process products
	 * @param line product being processed
	 * @return product to be added to ArrayList
	 */
	private static Product processProduct(String line) {
		return null;
	}
	
	/**
	 * helper method for processProduct to process tasks of products
	 * @param line task being processed
	 * @return task to be added to product's tasks list
	 */
	private static Task processTask(String line) {
		return null;
	}
}
