package stack;

public class Main {
    public static void main(String[] args) {
        AnsStack<String> stack = new AnsStack<>(3);
        String num10 = stack.push("10");
        System.out.println("num10: " + num10);
        stack.push("20");
        stack.push("30");
        stack.printAll();
        String pop = stack.pop();
        System.out.println("pop: " + pop);
        String peek = stack.peek();
        System.out.println("peek: " + peek);
        stack.printAll();
        System.out.println("============================");
    }
}
