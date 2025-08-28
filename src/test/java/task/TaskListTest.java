package task;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    // Minimal concrete Task for testing
    static class SimpleTask extends Task {
        public SimpleTask(String name) { super(name); }
        public SimpleTask(String name, boolean isDone) { super(name, isDone); }
        @Override public String toStorage() { return "S | " + (isDone ? "1" : "0") + " | " + taskName; }
    }

    @Test
    void newTaskList_startsEmpty() {
        TaskList tl = new TaskList();
        assertEquals(0, tl.size());
        assertTrue(tl.getTasks().isEmpty());
    }

    @Test
    void add_thenGet_preservesInsertionOrder() {
        TaskList tl = new TaskList();
        SimpleTask t1 = new SimpleTask("A");
        SimpleTask t2 = new SimpleTask("B");
        SimpleTask t3 = new SimpleTask("C");

        tl.add(t1);
        tl.add(t2);
        tl.add(t3);

        assertEquals(3, tl.size());
        assertSame(t1, tl.get(0), "First added should be at index 0");
        assertSame(t2, tl.get(1), "Second added should be at index 1");
        assertSame(t3, tl.get(2), "Third added should be at index 2");
    }

    @Test
    void delete_middleItem_shiftsLaterItemsLeft() {
        TaskList tl = new TaskList();
        SimpleTask t1 = new SimpleTask("A");
        SimpleTask t2 = new SimpleTask("B");
        SimpleTask t3 = new SimpleTask("C");
        tl.add(t1);
        tl.add(t2);
        tl.add(t3);

        tl.delete(1); // remove "B"

        assertEquals(2, tl.size());
        assertSame(t1, tl.get(0));
        assertSame(t3, tl.get(1), "Item after deleted one should shift left");
    }

    @Test
    void get_outOfBounds_throwsIndexOutOfBoundsException() {
        TaskList tl = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> tl.get(0));
        tl.add(new SimpleTask("A"));
        assertThrows(IndexOutOfBoundsException.class, () -> tl.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> tl.get(-1));
    }

    @Test
    void delete_outOfBounds_throwsIndexOutOfBoundsException() {
        TaskList tl = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> tl.delete(0));
        tl.add(new SimpleTask("A"));
        assertThrows(IndexOutOfBoundsException.class, () -> tl.delete(1));
        assertThrows(IndexOutOfBoundsException.class, () -> tl.delete(-1));
    }

    @Test
    void size_reflectsAddsAndDeletes() {
        TaskList tl = new TaskList();
        assertEquals(0, tl.size());
        tl.add(new SimpleTask("A"));
        assertEquals(1, tl.size());
        tl.add(new SimpleTask("B"));
        assertEquals(2, tl.size());
        tl.delete(0);
        assertEquals(1, tl.size());
        tl.delete(0);
        assertEquals(0, tl.size());
    }

    @Test
    void constructor_usesProvidedBackingList_andSharesMutations() {
        ArrayList<Task> backing = new ArrayList<>();
        SimpleTask t1 = new SimpleTask("A");
        backing.add(t1);

        TaskList tl = new TaskList(backing);
        assertEquals(1, tl.size());
        assertSame(t1, tl.get(0));

        // mutate via TaskList
        SimpleTask t2 = new SimpleTask("B");
        tl.add(t2);
        assertEquals(2, backing.size(), "Mutations via TaskList should reflect in backing list");

        // mutate via backing list
        SimpleTask t3 = new SimpleTask("C");
        backing.add(t3);
        assertEquals(3, tl.size(), "Mutations via backing list should reflect in TaskList");
        assertSame(t3, tl.get(2));
    }

    @Test
    void getTasks_returnsLiveBackingList() {
        TaskList tl = new TaskList();
        ArrayList<Task> ref = tl.getTasks();
        assertSame(ref, tl.getTasks(), "Should return the same backing list reference");

        // Mutating the returned list should affect the TaskList
        ref.add(new SimpleTask("A"));
        assertEquals(1, tl.size());
        ref.remove(0);
        assertEquals(0, tl.size());
    }
}
