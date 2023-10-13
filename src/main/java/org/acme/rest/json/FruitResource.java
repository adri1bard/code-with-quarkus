package org.acme.rest.json;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;

@Path("/fruits")
public class FruitResource {
    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));



    public FruitResource() {
        loadFruitsFromJsonFile("C:\\projets\\code-with-quarkus\\src\\main\\java\\org\\acme\\rest\\json\\fruits.json");
    }
    String filePath = "fruits.json";
    private void loadFruitsFromJsonFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File(filePath);
            Fruit[] loadedFruits = objectMapper.readValue(jsonFile, Fruit[].class);
            Collections.addAll(fruits, loadedFruits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    public Set<Fruit> list() {

        return fruits;
    }
    @GET
    @Path("/{name}")
    public Fruit getSingle(@PathParam("name") String name) {
        for (Fruit existingFruit : fruits) {
            if (existingFruit.name.contentEquals(name)){
                return existingFruit;
            }
        }
        return null;
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {

        for (Fruit existingFruit : fruits) {
            if (existingFruit.name.contentEquals(fruit.name) && existingFruit.description.contentEquals(fruit.description)){
                return fruits;
            }
        }
        fruits.add(fruit);
        return fruits;
    }



    @PUT

    public Set<Fruit> update(Fruit fruit) {
        for (Fruit existingFruit : fruits) {
            if (existingFruit.name.contentEquals(fruit.name)){
                existingFruit.description = fruit.description;
                return fruits;
            }
        }
        return fruits;
    }


    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }


}



