package be.realdolmen.zoo;

import be.realdolmen.zoo.command_pattern.commands.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Commander {
    private static Logger logger = LoggerFactory.getLogger(be.realdolmen.zoo.ZooApplication.class.getName());

    public enum Commands {
        SHOW_ANIMAL("Show animals", new ShowAnimalCommand()),
        ADD_ANIMAL("Add new animal", new AddAnimalCommand()),
        REMOVE_ANIMAL("Remove animal", new RemoveAnimalCommand()),
        ADD_TICKET_PRICE("Add ticket price", new AddTicketCommand()),
        FEED_ANIMAL("Feed animals", new FeedAnimalCommand()),
        SHOW_VISITOR("Show visitors", new ShowVisitorsCommand());

        private String commandDescription;
        private Command command;

        Commands(String commandDescription, Command command) {
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
}
