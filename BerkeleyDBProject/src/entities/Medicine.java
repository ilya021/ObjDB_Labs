package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.ArrayList;

@Entity
public class Medicine {
    @PrimaryKey(sequence = "medicine_pk")
    private int id;
    private String name;
    private String recipe;
    private String description;
    private String side_effect;

    public Medicine() {
    }

    public Medicine(int id, String name, String recipe,
                      String description, String side_effect) {
        this.id = id;
        this.name = name;
        this.recipe = recipe;
        this.description = description;
        this.side_effect = side_effect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSide_effect() {
        return side_effect;
    }

    public void setSide_effect(String side_effect) {
        this.side_effect = side_effect;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipe='" + recipe + '\'' +
                ", description='" + description + '\'' +
                ", side_effect='" + side_effect + '\'' +
                '}';
    }

}