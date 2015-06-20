package test.junit.features.petstore;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

import org.junit.Test;
import org.junit.runner.RunWith;

import test.junit.steps.PetStoreSteps;
import test.model.Pet;

@WithTags( {
    @WithTag(type="priority",name="medium"),
    @WithTag(type="component",name="Rest API"),
    @WithTag(type="special", name="JUnit")

})
@RunWith(SerenityRunner.class)
public class AddAPetToThePetStoreTest {

    @Steps
    PetStoreSteps petStore;

    @Test
    public void shouldBeAbleToAddPetsToAStore() {

        Pet fido = new Pet("available","fido");

        petStore.when_i_add_the_pet_to_the_store(fido);

        petStore.the_pets_should_be_available();

    }
}
