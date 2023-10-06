package edu.ncsu.csc216.product_backlog.model.command;

/**
 * Encapsulates information about a user command that could lead to a transition
 * @author Kavya Vadla
 */
public class Command {
	/** command note */
	private String note;
	/** command owner */
	private String owner;
	/** error message */
	private static final String COMMAND_ERROR_MESSAGE = "Invalid command.";
	
	/**
	 * Constructor of Command class with values for all fields
	 * @param c the command's CommandValue
	 * @param owner the command's owner
	 * @param noteText the command's note
	 * @throws IllegalArgumentException
	 */
	public Command (CommandValue c, String owner, String noteText) {
		
	}
	
	/**
	 * returns the command's command value
	 * @return command's command value
	 */
	public CommandValue getCommand() {
		return null;
	}
	
	/**
	 * returns the command's note text
	 * @return command note text
	 */
	public String getNoteText() {
		return note;
	}
	
	/**
	 * returns the command's owner
	 * @return command owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Represents one of the 6 possible commands a user can make
	 */
	public enum CommandValue { BACKLOG, CLAIM, PROCESS, VERIFY, COMPLETE, REJECT }

}
