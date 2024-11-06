import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Database database;

    public LoginPanel(HackathonFinderApp app, Database database) {
        this.database = database;

        setLayout(new GridBagLayout());
        setBackground(new Color(30, 30, 40)); // Dark background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding

        
        gbc.gridx = 0; // Column
        gbc.gridy = 0; // Row
        gbc.anchor = GridBagConstraints.WEST; // Align left
        add(new JLabel("Username:"), gbc);

        gbc.gridx = 1; // Move to next column
        usernameField = new JTextField(20); // Increased width
        add(usernameField, gbc);

        // Password label and field
        gbc.gridx = 0; // Reset to first column
        gbc.gridy = 1; // Move to next row
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1; // Move to next column
        passwordField = new JPasswordField(20); // Increased width
        add(passwordField, gbc);

        // Login button
        gbc.gridx = 0; // Reset to first column
        gbc.gridy = 2; // Move to next row
        gbc.gridwidth = 2; // Span across both columns
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (database.validateUser(username, password)) {
                    app.showPanel("Location");
                } else {
                    JOptionPane.showMessageDialog(app.getFrame(), "Incorrect username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(loginButton, gbc);
    }
}
