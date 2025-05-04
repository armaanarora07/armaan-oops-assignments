package java_exp_8;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class PersonSerializationDemo {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);
        String filename = "person.txt";
        
        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
            System.out.println("Person object serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
        
        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}