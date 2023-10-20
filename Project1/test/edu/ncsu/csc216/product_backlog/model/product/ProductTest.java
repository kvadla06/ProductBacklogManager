package edu.ncsu.csc216.product_backlog.model.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Tests Product class
 * 
 * getters will be tested through the other test method
 * @author Kavya Vadla
 */
class ProductTest {

	/** Product name */
	private final String productName = "Shopping Cart Simulation";
	/** product to test*/
	Product product = new Product(productName);
	/** array list of notes */
	private ArrayList<String> notes;
	/** task to add */
	private final Task task = new Task(1, "Backlog", "Express Carts", "F", "jep", "unowned", "false", notes);
	
	@Test
	void testProduct() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Product(null));
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Product(""));
		assertEquals("Invalid product name.", e1.getMessage());
		assertEquals("Invalid product name.", e2.getMessage());
		assertEquals("Shopping Cart Simulation", product.getProductName());
	}

	@Test
	void testSetProductName() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> product.setProductName(null));
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> product.setProductName(""));
		assertEquals("Invalid product name.", e1.getMessage());
		assertEquals("Invalid product name.", e2.getMessage());
		product.setProductName("new name");
		assertEquals("new name", product.getProductName());
	}

	@Test
	void testAddTaskTask() {
		product.addTask(task);
		product.addTask(new Task(3, "Processing", "Java Swing", "KA", "sesmith5", "sesmith5", "false", notes));
		product.addTask(new Task(2, "Owned", "Regular Carts", "F", "jep", "sesmith5", "false", notes));
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> product.addTask(new Task(2, "Owned", "Regular Carts", "F", "jep", "sesmith5", "false", notes)));
		assertEquals("Task cannot be added.", e1.getMessage());
		assertEquals(3, product.getTasks().size());
		assertEquals(2, product.getTasks().get(1).getTaskId());
	}

	@Test
	void testAddTaskStringTypeStringString() {
		String title = "title";
		Type type = Type.FEATURE;
		String creator = "creator";
		String note = "note";
		Task task2 = new Task(1, title, type, creator, note);
		product.addTask(title, type, creator, note);
		assertEquals(task2.toString(), product.getTaskById(1).toString());
	}

	@Test
	void testGetTaskById() {
		product.addTask(task);
		product.addTask(new Task(3, "Processing", "Java Swing", "KA", "sesmith5", "sesmith5", "false", notes));
		product.addTask(new Task(2, "Owned", "Regular Carts", "F", "jep", "sesmith5", "false", notes));
		Task task3 = new Task(3, "Processing", "Java Swing", "KA", "sesmith5", "sesmith5", "false", notes);
		assertEquals(task3.toString(), product.getTaskById(3).toString());
		assertEquals(null, product.getTaskById(4));
	}

	@Test
	void testExecuteCommand() {
		Command c = new Command(CommandValue.BACKLOG, null, "note");
		product.addTask(task);
		product.addTask(new Task(3, "Processing", "Java Swing", "KA", "sesmith5", "sesmith5", "false", notes));
		product.addTask(new Task(2, "Owned", "Regular Carts", "F", "jep", "sesmith5", "false", notes));
		product.executeCommand(2, c);
		assertEquals(product.getTaskById(2).getStateName(), "Backlog");
	}

	@Test
	void testDeleteTaskById() {
		product.addTask(task);
		product.addTask(new Task(3, "Processing", "Java Swing", "KA", "sesmith5", "sesmith5", "false", notes));
		product.addTask(new Task(2, "Owned", "Regular Carts", "F", "jep", "sesmith5", "false", notes));
		product.deleteTaskById(3);
		assertEquals(2, product.getTasks().size());
		assertEquals(null, product.getTaskById(3));
	}

}
