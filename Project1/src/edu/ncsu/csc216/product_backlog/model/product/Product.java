/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.product;

import java.util.List;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.*;

/**
 * Product that the tasks are beign worked on for
 * @author Kavya Vadla 
 */
public class Product {
	/** name of product */
	private String productName;
	/** used to set ids for tasks */
	private int counter;
	
	/**
	 * Class constructor for product that assigns given values for all fields
	 * @throws IllegalArgumentException if product name is null or empty
	 */
	public Product() {
		
	}
	
	/**
	 * sets name of product
	 * @param productName name of product
	 * @throws IllegalArgumentException if name is null or empty
	 */
	public void setProductName(String productName) {
		
	}
	
	/**
	 * gets product name
	 * @return name of product
	 */
	public String getProductName() {
		return "";
	}
	
	/**
	 * adds task to list in sorted order by id
	 * @param task task to be added
	 * @throws IllegalArgumentException if a task already exists with the given id
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * helper method to help ensure the new task has the correct id number
	 */
	private void setTaskCounter() {
		
	}
	
	/**
	 * empties list of tasks for product
	 */
	private void emptyList() {
		
	}
	
	/**
	 * creates new task with given information and adds to list
	 * @param title title of task
	 * @param type type of task
	 * @param creator creator of task
	 * @param note task note
	 */
	public void addTask(String title, Type type, String creator, String note) {
		
	}
	
	/**
	 * gets list of tasks
	 * @return returns list of tasks
	 */
	public List<Task> getTasks() {
		return null;
	}
	
	/**
	 * returns the task in list with given id, if theres no task with the id return null
	 * @param id id of task
	 */
	public Task getTaskById(int id) {
		return null;
	}
	
	/**
	 * finds task with given id and updates with given command
	 * @param id id of task
	 * @param c Command to update task
	 */
	public void executeCommand(int id, Command c) {
		
	}
	
	/**
	 * removes task from list at given index
	 * @param id id of text
	 */
	public void deleteTaskById(int id) {
		
	}
}
 