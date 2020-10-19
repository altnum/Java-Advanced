package Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    private class LibIterator implements Iterator<Book> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            if (this.count < books.length)
                return true;
            return false;
        }

        @Override
        public Book next() {
            return books[count++];
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
