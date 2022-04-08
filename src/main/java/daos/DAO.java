package daos;

import models.Cake;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static daos.ConnectionFactory.getConnection;

public class DAO implements cakeDAO {

    public Cake findCakeById(int id) throws SQLException {
        Connection connection = getConnection();
        Cake cake = new Cake();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cake WHERE id=" + id);

            if(rs.next())
            {
                cake = extractCakeFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cake;
    }

    private Cake extractCakeFromResultSet(ResultSet rs) throws SQLException {
        Cake cake = new Cake();

        cake.setId( rs.getInt("id") );
        cake.setSponge( rs.getString("sponge") );
        cake.setCream( rs.getString("cream") );
        cake.setFilling( rs.getString("filling") );
        cake.setShape( rs.getString("shape") );
        cake.setTier(rs.getInt("tier") );
        return cake;
    }

    public void printCake(Cake cake) {
        System.out.println("ID: " + cake.getId() +
                "\nSponge: " + cake.getSponge() +
                "\nCream: " + cake.getCream() +
                "\nFilling: " + cake.getFilling() +
                "\nShape " + cake.getShape() +
                "\nTier: " + cake.getTier());
        System.out.println("\n--------------------------");
    }

    public List<Cake> findAll() {
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cake");

            List<Cake> cakery = new ArrayList<>();

            Cake cake = null;
            while (rs.next()) {
                cake = extractCakeFromResultSet(rs);
                cakery.add(cake);
            }
            for (Cake c: cakery) {
                printCake(c);
            }

            return cakery;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Cake update(cakeDTO dto) {
        return null;
    }

    public Cake create(cakeDTO dto) {
        return null;
    }

    public void delete(int id) {

    }


    //represents the translation of what it becomes
}
