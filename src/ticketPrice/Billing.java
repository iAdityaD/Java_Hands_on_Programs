package ticketPrice;

public class Billing {
	
	String from ,to;
	int ntick;
	public Billing(String from,String to, String ntick){
		this.from = from;
		this.to = to;
		this.ntick = Integer.parseInt(ntick);
	}
	
	public float taxing(float amount) {
		float percent5;
		percent5 = (float) (amount*0.05);
		return  percent5;
	}
	public float amount() {
		float amt,total;
		amt = ntick*cost(from,to);
		total = amt +taxing(amt);
		return total;
	}
	//String s1[] = { " ", "CHENNAI", "BANGULORE", "HYDERABAD", "VIZAG"};
	public int cost(String from , String to){
		if (from == "CHENNAI") {
			switch(to) {
			case "BANGULORE":
				return 300;
			case "HYDERABAD":
				return 400;
			case "VIZAG":
				return 250;
			default :
				return 0;
			}
		}
		else if(from=="BANGULORE"){
			switch(to) {
			case "CHENNAI":
				return 300;
			case "HYDERABAD":
				return 400;
			case "VIZAG":
				return 250;
			default :
				return 0;
			}
		}
		else if(from=="HYDERABAD "){
			switch(to) {
			case "CHENNAI":
				return 300;
			case "BANGULORE":
				return 400;
			case "VIZAG":
				return 250;
			default :
				return 0;
			}
		}
		else if(from=="VIZAG "){
			switch(to) {
			case "CHENNAI":
				return 300;
			case "HYDERABAD":
				return 400;
			case "BANGULORE":
				return 250;
			default :
				return 0;
			}
		}
		return 0;
	}
}
