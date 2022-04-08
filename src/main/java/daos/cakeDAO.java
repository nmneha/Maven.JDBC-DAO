package daos;

import models.Cake;

import java.sql.SQLException;
import java.util.List;

//facilitate the handshake b/w the database and the java object

public interface cakeDAO {
    public Cake findCakeById(int id) throws SQLException;
    public List findAll();
    public boolean update(Cake cake);
    public boolean create(Cake cake);
    public boolean delete(int id);



}
