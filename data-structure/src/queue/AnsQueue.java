package queue;

import linkedList.AnsLinkedList;
import linkedList.ListNode;


public class AnsQueue <T> extends AnsLinkedList<T> implements Queue<T> {
    ListNode<T> front;
    ListNode<T> rear;

    @Override
    public ListNode<T> enqueue(T data) {
        ListNode<T> newNode;
        if(isEmpty()){
            newNode = addElement(data);
            front = newNode;
            rear = newNode;
        }else{
            newNode = addElement(data);
            rear = newNode;
        }
        return newNode;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            return null;
        }
        T  data = front.getData();
        front = front.link;
        if(front == null){
            rear = null;
        }
        return data;
    }

    @Override
    public void printQueue() {
        printList();
    }
}
