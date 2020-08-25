package be.realdolmen.zoo;

import be.realdolmen.zoo.command_pattern.commands.CommandosMJ;
import be.realdolmen.zoo.command_pattern.commands.ZooWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ZooApplication {
    private static Logger logger = LoggerFactory.getLogger(ZooApplication.class.getName());
    private Scanner scanner = new Scanner(System.in);
    private ZooWorker zooWorker = new ZooWorker();
    private boolean running = true;


    public static void main(String[] args) {
        logger.info("Opening Zoo...");
        new ZooApplication().start();
    }

    private void start() {
        while (running) {
            try {
                CommandosMJ command = chooseCommand();
                executeCommand(command);
            } catch (Exception e) {
                logger.error("Mayday mayday Error! :", e);
            }
        }
        logger.info("Closing zoo...");

    }

    private void executeCommand(CommandosMJ command) {

        //Example 1: Command pattern with reflection api
//        try {
//            Class c = Class.forName(Command.class.getName()); //Cammand class is refactored to Commander !
//            Method[] m = c.getDeclaredMethods(); //get methods of the Command class
//            Method commandMethod = Arrays.stream(m)
//                    .filter(method -> method.getName().equals(command.getCommandMethod()))
//                    .findFirst()
//                    .orElseThrow(() -> new NoSuchMethodError("method doesn't exist"));
//            commandMethod.invoke(new Command()); 
//        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
//            logger.error("Mayday crashing down!!", e);
//        }
        //Example 2: Normal command pattern using ZooWorker = invoker, ShowAnimalCommand and others = command , AnimalService and others = Receiver
        zooWorker.execute(command.getCommand());

    }

    CommandosMJ chooseCommand() throws InterruptedException {
        System.out.println("Available commands:");
        for (CommandosMJ command : CommandosMJ.values()) {
            System.out.printf("\t%d. %s \n", command.ordinal(), command.getCommandDescription()); //instead of using a hard coded index, i'm using ordinal to get the position of the enum.
        }
        System.out.print("Choose a command: ");
        int command = scanner.nextInt();
        Optional<CommandosMJ> commandOptional = Arrays.stream(CommandosMJ.values())
                .filter(command1 -> command1.ordinal() == command).findFirst(); //ordinal is the index of the enum and can be used to fetch the correct command
        if (!commandOptional.isPresent()) {
            logger.warn("Give in a correct number");
            sleep(2000);
            chooseCommand();
        }
        return commandOptional.get();
    }

//    {
//        //we need to create an entityManager
//        //just to let hibernate trigger the generation of the tables and pre fill it, this is not needed for the spring framework
//        Database.getEntityManager();
//    }

}
