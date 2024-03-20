public class Attendee {
    private String name;

    public Attendee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attendee: " + name;
    }
}
