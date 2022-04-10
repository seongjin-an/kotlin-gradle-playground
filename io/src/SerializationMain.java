import java.io.*;

class Person2 implements Serializable{
    private String name;
    private String job;
    public Person2(){}
    public Person2(String name, String job){
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person(name=" + name + ", job=" + job + ")";
    }
}

class Person implements Externalizable{
    private String name;
    private String job;
    public Person(){}
    public Person(String name, String job){
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person(name=" + name + ", job=" + job + ")";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(job);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        job = in.readUTF();
    }
}

public class SerializationMain {
    public static void main(String[] args) {
        Person personAnsj = new Person("ansj", "developer");
        Person personAnseongjin = new Person("anseongjin", "developer");

        try(
            FileOutputStream fos = new FileOutputStream("serial.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){
            oos.writeObject(personAnsj);
            oos.writeObject(personAnseongjin);
        }catch(IOException error){
            error.printStackTrace();
        }
        System.out.println("end output stream");

        try(
            FileInputStream fis = new FileInputStream("serial.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)
        ){
            Person ansj = (Person) ois.readObject();
            Person anseongjin = (Person) ois.readObject();
            System.out.println(ansj.toString());
            System.out.println(anseongjin.toString());
        }catch(IOException error){
            error.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("end input stream");
    }
}
