package linkedList;

public class ListNode<T> {
    private T data;
    public ListNode<T> link;

    public ListNode(){
        this.data = null;
        this.link = null;
    }

    public ListNode(T data){
        this.data = data;
        this.link = null;
    }

    public ListNode(T data, ListNode<T> link){
        this.data = data;
        this.link = link;
    }

    public T getData(){
        return this.data;
    }

}
