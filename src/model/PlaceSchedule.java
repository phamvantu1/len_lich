package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @QuangTung
 */

public class PlaceSchedule {
    private int id;
    private float hourVisit;
    private Place place;
    private List<ServiceSchedule> listServiceSchedule;

    public PlaceSchedule() {
        listServiceSchedule = new ArrayList<>();
    }

    public PlaceSchedule(int id, float hourVisit, Place place, List<ServiceSchedule> listServiceSchedule) {
        this.id = id;
        this.hourVisit = hourVisit;
        this.place = place;
        this.listServiceSchedule = listServiceSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHourVisit() {
        return hourVisit;
    }

    public void setHourVisit(float hourVisit) {
        this.hourVisit = hourVisit;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<ServiceSchedule> getListServiceSchedule() {
        return listServiceSchedule;
    }

    public void setListServiceSchedule(List<ServiceSchedule> listServiceSchedule) {
        this.listServiceSchedule = listServiceSchedule;
    }

    @Override
    public String toString() {
        return place.getName();
    }
}
