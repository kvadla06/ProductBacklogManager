package edu.ncsu.csc216.product_backlog.model.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;

class CommandTest {
	/** valid command */
	Command c = new Command(CommandValue.BACKLOG, null, "note");
	
	/** 
	 * tests Command constructor
	 */
	@Test
	void testCommand() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Command(null, "owner", "note"));
		assertEquals("Invalid command.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Command(CommandValue.BACKLOG, null, ""));
		assertEquals("Invalid command.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> new Command(CommandValue.BACKLOG, null, null));
		assertEquals("Invalid command.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> new Command(CommandValue.CLAIM, null, "note"));
		assertEquals("Invalid command.", e4.getMessage());
		Exception e5 = assertThrows(IllegalArgumentException.class, () -> new Command(CommandValue.CLAIM, "", "note"));
		assertEquals("Invalid command.", e5.getMessage());
		Exception e6 = assertThrows(IllegalArgumentException.class, () ->  new Command(CommandValue.BACKLOG, "owner", "note"));
		assertEquals("Invalid command.", e6.getMessage());
		
		
	}
	
	/**
	 * test getOwner()
	 */
	@Test
	void testGetOwner() {
		assertEquals(null, c.getOwner());
	}
	
	/**
	 * test getNoteText()
	 */
	@Test
	void testGetNoteText() {
		assertEquals("note", c.getNoteText());
	}
	
	/**
	 * test getOwner()
	 */
	@Test
	void testGetCommand() {
		assertEquals(CommandValue.BACKLOG, c.getCommand());
	}

}
