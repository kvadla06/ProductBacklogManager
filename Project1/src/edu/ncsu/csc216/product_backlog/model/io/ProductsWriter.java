package edu.ncsu.csc216.product_backlog.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import edu.ncsu.csc216.product_backlog.model.product.Product;
import edu.ncsu.csc216.product_backlog.model.task.Task;

/**
 * Writes a list of products to a file
 * @author Kavya Vadla
 */
public class ProductsWriter {
	
	/**
	 * writes products to a given file
	 * @param fileName file to write to
	 * @param products products to write to file
	 * @throws IllegalArgumentException if file cannot be written to
	 */
	public static void writeProductsToFile(String fileName, List<Product> products) {
		try {
			PrintStream fileWriter = new PrintStream(new File(fileName));
			for (int i = 0; i < products.size(); i++) {
				List<Task> tasks = products.get(i).getTasks();
				fileWriter.println("# " + products.get(i).getProductName());
				for (int j = 0; j < tasks.size(); j++) {
					System.out.println("J:"+j+"Task:"+tasks.get(j).toString());
					fileWriter.println(tasks.get(j).toString());
					for (int k = 0; k < tasks.get(j).getNotes().size(); k++) {
						fileWriter.print(tasks.get(j).getNotesList());
					}
				}
			}
		}	catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}

}
