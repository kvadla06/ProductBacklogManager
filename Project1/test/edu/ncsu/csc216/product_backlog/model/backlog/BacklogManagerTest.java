package edu.ncsu.csc216.product_backlog.model.backlog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * tests BacklogManager class
 * 
 * some getters are tested through other complex methods and some getter
 * test methods are shortened as they are tested through other methods
 * @author Kavya Vadla
 */
class BacklogManagerTest {
	/** backlog manager instance */
	private BacklogManager singleton = BacklogManager.getInstance();

	/**
	 * tests saveToFile
	 */
	@Test
	void testSaveToFile() {
		BacklogManager.resetManager();
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.saveToFile("test-files/actual1_task_backlog.txt"));
		assertEquals("Unable to save file.", e1.getMessage());
		BacklogManager manager = BacklogManager.getInstance();
		manager.addProduct("Shopping Cart Simulation");
		manager.addTaskToProduct("Express Carts", Type.BUG, "sesmith5", "backlog");
		manager.addProduct("Wolfscheduler");
		manager.addTaskToProduct("Weekly Repeat", Type.FEATURE, "sesmith5", "note");
		manager.saveToFile("test-files/actual1_task_backlog.txt");
	}

	/**
	 * tests loadFromFile
	 */
	@Test
	void testLoadFromFile() {
		BacklogManager.resetManager();
		singleton.loadFromFile("test-files/tasks1.txt");
		assertEquals("Shopping Cart Simulation", singleton.getProductName());
		assertEquals(2, singleton.getProductList().length);
	}

	/**
	 * tests loadProduct
	 */
	@Test
	void testLoadProduct() {
		BacklogManager.resetManager();
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "sesmith5", "backlog");
		singleton.addProduct("Wolfscheduler");
		singleton.addTaskToProduct("Weekly Repeat", Type.FEATURE, "sesmith5", "note");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.loadProduct("Project1"));
		assertEquals("Product not available.", e1.getMessage());
	}

	/**
	 * tests getTasksAsArray
	 */
	@Test
	void testGetTasksAsArray() {
		BacklogManager.resetManager();
		assertEquals(null, singleton.getTasksAsArray());
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		String[][] test = singleton.getTasksAsArray();
		assertAll("task fields",
					() -> assertEquals("1", test[0][0], "task id"),
					() -> assertEquals("Backlog", test[0][1], "task state"),
					() -> assertEquals("Bug", test[0][2], "task type"),
					() -> assertEquals("Express Carts", test[0][3], "task title"));
		
	}

	/**
	 * tests getTaskById
	 */
	@Test
	void testGetTaskById() {
		BacklogManager.resetManager();
		assertEquals(null, singleton.getTaskById(1));
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		assertEquals(null, singleton.getTaskById(2));
		assertEquals(new Task(1, "Express Carts", Type.BUG, "jep", "backlog").toString(), singleton.getTaskById(1).toString());
	}

	/**
	 * tests executeCommand
	 */
	@Test
	void testExecuteCommand() {
		BacklogManager.resetManager();
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "note");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.executeCommand(1, c));
		assertEquals("No product selected.", e1.getMessage());
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		singleton.executeCommand(1, c);
		assertEquals(singleton.getTaskById(1).getStateName(), "Owned");
	}

	/**
	 * tests deleteTaskById
	 */
	@Test
	void testDeleteTaskById() {
		BacklogManager.resetManager();
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.deleteTaskById(1));
		assertEquals("No product selected.", e1.getMessage());
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		singleton.addTaskToProduct("Regular Carts", Type.FEATURE, "jep", "claimed");
		singleton.deleteTaskById(1);
		
	}

	/**
	 * tests addTaskToProduct
	 */
	@Test
	void testAddTaskToProduct() {
		BacklogManager.resetManager();
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.addTaskToProduct("title", Type.BUG, "creator", "note"));
		assertEquals("No product selected.", e1.getMessage());
	}

	/**
	 * tests clearProducts
	 */
	@Test
	void testClearProducts() {
		BacklogManager.resetManager();
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		singleton.addTaskToProduct("Regular Carts", Type.FEATURE, "jep", "claimed");
		singleton.addProduct("Wolfscheduler");
		singleton.addTaskToProduct("Weekly Repeat", Type.FEATURE, "sesmith5", "note");
		singleton.clearProducts();
		assertEquals(0, singleton.getProductList().length);
	}

	/**
	 * tests editProduct
	 */
	@Test
	void testEditProduct() {
		BacklogManager.resetManager();
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.editProduct("Update"));
		assertEquals("No product selected.", e1.getMessage());
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		singleton.addTaskToProduct("Regular Carts", Type.FEATURE, "jep", "claimed");
		singleton.addProduct("Wolfscheduler");
		singleton.addTaskToProduct("Weekly Repeat", Type.FEATURE, "sesmith5", "note");
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> singleton.editProduct("Shopping Cart Simulation"));
		assertEquals("Invalid product name.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> singleton.editProduct(""));
		assertEquals("Invalid product name.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> singleton.editProduct(null));
		assertEquals("Invalid product name.", e4.getMessage());
		singleton.editProduct("Wolf Scheduler");
		assertEquals("Wolf Scheduler", singleton.getProductName());
	}

	/**
	 * tests addProduct
	 */
	@Test
	void testAddProduct() {
		BacklogManager.resetManager();
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		singleton.addTaskToProduct("Regular Carts", Type.FEATURE, "jep", "claimed");
		singleton.addProduct("Wolfscheduler");
		singleton.addTaskToProduct("Weekly Repeat", Type.FEATURE, "sesmith5", "note");
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> singleton.addProduct("Shopping Cart Simulation"));
		assertEquals("Invalid product name.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> singleton.addProduct(""));
		assertEquals("Invalid product name.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> singleton.addProduct(null));
		assertEquals("Invalid product name.", e4.getMessage());
	}

	/**
	 * tests deleteProduct
	 */
	@Test
	void testDeleteProduct() {
		BacklogManager.resetManager();
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> singleton.deleteProduct());
		assertEquals("No product selected.", e1.getMessage());
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		singleton.addTaskToProduct("Regular Carts", Type.FEATURE, "jep", "claimed");
		singleton.deleteProduct();
		assertEquals(null, singleton.getProductName());
		assertEquals(0, singleton.getProductList().length);
		singleton.addProduct("Shopping Cart Simulation");
		singleton.addTaskToProduct("Express Carts", Type.BUG, "jep", "backlog");
		singleton.addTaskToProduct("Regular Carts", Type.FEATURE, "jep", "claimed");
		singleton.addProduct("Wolfscheduler");
		singleton.addTaskToProduct("Weekly Repeat", Type.FEATURE, "sesmith5", "note");
		singleton.deleteProduct();
		assertEquals("Shopping Cart Simulation", singleton.getProductName());
		assertEquals(1, singleton.getProductList().length);
		
	}

}
