//Kasper Rosenberg
//karo5568
public class Dog1 {
	//Lägg till ny Dog
	
	
	//Attribut
	private String name;
	private String breed;
	private int yearOfBirth;
	private double weight;
	
	public Dog1(String name, String breed, int yearOfBirth, double weight) {
		this.name = name;
		this.breed = breed;
		this.yearOfBirth = yearOfBirth;
		this.weight = weight;
		
		
	}
	
	//Metoder:
	public void setName(String name) {
		this.name= name;
	}
	
	public String getName() {
		return name;
		
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getBreed() {
		return breed;
		
	}
	public void setYearOfBirth() {
		this.yearOfBirth = yearOfBirth;
	}
	
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	
	int getAge() {
		return getAge(2019);
	}
	int getAge(int year) {
		return year - yearOfBirth;
		
	}
	
	public void setWeight(double wieght) {
		this.weight = weight;
	}
	
	public double getWeight(){
		return weight;
	}
	
	
	public double getTailLength(String breed) {
		
		switch(breed) {
		case "tax":
			return 3.7;
		case "dachshund":
			return 3.7;
			
		default: 
			return (getAge() * weight)/10;
		}
	}
	
	//public int updateAge() {
		 
	//}
	
	public String toString() {
		return String.format("name=%s breed=%s yearOfBirth=%d weight=%f age=%d tailLength=%f", name, breed, yearOfBirth, weight, getAge(), getTailLength(breed));
	}

}
