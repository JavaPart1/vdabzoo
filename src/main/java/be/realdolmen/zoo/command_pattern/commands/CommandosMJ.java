package be.realdolmen.zoo.command_pattern.commands;

import be.realdolmen.zoo.command_pattern.commands.commands.*;

public enum CommandosMJ {
    SHOW_ANIMAL("Show animals", new ShowAnimalCommand()),
    ADD_ANIMAL("Add new animal", new AddAnimalCommand()),
    REMOVE_ANIMAL("Remove animal", new RemoveAnimalCommand()),
    ADD_TICKET_PRICE("Add ticket price", new AddTicketCommand()),
    FEED_ANIMAL("Feed animals", new FeedAnimalCommand()),
    SHOW_VISITOR("Show visitors", new ShowVisitorsCommand());

    private String commandDescription;
    private Command command;

    CommandosMJ(String commandDescription, Command command) {
        this.commandDescription = commandDescription;
        this.command = command;

    }
    public String getCommandDescription() {
        return commandDescription;
    }

    public Command getCommand() {
        return command;
    }
}
