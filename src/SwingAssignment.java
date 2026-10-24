import javax.swing.*;
import java.awt.*;

public class SwingAssignment extends JFrame {

    private JPanel panel;
    private JLabel label;
    private JButton actionButton;
    private boolean isStateChanged = false;
    private String initialText = "Welcome to Java Swing First Individual Assignment by Tigidankay Wurie Bah";
    private final Color originalColor = new Color(220, 240, 248);
    private final Color changedColor = new Color(220, 237, 205);

    public SwingAssignment() {
        // Set up the main window (JFrame)
        setTitle("Java Swing Assignment");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Instantiate JPanel with GridBagLayout for neat centering
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(originalColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Instantiate JLabel
        label = new JLabel(initialText);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(new Color(34, 34, 34));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, gbc);

        // Instantiate JButton
        actionButton = new JButton("Toggle Theme & Message");
        actionButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        actionButton.setFocusPainted(false);
        actionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridy = 1;
        panel.add(actionButton, gbc);

        // Add panel to frame
        add(panel);

        // Load and set application icon (ImageIcon requirement)
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/image/logo.jpg"));
            if (icon.getImage() != null) {
                setIconImage(icon.getImage());
            }
        } catch (Exception e) {
            System.out.println("Icon could not be loaded.");
        }

        // Action listener to change text and background color
        actionButton.addActionListener(e -> {
            isStateChanged = !isStateChanged;
            if (isStateChanged) {
                label.setText("Interactive State Activated! PROG209 Event Driven Assignment");
                panel.setBackground(changedColor);
            } else {
                label.setText(initialText);
                panel.setBackground(originalColor);
            }
        });

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SwingAssignment();
        });
    }
}