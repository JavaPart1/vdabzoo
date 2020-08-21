package be.realdolmen.zoo.services;

import be.realdolmen.zoo.domain.Visitor;
import be.realdolmen.zoo.repository.jdbc.VisitorRepository;

import java.util.List;

public class VisitorService {
    private VisitorRepository visitorRepository = new VisitorRepository();

    public void saveVisitor(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    public List<Visitor> findVisitorsByName(String name) {
        return visitorRepository.findByName(name);
    }
}
