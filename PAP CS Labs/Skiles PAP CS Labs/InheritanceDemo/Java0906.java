// Java0906.java
// This program demonstrates inheritance at three levels.


public class Java0906
{
	public static void main(String args[])
	{
		System.out.println("Class Inheritance");
		Cat c = new Cat("Tiger");//calls all three constructors
		c.age=5;
		System.out.println(c.getAge());//protected can be accessed by extended class.
		
		
		
		
	}
}


class Animal 
{
	protected int age;

	public Animal()
	{
		System.out.println("Animal Constructor Called");
		age = 15;
	}

	public int getAge()
	{
		return age;
	}
}


class Mammal extends Animal
{
	protected int weight;

	public Mammal()
	{
		System.out.println("Mammal Constructor Called");
		weight = 500;
	}

	public int getWeight()
	{
		return weight;
	}
}


class Cat extends Mammal
{
	protected String type;

	public Cat(String t)
	{
		System.out.println("Cat Constructor Called");
		type = t;
	}

	public String getType()
	{
		return type;
	}
}



