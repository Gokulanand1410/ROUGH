import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LocationPanel extends JPanel {
    private JTextField locationField;
    private JPanel resultsPanel;
    private JPanel samplePanel; // Panel for sample hackathons
    private Database database;

    public LocationPanel(HackathonFinderApp app, Database database) {
        this.database = database;

        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 40));

        // Input panel for location
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(30, 30, 40));
        inputPanel.add(new JLabel("Enter Location:"));

        locationField = new JTextField(20);
        inputPanel.add(locationField);

        JButton searchButton = new JButton("Search");
        inputPanel.add(searchButton);

        add(inputPanel, BorderLayout.NORTH);

        // Results panel to display search results
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(new Color(30, 30, 40));

        // Scroll pane for results panel
        JScrollPane scrollPane = new JScrollPane(resultsPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Sample hackathon panel (displayed at the bottom)
        samplePanel = new JPanel();
        samplePanel.setLayout(new BoxLayout(samplePanel, BoxLayout.Y_AXIS));
        samplePanel.setBackground(new Color(30, 30, 40));

        // Add sample hackathons
        addSampleHackathons();

        add(samplePanel, BorderLayout.SOUTH);

        // Action listener for search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText().trim();
                resultsPanel.removeAll(); // Clear previous results

                if (!location.isEmpty()) {
                    // Fetch hackathons based on location
                    List<HackathonDetails> hackathons = database.getHackathonsByLocation(location);

                    if (hackathons.isEmpty()) {
                        resultsPanel.add(new JLabel("No hackathons found for this location."));
                    } else {
                        // Display hackathons found for this location
                        for (HackathonDetails hackathon : hackathons) {
                            JPanel hackathonPanel = new JPanel();
                            hackathonPanel.setBorder(BorderFactory.createTitledBorder(
                                BorderFactory.createLineBorder(Color.WHITE, 2),
                                hackathon.getName(),
                                TitledBorder.CENTER,
                                TitledBorder.TOP,
                                new Font("Arial", Font.BOLD, 14),
                                Color.WHITE
                            ));
                            hackathonPanel.setBackground(new Color(50, 50, 60));

                            JLabel locationLabel = new JLabel("Location: " + hackathon.getLocation());
                            JLabel maxMembersLabel = new JLabel("Max Members: " + hackathon.getMaxMembers());
                            JLabel feeLabel = new JLabel("Registration Fee: " + hackathon.getFees());

                            // Add click listener to the hackathon name label
                            JButton registerButton = new JButton("Register");
                            registerButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Open the registration form for this hackathon
                                    openRegistrationForm(hackathon);
                                }
                            });

                            hackathonPanel.add(locationLabel);
                            hackathonPanel.add(maxMembersLabel);
                            hackathonPanel.add(feeLabel);
                            hackathonPanel.add(registerButton);

                            resultsPanel.add(hackathonPanel);
                        }
                    }
                } else {
                    // Show an error message if no location is entered
                    JOptionPane.showMessageDialog(app.getFrame(), "Please enter a location!", "Input Error", JOptionPane.ERROR_MESSAGE);
                }

                // Revalidate and repaint the results panel to show updated content
                resultsPanel.revalidate();
                resultsPanel.repaint();
            }
        });
    }

    // Method to add sample hackathons to the sample panel
    private void addSampleHackathons() {
        List<HackathonDetails> sampleHackathons = database.getSampleHackathons();

        for (HackathonDetails hackathon : sampleHackathons) {
            JPanel hackathonPanel = new JPanel();
            hackathonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2),
                hackathon.getName(),
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                Color.WHITE
            ));
            hackathonPanel.setBackground(new Color(50, 50, 60));

            JLabel locationLabel = new JLabel("Location: " + hackathon.getLocation());
            JLabel maxMembersLabel = new JLabel("Max Members: " + hackathon.getMaxMembers());
            JLabel feeLabel = new JLabel("Registration Fee: " + hackathon.getFees());

            // Add a Register button with an action listener to open the registration form
            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Open the registration form for this hackathon
                    openRegistrationForm(hackathon);
                }
            });

            hackathonPanel.add(locationLabel);
            hackathonPanel.add(maxMembersLabel);
            hackathonPanel.add(feeLabel);
            hackathonPanel.add(registerButton);

            samplePanel.add(hackathonPanel);
        }
    }

    // Method to open the registration form for the selected hackathon
    private void openRegistrationForm(HackathonDetails hackathon) {
        JFrame registrationFrame = new JFrame("Register for " + hackathon.getName());
        registrationFrame.setSize(400, 500);  // Increase the size to accommodate more fields
        registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Use GridLayout for better control over field placement
        JPanel formPanel = new JPanel(new GridLayout(11, 2, 10, 10)); // 11 rows: 1 for the label + 1 for the field (10 personal details)

        // Adding each personal detail field and its label in a row
        formPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        JTextField phoneField = new JTextField();
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Team Name:"));
        JTextField teamField = new JTextField();
        formPanel.add(teamField);

        formPanel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        formPanel.add(addressField);

        formPanel.add(new JLabel("City:"));
        JTextField cityField = new JTextField();
        formPanel.add(cityField);

        formPanel.add(new JLabel("State:"));
        JTextField stateField = new JTextField();
        formPanel.add(stateField);

        formPanel.add(new JLabel("Country:"));
        JTextField countryField = new JTextField();
        formPanel.add(countryField);

        formPanel.add(new JLabel("Zip Code:"));
        JTextField zipField = new JTextField();
        formPanel.add(zipField);

        formPanel.add(new JLabel("Gender:"));
        JTextField genderField = new JTextField();
        formPanel.add(genderField);

        // Add submit button at the end
        JButton submitButton = new JButton("Submit");
        formPanel.add(submitButton);

        registrationFrame.add(formPanel);
        registrationFrame.setVisible(true);

        // Handle form submission
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String team = teamField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String country = countryField.getText();
            String zip = zipField.getText();
            String gender = genderField.getText();

            // Show a success message
            JOptionPane.showMessageDialog(registrationFrame, "Registered successfully for " + hackathon.getName());
            registrationFrame.dispose();
        });
    }
}
