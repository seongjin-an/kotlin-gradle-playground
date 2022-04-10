public class AutoCloseableMain {
    public static void main(String[] args) {
        try(AutoCloseableObject obj = new AutoCloseableObject()){
            System.out.println("now try");
            throw new Exception("hi");
        }catch(Exception e){
            System.out.println("now caught");
        }
    }
}
