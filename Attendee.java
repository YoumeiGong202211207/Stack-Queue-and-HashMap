public class Attendee {
    private String name;
    private String seatNo;

    public Attendee(String name, String seatNo) {
        this.name = name;
        this.seatNo = seatNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Attendee: " + name + ", Seat No: " + seatNo;
    }
}
