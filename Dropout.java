public class Dropout extends Student {
    private int numOfRemainingModules;
    private int numOfMonthsAttended;
    private String dateOfDropout;
    private int remainingAmount;
    private boolean hasPaid;

    // constructor of Dropout Class
    public Dropout(String dateOfBirth, String studentName, int courseDuration, int tuitionFee,
            int numOfRemainingModules, int numOfMonthsAttended, String dateOfDropout) {
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        //setEnrollmentID(01150);
        super.setEnrollmentID(getEnrollmentID());
        super.setCourseName(getCourseName());
        super.setDateOfEnrollment(getDateOfEnrollment());
        //setCourseName("Computing");
        //setDateOfEnrollment("26/01/2020");
        this.numOfRemainingModules = numOfRemainingModules;
        this.numOfMonthsAttended = numOfMonthsAttended;
        this.dateOfDropout = dateOfDropout;
        remainingAmount = 0;
        hasPaid = false;
    }

    // accessor method for numOfRemainingModules
    public int getNumOfRemainingModules() {
        return numOfRemainingModules;
    }

    // accessor method for numOfMonthsAttended
    public int getNumOfMonthsAttended() {
        return numOfMonthsAttended;
    }

    // accessor method for dateOfDropout
    public String getDateOfDropout() {
        return dateOfDropout;
    }

    // accessor method for remainingAmount
    public int getRemainingAmount() {
        return remainingAmount;
    }
    
    public void setRemainingAmount(int remainingAmount){
        this.remainingAmount = remainingAmount;
    }

    // accessor method for hasPaid
    public boolean getHasPaid() {
        return hasPaid;
    }
    
    // method to calculate the remainingAmount
    public void billsPayable() {
        remainingAmount = ((getCourseDuration() - numOfMonthsAttended) * (getTuitionFee()/getCourseDuration()));
        this.remainingAmount = remainingAmount;
        hasPaid = true;
    }
   
    // method to remove the student from the system if the condition is met
    public void removeStudent() {
        if (hasPaid) {  
            setDateOfBirth("") ;
            setCourseName("");
            setStudentName("");
            setDateOfEnrollment("");
            setCourseDuration(0); 
            setTuitionFee(0);     
            setEnrollmentID(0);
            dateOfDropout = "";
            numOfRemainingModules = 0;
            numOfMonthsAttended = 0;
            remainingAmount = 0;
        }
        else
        {
            System.out.println("All bills not cleared");
        }
    }

    // method to display the details of student
    public void display() {
        super.display();
        System.out.println("Number of Remaining Modules :   " + numOfRemainingModules);
        System.out.println("Number of Months Attended   :   " + numOfMonthsAttended);
        System.out.println("Date of Dropout             :   " + dateOfDropout);
        System.out.println("Remaining Amount            :   " + remainingAmount);
        System.out.println();
    }
}
