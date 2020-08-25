package be.realdolmen.zoo.command_pattern.commands;

import be.realdolmen.zoo.command_pattern.commands.commands.Command;

//this is the invoker
public class ZooWorker {
    public ZooWorker() {
    }

    public void execute(Command command) {// we can use the interface Command as a type, that way we don't need to use the concrete classes as type (ex. concrete class = AddAnimalCommand)
        command.execute();
    }
}
