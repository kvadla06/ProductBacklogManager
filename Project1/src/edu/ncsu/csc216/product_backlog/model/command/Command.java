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
	/** command's commandValue */
	private CommandValue c;
	/** error message */
	private static final String COMMAND_ERROR_MESSAGE = "Invalid command.";
	
	/**
	 * Constructor of Command class with values for all fields
	 * @param c the command's CommandValue
	 * @param owner the command's owner
	 * @param noteText the command's note
	 * @throws IllegalArgumentException if fields are null or empty
	 */
	public Command (CommandValue c, String owner, String noteText) {
		if (c == null) {
			throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
		} else if (noteText == (null) || noteText.equals("")) {
			throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
		} else if (c == CommandValue.CLAIM) {
			if (owner.equals(null) || owner.equals("")) {
				throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
			}
		} else if (c != CommandValue.CLAIM) {
			if (owner != null) {
				throw new IllegalArgumentException(COMMAND_ERROR_MESSAGE);
			}
		}
		note = noteText;
		this.owner = owner;
		this.c = c;
		
	}
	
	/**
	 * returns the command's command value
	 * @return command's command value
	 */
	public CommandValue getCommand() {
		return c;
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
