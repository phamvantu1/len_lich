package dao;

import model.PlaceSchedule;
import model.Schedule;
import model.ServiceSchedule;
import model.Tour;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScheduleDAO extends DAO{
    public ScheduleDAO() {
        super();
    }
    public boolean addSchedule(Tour tour, Schedule schedule){
        boolean isSuccess = false;
        try {
            String sqlScheduleInfo = "INSERT INTO tblschedule (ticketprice, departureday, id_tour)" + "VALUES (?, ?, ?)";
            String sqlPlaceSchedule = "INSERT INTO tblplaceschedule (hourvisit, id_place, id_schedule)" + "VALUES (?, ?, ?)";
            String sqlServiceSchedule = "INSERT INTO tblserviceschedule (price, quantity, id_placeschedule, id_servicesupplier)" + "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sqlScheduleInfo, Statement.RETURN_GENERATED_KEYS);
            statement.setFloat(1, schedule.getTicketPrice());
            java.util.Date departureDay = schedule.getDepartureDay();
            java.sql.Date sqlDepartureDay = new java.sql.Date(departureDay.getTime());
            statement.setDate(2, sqlDepartureDay);
            statement.setInt(3, tour.getId());

            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0) {
                ResultSet rsSchedule = statement.getGeneratedKeys();
                if(rsSchedule.next()) {
                    int id_schedule = rsSchedule.getInt(1);
                    statement = con.prepareStatement(sqlPlaceSchedule, Statement.RETURN_GENERATED_KEYS);
                    if(schedule.getListPlaceSchedule() != null) {
                        for(PlaceSchedule placeSchedule: schedule.getListPlaceSchedule()) {
                            statement.setFloat(1, placeSchedule.getHourVisit());
                            statement.setInt(2, placeSchedule.getPlace().getId());
                            statement.setInt(3, id_schedule);
                            rowsInserted = statement.executeUpdate();
                            if(rowsInserted > 0) {
                                ResultSet rsPlaceSchedule = statement.getGeneratedKeys();
                                if(rsPlaceSchedule.next()) {
                                    int id_placeSchedule = rsPlaceSchedule.getInt(1);
                                    statement = con.prepareStatement(sqlServiceSchedule);
                                    if(placeSchedule.getListServiceSchedule() != null) {
                                        for(ServiceSchedule serviceSchedule: placeSchedule.getListServiceSchedule()) {
                                            statement.setInt(1, serviceSchedule.getPrice());
                                            statement.setInt(2, serviceSchedule.getQuantity());
                                            statement.setInt(3, id_placeSchedule);
                                            statement.setInt(4, serviceSchedule.getServiceSupplier().getId());
                                            rowsInserted = statement.executeUpdate();
                                            if(rowsInserted > 0) {
                                                isSuccess = true;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
}
