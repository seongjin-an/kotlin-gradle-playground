import java.util.ArrayList;

class Library{
    public ArrayList<String> shelf = new ArrayList<>();
    public Library(){
        shelf.add("book1");
        shelf.add("book2");
        shelf.add("book3");
//        shelf.add("book4");
//        shelf.add("book5");
//        shelf.add("book6");
    }
    public synchronized String lendBook() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while(shelf.size() == 0){
            System.out.println(thread.getName() + " waiting start");
            wait();
            System.out.println(thread.getName() + "waiting end");
        }
        if(shelf.size() >0) {
            String book = shelf.remove(0);
            System.out.println(thread.getName() + ": " + book + " lend");
            return book;
        }else return null;
    }
    public synchronized void returnBook(String book){
        Thread thread = Thread.currentThread();
        shelf.add(book);
        notifyAll();
        System.out.println(thread.getName() + ": " + book + " return");
    }
}

class Student extends Thread{
    public Student(String name){
        super(name);
    }
    @Override
    public void run() {
        try {
            String title = LibraryMain.library.lendBook();
            if (title == null) {
                System.out.println(getName() + " can not lend");
                return;
            }
            sleep(5000);
            LibraryMain.library.returnBook(title);
        }catch(InterruptedException error){
            System.out.println(error);
        }
    }
}

public class LibraryMain {
    public static Library library = new Library();

    public static void main(String[] args) {
        Student std1 = new Student("std1 ");
        Student std2 = new Student("std2 ");
        Student std3 = new Student("std3 ");
        Student std4 = new Student("std4 ");
        Student std5 = new Student("std5 ");
        std1.start();
        std2.start();
        std3.start();
        std4.start();
        std5.start();
    }
}
