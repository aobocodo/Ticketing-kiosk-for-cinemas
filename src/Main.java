import javax.swing.*;


/**
 * Name Main
 * usage main function to start the application
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new TotalPanel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
