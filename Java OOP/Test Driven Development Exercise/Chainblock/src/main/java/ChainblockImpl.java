import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionsByIds;

    public ChainblockImpl() {
        transactionsByIds = new HashMap<>();
    }

    public int getCount() {
        return this.transactionsByIds.size();
    }

    public void add(Transaction transaction) {
        this.transactionsByIds.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionsByIds.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!contains(id))
            throw new IllegalArgumentException();

        this.transactionsByIds.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!contains(id))
            throw new IllegalArgumentException();

        this.transactionsByIds.remove(id);
    }

    public Transaction getById(int id) {
        if (contains(id)) {
            return this.transactionsByIds.get(id);
        }

        throw new IllegalArgumentException();
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionsList = new ArrayList<>();

        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getStatus() == status)
                transactionsList.add(transaction);
        }

        if (transactionsList.size() == 0)
            throw new IllegalArgumentException();

        transactionsList.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return transactionsList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactions::add);
        return transactions.stream().map(Transaction::getFrom).collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactions::add);
        return transactions.stream().map(Transaction::getTo).collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
