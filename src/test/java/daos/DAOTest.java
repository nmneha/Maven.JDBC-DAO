package daos;

import junit.framework.Assert;
import junit.framework.TestCase;
import models.Cake;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DAOTest extends TestCase {
    DAO dao = new DAO();

    public void testFindCakeById() throws SQLException {
        Cake cake = dao.findCakeById(1);
        int id = cake.getId();
        String sponge = cake.getSponge();
        String filling = cake.getFilling();
        String cream = cake.getCream();
        String shape = "round";
        int tier = 3;
        Assert.assertEquals(1, id);
        Assert.assertEquals("vanilla", sponge);
        Assert.assertEquals("raspberry", filling);
        Assert.assertEquals("vanilla", cream);
        Assert.assertEquals("round", shape);
        Assert.assertEquals(3, tier);
    }

    public void testFindAll() {
        int size = dao.findAll().size();
        Assert.assertEquals(5, size);
    }

    public void testUpdate() {
        Cake cake = new Cake(2, "chocolate", "chocolate mousse", "chocolate ganache", "round", 3);
        dao.update(cake);
        int id = cake.getId();
        String sponge = cake.getSponge();
        String filling = cake.getFilling();
        String cream = cake.getCream();
        String shape = "round";
        int tier = 3;
        Assert.assertEquals(2, id);
        Assert.assertEquals("chocolate", sponge);
        Assert.assertEquals("chocolate ganache", filling);
        Assert.assertEquals("chocolate mousse", cream);
        Assert.assertEquals("round", shape);
        Assert.assertEquals(3, tier);

        Cake cake2 = new Cake(2, "chocolate", "chocolate", "coffee", "round", 3);
        dao.update(cake2);
    }

    public void testCreateDelete() {
        Cake cake = new Cake("funfetti", "bubblegum", "m&ms", "round", 3);
        dao.create(cake);
        List<Cake> cakery = dao.findAll();
        int id = cakery.get(cakery.size()-1).getId();
        int sizeBefore = cakery.size();
        Assert.assertEquals(6, sizeBefore);
        String sponge = cake.getSponge();
        String filling = cake.getFilling();
        String cream = cake.getCream();
        String shape = "round";
        int tier = 3;
        Assert.assertEquals("funfetti", sponge);
        Assert.assertEquals("m&ms", filling);
        Assert.assertEquals("bubblegum", cream);
        Assert.assertEquals("round", shape);
        Assert.assertEquals(3, tier);
        dao.delete(id);
        int sizeAfter = dao.findAll().size();
        Assert.assertEquals(5, sizeAfter);

    }
}