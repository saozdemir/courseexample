package _sw23serialization.controller;

import _sw23serialization.gui.FormEvent;
import _sw23serialization.model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public void addPerson(FormEvent ev) { //View ile Modeli yalıtma işlemi burada yapılıyor.
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmpCategory();
        String taxId = ev.getTaxId();
        boolean isCitizen = ev.isCitizen();
        String gender = ev.getGender();

        AgeCategory ageCategory = null;
        switch (ageCatId) {
            case 0:
                ageCategory = AgeCategory.CHILD;
                break;
            case 1:
                ageCategory = AgeCategory.ADULT;
                break;
            case 2:
                ageCategory = AgeCategory.SENIOR;
                break;
            default:
                break;
        }

        EmploymentCategory employmentCategory;
        if (empCat.equals("Employed")) {
            employmentCategory = EmploymentCategory.EMPLOYED;
        } else if (empCat.equals("Self-Employed")) {
            employmentCategory = EmploymentCategory.SELF_EMPLOYED;
        } else if (empCat.equals("Unemployed")) {
            employmentCategory = EmploymentCategory.UNEMPLOYED;
        } else {
            employmentCategory = EmploymentCategory.OTHER;
        }

        Gender genderCat;
        if (gender.equals("Male")) {
            genderCat = Gender.MALE;
        } else {
            genderCat = Gender.FEMALE;
        }

        Person person = new Person(name, occupation, ageCategory, employmentCategory, taxId, isCitizen, genderCat);
        db.addPerson(person);

    }

    public List<Person> getPeople() { //View ve Modeli burada bu şelilde yalıtmış olduk (Encapsulation)
        return db.getPeople();
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
