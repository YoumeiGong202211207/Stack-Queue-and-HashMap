import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    private ArrayList<String> eventAttendees;
    private final int capacity = 200;
    private HashMap<String, Attendee> seatDetails;

    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
        this.seatDetails = new HashMap<>(capacity, 0.6f);
    }

    public void addAttendee(String attendee, String seatNumber) {
        eventAttendees.add(attendee);
        seatDetails.put(seatNumber, new Attendee(attendee, seatNumber));
    }

    public void removeAttendee(String attendee, String seatNumber) {
        eventAttendees.remove(attendee);
        seatDetails.remove(seatNumber);
    }

    public void updateAttendee(int index, String newName) {
        if (index >= 0 && index < eventAttendees.size()) {
            String attendee = eventAttendees.get(index);
            eventAttendees.set(index, newName);
            Attendee attendeeDetails = seatDetails.get(attendee);
            attendeeDetails.setName(newName);
            seatDetails.remove(attendee);
            seatDetails.put(attendeeDetails.getSeatNo(), attendeeDetails);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public String findAttendee(int index) {
        if (index >= 0 && index < eventAttendees.size()) {
            String attendee = eventAttendees.get(index);
            Attendee attendeeDetails = seatDetails.get(attendee);
            return attendeeDetails.toString();
        } else {
            return "Attendee not found.";
        }
    }

    public int getTotalAttendees() {
        return eventAttendees.size();
    }

    public void setSeatDetails(String seatNumber, Attendee attendee) {
        seatDetails.put(seatNumber, attendee);
    }

    public Attendee getSeatDetails(String seatNumber) {
        return seatDetails.get(seatNumber);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event ID: ").append(eventID).append("\n");
        sb.append("Event Name: ").append(eventName).append("\n");
        sb.append("Event Venue: ").append(eventVenue).append("\n");
        sb.append("Event Date: ").append(eventDate).append("\n");
        sb.append("Attendees:\n");
        for (String attendee : eventAttendees) {
            Attendee attendeeDetails = seatDetails.get(attendee);
            sb.append(attendeeDetails.toString()).append("\n");
        }
        return sb.toString();
    }

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

    public HashMap<String, Attendee> getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(HashMap<String, Attendee> seatDetails) {
        this.seatDetails = seatDetails;
    }
}


