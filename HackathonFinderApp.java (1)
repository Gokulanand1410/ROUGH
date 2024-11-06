import javax.swing.*;
import java.awt.*;

public class HackathonFinderApp {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Database database;

    public HackathonFinderApp() {
        database = new Database(); // Ensure you have this Database class implemented
        frame = new JFrame("Hackathon Finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400); // Increased window size for better UI

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add panels
        mainPanel.add(new SplashScreen(this), "Splash"); // Updated to use SplashScreen
        mainPanel.add(new LoginPanel(this, database), "Login");
        mainPanel.add(new LocationPanel(this, database), "Location");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public JFrame getFrame() {
        return frame; // Added to retrieve the frame for showing dialogs
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HackathonFinderApp::new);
    }
}
