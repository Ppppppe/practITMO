package App.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

                                    // https://pokeapi.co/docs/v2#pokemon
public class Pokemon {

    private int id;                 // The identifier for this resource
    private String name;            // The name for this resource
    private int base_experience;    // The base experience gained for defeating this Pokemon
    private int height;             // The height of this Pokemon in decimetres
    private int weight;             // The weight of this Pokemon in hectograms


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
