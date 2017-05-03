import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class TimetablePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public TimetablePanel(CardLayout card, String title, String photo, Container container) {
		Control control = new Control();
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 13, 482, 489);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		add(panel);

		control.readScreenlocation();
		JPanel[] allScreenpanel = new JPanel[control.getMaxscreen()];
		for (int i = 0; i < control.getMaxscreen(); i++) {
			final int m = i;
			allScreenpanel[i] = new JPanel();
			allScreenpanel[i].setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
			allScreenpanel[i].setBackground(new Color(255, 160, 122));
			allScreenpanel[i].setLayout(new BorderLayout(0, 0));
			panel.add(allScreenpanel[i]);

			JLabel lblNewLabel_1 = new JLabel("Screen" + (i + 1));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
			allScreenpanel[i].add(lblNewLabel_1, BorderLayout.NORTH);

			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			allScreenpanel[i].add(panel_3, BorderLayout.CENTER);
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 45));

			JButton[] btnNewButton = new JButton[control.getHourtime(title, (i + 1)).size()];
			for (int j = 0; j < control.getHourtime(title, (i + 1)).size(); j++) {
				final int n = j;
				btnNewButton[j] = new JButton(control.getHourtime(title, (i + 1)).get(j));
				btnNewButton[j].setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
				btnNewButton[j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						SeatPanel seatlocation = new SeatPanel(card, container, title, (m + 1), control.getHourtime(title, (m + 1)).get(n));
						seatlocation.setLayout(null);
						seatlocation.setBackground(Color.WHITE);
						container.add(seatlocation, "seatlocation");
						card.show(container, "seatlocation");
					}
				});
				panel_3.add(btnNewButton[j]);
			}
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(510, 13, 310, 383);
		panel_1.setLayout(null);
		add(panel_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(photo));
		lblNewLabel.setBounds(0, 0, 310, 383);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(619, 423, 101, 54);
		panel_2.setLayout(new BorderLayout(0, 0));
		add(panel_2);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(getParent(), "menu");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel_2.add(btnNewButton);
	}
}
