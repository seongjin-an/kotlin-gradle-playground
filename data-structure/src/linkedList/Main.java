package linkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        AnsLinkedList<String> list = new AnsLinkedList<>();
        list.addElement("ANSJ");
        list.addElement("123");
        list.addElement("haha");
        list.printList();

        list.insertElement(1, "1111");
        list.printList();

        list.removeElement(1);
        list.printList();

        ListNode<String> ansj = list.searchNode("ANSJ");
        if(ansj == null){
            System.out.println("ansj is null");
        }else{
            System.out.println(ansj.getData());
        }
    }
}
