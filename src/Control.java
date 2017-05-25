import java.util.ArrayList;
import java.io.*;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Control {
	private ArrayList<String> list = null ;
	private ArrayList<String> lastList = null;
	File file = new File("movieinfo.xml");
	File file_1 = new File("seatinfo.xml");
	ArrayList<ScreenLocation> locations = new ArrayList<ScreenLocation>();
	ArrayList<SeatLocation> seats = new ArrayList<SeatLocation>();

	public void welcome() {
	} //C

	public void displayTime() {
	} //C

	public void displayScreen() {
	}

	public void displayTicket() {
	}//B

	public Document getDoc(File file) {
		Document doc = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public int getNumber() {
		int number = 0;
		try {
			NodeList movieList = getDoc(file).getElementsByTagName("movie");
			number = movieList.getLength();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return number;
	}

	public String getElement(String a, int b) {
		String element = "";
		try {
			NodeList movieList = getDoc(file).getElementsByTagName("movie");
			Node movieNode = movieList.item(b);
			Element movieElement = (Element) movieNode;
			element = movieElement.getElementsByTagName(a).item(0).getTextContent();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return element;
	}

	public void readScreenlocation() {
		try {
			NodeList movieList = getDoc(file).getElementsByTagName("movie");
			for (int i = 0; i < movieList.getLength(); i++) {
				Element movieElement = (Element) movieList.item(i);
				Element titleElement = (Element) movieElement.getElementsByTagName("title").item(0);
				NodeList movieScreen = movieElement.getElementsByTagName("location");
				for (int j = 0; j < movieScreen.getLength(); j++) {
					Element time = (Element) movieScreen.item(j);
					ScreenLocation location = new ScreenLocation();
					location.setTitle(titleElement.getTextContent());
					location.setScreen(time.getElementsByTagName("screen").item(0).getTextContent());
					Element detailtime = (Element) time.getElementsByTagName("time").item(0);
					location.setHour(detailtime.getElementsByTagName("hour").item(0).getTextContent());
					location.setMin(detailtime.getElementsByTagName("min").item(0).getTextContent());
					locations.add(location);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getMaxscreen() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int max = 0;
		for (ScreenLocation location : locations) {
			nums.add(Integer.parseInt(location.getScreen()));
		}
		for (Integer num : nums) {
			if (max < num) max = num;
		}
		return max;
	}

	public ArrayList<String> getHourtime(String title, int screen) {
		ArrayList<String> times = new ArrayList<String>();
		for (ScreenLocation location : locations) {
			if (title.equals(location.getTitle()) && screen == Integer.parseInt(location.getScreen())) {
				String addString = location.getHour() + ":" + location.getMin();
				times.add(addString);
			}
		}
		return times;
	}

	public void readSeatinfo() {
		try {
			NodeList screentimeList = getDoc(file_1).getElementsByTagName("screentime");
			for (int i = 0; i < screentimeList.getLength(); i++) {
				Element screentimeElement = (Element) screentimeList.item(i);

				SeatLocation seatlocation = new SeatLocation();
				Element titleElement = (Element) screentimeElement.getElementsByTagName("title").item(0);
				seatlocation.setTitle(titleElement.getTextContent());
				seatlocation.setTime(screentimeElement.getElementsByTagName("time").item(0).getTextContent());
				seatlocation.setMode(screentimeElement.getElementsByTagName("mode").item(0).getTextContent());
				seatlocation.setWidth(screentimeElement.getElementsByTagName("width").item(0).getTextContent());
				seatlocation.setHeight(screentimeElement.getElementsByTagName("height").item(0).getTextContent());
				seatlocation.setPosition(screentimeElement.getElementsByTagName("position").item(0).getTextContent());
				seatlocation.setPositionstate(screentimeElement.getElementsByTagName("positionstate").item(0).getTextContent());
				seats.add(seatlocation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		for (SeatLocation seat : seats)
//            System.out.println(seat.toString()); 
	}

	public int getSeatWidth(String title, String mode, String time) {
		int width = 0;
		for (SeatLocation seat : seats) {
			if (title.equals(seat.getTitle()) && mode.equals(seat.getMode()) && time.equals(seat.getTime())) {
				width = Integer.parseInt(seat.getWidth());
			}
		}
		return width;
	}

	public int getSeatHeight(String title, String mode, String time) {
		int height = 0;
		for (SeatLocation seat : seats) {
			if (title.equals(seat.getTitle()) && mode.equals(seat.getMode()) && time.equals(seat.getTime())) {
				height = Integer.parseInt(seat.getHeight());
			}
		}
		return height;
	}

	public String getPositionstate(String title, String mode, String time) {
		String positionstate = null;
		for (SeatLocation seat : seats) {
			if (title.equals(seat.getTitle()) && mode.equals(seat.getMode()) && time.equals(seat.getTime())) {
				positionstate = seat.getPositionstate();
			}
		}
		return positionstate;
	}

	public int getRowSeat(String title, String mode, String time) {
		String position = null;
		int max = 0;
		for (SeatLocation seat : seats) {
			if (title.equals(seat.getTitle()) && mode.equals(seat.getMode()) && time.equals(seat.getTime())) {
				position = seat.getPosition();
				String eachposition[] = position.split("-");
				for (int i = 0; i < Integer.parseInt(seat.getHeight()); i++) {
					if ((eachposition[i].length() - eachposition[i].replace("1", "").length()) > max)
						max = eachposition[i].length() - eachposition[i].replace("1", "").length();
				}
			}
		}
		return max;
	}

	public ArrayList<Integer> getSamenum(String positionstate, String number) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = -1; i <= positionstate.lastIndexOf(number); ++i) {
			i = positionstate.indexOf(number, i);
			nums.add(i + 1);
		}
		return nums;
	}

	public int getSeati(int num, int width) {
		if ((num % width) == 0) return num / width - 1;
		return num / width;
	}

	public int getSeatj(int num, int width) {
		if ((num % width) == 0) return width - 1;
		return (num % width) - 1;
	}

	public ArrayList<Integer> getSeatNum(String positionstateSeq, int height, int width, int number) {
		int count = 0;
		int pState = 0;
		int rSeatx = 0;
		int rSeaty = 0;
		ArrayList<Integer> seatNum = new ArrayList<>();
		if (number % width != 0) {
			for (int i = 0; i <= number / width; i++) {
				count = 0;
				for (int j = 0; j < number % width; j++) {
					pState = i * width + j + 1;
					if (positionstateSeq.substring(pState - 1, pState).equals("0") == false) count++;
				}
				rSeatx = number / width + 1;
				rSeaty = count;
			}
		}
		if (number % width == 0) {
			for (int i = 0; i <= number / width - 1; i++) {
				count = 0;
				for (int j = 0; j <= width - 1; j++) {
					pState = i * width + j + 1;
					if (positionstateSeq.substring(pState - 1, pState).equals("0") == false) count++;
				}
				rSeatx = number / width;
				rSeaty = count;
			}
		}
		seatNum.add(rSeatx);
		seatNum.add(rSeaty);
		return seatNum;
	}

//	public int reGetState(int i, int j, int width) {
//		return i * width + j;
//	}

	public boolean judgeTime(int filmHour, int filmMinute, int systemHour, int systemMinute) {
		if (filmHour > systemHour) return true;
		if (filmHour == systemHour) {
			if (filmMinute > systemMinute) return true;
		}
		return false;
	}

	public void updateElementValue(String number, String filmTitle, String filmTime, String filmMode) {
		try {
			Document doc = getDoc(file_1);
			doc.getDocumentElement().normalize();
			NodeList screentime = doc.getElementsByTagName("screentime");
			Element emp = null;
			for (int i = 0; i < screentime.getLength(); i++) {

				emp = (Element) screentime.item(i);
				Node title = emp.getElementsByTagName("title").item(0).getFirstChild();
				Node time = emp.getElementsByTagName("time").item(0).getFirstChild();
				Node mode = emp.getElementsByTagName("mode").item(0).getFirstChild();
				Node positionstate = emp.getElementsByTagName("positionstate").item(0).getFirstChild();
				if (title.getNodeValue().equals(filmTitle) && time.getNodeValue().equals(filmTime) && mode.getNodeValue().equals(filmMode)) {
					StringBuilder newPositionsate = new StringBuilder(positionstate.getNodeValue());
					newPositionsate.setCharAt(Integer.parseInt(number) - 1, '2');
					positionstate.setNodeValue(newPositionsate.toString());
				}
			}
			doc.getDocumentElement().normalize();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("seatinfo.xml"));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//	public void readMovie(){
//		ArrayList<Movie> lists = new ArrayList<Movie>();
//		try{
//		 	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
//            Document doc = dBuilder.parse(file);  
//            NodeList movieList = doc.getElementsByTagName("movie");  
//            for (int i = 0; i < movieList.getLength(); i++) {     
//                Element movieElement = (Element) movieList.item(i);  
//                Movie movie = new Movie();   
//                Element titleElement = (Element) movieElement.getElementsByTagName("title").item(0);  
//                movie.setTitle(titleElement.getTextContent()); 
//                movie.setPhoto(movieElement.getElementsByTagName("photo").item(0).getTextContent()); 
//                movie.setTimelength(movieElement.getElementsByTagName("timelength").item(0).getTextContent());
//                lists.add(movie); 
//                NodeList movieScreen = movieElement.getElementsByTagName("location");
//                for(int j = 0; j<movieScreen.getLength(); j++){
//                	Element time = (Element)movieScreen.item(j);
//                	ScreenLocation location = new ScreenLocation();
//                    location.setTitle(titleElement.getTextContent());
//                    location.setScreen(time.getElementsByTagName("screen").item(0).getTextContent());
//                    Element detailtime = (Element)time.getElementsByTagName("time").item(0);
//                    location.setHour(detailtime.getElementsByTagName("hour").item(0).getTextContent());
//                    location.setMin(detailtime.getElementsByTagName("min").item(0).getTextContent());
//                    locations.add(location);
//                    	
//                }
//               
//  
//            }
//		}catch (Exception e) {  
//			e.printStackTrace();  
//		}
//		for (Movie movie : lists)
//            System.out.println(movie.toString());  
//		for(ScreenLocation location : locations)
//			System.out.println(location.toString());
//	}

	public double chooseType(String type) {
		if (type.equals("Child")) return 8;
		else if (type.equals("Senior")) return 12.8;
		else if (type.equals("Student")) return 13.6;
		else return 16;
	}//A

		public void readFiles(String fileName) {// change to get ID in ticketID.txt
		try {
			File myFile = new File(fileName);
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			list = new ArrayList<String>();
			String ss = "";
			while ((ss = reader.readLine()) != null)
				list.add(ss);
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void allID() {
		try {
			File myFile = new File("ticketRecord.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			int i = 0;
			list= new ArrayList<String>();
			list.add("1");
			while ((line = reader.readLine()) != null) {
				if (i % 8 == 0) {
					String[] splitStr = line.split(" ");
					if(splitStr.length==2)
						list.add(splitStr[1]);
				}
				i++;
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		for(String s : list)
//			System.out.println(s);
	}

	public boolean checkDuplicated(String a, ArrayList<String> p) {
			for (String b : p)
				if (a.equals(b)) return true;
		return false;
	}

	public ArrayList<String> ticketID(int ticketnum) {
		int num = 0;
		int[] preid = new int[8];
		String lastid;
		Random ran = new Random();
		lastList = new ArrayList<String>();
		allID();
//		readFiles("ticketRecord.txt");
		for (int i = 0; i < ticketnum; i++) {
			StringBuffer id;
			do {
				id = new StringBuffer();
				for (int x = 0; x < 8; x++) {
					num = 1 + ran.nextInt(4);
					preid[x] = num;
				}
				for (int y = 0; y < 8; y++) {
					id.append(preid[y]);
				}
				lastid = id.toString();
			} while (checkDuplicated(lastid, list));
			list.add(lastid);
			lastList.add(lastid);
			//System.out.println(lastid);
			//System.out.println(lastid.equals("11111111"));//
		}
		return lastList;
	}



}
