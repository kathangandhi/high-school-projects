//NOTE - THIS FILE IS FOR PRACTICE - DO NOT USE FOR LABS.
class person
{
    // Variable for description of person
    private String fName;
    private String lName;
    private int age;
    public static int count;
    
    public person()//constructor method
    {
     fName="Blank";
     lName="Blank";
     age=0;
     count++;
    }
    
    public person(String f, String l)//constructor method
    {
     fName=f;
     lName=l;
     age=0;
     count++;
    }
    
    public person(String f, String l, int a)//constructor method
    {
     fName=f;
     lName=l;
     age=a;
     count++;
    }
    
    public void setAge(int a)
    {
     age=a;
    }
    
    public int getAge()
    {
     return age;
    }
    
    public String getName()
    {
     return fName + " " + lName ;
    }
}