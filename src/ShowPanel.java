import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;


/**
 * Name ShowPanel
 * Usage produce the show ticket panel
 */
class ShowPanel extends JPanel {
	private double totalPrice=0.0;
	private ArrayList<Ticket> tickets;

	/**
	 * constructor
	 * @param card card layout
	 * @param container frame.ContentPane()
	 * @param totalNumber all ticket number
	 * @param information chosen tickets information
	 */
	ShowPanel(CardLayout card, Container container, int totalNumber, ArrayList<SaveSeatinfo> information) {
		Control control = new Control();
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
		panel_2.setBounds(14, 123, 806, 192);
		add(panel_2);

		JTable table = new JTable();
		table.setEnabled(false);
		String[] tableHeads = new String[]{"Title","Screen", "Time", "SeatNum", "Type", "Price", "StudentID"};
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setColumnIdentifiers(tableHeads);
		table.setFillsViewportHeight(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.setRowHeight(40);
		table.setBackground(new Color(255, 160, 122));
		ArrayList<String> message = new ArrayList<>();
		for (SaveSeatinfo info : information) {
			message.add(info.getSaveTitle());
			message.add(String.valueOf(info.getSaveMode()));
			message.add(info.getSaveTime());
			message.add(info.getSaveSeatlocation());
			message.add(info.getSaveType());
			message.add(info.getSavePrice());
			message.add(info.getSaveID());
			BigDecimal tPrice = new BigDecimal(String.valueOf(totalPrice));
			BigDecimal sPrice = new BigDecimal(String.valueOf(Double.parseDouble(info.getSavePrice())));
			totalPrice=tPrice.add(sPrice).doubleValue();
		}

		Vector<String>[] v;
		v = new Vector[information.size()];
		for(int i=0; i<information.size(); i++){
			v[i] = new Vector();
			v[i].add(message.get(i*7));
			v[i].add(message.get(i*7+1));
			v[i].add(message.get(i*7+2));
			v[i].add(message.get(i*7+3));
			v[i].add(message.get(i*7+4));
			v[i].add(message.get(i*7+5));
			v[i].add(message.get(i*7+6));
			dtm.addRow(v[i]);
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(806, 192));
		panel_2.add(scrollPane);

		JPanel panel_d = new JPanel();
		panel_d.setLayout(null);
		panel_d.setBackground(Color.WHITE);
		panel_d.setBounds(14,315,806,140);
		JLabel lbl_1 = new JLabel();
		lbl_1.setIcon(new ImageIcon("images/bufferfly.gif"));
		lbl_1.setBounds(640, 0, 152, 140);
		panel_d.add(lbl_1);
		add(panel_d);


		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(14, 446, 806, 66);
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

		JButton btnNewButton = new JButton("Sure");
		tickets = new ArrayList<>();
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame fr=new JFrame("Get Tickets");
				fr.setSize(400, 200);
				fr.setLocationRelativeTo(null);
				fr.setVisible(true);
				fr.setResizable(false);
				fr.getContentPane().setBackground(Color.WHITE);
				fr.getContentPane().setLayout(null);

				JPanel panel_m = new JPanel();
				panel_m.setBackground(Color.WHITE);
				panel_m.setBounds(14, 13, 366, 78);
				fr.getContentPane().add(panel_m);
				panel_m.setLayout(new BorderLayout(0, 0));

				JLabel lblYouShouldPay = new JLabel("You should pay "+totalPrice);
				lblYouShouldPay.setHorizontalAlignment(SwingConstants.CENTER);
				lblYouShouldPay.setFont(new Font("Times New Roman", Font.BOLD, 23));
				panel_m.add(lblYouShouldPay, BorderLayout.CENTER);

				JPanel panel_p = new JPanel();
				panel_p.setBounds(145, 115, 82, 37);
				fr.getContentPane().add(panel_p);
				panel_p.setLayout(new BorderLayout(0, 0));

				JButton btnNewButton_p = new JButton("Pay");
				btnNewButton_p.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int i=0;
						for(SaveSeatinfo xmlInfo: information) {
							control.updateElementValue(String.valueOf(xmlInfo.getSaveNumber()), xmlInfo.getSaveTitle(), xmlInfo.getSaveTime(), String.valueOf(xmlInfo.getSaveMode()));
							Ticket ticket = new Ticket();
							ticket.setTitle(xmlInfo.getSaveTitle());
							ticket.setType(xmlInfo.getSaveType());
							ticket.setTime(xmlInfo.getSaveTime());
							ticket.setPrice(xmlInfo.getSavePrice());
							ticket.setSeatNum(xmlInfo.getSaveSeatlocation());
							ticket.setMode(String.valueOf(xmlInfo.getSaveMode()));
							ticket.setStuID(xmlInfo.getSaveID());
							ticket.setID(control.ticketID(information.size()).get(i));
							i++;
							tickets.add(ticket);
						}

						for(Ticket t : tickets){
							try{
								BufferedWriter addCustomer = new BufferedWriter(new FileWriter("ticketRecord.txt",true));
								addCustomer.write(t.toString());
								addCustomer.close();
							}
							catch (IOException e1){
								e1.printStackTrace();
							}
						}



						//to do product the ticket txt(ID.txt)
						for(Ticket t : tickets){
							try{
								BufferedWriter addCustomer = new BufferedWriter(new FileWriter(t.getID()+".txt",false));
								addCustomer.write(t.toString());
								addCustomer.close();
							}
							catch (IOException e1){
								e1.printStackTrace();
							}
						}





						fr.dispose();
						JOptionPane.showMessageDialog(null, "Pay Successfully :-)", "Tip", JOptionPane.PLAIN_MESSAGE);
						card.show(container, "menu");
					}
				});
				btnNewButton_p.setFont(new Font("Times New Roman", Font.BOLD, 18));
				panel_p.add(btnNewButton_p, BorderLayout.CENTER);


			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
		panel_3.add(btnNewButton);
	}
}
