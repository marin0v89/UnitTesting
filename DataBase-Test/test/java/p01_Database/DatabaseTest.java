package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private final static Integer[] ELEMENTS = new Integer[]{1, 2, 3};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }

    @Test
    public void testTestingConstructor() throws OperationNotSupportedException {
        assertEquals(ELEMENTS.length, database.getElements().length);
        assertArrayEquals(ELEMENTS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testStoringArrayCapacityCantBeMoreThan16Elements() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfElementsInConstructorAreLessThanOneThrowException() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void testWhenValidElementIsGivenToAddCommandElementIsAddedToLastIndex() throws OperationNotSupportedException {
        Integer firstElement = 15;
        database.add(firstElement);
        Integer[] lastElement = database.getElements();
        assertEquals(ELEMENTS.length + 1, lastElement.length);
        assertEquals(firstElement, lastElement[lastElement.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testTestingWhenNullElementIsGivenShouldThrowException() throws OperationNotSupportedException {
        Integer element = null;
        database.add(element);
    }

    @Test
    public void testLastElementIsRemoved() throws OperationNotSupportedException {
        database.remove();
        Integer[] databaseElements = database.getElements();
        assertEquals(ELEMENTS.length - 1, databaseElements.length);
        assertEquals(ELEMENTS[ELEMENTS.length - 2], databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testElementsIsEmptyAndRemovedExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Integer[1]);
        database.remove();
        database.remove();
    }

}