package test.junit.steps;

import net.thucydides.core.annotations.Step;

import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.model.Pet;
import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;


public class PetStoreSteps {

    Pet pet;

    @Step
    public void when_i_add_the_pet_to_the_store(Pet pet) {
        this.pet = pet;
        int id = Math.abs(new Random().nextInt());

//        pet.setId(id);
//        ObjectMapper mapper = new ObjectMapper();
//        String body = "";
//        try
//        {
//            body = mapper.writeValueAsString(pet);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        String jsonPet = "{\"id\": " + id + " , \"name\": \""
                + pet.getName() + "\", \"photoUrls\": [], \"status\": \""
                + pet.getStatus() + "\"}";

        rest().given().contentType("application/json")
                .content(jsonPet).post("http://petstore.swagger.io/v2/pet");

        this.pet.setId(id);
    }

    @Step
    public void the_pets_should_be_available() {
        rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
                    .then().statusCode(200)
                    .and().body("name", equalTo(pet.getName()));
    }
}
