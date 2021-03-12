//Kasper Rosenberg
//karo5568
import java.util.Scanner;
import java.util.ArrayList;

public class Register {
	private Scanner input = new Scanner(System.in);
	private User[] owners = new User[2];
	// Starta Program
	private void initializeProgram() {
//		// lägg till nya Dogs
//		Dog d1 = new Dog("Henrik", "tax", 10, 28);
//		dogregister.add(d1);
//		Dog d2 = new Dog("Patrik", "dachshund", 5, 12);
//		dogregister.add(d2);
//		Dog d3 = new Dog("Kasper", "labrador", 8, 10);
//		dogregister.add(d3);
//
//		// Lägg till användare
//		User u1 = new User("Husse");
//		userregister.add(u1);
//		u1.addUserDog(d1);
//		User u2 = new User("Viktor");
//		userregister.add(u2);
//		u2.addUserDog(d2);
//		User u3 = new User("Claes");
//		userregister.add(u3);
//		// Lägg till auctions
//		Auction a1 = new Auction(d1);
//		auctionregister.add(a1);
//		dogwithauctionregister.add(d1);
//		Auction a2 = new Auction(d2);
//		auctionregister.add(a2);
//		dogwithauctionregister.add(d2);
//		// Lägg till bids

		System.out.println("Hello! Welcome to the dogregister!");
		System.out.println(" ");
		System.out.println("Type Register new dog to register a new dog.");
		System.out.println("Type Increase Age to increase a dogs age.");
		System.out.println("Type List Dogs to list all dogs in register.");
		System.out.println("Type Remove dog to remove a dog from the register.");
		System.out.println("Type Register new user to register a new user.");
		System.out.println("Type List users to see all users in the register.");
		System.out.println("Type Remove user to remove a user from the register.");
		System.out.println("Type Start auction to start an auction.");
		System.out.println("Type List auctions to see all current auctions.");
		System.out.println("Type Make bid to place a bid in an auction.");
		System.out.println("Type Close auction to end an auction.");
		System.out.println("Type Exit to close the program.");
	}

	private void runCommandLoop() {
		boolean done;
		do {
			String command = readCommand();
			done = handleCommand(command);
		} while (!done);
	}

	// Läsa in input från användare
	private String readCommand() {
//		String name = readControl("Name>");
//		System.out.print("Ange namn på den hund du vill registrera: ");
//		String name = input.nextLine();
		String command = readControl("Command> ");
		return command;
//		System.out.print("Command> ");
//		return input.nextLine();
	}

	private ArrayList<Dog> dogregister = new ArrayList<>();
	//private ArrayList<User> userregister = new ArrayList<>();
	private ArrayList<Dog> dogwithauctionregister = new ArrayList();
	private ArrayList<Auction> auctionregister = new ArrayList<>();

//	public ArrayList<User> getUserregister() {
//		return new ArrayList<User>(userregister);
//	}

//	public ArrayList<Dog> getdogwithauctionregister() {
//		return new ArrayList<Dog>(dogwithauctionregister);
//	}

//	public ArrayList<Auction> getAuctionregister() {
//		return new ArrayList<Auction>(auctionregister);
//	}

//	private void addUser(User u) {
//		userregister.add(u);
//	}

	private void addDog(Dog d) {
		dogregister.add(d);
	}

	private void removeDog() {
		String dogName = readControl("Name>");
//		System.out.println("Ange namnet på hunden du vill ta bort");
//		String dogName = input.nextLine();
		Dog d = findDogByName(dogName);

		if (d != null) {
			dogregister.remove(d);
			System.out.println(dogName + " has been removed.");
		} else {
			System.out.println("Error: no registered dog with that name!");
		}
	}

	private Dog findDogWithAuction(String dogName) {
		for (Dog d : dogwithauctionregister) {
			if (d.getName().equalsIgnoreCase(dogName)) {
				return d;
			}
		}
		return null;
	}

