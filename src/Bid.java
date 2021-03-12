//Kasper Rosenberg
//karo5568
public class Bid {
	private User user;
	private int value;
	public Bid(User user, int value) {
		this.user = user;
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public User getUser() {
		return user;
	}
	public String toString() {
		return String.format("%s %d kr", getUser().getUserName(), value );
	}
//	public int compareTo(Bid other) {
//		int bid = this.getValue()-other.getValue();
//		if(bid > 0) {
//			return 1;
//		}else if(bid < 0) {
//			return -1;
//		}else {
//			return 0;
//		}		
//	}

}
