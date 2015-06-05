import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;


public class Query {
	private Calendar departureTime; // date as well, might need to change
	private String origin;
	private String destination;
	private List<Comparator<Path>> preferences;
	private List<Path> answers;
	private int numToDisplay;
	private String airlinePreference;
	
	public Query(Calendar time, String start, String end, List<Comparator<Path>> order, int amount, String airlinePreference) {
		departureTime = time;
		origin = start;
		destination = end;
		preferences = order;
		numToDisplay = amount;
		this.airlinePreference = airlinePreference;
	}

	public Calendar getDepartureTime() {
		return departureTime;
	}
	
	public void setAnswers(List<Path> paths) {
		answers = new ArrayList<Path>(paths);
	}
	
	public List<Path> getAnswers() {
		return answers;
	}
	
	public int getDay() {
		return departureTime.get(Calendar.DATE);
	}
	
	public int getMonth() {
		return departureTime.get(Calendar.MONTH);
	}
	
	public int getYear() {
		return departureTime.get(Calendar.YEAR);
	}
	
	public int getHour() {
		return departureTime.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinute() {
		return departureTime.get(Calendar.MINUTE);
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public List<Comparator<Path>> getPreferences() {
		return preferences;
	}
	
	public int getNumToDisplay() {
		return numToDisplay;
	}
	
	public String getAirlinePreference() {
		return airlinePreference;
	}
	
	public void print() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setTimeZone(departureTime.getTimeZone());
		System.out.print("["+dateFormat.format(departureTime.getTime()) +",");
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		timeFormat.setTimeZone(departureTime.getTimeZone());
		System.out.print(timeFormat.format(departureTime.getTime()) +",");
		//System.out.print(getHour() + ":" + getMinute() + ",");
		
		System.out.print(getOrigin() + "," + getDestination()+",("	);
			
		for (int i = 0; i < preferences.size(); i++) {
			String s = preferences.get(i).getClass().toString();
			System.out.print(s);
			if (i != preferences.size()-1) {
				System.out.print(",");
			}
		}
		
		System.out.println(")," + this.getNumToDisplay()+"]");
//		System.out.print(getTravelTime() + ","+getAirline()+"," + getCost()+"]");
	}
	
	// printing out format = context free grammar specified format
//	private Calendar departureTime;
//	private String origin;
//	private String destination;
//	private Preferences preferences;
//	private int numToDisplay;
	public String toString() {
		//Preference Order?
		/*List<String> stringPreferences = new ArrayList<String>();
		for (Comparator c:preferences) {
			if (c instanceof AirlinePreference)
				stringPreferences.add(airlinePreference);
			else if (c instanceof CostPreference)
				stringPreferences.add("Cost");
			else
				stringPreferences.add("Time");
		}
		//StringBuilder newa = new StringBuilder();
		return    "[ " + this.departureTime.get(Calendar.DAY_OF_MONTH) 
				+ "/" + this.departureTime.get(Calendar.MONTH)+1 
				+ "/" + this.departureTime.get(Calendar.YEAR)
				+ ", " + this.departureTime.get(Calendar.HOUR_OF_DAY)
				+ ":" + this.departureTime.get(Calendar.MINUTE)
				+ ", " + this.origin + "," + this.destination
				+ ", (" + stringPreferences.get(0) +", " + stringPreferences.get(1) + ", " + stringPreferences.get(2)
				+ "), " + this.numToDisplay
				+ "]";
		
		*/
		StringBuilder str = new StringBuilder();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setTimeZone(departureTime.getTimeZone());
		str.append("["+dateFormat.format(departureTime.getTime()) +", ");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		timeFormat.setTimeZone(departureTime.getTimeZone());
		str.append(timeFormat.format(departureTime.getTime()) +", ");
		str.append(getOrigin() + ", " + getDestination()+", ("	);
		for (int i = 0; i < preferences.size(); i++) {
			String s = "";
			if (preferences.get(i) instanceof AirlinePreference)
				s = airlinePreference;
			if (preferences.get(i) instanceof CostPreference)
				s = "Cost";
			if (preferences.get(i) instanceof TravelTimePreference)
				s = "Time";
			str.append(s);
			if (i != preferences.size()-1) {
				str.append(", ");
			}
		}
		
		str.append("), " + this.getNumToDisplay()+"]");
		return str.toString();
	}
}
