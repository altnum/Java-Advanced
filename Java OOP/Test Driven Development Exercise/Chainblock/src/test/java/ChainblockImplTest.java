import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactionsList;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.createTransactions();
    }
    
    private void fillChainBlock() {
        for (Transaction transaction : transactionsList) {
            this.chainblock.add(transaction);
        }
    }

    private void createTransactions() {
        this.transactionsList = new ArrayList<>();
        Transaction t = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "From", "To", 10.50);
        this.transactionsList.add(t);
        Transaction t2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "From", "To", 10.60);
        this.transactionsList.add(t2);
        Transaction t3 = new TransactionImpl(3, TransactionStatus.FAILED, "From", "To", 10.70);
        this.transactionsList.add(t3);
        Transaction t4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "From", "To", 10.80);
        this.transactionsList.add(t4);
    }

    @Test
    public void testContainsByIdReturnCorrectValue () {
        chainblock.add(transactionsList.get(0));
        Assert.assertTrue(chainblock.contains(transactionsList.get(0).getId()));
    }

    @Test
    public void testAddHasToAddTransactionToChainBlock() {
        chainblock.add(transactionsList.get(0));
        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testAddHasNotTransactionWhenDuplicatedId() {
        chainblock.add(transactionsList.get(0));
        Assert.assertEquals(1, chainblock.getCount());
        chainblock.add(transactionsList.get(1));
        Assert.assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testTransactionStatusHasToChangeCorrectly() {
        chainblock.add(transactionsList.get(0));
        chainblock.changeTransactionStatus(transactionsList.get(0).getId(), TransactionStatus.FAILED);
        Assert.assertEquals(TransactionStatus.FAILED, transactionsList.get(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentExceptionWhenTransactionDoesNotExist() {
        chainblock.changeTransactionStatus(transactionsList.get(0).getId(), TransactionStatus.FAILED);
    }

    @Test
    public void testRemoveTransactionByIdCorrectly() {
        fillChainBlock();
        Assert.assertEquals(4, chainblock.getCount());
        Transaction t = transactionsList.get(0);
        chainblock.removeTransactionById(t.getId());
        Assert.assertFalse(chainblock.contains(t.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExIfTransactionDoesNotExist() {
        fillChainBlock();
        chainblock.removeTransactionById(chainblock.getCount() + 1);
    }

    @Test
    public void testGetByIdHasToReturnCorrectTransaction() {
        fillChainBlock();
        Transaction expected = this.transactionsList.get(2);
        Transaction actual = this.chainblock.getById(expected.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdHasToThrowExIfIdNotPresent() {
        fillChainBlock();
        this.chainblock.getById(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusHasToThrowIfStatusNotExist() {
        fillChainBlock();
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionsStatusReturnCorrectTransactions() {
        fillChainBlock();
        List<Transaction> expected = this.transactionsList.stream().filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL).collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();

        result.forEach(actual::add);

        Assert.assertEquals(expected.size(), actual.size());

        for (Transaction t : actual) {
            Assert.assertEquals(TransactionStatus.SUCCESSFUL, t.getStatus());
        }
    }

    @Test
    public void testGetByTransactionsStatusReturnCorrectTransactionsInCorrectOrder () {
        fillChainBlock();
        List<Transaction> expected = this.transactionsList.stream().filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL).sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();

        result.forEach(actual::add);

        Assert.assertEquals(expected.size(), actual.size());

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSendersByTransactionStatusHasToThrowWhenIfStatusNotExist() {
        fillChainBlock();
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetByTransactionStatusReturnCorrectSendersInCorrectOrder() {
        fillChainBlock();
        List<String> expected = transactionsList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertNotNull(senders);
        List<String> actual = new ArrayList<>();
        senders.forEach(actual::add);
        Assert.assertEquals(expected.size(), actual.size());
        for (String sender : actual) {
            Assert.assertEquals("From", sender);
        }
        Assert.assertEquals(expected, actual);
    }

    //

    @Test(expected = IllegalArgumentException.class)
    public void testGetReceiversByTransactionStatusHasToThrowWhenIfStatusNotExist() {
        fillChainBlock();
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetByTransactionStatusReturnCorrectReceiversInCorrectOrder() {
        fillChainBlock();
        List<String> expected = transactionsList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Iterable<String> receivers = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertNotNull(receivers);
        List<String> actual = new ArrayList<>();
        receivers.forEach(actual::add);
        Assert.assertEquals(expected.size(), actual.size());
        for (String receiver : actual) {
            Assert.assertEquals("To", receiver);
        }
        Assert.assertEquals(expected, actual);
    }

}