package be.realdolmen.zoo.repository.jdbc;


import be.realdolmen.zoo.util.Database;
import be.realdolmen.zoo.domain.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TicketRepository {

    private Logger logger = LoggerFactory.getLogger(TicketRepository.class.getName());

    public void save(Ticket ticket) { // CREATE
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement(("insert into Ticket(id,originalPrice,reductionPrice) values ((SELECT LAST_INSERT_ID()),?,?)"))) {
            preparedStatement.setDouble(1, ticket.getOriginalPrice());
            preparedStatement.setDouble(2, ticket.getReductionPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("can't add ticketprice", e);
        }
    }

    public Ticket findById(int id) {
        try (PreparedStatement preparedStatement = new Database().createConnection().prepareStatement("select * from Ticket where id = ? ")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return new Ticket(resultSet.getDouble("originalPrice"));
        } catch (SQLException e) {
            logger.error("something went wrong", e);
        }
        return null;
    }
}
