//Kasper Rosenberg
//karo5568
import java.util.ArrayList;
public class User {
	
	private String userName;
	private ArrayList<Dog> ownedDogs = new ArrayList<>();
	
	
public User(String userName) {
	this.userName = userName;
}

public void addUserDog(Dog d) {
	ownedDogs.add(d);
}
public void removeUserDog(Dog d) {
	ownedDogs.remove(d);
	}
public ArrayList<Dog> getOwnedDogs(){
	return new ArrayList<Dog>(ownedDogs);
}
public String getUserName() {
	return userName;
}

private ArrayList<String> dogStringList(){
	ArrayList<String> list = new ArrayList<>();
	for(Dog d : ownedDogs) {
		list.add(d.getName());
	}
	return list;
}
public String toString() {
	return String.format("%s %s", userName, dogStringList());
}
}
