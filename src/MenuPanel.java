import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Name MenuPanel
 * Usage produce the menu panel
 */
class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param card card layout
	 * @param container frame.getContentPane()
	 */
	MenuPanel(CardLayout card, Container container) {
		Control controlelement = new Control();

		JPanel panel = new JPanel();
		panel.setBounds(14, 13, 310, 383);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 310, 383);
		lblNewLabel.setIcon(new ImageIcon(controlelement.getElement("photo", 0)));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(340, 13, 480, 480);
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 10));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(14, 404, 310, 86);
		add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel Label = new JLabel(controlelement.getElement("title", 0));
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		Label.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_2.add(Label);


		JLabel lblMin = new JLabel(controlelement.getElement("timelength", 0));
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_2.add(lblMin);


		JButton[] btnNewButton = new JButton[controlelement.getNumber()];

		for (int i = 0; i < controlelement.getNumber(); i++) {

			final int j = i;
			btnNewButton[i] = new JButton(controlelement.getElement("title", i));
			btnNewButton[i].setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
			btnNewButton[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					Label.setText(controlelement.getElement("title", j));
					lblMin.setText(controlelement.getElement("timelength", j));
					lblNewLabel.setIcon(new ImageIcon(controlelement.getElement("photo", j)));
				}

				@Override
				public void mouseClicked(MouseEvent arg0) {
					TimetablePanel timetable = new TimetablePanel(card, controlelement.getElement("title", j), controlelement.getElement("photo", j), container);
					timetable.setLayout(null);
					timetable.setBackground(Color.WHITE);
					container.add(timetable, "timetable");
					card.show(container, "timetable");
				}
			});
			panel_1.add(btnNewButton[i]);
		}
	}

}
