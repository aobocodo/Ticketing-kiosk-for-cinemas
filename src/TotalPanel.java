import javax.swing.*;
import java.awt.*;

public class TotalPanel {
	private JFrame frame;

	public TotalPanel() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame = new JFrame("Ticketing-kiosk");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(840, 550);
		frame.setLocationRelativeTo(null);
//		Toolkit kit = Toolkit.getDefaultToolkit();
//		Dimension screenSize = kit.getScreenSize();
//		int screenWidth = screenSize.width;
//		int screenHeight = screenSize.height;
//		frame.setBounds(screenWidth / 2 - 420, screenHeight / 2 - 250, 840, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
