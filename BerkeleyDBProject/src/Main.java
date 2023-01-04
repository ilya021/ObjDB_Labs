import com.sleepycat.persist.EntityCursor;
import config.Database;
import entities.Inspection;
import entities.Patient;
import DAClasses.InspectionDA;
import DAClasses.PatientDA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    public static void Lab3(){
        System.out.println("Lab 3 Starting");
        Database.setup();
        InspectionDA inspectionDA = new InspectionDA(Database.getStore());
        PatientDA patientDA = new PatientDA(Database.getStore());

        Patient patient = new Patient();
        patient.setId(0);

        patientDA.save(patient);

        Inspection one = new Inspection(
                0,
                patient.getId(),
                "01.01.2022",
                "hospital",
                "sore throat",
                "cold",
                "home mode"
        );

        Inspection two = new Inspection(
                1,
                patient.getId(),
                "11.11.2022",
                "hospital",
                "sore throat",
                "cold",
                "home mode"
        );

        Inspection three = new Inspection(
                2,
                patient.getId(),
                "12.12.2022",
                "hospital",
                "sore throat",
                "cold",
                "home mode"
        );

        inspectionDA.save(one);
        inspectionDA.save(two);
        inspectionDA.save(three);

        List<Inspection> inspections = inspectionDA.get();
        System.out.println("Inspection: ");
        System.out.println(inspections);

        System.out.println("Inspection with id = 2: ");
        System.out.println(inspectionDA.get(2));


        System.out.println("Inspection for team with id = 1: ");
        System.out.println(inspectionDA.getByPatientID(1));

        System.out.println(inspectionDA.delete(2));
        System.out.println(inspectionDA.update(one));

        System.out.println("Inspection after deleting and updating: ");
        System.out.println(inspectionDA.get());
    }

    public static void Lab4() {

        Database.setup();
        InspectionDA inspectionDA = new InspectionDA(Database.getStore());
        PatientDA patientDA = new PatientDA(Database.getStore());

        Patient patient = new Patient();
        patientDA.save(patient);
        patient = new Patient();
        patientDA.save(patient);

        System.out.println("Patients: ");
        System.out.println(patientDA.get());

        for (int i = 0; i < 4; i++){
            Inspection inspection = new Inspection(
                    0,
                    1,
                    "01.01.2022",
                    "hospital",
                    "sore throat",
                    "cold",
                    "home mode"
            );
            inspectionDA.save(inspection);
        }

        int target = 5;

        try (EntityCursor<Inspection> entityCursor = inspectionDA.cursor()) {
            for (Inspection inspection: entityCursor){
                if (inspection.getId() == target)
                {
                    System.out.println("Found inspection with target id: ");
                    System.out.println(inspection);
                }
            }
        }

        target = 2;

        System.out.println("Inspections before updating: ");
        System.out.println(inspectionDA.get(target));

        try (EntityCursor<Inspection> entityCursor = inspectionDA.cursor()) {
            for (Inspection inspection: entityCursor){
                if (inspection.getId() == 2)
                {
                    entityCursor.update(inspection);
                }
            }
        }

        System.out.println("Inspections after updating: ");
        System.out.println(inspectionDA.get(target));
    }

    public static void main(String[] args) {
        Lab3();
        Lab4();
    }
}