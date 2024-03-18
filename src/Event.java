import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    private ArrayList<String> eventAttendees;
    


    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
    } 

    public void addAttendee(String attendee) {
    
        eventAttendees.add(attendee);
        
    }

    public void removeAttendee(String attendee) {
        eventAttendees.remove(attendee);
    }

    public void updateAttendee(int index, String newName) {
        if (index >= 0 && index < eventAttendees.size()) {
            eventAttendees.set(index, newName);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public String findAttendee(int index) {
        if (index >= 0 && index < eventAttendees.size()) {
            return eventAttendees.get(index);
        } else {
            return "Attendee not found.";
        }
    }

    public int getTotalAttendees() {
        return eventAttendees.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event ID: ").append(eventID).append("\n");
        sb.append("Event Name: ").append(eventName).append("\n");
        sb.append("Event Venue: ").append(eventVenue).append("\n");
        sb.append("Event Date: ").append(eventDate).append("\n");
        sb.append("Attendees:\n");
        for (String attendee : eventAttendees) {
            sb.append(attendee).append("\n");
        }
        return sb.toString();
    }

    // Getters and setters
    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<String> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(ArrayList<String> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }
}

