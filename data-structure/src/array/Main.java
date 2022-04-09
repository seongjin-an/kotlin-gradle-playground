package array;

public class Main {
    public static void main(String[] args) {

        AnsArray2 ansArray2 = new AnsArray2();
        ansArray2.addElement(10);
        ansArray2.addElement(20);
        ansArray2.addElement(30);
        ansArray2.insertElement(1, 50);
        ansArray2.printAll();

        ansArray2.removeElement(1);
        ansArray2.printAll();

        ansArray2.addElement(70);
        ansArray2.printAll();
    }
}
