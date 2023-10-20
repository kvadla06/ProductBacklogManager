package edu.ncsu.csc216.product_backlog.model.backlog;

import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.io.ProductsReader;
import edu.ncsu.csc216.product_backlog.model.io.ProductsWriter;
import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Manages the products in the system
 * @author Kavya Vadla
 */
public class BacklogManager {
	/** instance of BacklogManager */
	private static BacklogManager singleton;
	/** list of products */
	private ArrayList<Product> products;
	/** current product in manager */
	private Product currentProduct;
	
	/**
	 * Construct a BacklogManager class in singleton design
	 */
	private BacklogManager() {
		
	}
	
	/**
	 * return instance of a BacklogManager
	 * @return instance of BacklogManager 
	 */
	public static BacklogManager getInstance() {
		if (singleton == null) {
			BacklogManager backlog = new BacklogManager();
			return backlog;
		}
		return singleton;
	}
	
	/**
	 * writes products to file
	 * @param fileName file to write to
	 * @throws IllegalArgumentException if project is null or there are no tasks in the project
	 */
	public void saveToFile(String fileName) {
		if (currentProduct == null || currentProduct.getTasks().size() == 0) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		ProductsWriter.writeProductsToFile(fileName, products);
	}
	
	/**
	 * reads the given file for products and their associated tasks
	 * @param fileName file to read
	 */
	public void loadFromFile(String fileName) {
		ArrayList<Product> product = ProductsReader.readProductsFile(fileName);
		for (int i = 0; i < product.size(); i++) {
			products.add(product.get(i));
			if (i == 0) {
				currentProduct = product.get(i);
			}
		}
	}
	
	/**
	 * find the product with given name in list and make it the current product
	 * @param productName name of product
	 * @throws IllegalArgumentException if product is not in the list
	 */
	public void loadProduct(String productName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName() == productName) {
				currentProduct = products.get(i);
			} else {
				throw new IllegalArgumentException("No product selected.");
			}
		}
	}
	
	/**
	 * returns a 2D string array to populate the GUI table
	 * @return 2D string array to populate GUI table
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public String[][] getTasksAsArray() {
		return null;
	}
	
	/**
	 * returns the task in list with given id, if theres no task with the id return null
	 * @param id id of task
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public Task getTaskById(int id) {
		if (currentProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		if (currentProduct.getTaskById(id) == null) {
			return null;
		}
		return currentProduct.getTaskById(id);
	}
	
	/**
	 * finds task with given id and updates with given command
	 * @param id id of task
	 * @param c Command to update task
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public void executeCommand(int id, Command c) {
		
	}
	
	/**
	 * removes task from list at given index
	 * @param id id of task
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public void deleteTaskById(int id) {
		if (currentProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		deleteTaskById(id);
	}
	
	/**
	 * creates new task with given information and adds to list
	 * @param title title of task
	 * @param type type of task
	 * @param creator creator of task
	 * @param note task note
	 */
	public void addTaskToProduct(String title, Type type, String creator, String note) {
		
	}
	
	/**
	 * returns name for currentProduct, if the currentProduct is null then null is returned
	 * @return name of product and null if product is null
	 */
	public String getProductName() {
		if (currentProduct == null) {
			return null;
		}
		return currentProduct.getProductName();
	}
	
	/**
	 * returns string array of product names
	 * @return string array of product names
	 */
	public String[] getProductList() {
		String[] productsString = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			productsString[i] = products.get(i).getProductName();
		}
		return productsString;
	}
	
	/**
	 * resets products to empty list and current product is set to null
	 */
	public void clearProducts() {
		products = new ArrayList<Product>();
		currentProduct = null;
	}
	
	/**
	 * updates currentProducts name to given value
	 * @param updateName name to be updated to 
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public void editProduct(String updateName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName() == updateName || updateName == null || updateName == "") {
				throw new IllegalArgumentException("Invalid product name.");
			}
		}
		if (currentProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		currentProduct.setProductName(updateName);
	}
	
	/** 
	 * adds new product to product list
	 * @param productName name of product
	 * @throws IllegalArgumentException if there is a product with the same name or if name is null or empty
	 */
	public void addProduct(String productName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductName() == productName || productName == null || productName == "") {
				throw new IllegalArgumentException("Invalid product name.");
			}
		}
		Product product = new Product (productName);
		products.add(product);
		loadProduct(productName);
		
	}
	
	/**
	 * deletes current product
	 * @throws IllegalArgumentException if current product is null when trying to delete
	 */
	public void deleteProduct() {
		if (currentProduct == null) {
			throw new IllegalArgumentException("No product selected.");
		}
		products.remove(currentProduct);
		if (products.size() == 0) {
			currentProduct = null;
		} else {
			currentProduct = products.get(0);
		}
	}
	
	/**
	 * resets backlog manager
	 */
	protected void resetManager() {
		singleton = null;
	}
}
