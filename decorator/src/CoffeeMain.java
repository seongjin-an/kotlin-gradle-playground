public class CoffeeMain {
    public static void main(String[] args) {
        Coffee ethiopiaCoffee = new EthiopiaAmericano();
        ethiopiaCoffee.brewing();
        System.out.println();

        Coffee ethiopiaLatte = new Latte(ethiopiaCoffee);
        ethiopiaLatte.brewing();
        System.out.println();

        Coffee mochaEthiopia = new Mocha(new Latte(new EthiopiaAmericano()));
        mochaEthiopia.brewing();
        System.out.println();

        Coffee mochaEthiopia2 = new Mocha(ethiopiaLatte);
        mochaEthiopia2.brewing();
        System.out.println();

        Coffee keyaCoffee = new WhippingCream(new Mocha(new Latte(new KeyaAmericano())));
        keyaCoffee.brewing();
    }
}
