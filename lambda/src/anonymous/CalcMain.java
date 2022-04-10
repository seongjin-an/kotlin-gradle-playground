package anonymous;

public class CalcMain {
    public static void main(String[] args) {
        Calc calc = (x, y) ->  x + y;
        System.out.println(calc.add(2, 3));
    }
}
