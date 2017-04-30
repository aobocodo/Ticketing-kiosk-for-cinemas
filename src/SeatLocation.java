
public class SeatLocation {
	private String title;
	private String time;
	private String mode;
	private String width;
	private String height;
	private String position;
	private String positionstate;
	
	public String toString(){
		return title+"  "+time+"  "+"  "+"screen"+mode+" "+width+height+"    "+position+"    "+positionstate;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setTime(String time){
		this.time= time;
	}
	public void setMode(String mode){
		this.mode= mode;
	}
	public void setWidth(String width){
		this.width= width;
	}
	public void setHeight(String height){
		this.height= height;
	}
	public void setPosition(String position){
		this.position= position;
	}
	public void setPositionstate(String positionstate){
		this.positionstate = positionstate;
	}
}
