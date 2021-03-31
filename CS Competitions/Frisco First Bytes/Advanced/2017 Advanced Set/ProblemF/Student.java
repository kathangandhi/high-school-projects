package ProblemF;

public class Student implements Comparable{
    private String name;
    private String gpa;
    private String studentID;

    public Student(String name,String gpa,String studentID){
        this.name = name;
        this.gpa = gpa;
        this.studentID = studentID;
    }

    public String getName(){
        return this.name;
    }

    public String getGPA(){
        return this.gpa;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public String toString(){
        return this.name+this.gpa+" "+this.studentID;
    }

    /**
     * @param Object o The object to be compared with
     * @return 
     * -1 if the Object should be placed lower in the list,<br>
     * 1 if the Object should be kept in the list,<br>
     * 0 if the Objects are equal
     */
    public int compareTo(Object o){
        Student other = (Student) o; 
        
        //comparing names alphabetically
        if(this.name.compareTo(other.name) > 0)
            return -1;
        else if(this.name.compareTo(other.name) < 0)
            return 1;
        else{
            //comparing gpas
            if(this.gpa.charAt(0) > other.gpa.charAt(0))
                return -1;
            else if(this.gpa.charAt(0) < other.gpa.charAt(0))
                return 1;
            else{
                if(this.gpa.charAt(1) == '+' && this.gpa.charAt(1) == '-')
                    return 1;
                else if(this.gpa.charAt(1) == '-' && this.gpa.charAt(1) == '+')
                    return -1;
                else{
                    //comparing studentIDs
                    if(Double.parseDouble(this.studentID) > Double.parseDouble(other.studentID))
                        return -1;
                    else if(Double.parseDouble(this.studentID) < Double.parseDouble(other.studentID))
                        return 1; 
                }
            }
        }
        return 0;
    }
}