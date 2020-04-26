package queue;

public interface Queue<E> {
    public void enqueue(E e);

    public E dequeue();

    public E getFront();

    public int getSize();

    public boolean isEmpty();
}
