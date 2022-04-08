package daos;

import models.Cake;

import java.sql.*;
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
        Cake cake = new Cake();
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cake");

            List<Cake> cakery = new ArrayList<>();
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

    public boolean update(Cake cake) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cake SET sponge=?, cream=?, filling=?, shape=?, tier=? WHERE id=?");
            ps.setString(1, cake.getSponge());
            ps.setString(2, cake.getCream());
            ps.setString(3, cake.getFilling());
            ps.setString(4, cake.getShape());
            ps.setInt(5, cake.getTier());
            ps.setInt(6, cake.getId());

            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean create(Cake cake) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cake VALUES (NULL, ?, ?, ?, ?, ?)");
            ps.setString(1, cake.getSponge());
            ps.setString(2, cake.getCream());
            ps.setString(3, cake.getShape());
            ps.setInt(4, cake.getTier());
            ps.setString(5, cake.getFilling());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM cake WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }


    //represents the translation of what it becomes
}
