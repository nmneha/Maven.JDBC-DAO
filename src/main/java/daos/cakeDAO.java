package daos;

import models.Cake;

import java.sql.SQLException;
import java.util.List;

//facilitate the handshake b/w the database and the java object

public interface cakeDAO {
    public Cake findCakeById(int id) throws SQLException;
    public List findAll();
    public Cake update(cakeDTO dto);
    public Cake create(cakeDTO dto);
    public void delete(int id);



}
