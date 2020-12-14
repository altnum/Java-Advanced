import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class IteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"X", "Y", "Z"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }
    //конструктор
        //1. без елементи (null)
    @Test(expected = OperationNotSupportedException.class)
    public void testCreateListWithNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }
        //2. да работи правилно
    //move
    //print
    //hasNext
    @Test
    public void testHasNextReturnCorrectBoolean () {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        ListIterator list = new ListIterator();
        list.print();
    }

    @Test
    public void testPrintCorrectly() {
        int index = 0;

        while (listIterator.hasNext()) {
            Assert.assertEquals(DATA[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}
