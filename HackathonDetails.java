public class HackathonDetails {
    private String name;
    private String location;
    private int maxMembers;
    private int fees;

    public HackathonDetails(String name, String location, int maxMembers, int fees) {
        this.name = name;
        this.location = location;
        this.maxMembers = maxMembers;
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public int getFees() {
        return fees;
    }
}
