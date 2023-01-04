package DAClasses;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import entities.Patient;

import java.util.List;
import java.util.Map;

public class PatientDA {
    // Index Accessors
    PrimaryIndex<Integer, Patient> id;

    public PatientDA(EntityStore store) throws DatabaseException {

        // Primary key for Patient class
        id = store.getPrimaryIndex(Integer.class, Patient.class);
    }

    public List<Patient> get(){
        return this.id.map().values().stream().toList();
    }

    public Patient save(Patient patient){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        patient.setId(id);
        return this.id.put(patient);
    }

}