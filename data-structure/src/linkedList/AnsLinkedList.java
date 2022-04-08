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

    public T getElement(int position){
        int i;
        ListNode<T> tempNode = head;

        if(position >= count){
            throw new IllegalArgumentException("검색 위치 오류 입니다. 현재 리스트의 개수는 " + count + "개 입니다.");
        }

        if(position == 0){
            return head.getData();
        }

        for(i = 0; i < position; i++){
            tempNode = tempNode.link;
        }

        return tempNode.getData();
    }

    public ListNode<T> getNode(int position){
        int i;
        ListNode<T> tempNode = head;

        if(position >= count){
            throw new IllegalArgumentException("검색 위치 오류 입니다. 현재 리스트의 개수는 " + count + "개 입니다.");
        }

        if(position == 0){
            return head;
        }
        for(i = 0; i < position; i++){
            tempNode = tempNode.link;
        }
        return tempNode;
    }

    public ListNode<T> searchNode(T data){
        ListNode<T> currentNode = head;
        while(currentNode != null){
            if(currentNode.getData() == data){
                return currentNode;
            }else{
                currentNode = currentNode.link;
            }
        }
        return currentNode;
    }

    public void removeAll(){
        this.head = null;
        count = 0;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        return head == null;
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
