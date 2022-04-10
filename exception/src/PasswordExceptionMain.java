public class PasswordExceptionMain {

    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) throws PasswordException {
        if(password == null){
            throw new PasswordException("password cannot be null");
        }else if(password.length() < 5){
            throw new PasswordException("password length must be longer than 5");
        }else if(password.matches("[a-zA-Z]+")) {
            throw new PasswordException("password must consist of special character");
        }
        this.password = password;
    }

    public static void main(String[] args) {
        PasswordExceptionMain password = new PasswordExceptionMain();
        String pwd = "abcabc1";
        try {
            password.setPassword(pwd);
            System.out.println("good");
        }catch(PasswordException error){
            System.out.println(error.getMessage());
        }
        System.out.println("end");
    }
}
