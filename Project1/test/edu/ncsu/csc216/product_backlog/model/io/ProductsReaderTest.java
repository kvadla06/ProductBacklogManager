package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * Tests ProductsReader class
 * 
 * @author Kavya Vadla
 */
class ProductsReaderTest {
	/** Valid course records */
	private final String validTestFile = "test-files/tasks1.txt";
	/** Invalid course records */
	private final String invalidTestFile = "test-files/tasks0.txt";
	/** Array to hold expected results */
	private ArrayList<Product> testProducts = new ArrayList<Product>();

	/**
	 * adds valid products to array list before each test
	 * 
	 */
	@Before
	public void setUp() {
		Product product = new Product("Shopping Cart Simulation");
		testProducts.add(product);
		ArrayList<String> note1 = new ArrayList<String>();
		note1.add("[Backlog] Express carts always choose the shortest line. If there are multiple shortest lines," + 
					" an express cart chooses the one with the smallest index.");
		Task t1 = new Task(1, "Backlog", "Express Carts", "F", "jep", "unowned", "false", note1);
		product.addTask(t1);
		
		ArrayList<String> note2 = new ArrayList<String>();
		note2.add("[Backlog] Regular carts always choose the shortest line excluding the express register line (at index 0)." + 
					" If there are multiple shortest lines, a regular cart chooses one with the smallest index.");
		note2.add("[Owned] Adding to sesmith5 backlog.");
		Task t2 = new Task(2, "Owned", "Regular Carts", "F", "jep", "sesmith5", "false", note2);
		product.addTask(t2);
		
		ArrayList<String> note3 = new ArrayList<String>();
		note3.add("[Backlog] Learn more about Swing to debug GUI.");
		note3.add("[Owned] Adding to sesmith5 backlog.");
		note3.add("[Processing] Found Swing tutorials at http://docs.oracle.com/javase/tutorial/uiswing/start/.");
		Task t3 = new Task(3, "Processing", "Java Swing", "KA", "sesmith5", "sesmith5", "false", note3);
		product.addTask(t3);
		
		ArrayList<String> note4 = new ArrayList<String>();
		note4.add("[Backlog] Special carts are failing system tests associated with wait time.");
		note4.add("[Owned] Adding to sesmith5 backlog.");
		note4.add("[Processing] Replicated failure locally in unit test.");
		note4.add("[Verifying] Implementation complete. Requires peer inspection.");
		Task t4 = new Task(5, "Verifying", "Calculation Wait Time", "B", "jdyoung2", "sesmith5", "false", note4);
		product.addTask(t4);
		
		ArrayList<String> note5 = new ArrayList<String>();
		note5.add("[Backlog] Special carts always choose the shortest special register line.\r\n"
				+ "If there are multiple shortest special register lines, a special cart\r\n"
				+ "chooses one with the smallest index.");
		note5.add("[Owned] Adding to sesmith5 backlog.");
		note5.add("[Processing] Created hierarchy to prepare for other cart types.");
		note5.add("[Verifying] Implementation complete. Requires peer inspection.");
		note5.add("[Done] No problems found during inspection.");
		Task t5 = new Task(8, "Done", "Special Carts", "F", "jep", "unowned", "true", note5);
		product.addTask(t5);
		
		ArrayList<String> note6 = new ArrayList<String>();
		note6.add("[Backlog] Add flatbed carts to simulation.");
		note6.add("[Owned] Rejected. Flatbed carts won't fit through physical register stations.");
		Task t6 = new Task(10, "Rejected", "Flatbed Carts", "F", "jep", "unowned", "false", note6);
		product.addTask(t6);
		
		Product product2 = new Product("WolfScheduler");
		testProducts.add(product2);
		ArrayList<String> note7 = new ArrayList<String>();
		note7.add("[Backlog] Events should have a weekly repeat of every 1, 2, 3, or 4 weeks.");
		note7.add("[Owned] Weekly repeat is unnecessary when creating ideal week.");
		Task t7 = new Task(2, "Rejected", "Weekly Repeat", "F", "sesmith5", "unowned", "false", note7);
		product2.addTask(t7);
		
		ArrayList<String> note8 = new ArrayList<String>();
		note8.add("[Backlog] Users can create events to identify places during their week where they have scheduled activities other than class.");
		Task t8 = new Task(5, "Backlog", "Add Event", "F", "sesmith", "unowned", "false", note8);
		product2.addTask(t8);
		
		ArrayList<String> note9 = new ArrayList<String>();
		note9.add("[Backlog] Users can add courses to their schedule.");
		note9.add("[Owned] Assigning to jctetter.");
		note9.add("[Processing] Creating Course class.");
		note9.add("[Processing] Adding error checking on course name.");
		note9.add("[Processing] Adding tests for Course.");
		note9.add("[Verifying] Request peer review.");
		note9.add("[Done] Updates meet requirements and test pass.");
		Task t9 = new Task(6, "Done", "Add Course", "F", "sesmith5", "jctetter", "true", note9);
		product2.addTask(t9);
	}	

	/**
	 * tests readProductsFile
	 */
	@Test
	void testReadProductsFile() {
		ArrayList<Product> products = ProductsReader.readProductsFile(validTestFile);
		assertEquals(2, products.size());
		
		for (int i = 0; i < testProducts.size(); i++) {
			assertEquals(testProducts.get(i), products.get(i));
		}
		
		try {
			ProductsReader.readProductsFile(invalidTestFile);
			fail("Unexpected error reading " + validTestFile);
		} catch (IllegalArgumentException e) {
			//if true
		}
		
		try {
			ProductsReader.readProductsFile("test-files/tasks4.txt");
			fail("Unexpected error reading " + "test-files/tasks4.txt");
		} catch (IllegalArgumentException e) {
			//if true
		}
		
		try {
			ProductsReader.readProductsFile("test-files/tasks13.txt");
			fail("Unexpected error reading " + "test-files/tasks13.txt");
		} catch (IllegalArgumentException e) {
			//if true
		}
		
			
		
	}

}
