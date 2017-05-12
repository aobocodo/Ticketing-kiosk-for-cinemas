import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
public class ShowPanel extends JPanel {
	public ShowPanel(CardLayout card, Container container, int totalNumber, ArrayList<SaveSeatinfo> information) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 13, 806, 42);
		add(panel);

		JLabel lblNewLabel = new JLabel("Check your tickets information");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 68, 806, 42);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTotalNumber = new JLabel("Total number: "+totalNumber);
		lblTotalNumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalNumber.setBounds(0, 0, 227, 18);
		lblTotalNumber.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblTotalNumber);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(14, 123, 806, 300);
		add(panel_2);

		JTable table = new JTable();
		String[] tableHeads = new String[]{"Title", "Time", "SeatNum", "Type", "Price", "ID"};
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		table.setFillsViewportHeight(true);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
//		table.setFont(new Font("", Font.BOLD, 10));
		table.setRowHeight(40);
		table.setBackground(new Color(255, 184, 133));
		ArrayList<String> message = new ArrayList<String>();
		for (SaveSeatinfo info : information) {
			message.add(info.getSaveTitle());
			message.add(info.getSaveTime());
			message.add(info.getSaveSeatlocation());
			message.add(info.getSaveType());
			message.add(info.getSavePrice());
			message.add(info.getSaveID());
			System.out.println(message);
		}

		Vector[] v = new Vector[information.size()];
		for(int i=0; i<information.size(); i++){
			System.out.println(message.get(i*6));
			v[i] = new Vector();
			v[i].add(message.get(i*6));
			v[i].add(message.get(i*6+1));
			v[i].add(message.get(i*6+2));
			v[i].add(message.get(i*6+3));
			v[i].add(message.get(i*6+4));
			v[i].add(message.get(i*6+5));
			dtm.addRow(v[i]);
		}



		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(806, 300));
		panel_2.add(scrollPane);


		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(14, 436, 806, 66);
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 20));

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				card.show(container, "seatlocation");
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel_3.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("pay the ticket");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel_3.add(btnNewButton);
	}
}
