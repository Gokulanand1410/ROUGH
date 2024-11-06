import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private List<HackathonDetails> hackathons;
    private List<HackathonDetails> sampleHackathons;
    private Map<String, String> users; // To store username and password

    public Database() {
        hackathons = new ArrayList<>();
        hackathons.add(new HackathonDetails("Pec Hackathon", "Location A", 5, 50));
        hackathons.add(new HackathonDetails("CodeSprint", "Location B", 4, 30));
        hackathons.add(new HackathonDetails("DevNation", "Location C", 6, 40));
        hackathons.add(new HackathonDetails("Hack n Chill", "Location D", 3, 25));
        hackathons.add(new HackathonDetails("TechQuest", "Location A", 5, 45));
        hackathons.add(new HackathonDetails("BuildCode", "Location E", 8, 60));
        hackathons.add(new HackathonDetails("CodeFest", "Location B", 6, 35));
        hackathons.add(new HackathonDetails("OpenHack", "Location F", 4, 20));
        hackathons.add(new HackathonDetails("InnoVate", "Location D", 7, 50));
        hackathons.add(new HackathonDetails("FutureHack", "Location G", 5, 55));

        // Sample Hackathons for display at the bottom
        sampleHackathons = new ArrayList<>();
        sampleHackathons.add(new HackathonDetails("Pec Hackathon", "Location A", 5, 50));
        sampleHackathons.add(new HackathonDetails("CodeSprint", "Location B", 4, 30));
        sampleHackathons.add(new HackathonDetails("DevNation", "Location C", 6, 40));
        sampleHackathons.add(new HackathonDetails("Hack n Chill", "Location D", 3, 25));
        sampleHackathons.add(new HackathonDetails("TechQuest", "Location A", 5, 45));

        // Sample users (username:password)
        users = new HashMap<>();
        users.put("a", "1");
        users.put("admin", "adminpass");
    }

    // Method to validate user credentials
    public boolean validateUser(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public List<HackathonDetails> getHackathonsByLocation(String location) {
        List<HackathonDetails> results = new ArrayList<>();
        for (HackathonDetails hackathon : hackathons) {
            if (hackathon.getLocation().equalsIgnoreCase(location)) {
                results.add(hackathon);
            }
        }
        return results;
    }

    public List<HackathonDetails> getSampleHackathons() {
        return sampleHackathons;
    }
}
