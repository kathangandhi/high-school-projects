import java.util.*;
public class Student implements Comparable<Student>{
    private String name;
    private int studentID;

    public Student(String name, int studentID){
        this.name = name;
        this.studentID = studentID;
    }

    public String getName(){
        return name;
    }

    public int getStudentID(){
        return studentID;
    }

    @Override
    public String toString(){
        return studentID+": "+name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student other = (Student) obj;
            if(this.studentID == other.studentID)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    //     @Override
    //     public int compareTo(Student s){
    //         if(this.studentID > s.studentID)
    //             return 1;
    //         else if(this.studentID < s.studentID)
    //             return -1;
    //         return 0;
    //     }
    
    @Override
    public int compareTo(Student s){
        return this.name.compareTo(s.name);
    }
    
    public static void sort(List<Student> students){
        boolean sorted = true;
        while(sorted){
            int count = 0;
            for(int s = 1; s < students.size(); s++){
                for(int i = s; i >= 1; i--){
                    if(students.get(i).compareTo(students.get(i-1)) < 0){
                        swap(i,i-1,students);
                        count++;
                    }
                    else
                        break;
                }
            }
            
            if(count == 0)
                sorted = false;
        }
    }
    
    /**
     * Swaps values at index i and j
     * @param i First index
     * @param j Second index
     */
    private static void swap(int i, int j, List<Student> students){
        Student og = students.get(j);
        students.set(j,students.get(i));
        students.set(i,og);
    }
}
