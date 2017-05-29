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

/**
 * Name Control
 * Usage Save all operation function
 */
class Control {
	private ArrayList<String> list = null;
	private File file = new File("movieinfo.xml");
	private File file_1 = new File("seatinfo.xml");
	private ArrayList<ScreenLocation> locations = new ArrayList<>();
	private ArrayList<SeatLocation> seats = new ArrayList<>();


	/**
	 * Connect file with document
	 * @param file different input file
	 * @return xxx.xml of relevant document
	 */
	private Document getDoc(File file) {
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

	/**
	 * Get movie number
	 * @return movie number
	 */
	int getNumber() {
		int number = 0;
		try {
			NodeList movieList = getDoc(file).getElementsByTagName("movie");
			number = movieList.getLength();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return number;
	}

	/**
	 * Get xml note information
	 * @param a node number
	 * @param b order of item
	 * @return content of the item
	 */
	String getElement(String a, int b) {
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

	/**
	 * Read movies' timetable to ScreenLocation class
	 */
	void readScreenlocation() {
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

	/**
	 * Get screen number
	 * @return number of screen
	 */
	int getMaxscreen() {
		ArrayList<Integer> nums = new ArrayList<>();
		int max = 0;
		for (ScreenLocation location : locations) {
			nums.add(Integer.parseInt(location.getScreen()));
		}
		for (Integer num : nums) {
			if (max < num) max = num;
		}
		return max;
	}

	/**
	 * Get movie time
	 * @param title movie name
	 * @param screen movies' screen
	 * @return ArrayList save hour and time
	 */
	ArrayList<String> getHourtime(String title, int screen) {
		ArrayList<String> times = new ArrayList<>();
		for (ScreenLocation location : locations) {
			if (title.equals(location.getTitle()) && screen == Integer.parseInt(location.getScreen())) {
				String addString = location.getHour() + ":" + location.getMin();
				times.add(addString);
			}
		}
		return times;
	}

	/**
	 * Read seat layout to SeatLocation class
	 */
	void readSeatinfo() {
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
	}

	/**
	 * Get screen width
	 * @param title movie name
	 * @param mode movie's screen number
	 * @param time movie's time
	 * @return cinema's width
	 */
	int getSeatWidth(String title, String mode, String time) {
		int width = 0;
		for (SeatLocation seat : seats) {
			if (title.equals(seat.getTitle()) && mode.equals(seat.getMode()) && time.equals(seat.getTime())) {
				width = Integer.parseInt(seat.getWidth());
			}
		}
		return width;
	}

	/**
	 * Get screen height
	 * @param title movie name
	 * @param mode movie screen
	 * @param time movie time
	 * @return cinema's length
	 */
	int getSeatHeight(String title, String mode, String time) {
		int height = 0;
		for (SeatLocation seat : seats) {
			if (title.equals(seat.getTitle()) && mode.equals(seat.getMode()) && time.equals(seat.getTime())) {
				height = Integer.parseInt(seat.getHeight());
			}
		}
		return height;
	}

	/**
	 * Get seat position state
	 * @param title movie name
	 * @param mode movie screen
	 * @param time movie time
	 * @return seat state
	 */
	String getPositionstate(String title, String mode, String time) {
		String positionstate = null;
		for (SeatLocation seat : seats) {
			if (title.equals(seat.getTitle()) && mode.equals(seat.getMode()) && time.equals(seat.getTime())) {
				positionstate = seat.getPositionstate();
			}
		}
		return positionstate;
	}

	/**
	 * Get row seat number
	 * @param title movie name
	 * @param mode movie screen
	 * @param time movie time
	 * @return a row's seat
	 */
	int getRowSeat(String title, String mode, String time) {
		String position;
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

	/**
	 * Get same position sate number
	 * @param positionstate seat state
	 * @param number state number 0 or 1 or 2
	 * @return each state number
	 */
	ArrayList<Integer> getSamenum(String positionstate, String number) {
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = -1; i <= positionstate.lastIndexOf(number); ++i) {
			i = positionstate.indexOf(number, i);
			nums.add(i + 1);
		}
		return nums;
	}

	/**
	 * Get seat i
	 * @param num customer choose location number
	 * @param width the row's width
	 * @return row seat number
	 */
	int getSeati(int num, int width) {
		if ((num % width) == 0) return num / width - 1;
		return num / width;
	}

	/**
	 * Get seat j
	 * @param num customer choose location number
	 * @param width the row's width
	 * @return column seat number
	 */
	int getSeatj(int num, int width) {
		if ((num % width) == 0) return width - 1;
		return (num % width) - 1;
	}

	/**
	 * Get seat number
	 * @param positionstateSeq seat state sequence
	 * @param width the row's width
	 * @param number seat number
	 * @return ArrayList of seat number
	 */
	ArrayList<Integer> getSeatNum(String positionstateSeq, int width, int number) {
		int count;
		int pState;
		int rSeatx = 0;
		int rSeaty = 0;
		ArrayList<Integer> seatNum = new ArrayList<>();
		if (number % width != 0) {
			for (int i = 0; i <= number / width; i++) {
				count = 0;
				for (int j = 0; j < number % width; j++) {
					pState = i * width + j + 1;
					if (!positionstateSeq.substring(pState - 1, pState).equals("0")) count++;
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
					if (!positionstateSeq.substring(pState - 1, pState).equals("0")) count++;
				}
				rSeatx = number / width;
				rSeaty = count;
			}
		}
		seatNum.add(rSeatx);
		seatNum.add(rSeaty);
		return seatNum;
	}


	/**
	 * Judge movie time
	 * @param filmHour movie hour
	 * @param filmMinute movie minute
	 * @param systemHour hour at now
	 * @param systemMinute minut at now
	 * @return the result of checking time
	 */
	boolean judgeTime(int filmHour, int filmMinute, int systemHour, int systemMinute) {
		if (filmHour > systemHour) return true;
		if (filmHour == systemHour) {
			if (filmMinute > systemMinute) return true;
		}
		return false;
	}

	/**
	 * Update xml element value
	 * @param number customer choose location number
	 * @param filmTitle movie name
	 * @param filmTime movie time
	 * @param filmMode movie screen
	 */
	void updateElementValue(String number, String filmTitle, String filmTime, String filmMode) {
		try {
			Document doc = getDoc(file_1);
			doc.getDocumentElement().normalize();
			NodeList screentime = doc.getElementsByTagName("screentime");
			Element emp;
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


	/**
	 * Get all ticket id from ticketRecord.txt
	 */
	private void allID() {
		try {
			File myFile = new File("ticketRecord.txt");
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String line;
			int i = 0;
			list = new ArrayList<>();
			list.add("1");
			while ((line = reader.readLine()) != null) {
				if (i % 8 == 0) {
					String[] splitStr = line.split(" ");
					if (splitStr.length == 2)
						list.add(splitStr[1]);
				}
				i++;
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Check duplicated
	 * @param a unsure id
	 * @param p Array list of exist id
	 * @return the result of compare them
	 */
	private boolean checkDuplicated(String a, ArrayList<String> p) {
		for (String b : p)
			if (a.equals(b)) return true;
		return false;
	}

	/**
	 * Get ticket id
	 * @param ticketnum total ticket number
	 * @return random and different ticket id list
	 */
	ArrayList<String> ticketID(int ticketnum) {
		int num;
		int[] preid = new int[8];
		String lastid;
		Random ran = new Random();
		ArrayList<String> lastList = new ArrayList<>();
		allID();
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
		}
		return lastList;
	}

}
