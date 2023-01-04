package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.ArrayList;

@Entity
public class Inspection {
    @PrimaryKey(sequence = "inspection_pk")
    private int id;
    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Patient.class, name = "patient")
    private int id_patient;
    private String date;
    private String location;
    private String symptoms;
    private String diagnosis;
    private String prescriptions;

    public Inspection() {
    }

    public Inspection(int id, int id_patient, String date, String location,
                      String symptoms, String diagnosis, String prescriptions) {
        this.id = id;
        this.id_patient = id_patient;
        this.date = date;
        this.location = location;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.prescriptions = prescriptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }
    @Override
    public String toString() {
        return "Inspection{" +
                "id=" + id +
                ", id_patient='" + id_patient + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescriptions='" + prescriptions + '\'' +
                '}';
    }

}