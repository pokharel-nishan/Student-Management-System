
public class Student{
    private String dateOfBirth;
    private String courseName;
    private String studentName;
    private String dateOfEnrollment;
    private int enrollmentID;
    private int courseDuration;
    private int tuitionFee;
 
    // constructor of Student class
    public Student(String dateOfBirth, String studentName, int courseDuration, int tuitionFee ){
        courseName = "";
        dateOfEnrollment = "";
        enrollmentID = 0;
        this.dateOfBirth = dateOfBirth;
        this.studentName = studentName;
        this.courseDuration = courseDuration;
        this.tuitionFee = tuitionFee;
    }
    
    // accessor method for dateOfBirth
    public String getDateOfBrith(){
        return dateOfBirth;
    }
    
    // mutator method for dateOfBirth
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    
    // accessor method for courseName
    public String getCourseName(){
        return courseName;
    }

    // mutator method for courseName
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    
    // accessor method for studentName
    public String getStudentName(){
        return studentName;
    }

    // mutator method for studentName
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    
    // accessor method for dateOfEnrollment
    public String getDateOfEnrollment(){
        return dateOfEnrollment;
    }

    // mutator method for dateOfEnrollment
    public void setDateOfEnrollment(String dateOfEnrollment){
        this.dateOfEnrollment = dateOfEnrollment;
    }

    // accessor method for enrollmentID
    public int getEnrollmentID(){
        return enrollmentID;
    }

    // mutator method for enrollmentID
    public void setEnrollmentID(int enrollmentID){
        this.enrollmentID = enrollmentID;
    }

    // accessor method for courseDuration
    public int getCourseDuration(){
        return courseDuration;
    }
    
    // mutator method for courseDuration
    public void setCourseDuration(int courseDuration){
        this.courseDuration = courseDuration;
    }

    // accessor method for tuitionFee
    public int getTuitionFee(){
        return tuitionFee;
    }
    
    // mutator method for tuitionFee
    public void setTuitionFee(int tuitionFee){
        this.tuitionFee = tuitionFee; 
    }

    // method to display the details of student if all the condition are met
    public void display(){
        if (dateOfBirth == "" || courseName == "" || studentName == "" || dateOfEnrollment == "" || enrollmentID == 0 || courseDuration == 0 || tuitionFee == 0)
        {
            System.out.println("Some parameters have not been set.");
        }
        else
        {
            System.out.println("Enrollment ID               :   " + enrollmentID);
            System.out.println("Date Of Birth               :   " + dateOfBirth);
            System.out.println("Course Name                 :   " + courseName);
            System.out.println("Student Name                :   " + studentName);
            System.out.println("Years Enrolled              :   " + dateOfEnrollment);
            System.out.println("Course Duration (months)    :   " + courseDuration);
            System.out.println("Tuition Fee                 :   $" + tuitionFee);
        }
    }
}