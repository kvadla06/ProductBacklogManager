package edu.ncsu.csc216.product_backlog.model.task;

import java.util.ArrayList;

import edu.ncsu.csc216.product_backlog.model.command.Command;

/**
 * Represents a task in the Product Backlog system
 * @author Kavya Vadla
 */
public class Task {
	/** id of task */
	private int taskId;
	/** title of task */
	private String title;
	/** creator of task */
	private String creator;
	/** owner of task */
	private String owner;
	/** boolean if task if verified or not */
	private boolean isVerified;
	/** notes of task */
	private ArrayList<String> notes;
	/** Backlog state */
	public static final String BACKLOG_NAME = "Backlog";
	/** Owned state */
	public static final String OWNED_NAME = "Owned";
	/** Process state */
	public static final String PROCESSING_NAME = "Processing";
	/** Verify state */
	public static final String VERIFYING_NAME = "Verifying";
	/** Done state */
	public static final String DONE_NAME = "Done";
	/** Rejected state */
	public static final String REJECTED_NAME = "Rejected";
	/** Feature type */
	public static final String FEATURE_NAME = "Feature";
	/** Bug type */
	public static final String BUG_NAME = "Bug";
	/** Technical work type */
	public static final String TECHNICAL_WORK_NAME = "Technical Work";
	/** Knowledge Acquisition type */
	public static final String KNOWLEDGE_ACQUISITION_NAME = "Knowledge Acquisition";
	/** Feature type short name */
	public static final String T_FEATURE = "F";
	/** Bug type short name */
	public static final String T_BUG = "B";
	/** Technical work type short name */
	public static final String T_TECHNICAL_WORK = "TW";
	/** Knowledge Acquisition type short name */
	public static final String T_KNOWLEDGE_ACQUISITION = "KA";
	/** Constant string for unowned task */
	public static final String UNOWNED = "unowned";
	
	/** 
	 * Constructor of Task class with values for all given fields
	 * @param id id of task
	 * @param state state of task
	 * @param title title of task
	 * @param type type of task
	 * @param creator creator of task
	 * @param owner owner of task
	 * @param verified if the task has been verified or not
	 * @param notes notes of the task
	 * @throws IllegalArgumentException
	 */
	public Task (int id, String state, String title, String type, String creator, String owner, String verified, ArrayList<String> notes) {
		
	}
	
	/** 
	 * Constructor of Task class with values for all given fields
	 * @param id id of task
	 * @param title title of task
	 * @param type type of task
	 * @param creator creator of task
	 * @param note note to be added to notes list
	 * @throws IllegalArgumentException
	 */
	public Task (int id, String title, Type type, String creator, String note) {
		
	}
	
	/**
	 * The possible types of tasks
	 */
	public enum Type { FEATURE, BUG, TECHNICAL_WORK, KNOWLEDGE_ACQUISITION }

	/**
	 * sets taskId
	 * @param taskId task id
	 * @throws IllegalArgumentException
	 */
	private void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * sets title of task
	 * @param title title of task
	 * @throws IllegalArgumentException
	 */
	private void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * sets type of task
	 * @param type type of task
	 * @throws IllegalArgumentException
	 */
	private void setType(Type type) {
		
	}
	
	/**
	 * sets creator of task
	 * @param creator creator of task
	 * @throws IllegalArgumentException
	 */
	private void setCreator(String creator) {
		this.creator = creator;
	}
	
	/**
	 * sets owner of task
	 * @param owner owner of task
	 * @throws IllegalArgumentException
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * sets task verification
	 * @param verified if task is verified or not
	 * @throws IllegalArgumentException
	 */
	private void setVerified(String verified) {
		
	}
	
	/**
	 * sets notes
	 * @param notes list of notes for a task
	 * @throws IllegalArgumentException
	 */
	private void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	
	/**
	 * adds note to list
	 * @param note note to be added 
	 * @throws IllegalArgumentException
	 */
	public int addNoteToList(String note) {
		return 0;
	}
	
	/**
	 * gets taskId
	 * @return taskId
	 */
	public int getTaskId() {
		return 0;
	}
	
