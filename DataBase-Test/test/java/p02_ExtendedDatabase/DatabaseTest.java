package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private final static Person[] PEOPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C")
    };
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testTestingConstructor() throws OperationNotSupportedException {
        assertEquals(PEOPLE.length, database.getElements().length);
        assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testStoringArrayCapacityCantBeMoreThan16Elements() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfElementsInConstructorAreLessThanOneThrowException() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void testWhenValidElementIsGivenToAddCommandElementIsAddedToLastIndex() throws OperationNotSupportedException {
        Person person = new Person(4, "D");
        database.add(person);
        Person[] lastElement = database.getElements();
        assertEquals(PEOPLE.length + 1, lastElement.length);
        Person currentPerson = lastElement[lastElement.length - 1];
        assertEquals(person.getId(), currentPerson.getId());
        assertEquals(person.getUsername(), currentPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testTestingWhenNullElementIsGivenShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testLastElementIsRemoved() throws OperationNotSupportedException {
        database.remove();
        Person[] databaseElements = database.getElements();
        assertEquals(PEOPLE.length - 1, databaseElements.length);
        Person expectedPerson = PEOPLE[PEOPLE.length - 2];
        Person actualPerson = databaseElements[databaseElements.length - 1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testElementsIsEmptyAndRemovedExceptionIsThrown() throws OperationNotSupportedException {
        database = new Database(new Person(6, "asd"));
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowingExceptionIfGivenElementIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testIfGivenUsernameIsValidReturnValidUsername() throws OperationNotSupportedException {
        Person validUsername = database.findByUsername("B");
        assertEquals(PEOPLE[1].getId(), validUsername.getId());
        assertEquals(PEOPLE[1].getUsername(), validUsername.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testTestingIfGivenArrayIsEmpty() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findByUsername("C");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWhenFindPersonByIdOnEmptyArrayExceptionIsThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findById(2);
    }

    @Test
    public void testWhenGivenIdIsValidReturnValidPerson() throws OperationNotSupportedException {
        Person validPerson = database.findById(2);
        assertEquals(PEOPLE[1].getId(), validPerson.getId());
        assertEquals(PEOPLE[1].getUsername(), validPerson.getUsername());

    }

}