package edu.ncsu.csc216.product_backlog.model.backlog;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Manages the products in the system
 * @author Kavya Vadla
 */
public class BacklogManager {
	
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
		return null;
	}
	
	/**
	 * writes products to file
	 * @param fileName file to write to
	 * @throws IllegalArgumentException if project is null or there are no tasks in the project
	 */
	public void saveToFile(String fileName) {
		
	}
	
	/**
	 * reads the given file for products and their associated tasks
	 * @param fileName file to read
	 */
	public void loadFromFile(String fileName) {
		
	}
	
	/**
	 * find the product with given name in list and make it the current product
	 * @param productName name of product
	 * @throws IllegalArgumentException if product is not in the list
	 */
	public void loadProduct(String productName) {
		
	}
	
	/**
	 * checks if product is already in the list
	 * @param productName name of product
	 */
	private void isDuplicateProduct(String productName) {
		
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
		return null;
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
	 * @param id id of text
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public void deleteTaskById(int id) {
		
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
		return "";
	}
	
	/**
	 * returns string array of product names
	 * @return string array of product names
	 */
	public String[] getProductList() {
		return null;
	}
	
	/**
	 * resets products to empty list and current product is set to null
	 */
	public void clearProducts() {
		
	}
	
	/**
	 * updates currentProducts name to given value
	 * @param updateName name to be updated to 
	 * @throws IllegalArgumentException if currentProduct is null
	 */
	public void editProduct(String updateName) {
		
	}
	
	/** 
	 * adds new product to product list
	 * @param productName name of product
	 * @throws IllegalArgumentException if there is a product with the same name or if name is null or empty
	 */
	public void addProduct(String productName) {
		
	}
	
	/**
	 * deletes current product
	 * @throws IllegalArgumentException if current product is null when trying to delete
	 */
	public void deleteProduct() {
		
	}
	
	/**
	 * resets backlog manager
	 */
	protected void resetManager() {
		
	}
}
