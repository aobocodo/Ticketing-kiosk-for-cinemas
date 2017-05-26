import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * Name TotalPanel
 * Usage produce the total panel
 */
class TotalPanel {

	/**
	 * Constructor
	 */
	TotalPanel() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		int systemHour = c.get(Calendar.HOUR_OF_DAY);
		if (systemHour == 0)
			JOptionPane.showMessageDialog(null, "Email send :-)", "Email", JOptionPane.PLAIN_MESSAGE);
		JFrame frame = new JFrame("Ticketing-kiosk");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(840, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		CardLayout card = new CardLayout(0, 0);
		frame.getContentPane().setLayout(card);
		MenuPanel menu = new MenuPanel(card, frame.getContentPane());
		menu.setLayout(null);
		menu.setBackground(Color.WHITE);
		frame.getContentPane().add(menu, "menu");
		card.show(frame.getContentPane(), "menu");
	}
}