	/**
	 * gets task state
	 * @return state of task
	 */
	public String getStateName() {
		return "";
	}
	
	/**
	 * sets state of task
	 * @throws IllegalArgumentException
	 */
	private void setState() {

	}
	
	/**
	 * sets the type of task from a string
	 * @throws IllegalArgumentException
	 */
	private void setTypeFromString() {
		
	}
	
	/**
	 * gets type of task
	 * @return type of task
	 */
	public Type getType() {
		return null;
	}
	
	/**
	 * gets long name of type of task
	 * @return long name of task type
	 */
	public String getTypeLongName() {
		return "";
	}
	
	/**
	 * gets short name of type of task
	 * @return short name of task type
	 */
	public String getTypeShortName() {
		return "";
	}
	
	/**
	 * gets owner of task
	 * @return task owner
	 */
	public String getOwner() {
		return "";
	}
	
	/**
	 * gets title of task
	 * @return task title
	 */
	public String getTitle() {
		return "";
	}
	
	/**
	 * gets creator of task
	 * @return task creator
	 */
	public String getCreator() {
		return "";
	}
	
	/**
	 * if the task has been verified or not
	 * @return true if task has been verified, false if not
	 */
	public boolean isVerified() {
		return false;
	}
	
	/**
	 * gets Array List of notes list of task
	 * @return task notes list
	 */
	public ArrayList<String> getNotes() {
		return null;
	}
	
	/**
	 * gets String of notes list of task
	 * @return task notes list
	 */
	public String getNotesList() {
		return "";
	}
	
	/**
	 * toString method of Task class
	 * @return String representation of task
	 */
	@Override
	public String toString() {
		return "";
	}
	
	/**
	 * updates the state of the task
	 * @param c command to be updated to
	 * @throws UnsupportedOperationException if the transition is not appropriate for the FSM
	 */
	public void update(Command c) {
		
	}
	
	/**
	 * gets notes list in String array representation
	 * @return string array notes list
	 */
	public String[] getNotesArray() {
		return null;
	}
	
	/**
	 * Interface for states in the Task State Pattern.  All 
	 * concrete task states must implement the TaskState interface.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
	 */
	private interface TaskState {
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		void updateState(Command c);
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		String getStateName();
	
	}
	
	/**
	 * Backlog State of task
	 * @author Kavya Vadla
	 */
	public class BacklogState implements TaskState {
		/**
		 * Backlog State constructor
		 */
		private BacklogState() {
			
		}
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		public void updateState(Command c) {
			
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "";
		}
	}
	
	/**
	 * Owned State of task
	 * @author Kavya Vadla
	 */
	public class OwnedState implements TaskState {
		/**
		 * Owned State constructor
		 */
		private OwnedState() {
			
		}
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		public void updateState(Command c) {
			
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "";
		}
	}
	
	/**
	 * Verifying State of task
	 * @author Kavya Vadla
	 */
	public class VerifyingState implements TaskState {
		/**
		 * Verifying State constructor
		 */
		private VerifyingState() {
			
		}
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		public void updateState(Command c) {
			
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "";
		}
	}
	
	/**
	 * Processing State of task
	 * @author Kavya Vadla
	 */
	public class ProcessingState implements TaskState {
		/**
		 * Processing State constructor
		 */
		private ProcessingState() {
			
		}
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		public void updateState(Command c) {
			
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "";
		}
	}
	
	/**
	 * Done State of task
	 * @author Kavya Vadla
	 */
	public class DoneState implements TaskState {
		/**
		 * Done State constructor
		 */
		private DoneState() {
			
		}
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		public void updateState(Command c) {
			
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "";
		}
	}
	
	/**
	 * Rejected State of task
	 * @author Kavya Vadla
	 */
	public class RejectedState implements TaskState {
		/**
		 * Rejected State constructor
		 */
		private RejectedState() {
			
		}
		
		/**
		 * Update the Task based on the given Command
		 * An UnsupportedOperationException is thrown if the Command is not a
		 * is not a valid action for the given state.  
		 * @param c Command describing the action that will update the Task
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		public void updateState(Command c) {
			
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "";
		}
	}
}
