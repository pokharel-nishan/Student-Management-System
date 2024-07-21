public class Regular extends Student{
    private int numOfModules;
    private int numOfCreditHours;
    private double daysPresent;
    private boolean isGrantedScholarship;
    
    // constructor of Regular class
    public Regular(int enrollmentID, String dateOfBirth, String courseName, String studentName, String dateOfEnrollment, int courseDuration, int tuitionFee, int numOfModules, int numOfCreditHours, double daysPresent){
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        setCourseName(courseName);
        setDateOfEnrollment(dateOfEnrollment);
        setEnrollmentID(enrollmentID);
        this.numOfModules = numOfModules;
        this.numOfCreditHours = numOfCreditHours;
        this.daysPresent = daysPresent;
        isGrantedScholarship = false;
    }

    // accessor method for numOfModules
    public int getNumOfModules(){
        return numOfModules;
    }

    // accessor method for numOfCreditHours
    public int getNumOfCreditHours(){
        return numOfCreditHours;
    }

    // accessor method for daysPresent
    public double getDaysPresent(){
        return daysPresent;
    }

    // accessor method for isGrantedScholarship
    public boolean getIsGrantedScholarship(){
        return isGrantedScholarship;
    }

        
    
    /*
     * method to calculate the presentPercentage
     * And return the attendance grade if conditions are met.
     */
    public char presentPercentage(int numberOfDaysPresent){
        double presentDays = (double) numberOfDaysPresent;
        double presentPercentage = (presentDays / (getCourseDuration()* 30)) * 100;  
        
        this.daysPresent = numberOfDaysPresent;
        
        if ((getCourseDuration() *30 ) < numberOfDaysPresent || numberOfDaysPresent < 0 ){
            return 0;
        }
        else if (presentPercentage >= 80)
        {   
            isGrantedScholarship = true;
            return 'A';
        } 
        else if (presentPercentage >= 60)
        {
            return 'B';
        } 
        else if (presentPercentage >= 40) 
        {
            return 'C';
        } 
        else if (presentPercentage >= 20) 
        {
            return 'D';
        } 
        else 
        {
            return 'E';
        }
    }

    /*
     * method that is used to display some details of students
     * And display the scholarship granted mmessage if condition is met.
     */
    public void  grantCertificate(String courseName, int enrollmentID, String dateOfEnrollment){
        System.out.println("Student has graduated");
        System.out.println("Course Name     :   " + courseName);
        System.out.println("Enrollment ID   :   " + enrollmentID);
        System.out.println("Date of Enrollment: " + dateOfEnrollment);
    
        if (isGrantedScholarship){
            System.out.println("The scholarship has been granted.");
        }
    }

    // method to display the details of student
    public void display(){
            super.display();
            System.out.println("Number of Modules           :   " + numOfModules);
            System.out.println("Number of Credit Hours      :   " + numOfCreditHours);
            System.out.println("Days Present                :   " + daysPresent);
            System.out.println();
    }
}
