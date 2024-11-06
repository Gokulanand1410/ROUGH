public class Hackathon {
    private String name;
    private String location;
    private String date;

    public Hackathon(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public String getDetails() {
        return name + ": " + location + ", Date: " + date;
    }
}
