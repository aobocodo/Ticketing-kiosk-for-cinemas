import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TotalPanel();
					
//					StringBuffer buffer = new StringBuffer("01111110");
//					System.out.println(buffer.toString());
//					buffer.replace(1, 2, "a");
//					System.out.println(buffer.toString());
					//new MainGUI();
					//new MenuGUI();
					//Control test = new Control();
					//test.readSeatinfo();
//					test.readScreenlocation();
//					System.out.println(test.getFirstelement("photo"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
