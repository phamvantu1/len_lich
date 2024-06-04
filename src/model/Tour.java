package model;

import java.util.List;

/**
 *
 * @QuangTung
 */

public class Tour {
    private int id;
    private String name;
    private String departurePlace;
    private String destination;
    private String description;
    private User creator;
    private List<Schedule> listSchedule;

    public Tour() {
    }

    public Tour(int id, String name, String departurePlace, String destination, String description, User creator, List<Schedule> listSchedule) {
        this.id = id;
        this.name = name;
        this.departurePlace = departurePlace;
        this.destination = destination;
        this.description = description;
        this.creator = creator;
        this.listSchedule = listSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Schedule> getListSchedule() {
        return listSchedule;
    }

    public void setListSchedule(List<Schedule> listSchedule) {
        this.listSchedule = listSchedule;
    }
    
    
}
