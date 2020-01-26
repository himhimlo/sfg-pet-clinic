package com.siuhim.sfgpetclinic.bootstrap;

import com.siuhim.sfgpetclinic.model.Owner;
import com.siuhim.sfgpetclinic.model.Pet;
import com.siuhim.sfgpetclinic.model.PetType;
import com.siuhim.sfgpetclinic.model.Vet;
import com.siuhim.sfgpetclinic.services.OwnerService;
import com.siuhim.sfgpetclinic.services.PetTypeService;
import com.siuhim.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType dog = petTypeService.save(petType1);
        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType cat = petTypeService.save(petType2);
        Owner owner1 = new Owner();
        owner1.setFirstName("Mary");
        owner1.setLastName("Chan");
        owner1.setAddress("1 Abc Street");
        owner1.setCity("Hong Kong");
        owner1.setTelephone("123123");
        Pet pet1 = new Pet();
        pet1.setName("Puppy");
        pet1.setBirthDate(LocalDate.now());
        pet1.setPetType(dog);
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Tom");
        owner2.setLastName("Wong");
        owner2.setAddress("2 Abc Street");
        owner2.setTelephone("234234");
        owner1.setCity("Hong Kong");
        Pet pet2 = new Pet();
        pet2.setName("Kitty");
        pet2.setBirthDate(LocalDate.now());
        pet2.setPetType(cat);
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        ownerService.save(owner2);
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Yiu");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Jack");
        vet2.setLastName("Cheung");
        vetService.save(vet2);
    }
}
