package animal2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class PetRegistry {
    private List<Animal> animals;

    public PetRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("New " + animal.getType() + " added to the registry.");
    }

    public void listCommands(int animalId) {
        for (Animal animal : animals) {
            if (animal.id == animalId) {
                animal.listCommands();
                return;
            }
        }
        System.out.println("Animal with ID " + animalId + " not found.");
    }

    public void teachCommand(int animalId, String command) {
        for (Animal animal : animals) {
            if (animal.id == animalId) {
                animal.teachCommand(command);
                return;
            }
        }
        System.out.println("Animal with ID " + animalId + " not found.");
    }

    public void listAnimalsByDateOfBirth() {
        animals.sort(Comparator.comparing(animal -> animal.birthDate));
        System.out.println("List of animals sorted by date of birth:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public int getTotalAnimalsCount() {
        return animals.size();
    }
}