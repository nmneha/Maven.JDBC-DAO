import daos.DAO;
import daos.DTO;
import models.Cake;

import java.sql.Connection;
import java.sql.SQLException;

import static daos.ConnectionFactory.getConnection;


public class App {

    static DAO dao = new DAO();
    static DTO dto = new DTO();

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        dao.findCakeById(1);
        System.out.println(dao.findAll());
        Cake cake = new Cake(1, "vanilla", "vanilla", "raspberry", "round", 3 );
        dao.update(cake);
        Cake cake2 = dao.findCakeById(1);
        dao.printCake(cake2);
        Cake cake3 = new Cake("funfetti", "bubblegum", "m&ms", "round", 3);
        dao.delete(7);
    }
}
