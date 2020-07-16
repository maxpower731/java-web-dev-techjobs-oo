package org.launchcode.techjobs_oo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //  Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    //  Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //  Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        HashMap<String, Object> stringHash = new HashMap<>();
        String dataMessage = "Data not available";
        String finalMessage = "";
        Boolean atLeastOneValuePresent = false;

        stringHash.put("ID: ", id);
        stringHash.put("Name: ", name);
        stringHash.put("Employer: ", employer);
        stringHash.put("Location: ", location);
        stringHash.put("Position Type: ", positionType);
        stringHash.put("Core Competency: ", coreCompetency);

        for (Map.Entry<String, Object> entry : stringHash.entrySet()) {
            finalMessage += "\n" + entry.getKey();
                if (entry.getValue().toString() == "") {
                    finalMessage += dataMessage;
                } else if (entry.getKey() == "ID: ") {
                    finalMessage += entry.getValue();
                } else {
                    finalMessage += entry.getValue();
                    atLeastOneValuePresent = true;
                }
        }

        if (!atLeastOneValuePresent) {
            return "OOPS! This job does not seem to exist.";
        }

        return finalMessage += "\n";

//                "\nID: " +
//                "\nName: " +
//                "\nEmployer: " + employer +
//                "\nLocation: " +
//                "\nPosition Type: " +
//                "\nCore Competency: " +
//                "\n";
    }
}