	private Dog findDogByName(String dogName) {

		for (Dog d : dogregister) {
			if (d.getName().equalsIgnoreCase(dogName)) {
				return d;

			}
			// index ++;
			// if(length == index) {
		}
		return null;
	}

	private User findUserByName(String userName) {
		for(int i=0; i<owners.length; i++) {
			if(owners[i]!= null) {
				if(owners[i].getUserName().equals(userName)) {
					return owners[i];
				}
			}
		}
		return null;
		
//		for (User u : userregister) {
//
//			if (u.getUserName().equalsIgnoreCase(userName)) {
//				return u;
//			}
//		}
//		return null;
	}

	private void listDogs() {
		System.out.println("Smallest taillength to display>");
		double angTailLength = input.nextDouble();

		sortDogs();

		for (Dog d : dogregister) {
			if (d.getTailLength() >= (angTailLength)) {
				if (d.getOwner() != null) {
					System.out.print(d + ", owned by ");
					System.out.println(d.getOwner().getUserName());
				} else {
					System.out.println(d);
				}
			}

		}
		input.nextLine();
	}
	private void sortDogs() {
		boolean notSorted = true;
		while (notSorted) {
			notSorted = false;
			for (int i = 0; i < dogregister.size() - 1; i++) {
				Dog first = dogregister.get(i);
				Dog second = dogregister.get(i + 1);
				if (first.compareTo(second) > 0) {
				dogregister.set(i, second);
				dogregister.set(i + 1, first);
				notSorted = true;
			}
		}
	}
	}
	private void registerDog() {
		String name = readControl("Name>");
//		System.out.print("Ange namn på den hund du vill registrera: ");
//		String name = input.nextLine();
		String breed = readControl("Breed>");
//		System.out.print("Ange ras på den hund du vill registrera: ");
//		String breed = input.nextLine();
		System.out.print("Age>");
		int age = input.nextInt();
		System.out.print("Weight>");
		int weight = input.nextInt();
		Dog dd = new Dog(name, breed, age, weight);
		addDog(dd);
		input.nextLine();
		System.out.print(name + " has been added to the register.");
		System.out.println();
	}

	private void increaseAge() {
		int ageIndex = 0;
		int ageLength = dogregister.size();
		String increaseNameAge = readControl("Name> ");
//		System.out.println("Ange namn på den hund du vill ändra åldern på: ");
//		String increaseNameAge = input.nextLine();
		for (Dog d : dogregister) {
			if (d.getName().equalsIgnoreCase(increaseNameAge)) {
				d.updatedAge();
				System.out.println(d.getName() + " is now one year older.");
				break;
			}
			ageIndex++;
			if (ageLength == ageIndex) {
				System.out.println("Error: No dog registered with that name!");
			}
		}

	}

	private String readControl(String message) {
		System.out.println(message);
		String value = input.nextLine();
		while (value.trim().isEmpty()) {
			System.out.println("Error, cant be empty");
			System.out.println(message);
			value = input.nextLine();
		}
		return value.trim().toLowerCase();
	}

	private void registerNewUser() {

		String userName = readControl("Name>");
		User u = new User(userName);
//		addUser(u);
		for(int i =0; i<owners.length; i++) {
			if (owners[i]==null) {
				owners[i] = u;
		System.out.println(userName + " has been added to the register.");
		return;
		// test
		// System.out.println(userregister);

	}
	}
	User[] longerArray = new User [owners.length+2];
	for(int j = 0; j<owners.length; j++){
		longerArray[j] = owners[j];
	}
	owners = longerArray;
	for(int i=0; i<owners.length;i++) {
		if(owners[i]==null) {
			owners[i] = u;
			System.out.println(userName + " has been added to the register.");
			return;
		}
	}
	}
	private void listUsers() {
		boolean empty = true;
		for(int i=0; i<owners.length; i++) {
			if(owners[i]!= null) {
				System.out.println(owners[i]);
				empty = false;
			}
		}
		if (empty) {
			System.out.println("Error: No users in the register!");
		}
	}
//		if (userregister.isEmpty()) {
//			System.out.println("Error: No users in the register!");
//		}
//		for (User u : userregister) {
//			System.out.println(u);
//		}


