package _sw29preferences.model;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Person> people;

    public Database() {
        this.people = new LinkedList<Person>();// Ekleme silme işlemlerinde daha effektif
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
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

    public void removePerson(int index) {
        people.remove(index);
    }
}
