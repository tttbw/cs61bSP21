package deque;
public class LinkedListDeque<T> implements Deque<T> {
    public class Node {
        private T value;
        private Node prev;
        private Node next;

        public Node(T x, Node pre, Node nex) {
            value = x;
            next = nex;
            prev = pre;
        }
    }
    public Node sentinel;
    public int size;
    public LinkedListDeque() {
        T meaningless = null;
        sentinel = new Node(meaningless, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public void getFirst() {
        System.out.println(sentinel.next.value);
    }

    public void getLast() {
        System.out.println(sentinel.prev.value);
    }

    public void addFirst(T x) {
        size += 1;
        Node Newnode = new Node(x, null, null);
        Newnode.prev = sentinel;
        Newnode.next = sentinel.next;
        sentinel.next.prev = Newnode;
        sentinel.next = Newnode;
    }

    public void addLast(T x) {
        size += 1;
        Node Newnode = new Node(x, null, null);
        Newnode.prev = sentinel.prev;
        Newnode.next = sentinel;
        sentinel.prev.next = Newnode;
        sentinel.prev = Newnode;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.value + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }
        Node dropOne;
        dropOne = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        if(size != 0)
            {size --;}
        return dropOne.value;
    }

    public T removeLast() {
        if (sentinel.prev == null) {
            return null;
        }
        Node dropOne;
        dropOne = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        if(size != 0)
            {size --;}
        return dropOne.value;
    }

    public T get(int index) {
        if (index > this.size() - 1) {
            return null;
        }
        if (index < 0) {
            return null;
        }
        int i = 0;
        Node p = sentinel;
        while (i < index + 1) {
            p = p.next;
            i++;
        }
        return p.value;
    }

}
