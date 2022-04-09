package array;

public class Main2 {
    public static void main(String[] args) {
        Array<String> arr = new Array<>();
        String ansj = arr.add("ansj");
        System.out.println("ansj: " + ansj);
        arr.add("123");
        arr.printAll();
        System.out.println("==============================");
        Array<Integer> arr2 = new Array<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.printAll();
        arr2.remove(1);
        arr2.printAll();
        arr2.insert(1,2);
        arr2.printAll();
        System.out.println("========================================");
        Array<String> arr3 = new Array<>(3);
        arr3.add("ansj");
        arr3.add("anseongjin");
        arr3.add("ans");
        arr3.printAll();
        arr3.add("123");
        arr3.add("234");
        arr3.add("345");
        String index5 = arr3.get(5);
        System.out.println("index5: " + index5);
        arr3.printAll();
        System.out.println("=======================================");
        String num111 = arr3.insert(1, "111");
        System.out.println("num111: "+ num111);
        arr3.insert(1, "222");
        arr3.insert(1, "333");
        arr3.insert(1, "444");
        arr3.printAll();
        System.out.println("=========================================");
        String str1 = arr3.remove(1);
        System.out.println("str1: " + str1);
        arr3.printAll();
    }
}
