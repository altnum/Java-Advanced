package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class BankVaultTest {
    private BankVault bankVault;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        bankVault = new BankVault();
        item1 = new Item("Rado", "111");
        item2 = new Item("Jorje", "222");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testVaultSafesUnmodifiableMap() {
        bankVault.getVaultCells().put("C1", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonExistingCell() throws OperationNotSupportedException {
        bankVault.addItem("D1", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCellAlreadyTaken() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A1", item2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testItemAlreadyInCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("B1", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingItem() {
        bankVault.removeItem("A1", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingCell() {
        bankVault.removeItem("D1", item1);
    }

    @Test
    public void testRemovedExistingItemSuccessfully() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.removeItem("A1", item1);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }

    @Test
    public void testGetOwner() {
        Assert.assertEquals("Rado", item1.getOwner());
    }

    @Test
    public void itemSuccessfullyAdded() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        Assert.assertEquals(bankVault.getVaultCells().get("A1"), item1);
    }

    @Test
    public void testRightInitialization() {
        for (Map.Entry<String, Item> e : bankVault.getVaultCells().entrySet()) {
            Assert.assertNull(e.getValue());
        }
    }

    @Test
    public void i() {
        Assert.assertEquals("111", item1.getItemId());
    }

}