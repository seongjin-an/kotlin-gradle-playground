public class Latte extends Decorator{

    public Latte(Coffee coffee) {
        super(coffee);//상위 클래스 default constructor 가 없기에 명시적으로 호출해야 함
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println(" Adding Milk");
    }
}
