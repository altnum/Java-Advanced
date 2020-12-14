import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "First"),
                                                new Person(3, "Third"),
                                                new Person(2, "Second")};
    @Before
    public void prepareDatabase () throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasToCreateValidObjects () throws OperationNotSupportedException {
        Person[] databaseNumbers = database.getElements();
        Assert.assertEquals("Count of elements is incorrect", PEOPLE.length, databaseNumbers.length);
        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(PEOPLE[i], databaseNumbers[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements ()  throws OperationNotSupportedException {
        Person[] numbers = new Person[17];
        new p02_ExtendedDatabase.Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElement () throws OperationNotSupportedException {
        Person[] numbers = new Person[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWhenParamNull () throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement () throws OperationNotSupportedException {
        database.add(new Person(4, "Forth"));
        Assert.assertEquals(4, database.getElements().length);
        Assert.assertEquals(4, database.getElements()[3].getId());
        Assert.assertEquals("Forth", database.getElements()[3].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData () throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }

        database.remove();
    }

    @Test
    public void testRemoveLastElement () throws OperationNotSupportedException {
        database.remove();
        Person[] elementsInDatabase = database.getElements();
        Assert.assertEquals(PEOPLE.length - 1, elementsInDatabase.length);
        Assert.assertEquals(3, elementsInDatabase[elementsInDatabase.length - 1].getId());
        Assert.assertEquals("Third", elementsInDatabase[elementsInDatabase.length - 1].getUsername());
        for (int i = 0; i < elementsInDatabase.length; i++) {
            Assert.assertEquals(elementsInDatabase[i], PEOPLE[i]);
        }
    }

    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExWithNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
            database = new Database();
            database.findByUsername("First");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowWithEmptyData () throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }

    @Test
    public void testFindIdReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());

        Person resultPerson2 = database.findById(2);
        Assert.assertEquals(2, resultPerson2.getId());
        Assert.assertEquals("Second", resultPerson2.getUsername());
    }


}
