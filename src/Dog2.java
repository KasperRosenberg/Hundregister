//Johan Hellström johe3082

public class Dog2 {

	private String name;
	private String breed;
	private int age;
	private int yearOfBirth;
	private double weight;
	private int year;
	private double tailLength;
		//Metoder:
public Dog2(String name, String breed, int yearOfBirth, double weight) {
	//this.name = name;
	//this.breed = breed;
	this.age = age;
	this.weight = weight;
	//this.yearOfBirth = yearOfBirth;
	this.tailLength = tailLength;
}
public String getName() {
	return name;	
}
public void setName(String name) {
	this.name = name;
}
public String getBreed() {
	return breed;	
}
public void setBreed(String breed) {
	this.breed = breed;
}
public int getYearOfBirth() {
	return yearOfBirth;
}
public void setYearOfBirth(int yearOfBirth) {
	this.yearOfBirth = yearOfBirth;
}

public int getAge() {
	return getAge(2019);
}
public int getAge(int year) {
	//return year - yearOfBirth;
	age = year - yearOfBirth;
	return age;
}
public double getWeight() {
	return weight;
	
}
/*public void setTailLength(String breed) {
	this.tailLength = tailLength;
	
}*/
public double getTailLength() {
	switch (breed) {
	case "tax":
		return 3.7;
	case "dachshund":
		return 3.7;
	default:
	//svanslängd = (ålder * vikt)/10
		double tailLength = (getAge() * weight)/10;
		return tailLength;
	}
	
}
public void updateAge() {
	
}
public String toString() {
	return String.format("name=%s breed=%s yearOfBirth=%d weight=%f age=%d", name, breed, yearOfBirth, weight, getAge());
}
//public void getToString() {
// age=%d weight=%d   , age, weight     , int age, double weight
	
//}
}
