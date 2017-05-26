import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class SeatPanel extends JPanel {
	private int cli = 0;
	private JLabel[][] l1;
	private ArrayList<SaveSeatinfo> seatInformation;

	SeatPanel(CardLayout card, Container container, String title, int mode, String time) {
		Control control = new Control();
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 13, 178, 209);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel("Child(2-17)");
		lblNewLabel.setBounds(10, 5, 95, 24);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_4.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 182, 193));
		panel_5.setBounds(140, 5, 25, 25);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Adult(18-54)");
		lblNewLabel_1.setBounds(10, 5, 200, 24);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_6.add(lblNewLabel_1);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(139, 0, 0));
		panel_7.setBounds(140, 5, 25, 25);
		panel_6.add(panel_7);
		panel_7.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Senior(>=55)");
		lblNewLabel_2.setBounds(10, 5, 200, 24);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_8.add(lblNewLabel_2);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 69, 0));
		panel_9.setBounds(140, 5, 25, 25);
		panel_8.add(panel_9);
		panel_9.setLayout(null);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel.add(panel_10);
		panel_10.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Student(>=18)");
		lblNewLabel_3.setBounds(10, 5, 200, 24);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_10.add(lblNewLabel_3);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 0, 255));
		panel_11.setBounds(140, 5, 25, 25);
		panel_10.add(panel_11);
		panel_10.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(14, 235, 178, 189);
		add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblLogan = new JLabel(title);//title
		lblLogan.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblLogan.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblLogan);

		JLabel lblScreen = new JLabel("Screen" + (mode));//screen
		lblScreen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblScreen.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblScreen);

		JLabel label = new JLabel(time);//time
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(15, 444, 178, 100);
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		panel_3.setBackground(Color.WHITE);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(container, "timetable");
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel_3.add(btnBack);

		JButton btnBack_1 = new JButton("Sure");
		seatInformation = new ArrayList<>();
		btnBack_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (cli == 0)
					JOptionPane.showMessageDialog(null, "Please choose one or more seat", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					ShowPanel show = new ShowPanel(card, container, cli, seatInformation);
					show.setLayout(null);
					show.setBackground(Color.WHITE);
					container.add(show, "show");
					card.show(container, "show");
				}
			}
		});
		btnBack_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel_3.add(btnBack_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(206, 20, 614, 489);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(20, 440, 20, 50);
		panel_1.add(lblNewLabel_4);

		control.readSeatinfo();
		JLabel lblNewLabel_5 = new JLabel(Integer.toString(control.getRowSeat(title, Integer.toString(mode), time)));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(560, 440, 100, 50);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("A");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(600, 10, 30, 40);
		panel_1.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(String.valueOf((char) (64 + control.getSeatHeight(title, Integer.toString(mode), time))));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_8.setBounds(600, 385, 30, 40);
		panel_1.add(lblNewLabel_8);

		int y = control.getSeatHeight(title, Integer.toString(mode), time);
		int x = control.getSeatWidth(title, Integer.toString(mode), time);
		int ydistance = ((489 - 68 * y) / y);
		l1 = new JLabel[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				l1[i][j] = new JLabel("blue");
				l1[i][j].setBounds(j * 66, (66 + ydistance) * i, 67, 67);
				panel_1.add(l1[i][j]);
			}
		}

		if (control.getSamenum(control.getPositionstate(title, Integer.toString(mode), time), "0").get(0) != 0) {
			for (Integer number : control.getSamenum(control.getPositionstate(title, Integer.toString(mode), time), "0")) {
				int i = control.getSeati(number, x);
				int j = control.getSeatj(number, x);
				l1[i][j].setVisible(false);
			}
		}

		if (control.getSamenum(control.getPositionstate(title, Integer.toString(mode), time), "1").get(0) != 0) {
			for (Integer number : control.getSamenum(control.getPositionstate(title, Integer.toString(mode), time), "1")) {
				int i = control.getSeati(number, x);
				int j = control.getSeatj(number, x);
				l1[i][j].setIcon(new ImageIcon("images/origin.PNG"));
				l1[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (cli <= 4 && check(cli, l1[i][j].getText()) == 1) {
							if (l1[i][j].getText().equals("blue")) {
								JFrame fr = new JFrame("Type");
								fr.setSize(250, 200);
								fr.setLocationRelativeTo(null);
								fr.setVisible(true);
								fr.setResizable(false);
								JPanel smallPanel = new JPanel();
								fr.add(smallPanel);
								smallPanel.setBackground(Color.WHITE);
								smallPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

								JTextField t1 = new JTextField("Need ID", 15);
								t1.setFont(new Font("Times New Roman", Font.PLAIN, 18));

								String type[] = {"Student 13.6", "Adult 16", "Senior 12.8", "Child 8"};
								JComboBox<String> box;
								box = new JComboBox<>(type);
								box.setFont(new Font("Times New Roman", Font.BOLD, 20));
								box.addActionListener(arg01 -> {
									if (box.getSelectedItem().equals("Student 13.6")) {
										t1.setText("Need ID");
										t1.setEditable(true);
										t1.setEnabled(true);
										t1.repaint();
									}
									if (box.getSelectedItem().equals("Adult 16")) {
										t1.setText("Without ID");
										t1.setEditable(false);
										t1.setEnabled(false);
										t1.repaint();
									}
									if (box.getSelectedItem().equals("Senior 12.8")) {
										t1.setText("Without ID");
										t1.setEditable(false);
										t1.setEnabled(false);
										t1.repaint();
									}
									if (box.getSelectedItem().equals("Child 8")) {
										t1.setText("Without ID");
										t1.setEditable(false);
										t1.setEnabled(false);
										t1.repaint();
									}
								});
								JButton b1 = new JButton("Submit");
								b1.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										String eachWord[] = ((String) box.getSelectedItem()).split(" ");
										if (eachWord[0].equals("Student") && t1.getText().matches("^^\\d{10}$")) {
											cli++;
											l1[i][j].setText("others");
											l1[i][j].setIcon(new ImageIcon("images/student.PNG"));
											SaveSeatinfo info = new SaveSeatinfo(number, title, time, mode);
											info.setSaveType(eachWord[0]);
											info.setSavePrice(eachWord[1]);
											info.setSeatlocation(String.valueOf((char) (64 + control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(0))) +
													control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(1));
											info.setSaveID(t1.getText());
											seatInformation.add(info);
											fr.dispose();
										} else if (eachWord[0].equals("Adult")) {
											cli++;
											l1[i][j].setText("others");
											l1[i][j].setIcon(new ImageIcon("images/adult.PNG"));
											SaveSeatinfo info = new SaveSeatinfo(number, title, time, mode);
											info.setSaveType(eachWord[0]);
											info.setSavePrice(eachWord[1]);
											info.setSeatlocation(String.valueOf((char) (64 + control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(0))) +
													control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(1));
											info.setSaveID("None");
											seatInformation.add(info);
											fr.dispose();
										} else if (eachWord[0].equals("Senior")) {
											cli++;
											l1[i][j].setText("others");
											l1[i][j].setIcon(new ImageIcon("images/senior.PNG"));
											SaveSeatinfo info = new SaveSeatinfo(number, title, time, mode);
											info.setSaveType(eachWord[0]);
											info.setSavePrice(eachWord[1]);
											info.setSeatlocation(String.valueOf((char) (64 + control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(0))) +
													control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(1));
											info.setSaveID("None");
											seatInformation.add(info);
											fr.dispose();
										} else if (eachWord[0].equals("Child")) {
											cli++;
											l1[i][j].setText("others");
											l1[i][j].setIcon(new ImageIcon("images/child.PNG"));
											SaveSeatinfo info = new SaveSeatinfo(number, title, time, mode);
											info.setSaveType(eachWord[0]);
											info.setSavePrice(eachWord[1]);
											info.setSeatlocation(String.valueOf((char) (64 + control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(0))) +
													control.getSeatNum(control.getPositionstate(title, Integer.toString(mode), time), x, number).get(1));
											info.setSaveID("None");
											seatInformation.add(info);
											fr.dispose();
										} else
											JOptionPane.showMessageDialog(null, "ID must be 10 number", "Error", JOptionPane.ERROR_MESSAGE);
									}
								});
								b1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
								smallPanel.add(box);
								smallPanel.add(t1);
								smallPanel.add(b1);
							} else {
								l1[i][j].setText("blue");
								l1[i][j].setIcon(new ImageIcon("images/origin.PNG"));
								seatInformation.removeIf(saveSeatinfo -> saveSeatinfo.getSaveNumber() == number);
								cli--;
							}
						} else
							JOptionPane.showMessageDialog(null, "Up to four at time", "Error", JOptionPane.ERROR_MESSAGE);
					}
				});
			}
		}

		for (int m = 2; m < 6; m++) {
			if (control.getSamenum(control.getPositionstate(title, Integer.toString(mode), time), Integer.toString(m)).get(0) != 0) {
				for (Integer number : control.getSamenum(control.getPositionstate(title, Integer.toString(mode), time), Integer.toString(m))) {
					int i = control.getSeati(number, x);
					int j = control.getSeatj(number, x);
					l1[i][j].setIcon(new ImageIcon("images/origin.PNG"));
					l1[i][j].setEnabled(false);
				}
			}
		}
	}

	private int check(int num, String state) {
		if (num == 4 && state.equals("blue")) return 0;
		return 1;
	}
}
