package animal2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PetRegistry registry = new PetRegistry();

            boolean exit = false;
            while (!exit) {
                System.out.println("\nPet Registry Menu:");
                System.out.println("1. Add a new pet");
                System.out.println("2. List commands for a pet");
                System.out.println("3. Teach a new command to a pet");
                System.out.println("4. List animals by date of birth");
                System.out.println("5. Show total number of animals");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addNewPet(scanner, registry);
                        break;
                    case 2:
                        listCommandsForPet(scanner, registry);
                        break;
                    case 3:
                        teachNewCommand(scanner, registry);
                        break;
                    case 4:
                        registry.listAnimalsByDateOfBirth();
                        break;
                    case 5:
                        System.out.println("Total number of animals: " + registry.getTotalAnimalsCount());
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addNewPet(Scanner scanner, PetRegistry registry) {
        System.out.print("Enter pet type (Dog/Cat/Hamster/Horse/Camel/Donkey): ");
        String type = scanner.nextLine();
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet birth date (yyyy-MM-dd): ");
        String birthDate = scanner.nextLine();

        List<String> commands = new ArrayList<>();
        System.out.print("Enter pet commands separated by commands: ");
        String[] commandArray = scanner.nextLine().split(", ");
        commands.addAll(Arrays.asList(commandArray));

        switch (type.toLowerCase()) {
            case "dog":
                registry.addAnimal(new Dog(name, birthDate, commands));
                break;
            case "cat":
                registry.addAnimal(new Cat(name, birthDate, commands));
                break;
            case "hamster":
                registry.addAnimal(new Hamster(name, birthDate, commands));
                break;
            case "horse":
                registry.addAnimal(new Horse(name, birthDate, commands));
                break;
            case "camel":
                registry.addAnimal(new Camel(name, birthDate, commands));
                break;
            case "donkey":
                registry.addAnimal(new Donkey(name, birthDate, commands));
                break;
            default:
                System.out.println("Invalid pet type.");
        }
    }

    private static void listCommandsForPet(Scanner scanner, PetRegistry registry) {
        System.out.print("Enter pet ID: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        registry.listCommands(petId);
    }

    private static void teachNewCommand(Scanner scanner, PetRegistry registry) {
        System.out.print("Enter pet ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter command to teach: ");
        String command = scanner.nextLine();
        registry.teachCommand(id, command);
    }
}