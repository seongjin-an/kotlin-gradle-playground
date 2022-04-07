package array;

public class Main {
    public static void main(String[] args) {
//        AnsArray ansArray = new AnsArray(3);
//        ansArray.addElement(1);
//        ansArray.addElement(2);
//        ansArray.addElement(3);
//        for(int i = 0; i < ansArray.getSize(); i++){
//            System.out.println(i + ": " +ansArray.getElement(i));
//        }
        AnsArray ansArray = new AnsArray();
        ansArray.addElement(10);
        ansArray.addElement(20);
        ansArray.addElement(30);
        ansArray.insertElement(1, 50);
        ansArray.printAll();

        ansArray.removeElement(1);
        ansArray.printAll();

        ansArray.addElement(70);
        ansArray.printAll();
    }
}
