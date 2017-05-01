import java.awt.BorderLayout;
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
import javax.swing.border.LineBorder;

public class SeatPanel extends JPanel{
	
	public SeatPanel(CardLayout card, Container container, String title, int mode, String time){
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
		
		JLabel lblScreen = new JLabel("Screen"+(mode));//screen
		lblScreen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblScreen.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblScreen);
		
		JLabel label = new JLabel(time);//time
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(49, 444, 107, 58);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(container,"timetable");
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel_3.add(btnBack);
		
		
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
		JLabel lblNewLabel_5 = new JLabel(Integer.toString(control.getRowSeat(title, Integer.toString(mode), time)));//横的有多少个座位
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(560, 440, 100, 50);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("A");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(600, 10, 30, 40);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(String.valueOf((char)(64+control.getSeatHeight(title, Integer.toString(mode), time))));//竖的有多少个座位
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_8.setBounds(600, 385, 30, 40);
		panel_1.add(lblNewLabel_8);
		
		int y = control.getSeatHeight(title, Integer.toString(mode), time);
		int x = control.getSeatWidth(title, Integer.toString(mode), time);
		int ydistance = ((489-68*y)/y);
		
		JLabel[][] l1 = new JLabel[y][x];
		for(int i=0; i<y; i++){
			for(int j=0; j<x; j++){
				l1[i][j] = new JLabel("new label");
				l1[i][j].setBounds(j*66,(66+ydistance)*i,67,67);
				l1[i][j].setIcon(new ImageIcon("E:\\moviephoto\\origin.PNG"));
				panel_1.add(l1[i][j]);
			}
			
		}
		
		
	}
}
