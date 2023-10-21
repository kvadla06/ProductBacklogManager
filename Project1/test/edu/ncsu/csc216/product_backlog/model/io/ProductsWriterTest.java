package edu.ncsu.csc216.product_backlog.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * Tests ProductsWriter class
 * 
 * @author Kavya Vadla
 */
class ProductsWriterTest {

	/**
	 * test writeProductsToFile
	 */
	@Test
	void testWriteProductsToFile() {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = new Product("Product");
		products.add(product);
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("[Backlog] note1");
		ArrayList<String> notes2 = new ArrayList<String>();
		notes2.add("[Backlog] note2");
		ArrayList<String> notes3 = new ArrayList<String>();
		notes3.add("[Backlog] note3");
		
		Task t1 = new Task(1, "Backlog", "title1", "B", "creator1", "unowned", "false", notes);
		Task t2 = new Task(2, "Backlog", "title2", "F", "creator2", "unowned", "false", notes2);
		Task t3 = new Task(3, "Backlog", "title3", "KA", "creator3", "unowned", "false", notes3);
		product.addTask(t1);
		product.addTask(t2);
		product.addTask(t3);
		
		Product product2 = new Product("A Product");
		products.add(product2);
		
		ArrayList<String> notesA1 = new ArrayList<String>();
		notesA1.add("[Backlog] note01");
		ArrayList<String> notesA2 = new ArrayList<String>();
		notesA2.add("[Backlog] note02");
		
		Task tA1 = new Task(1, "Backlog", "title01", "TW", "creator01", "unowned", "false", notesA1);
		Task tA2 = new Task(2, "Backlog", "title02", "F", "creator02", "unowned", "false", notesA2);
		product2.addTask(tA1);
		product2.addTask(tA2);

		try {
			ProductsWriter.writeProductsToFile("test-files/actual_task_backlog.txt", products);
		} catch (IllegalArgumentException e) {
			fail("Cannot write to course records file");
		}
		
		checkFiles("test-files/exp_task_backlog.txt", "test-files/actual_task_backlog.txt");
		
		
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				String one = expScanner.nextLine();
				String two = actScanner.nextLine();
				System.out.println(one);
				System.out.println(two);
				assertEquals(one, two);
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
