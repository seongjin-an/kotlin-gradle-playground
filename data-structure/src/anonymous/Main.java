package anonymous;

public class Main {
    public static void main(String[] args) {
        Developer dev = new Developer();
        dev.checkDeveloper(new Person() {
            @Override
            public String getName() {
                return "anseongjin";
            }

            @Override
            public int getAge() {
                return 222;
            }
        });
        dev.checkDeveloper(new Person() {
            @Override
            public String getName() {
                return "ansj";
            }

            @Override
            public int getAge() {
                return 11;
            }
        });
        dev.checkInformation(() -> {
            return "pangyo";
        });
    }
}
