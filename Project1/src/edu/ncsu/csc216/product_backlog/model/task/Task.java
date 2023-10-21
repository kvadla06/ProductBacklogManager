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
	/** type of task */
	private Type type;
	/** boolean if task if verified or not */
	private boolean isVerified;
	/** current state of task */
	private TaskState currentState;
	/** notes of task */
	private ArrayList<String> notes = new ArrayList<String>();
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
	/** Final instance of backlog state class */
	private final BacklogState backlogState = new BacklogState();
	/** Final instance of owned state class */
	private final OwnedState ownedState = new OwnedState();
	/** Final instance of processing state class */
	private final ProcessingState processingState = new ProcessingState();
	/** Final instance of verifying state class */
	private final VerifyingState verifyingState = new VerifyingState();
	/** Final instance of done state class */
	private final DoneState doneState = new DoneState();
	/** Final instance of rejected state class */
	private final RejectedState rejectedState = new RejectedState();
	
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
		if (id <= 0) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (title == null || title.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (type == null) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (creator == null || creator.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (state == null || state.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (type == null || type.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (owner == null || owner.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (verified == null) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (state.equals("Backlog")) {
			if (owner != UNOWNED) {
				throw new IllegalArgumentException("Invalid task information.");
			}
		}
		if (verified.equals("true") || verified.equals("false")) {
			setVerified(verified);
		} else {
			throw new IllegalArgumentException("Invalid task information.");
		}
		setTaskId(id);
		setState(state);
		setTitle(title);
		setTypeFromString(type);
		setCreator(creator);
		setOwner(owner);
		setVerified(verified);
		setNotes(notes);
		
	}
	
	/** 
	 * Constructor of Task class with values for all given fields
	 * @param id id of task
	 * @param title title of task
	 * @param type type of task
	 * @param creator creator of task
	 * @param note note to be added to notes list
	 * @throws IllegalArgumentException if an item is null, empty, or if any id number is less than or equal to 0
	 */
	public Task (int id, String title, Type type, String creator, String note) {
		if (id <= 0) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (title == null || title.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (type == null) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (creator == null || creator.equals("") ) {
			throw new IllegalArgumentException("Invalid task information.");
		} else if (note == null || note.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		setTaskId(id);
		setTitle(title);
		setType(type);
		setCreator(creator);
		setOwner(UNOWNED);
		setState(BACKLOG_NAME);
		addNoteToList(note);
	}
	
	/**
	 * The possible types of tasks
	 */
	public enum Type {FEATURE, BUG, TECHNICAL_WORK, KNOWLEDGE_ACQUISITION }

	/**
	 * sets taskId
	 * @param taskId task id
	 * @throws IllegalArgumentException if id is less than or equal to 0 
	 */
	private void setTaskId(int taskId) {
		if (taskId <= 0) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.taskId = taskId;
	}
	
	/**
	 * sets title of task
	 * @param title title of task
	 * @throws IllegalArgumentException title is null or an empty string
	 */
	private void setTitle(String title) {
		if (title == null || title.equals("")) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.title = title;
	}
	
	/**
	 * sets type of task
	 * @param type type of task
	 * @throws IllegalArgumentException if type is null
	 */
	private void setType(Type type) {
		if (type == null) {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.type = type;
	}
	
	/**
	 * sets creator of task
	 * @param creator creator of task
	 * @throws IllegalArgumentException if creator is null or an empty string
	 */
	private void setCreator(String creator) {
		if (creator == null || creator == "") {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.creator = creator;
	}
	
	/**
	 * sets owner of task
	 * @param owner owner of task
	 * @throws IllegalArgumentException if owner is null or an empty string
	 */
	private void setOwner(String owner) {
		if (owner == null || owner == "") {
			throw new IllegalArgumentException("Invalid task information.");
		}
		this.owner = owner;
	}
	
	/**
	 * sets task verification
	 * @param verified if task is verified or not
	 * @throws IllegalArgumentException if verified is anything other than true or false
	 */
	private void setVerified(String verified) {
		if(verified.equals("false")) {
			this.isVerified = false;
		} else if (verified.equals("true")) {
			this.isVerified = true;
		} else {
			throw new IllegalArgumentException("Invalid task information.");
		}
	}
	
	/**
	 * sets notes
	 * @param notes list of notes for a task
	 */
	private void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	
	/**
	 * adds note to list
	 * @param note note to be added 
	 * @throws IllegalArgumentException if note is null or empty
	 */
	public int addNoteToList(String note) {
		if (note == null || note == "") {
			throw new IllegalArgumentException("Invalid task information.");
		}
		String noteAdd = "[" + getStateName() + "]" + " " + note;
		if (notes == null) {
			notes = new ArrayList<String>();
		}
		notes.add(noteAdd);
		return notes.size() - 1;
	}
	
	/**
	 * gets taskId
	 * @return taskId
	 */
	public int getTaskId() {
		return this.taskId;
	}
	
	/**
	 * gets task state
	 * @return state of task
	 */
	public String getStateName() {
		return currentState.getStateName();
	}
	
	/**
	 * sets state of task
	 * @throws IllegalArgumentException if state is not one of the valid states
	 * @param state state of task
	 */
	private void setState(String state) {
		switch (state) {
		case BACKLOG_NAME:
			currentState = backlogState;
			break;
		case OWNED_NAME:
			currentState = ownedState;
			break;
		case PROCESSING_NAME:
			currentState = processingState;
			break;
		case VERIFYING_NAME:
			currentState = verifyingState;
			break;
		case DONE_NAME:
			currentState = doneState;
			break;
		case REJECTED_NAME:
			currentState = rejectedState;
			break;
		default:
			throw new IllegalArgumentException("Invalid task information.");
		}
	}
	
	/**
	 * sets the type of task from a string
	 * @throws IllegalArgumentException if type is not one of the valid types
	 * @param state type of task
	 */
	private void setTypeFromString(String type) {
		switch (type) {
			case T_FEATURE:
				this.type = Type.FEATURE;
				break;
			case T_BUG:
				this.type = Type.BUG;
				break;
			case T_KNOWLEDGE_ACQUISITION:
				this.type = Type.KNOWLEDGE_ACQUISITION;
				break;
			case T_TECHNICAL_WORK:
				this.type = Type.TECHNICAL_WORK;
				break;
			default:
				throw new IllegalArgumentException("Invalid task information.");
		}
	}
	
	/**
	 * gets type of task
	 * @return type of task
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * gets long name of type of task
	 * @return long name of task type
	 */
	public String getTypeLongName() {
		if (type == Type.BUG) {
			return BUG_NAME;
		} else if (type == Type.FEATURE) {
			return FEATURE_NAME;
		} else if (type == Type.TECHNICAL_WORK) {
			return TECHNICAL_WORK_NAME;
		} else {
			return KNOWLEDGE_ACQUISITION_NAME;
		}
	}
	
	/**
	 * gets short name of type of task
	 * @return short name of task type
	 */
	public String getTypeShortName() {
		if (type == Type.BUG) {
			return T_BUG;
		} else if (type == Type.FEATURE) {
			return T_FEATURE;
		} else if (type == Type.TECHNICAL_WORK) {
			return T_TECHNICAL_WORK;
		} else {
			return T_KNOWLEDGE_ACQUISITION;
		}
	}
	
	/**
	 * gets owner of task
	 * @return task owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * gets title of task
	 * @return task title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * gets creator of task
	 * @return task creator
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * if the task has been verified or not
	 * @return true if task has been verified, false if not
	 */
	public boolean isVerified() {
		return isVerified;
	}
	
	/**
	 * gets Array List of notes list of task
	 * @return task notes list
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}
	
	/**
	 * gets String of notes list of task
	 * @return task notes list
	 */
	public String getNotesList() {
		String notesList = "";
		for (int i = 0; i < notes.size(); i++) {
			notesList = notesList + "- " + notes.get(i) + "\n";
		}
		return notesList;
	}
	
	/**
	 * toString method of Task class
	 * @return String representation of task
	 */
	@Override
	public String toString() {
		String typeS = "";
		switch (type.name()) {
			case "BUG":
				typeS = T_BUG;
				break;
			case "FEATURE":
				typeS = T_FEATURE;
				break;
			case "TECHNICAL_WORK":
				typeS = T_TECHNICAL_WORK;
				break;
			case "KNOWLEDGE_ACQUISITION":
				typeS = T_KNOWLEDGE_ACQUISITION;
				break;
			default:
				typeS = "";
		}
		return "* " + taskId + "," + currentState.getStateName() + "," + title + "," + typeS + "," + creator + "," + owner + "," + String.valueOf(isVerified);
	}
	
	/**
	 * updates the state of the task
	 * @param c command to be updated to
	 * @throws UnsupportedOperationException if the transition is not appropriate for the FSM
	 */
	public void update(Command c) {
		currentState.updateState(c);
	}
	
	/**
	 * gets notes list in String array representation
	 * @return string array notes list
	 */
	public String[] getNotesArray() {
		String[] notesString = new String[notes.size()];
		for (int i = 0; i < notesString.length; i++) {
			notesString[i] = notes.get(i);
		}
		return notesString;
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
	private class BacklogState implements TaskState {		
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
			switch (c.getCommand()) {
				case CLAIM:
					if (c.getOwner() == UNOWNED) {
						throw new UnsupportedOperationException("Invalid transition.");
					}
					owner = c.getOwner();
					currentState = ownedState;
					addNoteToList(c.getNoteText());
					break;
				case REJECT:
					currentState = rejectedState;
					addNoteToList(c.getNoteText());
					break;
				default:
					throw new UnsupportedOperationException("Invalid transition.");
				}
			
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "Backlog";
		}
	}
	
	/**
	 * Owned State of task
	 * @author Kavya Vadla
	 */
	private class OwnedState implements TaskState {
		
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
			switch (c.getCommand()) {
				case PROCESS:
					currentState = processingState;
					addNoteToList(c.getNoteText());
					break;
				case REJECT:
					owner = UNOWNED;
					currentState = rejectedState;
					addNoteToList(c.getNoteText());
					break;
				case BACKLOG:
					owner = UNOWNED;
					currentState = backlogState;
					addNoteToList(c.getNoteText());
					break;
				default:
					throw new UnsupportedOperationException("Invalid transition.");
				}
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "Owned";
		}
	}
	
	/**
	 * Verifying State of task
	 * @author Kavya Vadla
	 */
	private class VerifyingState implements TaskState {
		
		
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
			switch (c.getCommand()) {
				case COMPLETE:
					if (type == Type.KNOWLEDGE_ACQUISITION) {
						throw new UnsupportedOperationException("Invalid transition.");
					}
					currentState = doneState;
					isVerified = true;
					addNoteToList(c.getNoteText());
					break;
				case PROCESS:
					if (type == Type.KNOWLEDGE_ACQUISITION) {
						throw new UnsupportedOperationException("Invalid transition.");
					}
					currentState = processingState;
					addNoteToList(c.getNoteText());
					break;
				default:
					throw new UnsupportedOperationException("Invalid transition.");
				}
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "Verifying";
		}
	}
	
	/**
	 * Processing State of task
	 * @author Kavya Vadla
	 */
	private class ProcessingState implements TaskState {
		
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
			switch (c.getCommand()) {
				case PROCESS:
					addNoteToList(c.getNoteText());
					break;
				case VERIFY:
					if (type == Type.KNOWLEDGE_ACQUISITION) {
						throw new UnsupportedOperationException("Invalid transition.");
					}
					currentState = verifyingState;
					addNoteToList(c.getNoteText());
					break;
				case COMPLETE:
					if (type != Type.KNOWLEDGE_ACQUISITION){
						throw new UnsupportedOperationException("Invalid transition.");
					}
					currentState = doneState;
					addNoteToList(c.getNoteText());
					break;
				case BACKLOG:
					owner = UNOWNED;
					currentState = backlogState;
					addNoteToList(c.getNoteText());
				break;
				default:
					throw new UnsupportedOperationException("Invalid transition.");
			}
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "Processing";
		}
	}
	
	/**
	 * Done State of task
	 * @author Kavya Vadla
	 */
	private class DoneState implements TaskState {
		
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
			switch (c.getCommand()) {
				case PROCESS:
					currentState = processingState;
					addNoteToList(c.getNoteText());
					isVerified = false;
					break;
				case BACKLOG:
					owner = UNOWNED;
					currentState = backlogState;
					isVerified = false;
					addNoteToList(c.getNoteText());
					break;
				default:
					throw new UnsupportedOperationException("Invalid transition.");
				}
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "Done";
		}
	}
	
	/**
	 * Rejected State of task
	 * @author Kavya Vadla
	 */
	private class RejectedState implements TaskState {
		
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
			switch (c.getCommand()) {
				case BACKLOG:
					owner = UNOWNED;
					currentState = backlogState;
					addNoteToList(c.getNoteText());
					break;
				default:
					throw new UnsupportedOperationException("Invalid transition.");
		}
		}
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return "Rejected";
		}
	}
}
