package dao;


import model.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO extends DAO{

    public ServiceDAO() {
        super();
    }

    public List<Service> searchService(String key) {
        List<Service> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblservice WHERE name LIKE ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + key + "%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {

                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setDescription(rs.getString("description"));
                result.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
