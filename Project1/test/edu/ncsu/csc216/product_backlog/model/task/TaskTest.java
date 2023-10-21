package edu.ncsu.csc216.product_backlog.model.task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.product_backlog.model.command.Command;
import edu.ncsu.csc216.product_backlog.model.command.Command.CommandValue;
import edu.ncsu.csc216.product_backlog.model.task.Task.Type;

/**
 * Testing Task class
 * 
 * 
 * Most getters are tested through other testing methods.
 * @author Kavya Vadla
 */
class TaskTest {
	/** Task id */
	private static final int ID = 1;
	/** Task state */
	private static final String STATE = "Backlog";
	/** Task title */
	private static final String TITLE = "title";
	/** Task type string */
	private static final String STYPE = "F";
	/** Task type */
	private static final Type TYPE = Type.FEATURE;
	/** Task creator */
	private static final String CREATOR = "creator";
	/** Task owner */
	private static final String OWNER = "unowned";
	/** Task isVerified */
	private static final String VERIFIED = "false";
	/** notes array for task */
	private ArrayList<String> notes = new ArrayList<String>();
	/** single note for task */
	private String note = "note";
	
	/**
	 * testing long test constructor
	 */
	@Test
	void testTaskIntStringStringStringStringStringStringArrayListOfString() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Task(-1, STATE, TITLE, STYPE, CREATOR, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, null, TITLE, STYPE, CREATOR, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, "", TITLE, STYPE, CREATOR, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, null, STYPE, CREATOR, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e4.getMessage());
		Exception e5 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, "", STYPE, CREATOR, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e5.getMessage());
		Exception e6 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, TITLE, null, CREATOR, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e6.getMessage());
		Exception e7 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, TITLE, "", CREATOR, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e7.getMessage());
		Exception e8 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, TITLE, STYPE, null, OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e8.getMessage());
		Exception e9 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, TITLE, STYPE, "", OWNER, VERIFIED, notes));
		assertEquals("Invalid task information.", e9.getMessage());
		Exception e10 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, TITLE, STYPE, CREATOR, "", VERIFIED, notes));
		assertEquals("Invalid task information.", e10.getMessage());
		Exception e11 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, STATE, TITLE, STYPE, CREATOR, null, VERIFIED, notes));
		assertEquals("Invalid task information.", e11.getMessage());
		Exception e12 = assertThrows(IllegalArgumentException.class, () ->  new Task(ID, STATE, TITLE, STYPE, CREATOR, OWNER, "verified", notes));
		assertEquals("Invalid task information.", e12.getMessage());
		Exception e13 = assertThrows(IllegalArgumentException.class, () ->  new Task(ID, STATE, TITLE, STYPE, CREATOR, OWNER, null, notes));
		assertEquals("Invalid task information.", e13.getMessage());
		
		Task task = new Task(1, "Backlog", "title", "F", "creator", "unowned", "false", notes);
		assertAll("Task",
				() -> assertEquals(ID, task.getTaskId(), "incorrect id"),
				() -> assertEquals(STATE, task.getStateName(), "incorrect state"),
				() -> assertEquals(TITLE, task.getTitle(), "incorrect title"),
				() -> assertEquals(STYPE, task.getTypeShortName(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals(OWNER, task.getOwner(), "incorrect owner"),	
				() -> assertEquals(VERIFIED, String.valueOf(task.isVerified()), "incorrect verification"),
				() -> assertEquals(notes, task.getNotes(), "incorrect notes"));
	}

	/**
	 * testing shorter Task constructor
	 */
	@Test
	void testTaskIntStringTypeStringString() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Task(-1, TITLE, TYPE, CREATOR, note));
		assertEquals("Invalid task information.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, null, TYPE, CREATOR, note));
		assertEquals("Invalid task information.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, "", TYPE, CREATOR, note));
		assertEquals("Invalid task information.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, TITLE, null, CREATOR, note));
		assertEquals("Invalid task information.", e4.getMessage());
		Exception e5 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, TITLE, TYPE, null, note));
		assertEquals("Invalid task information.", e5.getMessage());
		Exception e6 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, TITLE, TYPE, "", note));
		assertEquals("Invalid task information.", e6.getMessage());
		Exception e7 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, TITLE, TYPE, CREATOR, null));
		assertEquals("Invalid task information.", e7.getMessage());
		Exception e8 = assertThrows(IllegalArgumentException.class, () -> new Task(ID, TITLE, TYPE, CREATOR, ""));
		assertEquals("Invalid task information.", e8.getMessage());
		
		Task task = new Task(ID, TITLE, TYPE, CREATOR, note);
		assertAll("Task",
				() -> assertEquals(ID, task.getTaskId(), "incorrect id"),
				() -> assertEquals(TITLE, task.getTitle(), "incorrect title"),
				() -> assertEquals(TYPE, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Backlog] " + note, task.getNotes().get(0), "incorrect note"));
	}

	/**
	 * Testing adding note to list
	 */
	@Test
	void testAddNoteToList() {
		Task task = new Task(1, "Backlog", "title", "F", "creator", "unowned", "false", notes);
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> task.addNoteToList(null));
		assertEquals("Invalid task information.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> task.addNoteToList(""));
		assertEquals("Invalid task information.", e2.getMessage());
		task.addNoteToList(note);
		assertEquals("[Backlog] " + note, task.getNotes().get(0));
	}

	/**
	 * test getTypeLongName
	 */
	@Test
	void testGetTypeLongName() {
		Task t1 = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Task t2 = new Task(1, "Backlog", "title", "F", "creator", "unowned", "false", notes);
		Task t3 = new Task(1, "Backlog", "title", "TW", "creator", "unowned", "false", notes);
		Task t4 = new Task(1, "Backlog", "title", "KA", "creator", "unowned", "false", notes);
		assertEquals("Bug", t1.getTypeLongName());
		assertEquals("Feature", t2.getTypeLongName());
		assertEquals("Technical Work", t3.getTypeLongName());
		assertEquals("Knowledge Acquisition", t4.getTypeLongName());
	}

	/**
	 * tests getTypeShortName
	 */
	@Test
	void testGetTypeShortName() {
		Task t1 = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Task t2 = new Task(1, "Backlog", "title", "F", "creator", "unowned", "false", notes);
		Task t3 = new Task(1, "Backlog", "title", "TW", "creator", "unowned", "false", notes);
		Task t4 = new Task(1, "Backlog", "title", "KA", "creator", "unowned", "false", notes);
		assertEquals("B", t1.getTypeShortName());
		assertEquals("F", t2.getTypeShortName());
		assertEquals("TW", t3.getTypeShortName());
		assertEquals("KA", t4.getTypeShortName());
	}

	/**
	 * tests getNotesList
	 */
	@Test
	void testGetNotesList() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		task.addNoteToList(note);
		task.addNoteToList("note2");
		task.addNoteToList("note3");
		task.addNoteToList("note4");
		assertEquals("- [Backlog] " + note + "\n- [Backlog] note2\n- [Backlog] note3\n- [Backlog] note4\n", task.getNotesList());
		
	}

	/**
	 * test task toString
	 */
	@Test
	void testToString() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		assertEquals("* 1,Backlog,title,B,creator,unowned,false", task.toString());
	}

	/**
	 * test task update
	 */
	@Test
	void testUpdate() {
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		Task t = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		t.update(c);

		assertAll("Task commands",
				() -> assertEquals("Owned", t.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", t.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, t.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, t.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Owned] claiming task", t.getNotes().get(0), "incorrect note"));
	}

	/**
	 * testing getNotes as a String Array
	 */
	@Test
	void testGetNotesArray() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		task.addNoteToList(note);
		task.addNoteToList("note2");
		task.addNoteToList("note3");
		task.addNoteToList("note4");
		String[] stringNotes = {"[Backlog] note", "[Backlog] note2", "[Backlog] note3", "[Backlog] note4"};
		assertTrue(Arrays.equals(task.getNotesArray(), stringNotes));
	}
	
	/**
	 * Tests backlogStateA transition
	 */
	@Test
	void testBacklogA() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		assertAll("Task states",
				() -> assertEquals("Owned", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Owned] claiming task", task.getNotes().get(0), "incorrect note"));
	}
	
	/**
	 * Tests backlogStateA transition
	 */
	@Test
	void testBacklogB() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.REJECT, null, "rejecting task");
		task.update(c);
		assertAll("Task states",
				() -> assertEquals("Rejected", task.getStateName(), "incorrect state"),
				() -> assertEquals("unowned", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),
				() -> assertFalse(task.isVerified()),
				() -> assertEquals("[Rejected] rejecting task", task.getNotes().get(0), "rejecting note"));
	}
	
	/**
	 * Tests invalid backlog transitions
	 */
	@Test
	void testBacklogInvalid() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.PROCESS, null, "processing task");
		Command c2 = new Command(CommandValue.COMPLETE, null, "task done");
		Command c3 = new Command(CommandValue.VERIFY, null, "verifying task");
		Command c4 = new Command(CommandValue.CLAIM, "unowned", "claiming task");
		assertAll("Backlog transitions",
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c), "process state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c2), "done state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c3), "verify state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c4), "unowned in claim command"));
	}
	
	/**
	 * Tests ownedStateA transition
	 */
	@Test
	void testOwnedA() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		assertAll("Task states",
				() -> assertEquals("Processing", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Processing] processing task", task.getNotes().get(1), "incorrect note"));
	}
	
	/**
	 * Tests ownedStateB transition
	 */
	@Test
	void testOwnedB() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.REJECT, null, "rejecting task");
		task.update(c1);
		assertAll("Task states",
				() -> assertEquals("Rejected", task.getStateName(), "incorrect state"),
				() -> assertEquals("unowned", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Rejected] rejecting task", task.getNotes().get(1), "incorrect note"));
	}
	
	/**
	 * Tests ownedStateC transition
	 */
	@Test
	void testOwnedC() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.BACKLOG, null, "returning task to backlog");
		task.update(c1);
		assertAll("Task states",
				() -> assertEquals("Backlog", task.getStateName(), "incorrect state"),
				() -> assertEquals("unowned", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Backlog] returning task to backlog", task.getNotes().get(1), "incorrect note"));
	}
	
	/**
	 * Tests invalid owned transitions
	 */
	@Test
	void testOwnedInvalid() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c2 = new Command(CommandValue.COMPLETE, null, "task done");
		Command c3 = new Command(CommandValue.VERIFY, null, "verifying task");
		Command c4 = new Command(CommandValue.CLAIM, "sesmith5", "claiming task again");
		assertAll("Backlog transitions",
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c2), "done state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c3), "verify state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c4), "owned state"));
	}
	
	/**
	 * Tests processStateA transition
	 */
	@Test
	void testProcessingA() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.PROCESS, null, "processing task2");
		task.update(c2);
		assertAll("Task states",
				() -> assertEquals("Processing", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Processing] processing task2", task.getNotes().get(2), "incorrect note"));
	}
	
	/**
	 * Tests processStateB transition
	 */
	@Test
	void testProcessingB() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.VERIFY, null, "verifying task");
		task.update(c2);
		assertAll("Task states",
				() -> assertEquals("Verifying", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Verifying] verifying task", task.getNotes().get(2), "incorrect note"));
	}
	
	/**
	 * Tests processStateC transition
	 */
	@Test
	void testProcessingC() {
		Task task = new Task(1, "Backlog", "title", "KA", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.COMPLETE, null, "done task");
		task.update(c2);
		assertAll("Task states",
				() -> assertEquals("Done", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.KNOWLEDGE_ACQUISITION, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Done] done task", task.getNotes().get(2), "incorrect note"));
	}
	
	/**
	 * Tests processStateD transition
	 */
	@Test
	void testProcessingD() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.BACKLOG, null, "returning task");
		task.update(c2);
		assertAll("Task states",
				() -> assertEquals("Backlog", task.getStateName(), "incorrect state"),
				() -> assertEquals("unowned", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Backlog] returning task", task.getNotes().get(2), "incorrect note"));
	}
	
	/**
	 * Tests invalid process transitions
	 */
	@Test
	void testProcessInvalid() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.REJECT, null, "reject task");
		Command c3 = new Command(CommandValue.CLAIM, "sesmith5", "claiming task again");
		Command c4 = new Command(CommandValue.COMPLETE, null, "task done");
		Task task2 = new Task(2, "Processing", "title", "KA", "creator", "unowned", "false", notes);
		Command c5 = new Command(CommandValue.VERIFY, null, "verifying task");
		assertAll("Backlog transitions",
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c2), "reject state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c3), "owned state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c4), "done state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task2.update(c5), "verify state"));
	}
	
	/**
	 * Tests verifyStateA transition
	 */
	@Test
	void testVerifyingA() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.VERIFY, null, "verifying task");
		task.update(c2);
		Command c3 = new Command(CommandValue.COMPLETE, null, "done task");
		task.update(c3);
		assertAll("Task states",
				() -> assertEquals("Done", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),
				() -> assertTrue(task.isVerified()),
				() -> assertEquals("[Done] done task", task.getNotes().get(3), "incorrect note"));
	}
	
	/**
	 * Tests verifyStateB transition
	 */
	@Test
	void testVerifyingB() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.VERIFY, null, "verifying task");
		task.update(c2);
		Command c3 = new Command(CommandValue.PROCESS, null, "processing task again");
		task.update(c3);
		assertAll("Task states",
				() -> assertEquals("Processing", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Processing] processing task again", task.getNotes().get(3), "incorrect note"));
	}
	
	/**
	 * Tests invalid verify transitions
	 */
	@Test
	void testVerifyInvalid() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.VERIFY, null, "verifying task");
		task.update(c2);
		Command c3 = new Command(CommandValue.REJECT, null, "reject task");
		Command c4 = new Command(CommandValue.CLAIM, "sesmith5", "claiming task again");
		Command c5 = new Command(CommandValue.BACKLOG, null, "backlog task");
		Command c6 = new Command(CommandValue.VERIFY, null, "verify task");
		Task task2 = new Task(2, "Verifying", "title", "KA", "creator", "unowned", "false", notes);
		Command c7 = new Command(CommandValue.PROCESS, null, "processing task");
		Command c8 = new Command(CommandValue.COMPLETE, null, "done task");
		assertAll("Backlog transitions",
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c3), "reject state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c4), "owned state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c5), "done state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c6), "verify state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task2.update(c7), "process state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task2.update(c8), "done state"));
	}
	
	/**
	 * Tests doneStateA transition
	 */
	@Test
	void testDoneA() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.VERIFY, null, "verifying task");
		task.update(c2);
		Command c3 = new Command(CommandValue.COMPLETE, null, "done task");
		task.update(c3);
		Command c4 = new Command(CommandValue.PROCESS, null, "processing task2");
		task.update(c4);
		assertAll("Task states",
				() -> assertEquals("Processing", task.getStateName(), "incorrect state"),
				() -> assertEquals("sesmith5", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertTrue(task.isVerified()),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Processing] processing task2", task.getNotes().get(4), "incorrect note"));
	}
	
	/**
	 * Tests doneStateB transition
	 */
	@Test
	void testDoneB() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.VERIFY, null, "verifying task");
		task.update(c2);
		Command c3 = new Command(CommandValue.COMPLETE, null, "done task");
		task.update(c3);
		Command c4 = new Command(CommandValue.BACKLOG, null, "backlog task");
		task.update(c4);
		assertAll("Task states",
				() -> assertEquals("Backlog", task.getStateName(), "incorrect state"),
				() -> assertEquals("unowned", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertTrue(task.isVerified()),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Backlog] backlog task", task.getNotes().get(4), "incorrect note"));
	}
	
	/**
	 * Tests invalid done transitions
	 */
	@Test
	void testDoneInvalid() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.PROCESS, null, "processing task");
		task.update(c1);
		Command c2 = new Command(CommandValue.VERIFY, null, "verifying task");
		task.update(c2);
		Command c3 = new Command(CommandValue.COMPLETE, null, "done task");
		task.update(c3);
		Command c4 = new Command(CommandValue.COMPLETE, null, "task done");
		Command c5 = new Command(CommandValue.VERIFY, null, "verifying task");
		Command c6 = new Command(CommandValue.CLAIM, "sesmith5", "claiming task again");
		Command c7 = new Command(CommandValue.REJECT, null, "rejecting task");
		assertAll("Backlog transitions",
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c4), "done state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c5), "verify state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c6), "verify state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c7), "owned state"));
	}
	
	/**
	 * Tests rejectStateA transition
	 */
	@Test
	void testRejectA() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.REJECT, null, "rejecting task");
		task.update(c1);
		Command c2 = new Command(CommandValue.BACKLOG, null, "backlog task");
		task.update(c2);
		assertAll("Task states",
				() -> assertEquals("Backlog", task.getStateName(), "incorrect state"),
				() -> assertEquals("unowned", task.getOwner(), "incorrect owner"),
				() -> assertEquals(Type.BUG, task.getType(), "incorrect type"),
				() -> assertEquals(CREATOR, task.getCreator(), "incorrect creator"),	
				() -> assertEquals("[Backlog] backlog task", task.getNotes().get(2), "incorrect note"));
	}
	
	/**
	 * Tests invalid done transitions
	 */
	@Test
	void testRejectInvalid() {
		Task task = new Task(1, "Backlog", "title", "B", "creator", "unowned", "false", notes);
		Command c = new Command(CommandValue.CLAIM, "sesmith5", "claiming task");
		task.update(c);
		Command c1 = new Command(CommandValue.REJECT, null, "rejecting task");
		task.update(c1);
		Command c2 = new Command(CommandValue.COMPLETE, null, "task done");
		Command c3 = new Command(CommandValue.VERIFY, null, "verifying task");
		Command c4 = new Command(CommandValue.CLAIM, "sesmith5", "claiming task again");
		Command c5 = new Command(CommandValue.PROCESS, null, "processing task");
		assertAll("Backlog transitions",
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c2), "done state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c3), "verify state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c4), "verify state"),
				() -> assertThrows(UnsupportedOperationException.class, () -> task.update(c5), "owned state"));
	}
	
}
