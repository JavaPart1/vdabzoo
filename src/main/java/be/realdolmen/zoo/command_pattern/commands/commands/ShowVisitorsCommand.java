package be.realdolmen.zoo.command_pattern.commands.commands;

import be.realdolmen.zoo.domain.Visitor;
import be.realdolmen.zoo.services.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class ShowVisitorsCommand implements Command {
    private static Logger logger = LoggerFactory.getLogger(ShowVisitorsCommand.class.getName());
    private Scanner scanner = new Scanner(System.in);

    private VisitorService visitorService = new VisitorService();

    @Override
    public void execute() {
        System.out.println("What is the name of the visitor? ");
        String name = scanner.next();
        List<Visitor> visitors = visitorService.findVisitorsByName(name);
        visitors.forEach(visitor -> System.out.printf("name: %s visitorType: %s \n ", visitor.getName(), visitor.getVisitorType()));
    }
}
