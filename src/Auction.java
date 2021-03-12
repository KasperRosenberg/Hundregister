//Kasper Rosenberg
//karo5568
import java.util.ArrayList;

public class Auction {
	
	private static int counter;
	private int number;
	private Dog auctionDog;
	private ArrayList<Bid> bidregister = new ArrayList<>();
	private Bid[] topThreeBids = new Bid[3];

	public Auction(Dog auctionDog) {
		this.auctionDog = auctionDog;
		number = ++counter;
	}
	public int getNumber() {
		return number;
	}
	public void addBid(Bid b) {
		bidregister.add(b);
	}
	public Dog getAuctionDog() {
		return auctionDog;
	}
	public Bid getWinningBid() {
		if (bidregister.isEmpty()) {
			return null;
		}else {
		return bidregister.get(bidregister.size()- bidregister.size());
		}
	}
	public int getHighestBid() {
		int highestBid = 0; 
		for (Bid b : bidregister) {
			if (b.getValue() > highestBid) {
				highestBid = b.getValue();
			}
		}
	return highestBid;	
	}
	public Bid[] sortThreeHighestBids() {
		//först sortera bidregister
	sortBids();
	//hämta dom 3 största bids och stoppa in i topThreeBids med bidregister.get(index 0,1,2)
	for (int i = 0; i < bidregister.size() && i < 3; i++) {
		if (i < topThreeBids.length) {
			topThreeBids[i]=bidregister.get(i);
		}
//		else {
////			createDynamic(topThreeBids);
////			topThreeBids[i]=bidregister.get(i);
//			Bid[] topThreeBidsLong = new Bid[topThreeBids.length + 1];
//			for (int j = 0 ; j <= topThreeBids.length ; j++) {
//				topThreeBidsLong[i] = topThreeBids[i];
//		}
//			topThreeBids = topThreeBidsLong;
//	}
	}
	return topThreeBids;
	}
//	public Bid[] createDynamic(Bid [] gamlaListan) {
//		Bid[] topThreeBidsLong = new Bid[gamlaListan.length + 1];
//		for (int i = 0 ; i < gamlaListan.length ; i++) {
//		topThreeBidsLong[i] = gamlaListan[i];
//		}return topThreeBidsLong;
//	}
	public Bid findBid(User u) {
		for(Bid b : bidregister) {
			if(b.getUser().equals(u)) {
				return b;
			}
		}return null;
	}
	public void removeBid(Bid b) {
		bidregister.remove(b);
	}
	public void sortBids() {
	boolean notSorted = true;
	while (notSorted) {
		notSorted = false;
		for (int i = 0; i < bidregister.size() - 1; i++) {
			Bid first = bidregister.get(i);
			Bid second = bidregister.get(i + 1);
			if (first.getValue() < second.getValue()) {
				bidregister.set(i, second);
				bidregister.set(i + 1, first);
				notSorted = true;
			}
		}
	}
	}
	
	public ArrayList<Bid> getBidregister(){
		return new ArrayList<Bid>(bidregister);
	}
	public String toString() {
		return String.format("Auction #%d : %s. Top bids: ", number, auctionDog.getName());
	}
	
}
