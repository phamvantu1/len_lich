package dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Tour;
import model.User;

/**
 *
 * @QuangTung
 */
public class TourDAO extends DAO {

    public TourDAO() {
        super();
    }

    public int addTour(Tour tour) {
        int id_tour = -1;
        try {

            String sql = "INSERT INTO tbltour (name, departurePlace, destination, description, id_user) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, tour.getName());
            statement.setString(2, tour.getDeparturePlace());
            statement.setString(3, tour.getDestination());
            statement.setString(4, tour.getDescription());
            statement.setInt(5, tour.getCreator().getId());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    id_tour = rs.getInt(1);
                }
                id_tour = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id_tour;
    }

    public List<Tour> searchTour(String key) {
        List<Tour> tours = new ArrayList<>();
        try {

            String sqltour = "SELECT * FROM tbltour WHERE name LIKE ?";
            String sqluser = "SELECT * FROM tbluser WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sqltour);

            statement.setString(1, "%" + key + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setName(resultSet.getString("name"));
                tour.setDeparturePlace(resultSet.getString("departurePlace"));
                tour.setDestination(resultSet.getString("destination"));
                tour.setDescription(resultSet.getString("description"));

                statement = con.prepareStatement(sqluser);
                statement.setInt(1, resultSet.getInt("id_user"));
                ResultSet userInfo = statement.executeQuery();
                if (userInfo.next()) {
                    User creator = new User();
                    creator.setId(userInfo.getInt("id"));
                    creator.setFullname(userInfo.getString("fullname"));
                    tour.setCreator(creator);
                    tours.add(tour);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tours;
    }
}
