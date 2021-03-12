//Kasper Rosenberg
//karo5568
//import java.util.ArrayList;

public class Dog implements Comparable<Dog>{
	//Lägg till ny Dog
	
	//Attribut
	private String name;
	private String breed;
	private int age;
	private User owner;
	private int weight;
	//private double tailLength;
	//private int updatedAge;
	
	public Dog(String name, String breed, int age, int weight) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	//	this.yearOfBirth = yearOfBirth;
		this.weight = weight;
		//this.tailLength = tailLength;
	}
	
	//Metoder:
	public String getName() {
		return name;		
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User u) {
		this.owner = u;
	}
	public String getBreed() {
		return breed;
		
	}
	public int getAge() {
		return age;
	}

	public int getWeight(){
		return weight;
	}
	

	public double getTailLength() {
		
		switch(breed.toLowerCase()) {
		case "tax":
			return 3.7;
//		case "Tax":
//		    return 3.7;
		case "dachshund":
			return 3.7;
//		case "Dachshund":
//		    return 3.7;
			
		default:
			return (age * weight)/10.0;
		}
	}
	
	public void updatedAge() {
	    age++;
	 }
	
	public String toString() {
		return String.format("%s (%s, %d years, %d kilo, %.2f cm tail)", name, breed, age, weight, getTailLength());
	}

	@Override
	public int compareTo(Dog other) {
		double tail = this.getTailLength()-other.getTailLength();
		if(tail > 0) {
			return 1;
		}else if(tail < 0) {
			return -1;
		}else {
			int letter = name.compareTo(other.name);
			return letter;
		}		
	}

}
