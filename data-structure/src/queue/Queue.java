package queue;

import linkedList.ListNode;

public interface Queue <T> {
    public ListNode<T> enqueue(T data);
    public T dequeue();
    public void printQueue();
}
