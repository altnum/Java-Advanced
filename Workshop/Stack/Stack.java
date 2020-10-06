public class Stack {

    private static class Node {
        private int element;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public Stack() {
    }

    public void Push(int element) {
        Node newNode = new Node(element);
        if (this.top == null) {
            this.top = newNode;
        } else {

        }
    }
}
