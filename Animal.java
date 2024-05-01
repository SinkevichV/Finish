package animal2;

import java.util.List;

abstract class Animal {
    protected static int counter = 0;

    protected int id;
    protected String name;
    protected String type;
    protected String birthDate;
    protected List<String> commands;

    public Animal(String name, String type, String birthDate, List<String> commands) {
        this.id = ++counter;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public void listCommands() {
        System.out.println("Commands for " + type + " " + name + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }

    public void teachCommand(String command) {
        commands.add(command);
        System.out.println(type + " " + name + " has learned the command: " + command);
    }

    public String toString() {
        return id + "\t" + name + "\t" + type + "\t" + birthDate + "\t" + commands;
    }

    public String getType() {
        return type;
    }
}
