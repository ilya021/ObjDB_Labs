package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.ArrayList;

@Entity
public class Patient {
    @PrimaryKey(sequence = "patient_pk")
    private int id;
    private String name_patient;
    private String surname_patient;
    private String gender;
    private String date_birth;
    private String address;
    private String phone;

    public Patient() {
    }

    public Patient(int id, String name_patient, String surname_patient,
                String gender, String date_birth, String address, String phone) {
        this.id = id;
        this.name_patient = name_patient;
        this.surname_patient = surname_patient;
        this.gender = gender;
        this.date_birth = date_birth;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_patient() {
        return name_patient;
    }

    public void setName_patient(String name_patient) {
        this.name_patient = name_patient;
    }

    public String getSurname_patient() {
        return surname_patient;
    }

    public void setSurname_patient(String surname_patient) {
        this.surname_patient = surname_patient;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name_patient='" + name_patient + '\'' +
                ", surname_patient='" + surname_patient + '\'' +
                ", gender='" + gender + '\'' +
                ", date_birth='" + date_birth + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}