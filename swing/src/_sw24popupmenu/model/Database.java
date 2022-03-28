package _sw24popupmenu.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private ArrayList<Person> people;

    public Database() {
        this.people = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Person[] persons = people.toArray(new Person[people.size()]);

        objectOutputStream.writeObject(persons);

        objectOutputStream.close();
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            Person[] persons = (Person[]) objectInputStream.readObject();
            people.clear();
            people.addAll(Arrays.asList(persons));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        objectInputStream.close();
    }
}