	private void removeUser() {
		String userName = readControl("Name>");
		User u = findUserByName(userName);
		for(int i =0; i<owners.length; i++) {
			if(owners[i]==u) {
				for (Dog d : u.getOwnedDogs()) {
					d.setOwner(null);
				}
				for(Auction a : auctionregister) {
					for(Bid b : a.getBidregister()) {
						if(b.getUser() == u) {
							a.removeBid(b);
						}
					}
				}
				owners[i] = null;
				System.out.println(userName + " has been removed.");
				return;
			}
		}
		System.out.println("Error: No registered user with that name!");
		
//		if (u != null) {
//			userregister.remove(u);
//			for (Dog d : u.getOwnedDogs()) {
//				d.setOwner(null);
//			}	
//			for (Auction a : auctionregister) {
//				for(Bid b : a.getBidregister()) {
//					if(b.getUser() == u) {
//						a.removeBid(b);	
//					}
//				}
//			}
//			System.out.println(userName + " has been removed.");
//		} 
		//else {
		//	System.out.println("Error: No registered user with that name!");
	//	}
	}

	private void startAuction() {
		String dogName = readControl("Enter the name of the dog: ");
//		System.out.println("Ange namnet på den hund du vill starta en auction för: ");
//		String dogName = input.nextLine();
		Dog d = findDogByName(dogName);
		if (d != null && findAuctionByName(d) != null) {
			System.out.println("Error: " + d.getName() + " is already up for sale!");
		} else if (d != null && findAuctionByName(d) == null) {
			if (d.getOwner() != null) {
				System.out.println("Error: " + dogName + " already has an owner!");
				return;
			}
//			for (User u : userregister) {
//				if (u.getOwnedDogs().contains(d)) {
//					System.out.println("Fel, hunden har redan en ägare");
//					return;
//				}// else if (!u.getOwnedDogs().contains(d)) {
//					
//			}
			Auction a = new Auction(d);
			auctionregister.add(a);
			dogwithauctionregister.add(d);
			System.out.println("Auction started.");
			// }

		} else {
			System.out.println("Error: no registered dog with that name!");
		}
	}

//	public void addOwner(Dog d) {
//
//	}
//
//	public void removeOwner(Dog d) {
//
//	}

	private void listAuctions() {
		if (auctionregister.isEmpty()) {
			System.out.println("Error: No current auctions!");
		} else {
			for (Auction a : auctionregister) {
				boolean empty = true;
				int k = 0;
				for (int i = 0; i < a.sortThreeHighestBids().length; i++) {
					if (a.sortThreeHighestBids()[i] != null) {
							if(i<1) {
								System.out.print(a);
							}
						System.out.print(a.sortThreeHighestBids()[i] + ", ");
						empty = false;
					} if (empty && k < 1) {
						System.out.println(a);
						k++;
					}
				} System.out.println();
			}
		}
	}

	private void closeAuction() {
		String dogForSale = readControl("Enter the name of the dog: ");
		Dog soldDog = findDogByName(dogForSale);
		if (soldDog == null) {
			System.out.println("Error: this dog is not up for auction!");
			return;
		}
		Auction closedAuction = findAuctionByName(soldDog);
		if (closedAuction == null) {
			System.out.println("Error: this dog is not up for auction!");
			return;
		}
		int winningPrice = closedAuction.getHighestBid();
		Bid winningBid = closedAuction.getWinningBid();
		if (winningBid != null) {
			User winner = winningBid.getUser();
			String winnerString = winner.getUserName();
			System.out.println("The auction is closed. The winning bid was " + winningPrice + "kr and was made by "
					+ winnerString);
			winner.addUserDog(soldDog);
			soldDog.setOwner(winner);
		} else {
			System.out.println("The auction is closed, no bids where made for " + soldDog.getName());
		}
		auctionregister.remove(closedAuction);
	}

