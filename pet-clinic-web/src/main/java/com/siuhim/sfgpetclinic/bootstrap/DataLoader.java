package com.siuhim.sfgpetclinic.bootstrap;

import com.siuhim.sfgpetclinic.model.Owner;
import com.siuhim.sfgpetclinic.model.PetType;
import com.siuhim.sfgpetclinic.model.Vet;
import com.siuhim.sfgpetclinic.services.OwnerService;
import com.siuhim.sfgpetclinic.services.PetTypeService;
import com.siuhim.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);
        Owner owner1 = new Owner();
        owner1.setFirstName("Mary");
        owner1.setLastName("Chan");
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Tom");
        owner2.setLastName("Wong");
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
