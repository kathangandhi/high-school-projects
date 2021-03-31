//NOTE - THIS FILE IS FOR PRACTICE - DO NOT USE FOR LABS.
class personTester
{
    public static void main(String args[])
    {
      person person1 = new person();
      person person2 = new person("The Great", "Ruler");
      person person3 = new person("What's", "My Name", 16);
      
      person2.setAge(15);
      
      System.out.println(person1.getName());
      System.out.println(person2.getName());
      System.out.println(person3.getName());
      System.out.println("There are "+person.count+" people");
    }
    
}