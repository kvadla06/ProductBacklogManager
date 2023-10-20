/**
 * 
 */
package edu.ncsu.csc216.product_backlog.model.product;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.*;

/**
 * Product that the tasks are being worked on for
 * @author Kavya Vadla 
 */
public class Product {
	/** name of product */
	private String productName;
	/** used to set ids for tasks */
	private int counter;
	/**list of tasks */
	private ArrayList<Task> tasks;
	
	/**
	 * Class constructor for product that assigns given values for all fields
	 * @param productName name of product
	 * @throws IllegalArgumentException if product name is null or empty
	 */
	public Product(String productName) {
		if (productName == null || productName == "") {
			throw new IllegalArgumentException("Invalid product name.");
		}
		this.productName = productName;
		emptyList();
		counter = 1;
	}
	
	/**
	 * sets name of product
	 * @param productName name of product
	 * @throws IllegalArgumentException if name is null or empty
	 */
	public void setProductName(String productName) {
		if (productName == null || productName == "") {
			throw new IllegalArgumentException("Invalid product name.");
		}
		this.productName = productName;
	}
	
	/**
	 * gets product name
	 * @return name of product
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * adds task to list in sorted order by id
	 * @param task task to be added
	 * @throws IllegalArgumentException if a task already exists with the given id
	 */
	public void addTask(Task task) {
		boolean add = false;
		if (tasks.size() == 0) {
			tasks.add(task);
			add = true;
		} else {
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).getTaskId() == task.getTaskId()) {
					throw new IllegalArgumentException("Task cannot be added.");
				}
				if (tasks.get(i).getTaskId() > task.getTaskId()) {
					tasks.add(i, task);
					add = true;
					break;
				}
			} 
			if (!add) {
					tasks.add(task);
			}
		}
		counter += 1;
	}
		
	
	/**
	 * helper method to help ensure the new task has the correct id number
	 */
	private void setTaskCounter() {
		if (tasks.size() == 0) {
			counter = 1;
		} else {
			counter = tasks.get(tasks.size() - 1).getTaskId() + 1;
		}
	}
	
	/**
	 * empties list of tasks for product
	 */
	private void emptyList() {
		tasks = new ArrayList<Task>();
	}
	
	/**
	 * creates new task with given information and adds to list
	 * @param title title of task
	 * @param type type of task
	 * @param creator creator of task
	 * @param note task note
	 */
	public void addTask(String title, Type type, String creator, String note) {
		setTaskCounter();
		Task task = new Task(1, title, type, creator, note);
		addTask(task);
	}
	
	/**
	 * gets list of tasks
	 * @return returns list of tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}
	
	/**
	 * returns the task in list with given id, if theres no task with the id return null
	 * @param id id of task
	 */
	public Task getTaskById(int id) {
		for (int i = 0; i < tasks.size(); i++)  {
			if (tasks.get(i).getTaskId() == id) {
				return tasks.get(i);
			}
		}
		return null;
	}
	
	/**
	 * finds task with given id and updates with given command
	 * @param id id of task
	 * @param c Command to update task
	 */
	public void executeCommand(int id, Command c) {
		Task task = getTaskById(id);
		task.update(c);
	}
	
	/**
	 * removes task from list at given index
	 * @param id id of text
	 */
	public void deleteTaskById(int id) {
		for (int i = 0; i < tasks.size(); i++)  {
			if (tasks.get(i).getTaskId() == id) {
				tasks.remove(i);
			}
		}
	}
}
 