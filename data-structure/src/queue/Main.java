package queue;

public class Main {
    public static void main(String[] args) {
        AnsQueue<String> queue = new AnsQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.printQueue();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
