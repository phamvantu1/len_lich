package dao;

import model.Place;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAO extends DAO{
    public PlaceDAO() {
        super();
    }
    public List<Place> searchPlace(String key) {
        List<Place> listPlace = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblplace WHERE name LIKE ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + key + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {

                Place place = new Place();
                place.setId(rs.getInt("id"));
                place.setName(rs.getString("name"));
                place.setLocation(rs.getString("location"));
                place.setDescription(rs.getString("description"));
                listPlace.add(place);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listPlace;
    }
}
