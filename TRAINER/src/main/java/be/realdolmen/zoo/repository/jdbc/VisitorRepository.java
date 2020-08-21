package be.realdolmen.zoo.repository.jdbc;


import be.realdolmen.zoo.util.Database;
import be.realdolmen.zoo.domain.Visitor;
import be.realdolmen.zoo.domain.enums.VisitorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitorRepository {
    private Logger logger = LoggerFactory.getLogger(VisitorRepository.class.getName());

    public void save(Visitor visitor) { // CREATE
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement(("insert into Visitor(id,name,visitorType,ticket_fk) values ((SELECT LAST_INSERT_ID()),?,?,?)"))) {
            preparedStatement.setString(1, visitor.getName());
            preparedStatement.setString(2, visitor.getVisitorType().name());
            preparedStatement.setInt(2, visitor.getTicket() != null ? visitor.getTicket().getId() : 0);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("can't add visitor", e);
        }
    }

    public List<Visitor> findByName(String name) { //READ
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement(("select * from Visitor as v where name like ? "))) {
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            List<Visitor> visitors = new ArrayList<Visitor>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Visitor visitor = new Visitor();
                visitor.setName(resultSet.getString("name"));
                visitor.setVisitorType(VisitorType.valueOf(resultSet.getString("visitorType")));
                visitors.add(visitor);
            }
            return visitors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
