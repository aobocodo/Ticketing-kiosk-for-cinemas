import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new TotalPanel();

//                StringBuffer buffer = new StringBuffer("01111110");
//                System.out.println(buffer.toString());
//                buffer.replace(1, 2, "a");
//                System.out.println(buffer.toString());
//                new MainGUI();
//                new MenuGUI();
//                Control test = new Control();
//                test.getSamenum("1101101111011011110110111101101111111111", "0");
//                for(Integer number : test.getSamenum("1101101111011011110110111101101111111111", "0")){
//                    System.out.println("i= "+test.getSeati(number,8)+"j= "+test.getSeatj(number,8));
//                }
//                test.getSeati(30,8);
//                test.getSeatj(30,8);
//                System.out.println("i= "+test.getSeati(3,8)+"j= "+test.getSeatj(3,8));
//                test.readSeatinfo();
//                System.out.println(test.getSeatWidth("MOONLIGHT", "2", "18:00"));
//                System.out.println(test.getSeatHeight("MOONLIGHT", "2", "18:00"));
//                System.out.println(test.getRowSeat("KONG: SKULL ISLAND", "1", "21:00"));
//                test.readScreenlocation();
//                System.out.println(test.getFirstelement("photo"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
