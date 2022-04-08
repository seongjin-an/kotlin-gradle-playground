package linkedList;

public class AnsLinkedList<T> {
    private ListNode<T> head;
    int count;

    public AnsLinkedList(){
        this.head = null;
        count = 0;
    }

    public ListNode<T> addElement(T data){
        ListNode<T> newNode;

        if(head == null){
            newNode = new ListNode<>(data);
            head = newNode;
        }else{
            newNode = new ListNode<>(data);
            ListNode<T> temp = head;
            while(temp.link != null){
                temp = temp.link;
            }
            temp.link = newNode;
        }
        count++;

        return newNode;
    }

    public ListNode<T> insertElement(int position, T data){
        int i;
        ListNode<T> tempNode = head;
        ListNode<T> preNode = null;

        ListNode<T> newNode = new ListNode<T>(data);

        if(position < 0 || position > count) {
            return null;
        }

        if(position == 0){
            newNode.link = head;
            head = newNode;
        }else{
            for(i = 0; i < position; i++){
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            newNode.link = preNode.link;
            preNode.link = newNode;
        }
        count++;
        return newNode;
    }

    public ListNode<T> removeElement(int position){
        int i;
        ListNode<T> tempNode = head;
        ListNode<T> preNode = null;

        if(position == 0){
            head = tempNode.link;
        }else{
            for(i = 0; i < position; i++){
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            preNode.link = tempNode.link;
        }
        count--;
        return tempNode;
    }

    public void printList(){
        ListNode<T> temp = this.head;
        System.out.print("L = (");
        while(temp != null){
            System.out.print(temp.getData());
            temp = temp.link;
            if(temp != null){
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}
