package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @QuangTung
 */

public class Schedule {
    private int id;
    private float ticketPrice;
    private Date departureDay;
    private List<PlaceSchedule> listPlaceSchedule;

    public Schedule() {
        listPlaceSchedule = new ArrayList<>();
    }

    public Schedule(int id, float ticketPrice, Date departureDay, List<PlaceSchedule> listPlaceSchedule) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.departureDay = departureDay;
        this.listPlaceSchedule = listPlaceSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Date departureDay) {
        this.departureDay = departureDay;
    }

    public List<PlaceSchedule> getListPlaceSchedule() {
        return listPlaceSchedule;
    }

    public void setListPlaceSchedule(List<PlaceSchedule> listPlaceSchedule) {
        this.listPlaceSchedule = listPlaceSchedule;
    }
    
    
}
