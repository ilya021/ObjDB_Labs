package DAClasses;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.*;
import entities.Inspection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class InspectionDA {
    // Index Accessors
    PrimaryIndex<Integer, Inspection> id;
    SecondaryIndex<Integer, Integer, Inspection> id_patient;

    public InspectionDA(EntityStore store) throws DatabaseException {

        // Primary key for Inspection class
        id = store.getPrimaryIndex(Integer.class, Inspection.class);
        id_patient = store.getSecondaryIndex(id, Integer.class, "patient");
    }
    public EntityCursor<Inspection> cursor(){
        return this.id.entities();
    }

    public List<Inspection> get(){
        return this.id.map().values().stream().toList();
    }

    public Inspection get(Integer id){
        return this.id.get(id);
    }

    public List<Inspection> getByPatientID(Integer id_patient){
        EntityJoin<Integer, Inspection> join = new EntityJoin<>(this.id);
        join.addCondition(this.id_patient, id_patient);
        try (ForwardCursor<Inspection> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false).toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public Inspection save(Inspection inspection){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        inspection.setId(id);
        return this.id.put(inspection);
    }


    public Inspection update(Inspection inspection){
        return this.id.put(inspection);
    }

    public boolean delete(Integer id){
        return this.id.delete(id);
    }
}