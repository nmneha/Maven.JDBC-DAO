import daos.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import static daos.ConnectionFactory.getConnection;


public class App {

    static DAO dao = new DAO();

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.println(dao.findCakeById(1));
        System.out.println(dao.findAll());
    }
}
