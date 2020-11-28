import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElement () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        Database database = new Database(numbers);
        Integer[] databaseNumebers = database.getElements();

        Assert.assertEquals("c", numbers.length, databaseNumebers.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionWhenParamNull () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        Database database = new Database(numbers);
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement () throws OperationNotSupportedException {
        Integer[] numbers = {5, 9, 29, 45};
        Database database = new Database(numbers);
        database.add(17);
        Assert.assertEquals("done", 5, database.getElements().length);
        Assert.assertEquals(Integer.valueOf(17), database.getElements()[4]);
    }
}
