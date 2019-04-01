package serializableStudy.mainTest;

import serializableStudy.model.Man;
import serializableStudy.model.Person;

import java.io.*;

public class SerializableMainTest {

    //序列化对象
    public static void writeSerializableObject() {
        try {
            Man man = new Man("zhouhang","zhouhang");
            Person person = new Person(man,"zhouhang",22);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("zhouhang.txt"));
            objectOutputStream.writeObject("string");
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //反序列化对象
    public static void readSerializableObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("zhouhang.txt"));
            String string = (String) objectInputStream.readObject();
            Person person = (Person) objectInputStream.readObject();
            System.out.println(string + ", age =" + person.getAge() + ", name =" + person.getMan().getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        writeSerializableObject();

        readSerializableObject();
    }

}
