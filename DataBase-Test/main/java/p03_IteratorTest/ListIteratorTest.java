package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator("wood", "silver", "gold");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPassingNullElementsToConstructorThrownException() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testPassingValidElementsToConstructorReturnsCorrBool() throws OperationNotSupportedException {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test
    public void testPassingValidElementsToConstructorReturnsCorrBoolWithHasNext() throws OperationNotSupportedException {
        assertTrue(listIterator.hasNext());
        assertTrue(listIterator.hasNext());
        assertTrue(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyListIteratorExceptionIsThrown() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void testPrintingElementsInListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator("Goshko");
        listIterator.print();
    }

}