	private Auction findAuctionByName(Dog d) {
		for (Auction a : auctionregister) {
			if (a.getAuctionDog().equals(d)) {
				return a;
			}
		}
		return null;
	}
	
	private void makeBid(User bidder, int bid, Dog d) {
		Bid b = new Bid(bidder, bid);
		findAuctionByName(d).addBid(b);
		System.out.println("Bid made");
	}

	private void makeBid() {
		String userName = readControl("Enter the name of the user: ");
		User bidder = findUserByName(userName);
		//if (bidder != null) {
		for (int i=0; i<owners.length; i++) {
			if (owners[i] != null) {
				if (owners[i].equals(bidder)) {
			
			String dogName = readControl("Enter the name of the dog: ");
			Dog d = findDogWithAuction(dogName);
			if (d != null) {
				// ta input för att göra ett bud
				System.out.println("Amount to bid: " + "min " + (findAuctionByName(d).getHighestBid() + 1) + ")");
				int bid = input.nextInt();
				input.nextLine();
				Auction a = findAuctionByName(d);
				// Kolla så att budet inte är lägre än befintligt
				while (bid <= a.getHighestBid()) {
					System.out.println("Error: To low bid!");
					System.out.println("Amount to bid: " + "min " + (findAuctionByName(d).getHighestBid() + 1) + ")");
					bid = input.nextInt();
					input.nextLine();
				}
				// Om det finns befintligt bud från samma user, ta bort bid
				Bid existingBid = a.findBid(bidder);
				if (existingBid != null) {
					a.removeBid(existingBid);
				}
				makeBid(bidder,bid,d);
//				Bid b = new Bid(bidder, bid);
//				findAuctionByName(d).addBid(b);
//				System.out.println("Bid made");
				return;
			} else {
				System.out.println("Error: This dog is not up for auction");
				return;
			}
		} 
		}
	}
		System.out.println("Error: no registered user with that name!");
	}
	private void listBids() {
		String listBidsForDog = readControl("Enter the name of the dog: ");
		Dog d = findDogWithAuction(listBidsForDog);
		if (d != null) {
			// skriv ut bids
			Auction a = findAuctionByName(d);
			if (findAuctionByName(d) == null) {
				System.out.println("Error: this dog is not up for auction.");
			}
			if (a.getBidregister().isEmpty()) {
				System.out.println("No bids registered for this auction.");
			} else {
				a.sortBids();
				System.out.println("Here are the bids for this auction: ");
				for (Bid b : a.getBidregister()) {
					System.out.println(b);
				}
			}
		}else {
			System.out.println("Error, there is no dog with that name");
		}
	}

	// Hantera input
	private boolean handleCommand(String command) {
		switch (command) {
		// Register New Dog
		case "register new dog":
			registerDog();
			break;
		// return false;

		case "increase age":
			increaseAge();
			break;
		// return false;

		case "list dogs":
			listDogs();
			break;
		// return false;

		case "remove dog":
			removeDog();
			break;

		case "register new user":
			registerNewUser();
			break;

		case "list users":
			listUsers();
			break;

		case "remove user":
			removeUser();
			break;

		case "start auction":
			startAuction();
			break;

		case "list auctions":
			listAuctions();
			break;
		case "close auction":
			closeAuction();
			break;
		case "make bid":
			makeBid();
			break;
		case "list bids":
			listBids();
			break;
		// exit
		case "exit":
			return true;

		default:
			System.out.println("Error: No such option!");
			break;
		// return false;
		}
		return false;
	}

	// Exit program (Få !done att bli true)
	private void closeProgram() {
		System.out.println("Thank you! Please come again!");

	}

	private void runProgram() {
		initializeProgram();
		runCommandLoop();
		closeProgram();
	}

	public static void main(String[] args) {
		new Register().runProgram();

	}

}