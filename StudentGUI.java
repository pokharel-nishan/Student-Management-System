import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Iterator;

public class StudentGUI implements ActionListener{
    // main frame
    private JFrame frame;
    // tabbed pane for holding regular and dropout student panel
    private JTabbedPane tabbedPane;
    // panel for regular student and dropout student
    private JPanel regularStudentPanel, dropoutStudentPanel;
    
    // labels for regular student
    private JLabel regular_label_enrollmentId, regular_label_studentName, regular_label_dateOfBirth, 
    regular_label_courseName, regular_label_courseDuration, regular_label_numModules, regular_label_dateOfEnrollment,
    regular_label_numCreditHours, regular_label_numDaysPresent, regular_label_tuitionFee;
    
    // text fields for regular student
    private JTextField regular_text_enrollmentId, regular_text_studentName, regular_text_courseName, regular_text_courseDuration,
    regular_text_numModules, regular_text_numCreditHours, regular_text_numDaysPresent,regular_text_tuitionFee;
    
    // combo boxes for regular student
    private JComboBox<String> regular_comboBox_DOB_year, regular_comboBox_DOB_month, regular_comboBox_DOB_day,
    regular_comboBox_DOE_year, regular_comboBox_DOE_month, regular_comboBox_DOE_day;
    
    // buttons for regular student
    private JButton addRegularStudent, calculatePresentPercentage, 
    grantCertificate, regular_displayDetails, regular_clear;

    // labels for dropout student
    private JLabel dropout_label_enrollmentId, dropout_label_studentName, dropout_label_dateOfBirth, dropout_label_courseName, 
    dropout_label_tuitionFee, dropout_label_courseDuration, dropout_label_numRemainingModules, dropout_label_dateOfEnrollment,
    dropout_label_numMonthsAttended, dropout_label_dateOfDropout, dropout_label_remainingAmount;
    
    // text fields for dropout student
    private JTextField dropout_text_enrollmentId, dropout_text_studentName, dropout_text_courseName, dropout_text_courseDuration,
    dropout_text_numRemainingModules, dropout_text_numMonthsAttended, dropout_text_remainingAmount,dropout_text_tuitionFee;
    
    // combo boxes for dropout student
    private JComboBox<String> dropout_comboBox_DOB_year, dropout_comboBox_DOB_month, dropout_comboBox_DOB_day,
    dropout_comboBox_DOE_year, dropout_comboBox_DOE_month, dropout_comboBox_DOE_day, dropout_comboBox_DOD_year,
    dropout_comboBox_DOD_month, dropout_comboBox_DOD_day;
    
    // buttons for dropout student
    private JButton dropout_clear, dropout_displayDetails, addDropoutStudent,
    removeStudent, payBills;
    
    // Regular Class: Calculate Present Percentage frame
    private JFrame presentPercentageFrame;
    private JTextField PP_text_enrollmentId, PP_text_numPresentDays;
    private JButton PP_calculate_presentPercentage;
    private JLabel PP_enrollmentId,PP_numPresentDays;
    
    // Regular Class: Grant Certificate frame
    private JFrame grantCertificateFrame;
    private JLabel GC_enrollmentId, GC_courseName, GC_dateOfEnrollment;
    private JTextField GC_text_enrollmentId, GC_text_courseName;
    private JComboBox<String> GC_comboBox_DOE_year, GC_comboBox_DOE_month, GC_comboBox_DOE_day;
    private JButton GC_grantCertificate;
    
    // Dropout Class: Pay Bills frame
    private JFrame payBillsFrame;
    private JLabel PB_enrollmentId;
    private JTextField PB_text_enrollmentId;
    private JButton PB_payBills;
    
    // Dropout Class: Remove Student frame
    private JFrame removeStudentFrame;
    private JTextField RS_text_enrollmentId;
    private JLabel RS_enrollmentId;
    private JButton RS_removeStudent;
    
    // arraylist to store objects of type Student
    private ArrayList<Student> list = new ArrayList<Student>();
    
    private Color skyBlue, lightRed, mintGreen, orchidOrange, limaBean, white, paleTurquoise;
    private Font labelFont, buttonFont;
    
    // constructor for StudentGUI class
    public StudentGUI(){
        // initializing a new JFrame with title "Student Details"
        frame = new JFrame("Student Details");
        // initializing a new JTabbedPane 
        tabbedPane = new JTabbedPane();
        // initializing a JPanel for regular student
        regularStudentPanel = new JPanel();
        // initializing a JPanel for dropout student
        dropoutStudentPanel = new JPanel();
        
        // initializing the instances of color
        skyBlue = new Color(0, 50, 255, 1);
        lightRed = new Color(238, 144, 144, 50);
        mintGreen = new Color(166, 251, 178);
        orchidOrange = new Color(255, 161, 128);
        limaBean = new Color(255, 213, 144);
        white = new Color(255, 255, 255);
        paleTurquoise = new Color(165, 251, 213);
        
        //initializing the instances of font
        labelFont = new Font("Times new roman",Font.PLAIN, 16);
        buttonFont = new Font("Times new roman", Font.BOLD, 15);
        
        
        // Regular Student panel: label and text field for Enrollment Id
        regular_label_enrollmentId = new JLabel("Enrollment ID:");
        regular_label_enrollmentId.setBounds(20, 50, 100, 25);
        regular_label_enrollmentId.setFont(labelFont);
        regular_text_enrollmentId = new JTextField();
        regular_text_enrollmentId.setBounds(180, 50, 80, 25);
        
        // Regular Student panel: label and text field for Student Name
        regular_label_studentName = new JLabel("Student Name:");
        regular_label_studentName.setBounds(20, 100, 100, 25);
        regular_label_studentName.setFont(labelFont);
        regular_text_studentName = new JTextField();
        regular_text_studentName.setBounds(180, 100, 200, 25);
        
        // Regular Student panel: label for date of birth
        regular_label_dateOfBirth = new JLabel("Date of Birth:");
        regular_label_dateOfBirth.setBounds(480, 100, 100, 25);
        regular_label_dateOfBirth.setFont(labelFont);
        
        // array to store year from 1990 to 2023
        String[] array_year = new String[34];
        for (int i = 0; i < array_year.length; i++){
            array_year[i] = String.valueOf(1990 + i);
        }
       
        // array to store month from 1 to 12
        String[] array_month = new String[12];
        for (int i = 1; i <= array_month.length; i++){
            array_month[i - 1] = String.valueOf(i);
        }
        
        // array to store days from 1 to 32
        String[] array_day = new String[32];
        for (int i = 1; i <= array_day.length; i++){
            array_day[i - 1] = String.valueOf(i);
        }
       
        // Regular Student panel: combo box for date of birth (year)
        regular_comboBox_DOB_year = new JComboBox<String>(array_year);
        regular_comboBox_DOB_year.setBounds(640, 100, 80, 25);
        regular_comboBox_DOB_year.setBackground(white); 
        
        // Regular Student panel: combo box for date of birth (month)
        regular_comboBox_DOB_month = new JComboBox<String>(array_month);
        regular_comboBox_DOB_month.setBounds(740, 100, 60, 25);
        regular_comboBox_DOB_month.setBackground(white);
        
        // Regular Student panel: combo box for date of birth (day)
        regular_comboBox_DOB_day = new JComboBox<String>(array_day);
        regular_comboBox_DOB_day.setBounds(820, 100, 50, 25);
        regular_comboBox_DOB_day.setBackground(white);
        
        // Regular Student panel: label and text field for Course Name
        regular_label_courseName = new JLabel("Course Name:");
        regular_label_courseName.setBounds(20, 150, 100, 25);
        regular_label_courseName.setFont(labelFont);
        regular_text_courseName = new JTextField();
        regular_text_courseName.setBounds(180, 150, 200, 25);
        
        // Regular Student panel: label and text field for Course Duration
        regular_label_courseDuration = new JLabel("Course Duration (months):"); 
        regular_label_courseDuration.setBounds(480, 150, 200, 25);
        regular_label_courseDuration.setFont(labelFont);
        regular_text_courseDuration = new JTextField();
        regular_text_courseDuration.setBounds(640, 150, 200, 25);
        
        // Regular Student panel: label and text field for Tuition Fee
        regular_label_tuitionFee = new JLabel("Tuition Fee:");
        regular_label_tuitionFee.setBounds(20, 200, 150, 25);
        regular_label_tuitionFee.setFont(labelFont);
        regular_text_tuitionFee = new JTextField();
        regular_text_tuitionFee.setBounds(180, 200, 200, 25);
    
        // Regular Student panel: label for Date of Enrollment
        regular_label_dateOfEnrollment = new JLabel("Date of Enrollment:");
        regular_label_dateOfEnrollment.setBounds(480, 200, 125, 25);
        regular_label_dateOfEnrollment.setFont(labelFont);
        
        // Regular Student panel: combo box for Date of Enrollment (year)
        String[] enrollment_years = {"2018", "2019", "2020", "2021", "2022", "2023"};
        regular_comboBox_DOE_year = new JComboBox<String>(enrollment_years);
        regular_comboBox_DOE_year.setBounds(640, 200, 80, 25);
        regular_comboBox_DOE_year.setBackground(white);
        
        // Regular Student panel: combo box for Date of Enrollment (month)
        regular_comboBox_DOE_month = new JComboBox<String>(array_month);
        regular_comboBox_DOE_month.setBounds(740, 200, 60, 25);
        regular_comboBox_DOE_month.setBackground(white);
        
        // Regular Student panel: combo box for Date of Enrollment (day)
        regular_comboBox_DOE_day = new JComboBox<String>(array_day);
        regular_comboBox_DOE_day.setBounds(820, 200, 50, 25);
        regular_comboBox_DOE_day.setBackground(white);
        
        // Regular Student panel: label and text field for Number of Modules
        regular_label_numModules = new JLabel("Number of Modules:"); 
        regular_label_numModules.setBounds(20, 250, 170, 25);
        regular_label_numModules.setFont(labelFont);
        regular_text_numModules = new JTextField();
        regular_text_numModules.setBounds(180, 250, 200, 25);
        
        // Regular Student panel: label and text field for Number of Credit Hours
        regular_label_numCreditHours = new JLabel("Number of Credit Hours: "); 
        regular_label_numCreditHours.setBounds(480, 250, 160, 25);
        regular_label_numCreditHours.setFont(labelFont);
        regular_text_numCreditHours = new JTextField();
        regular_text_numCreditHours.setBounds(640, 250, 200, 25);
        
        // Regular Student panel: label and text field for Number of Days Present
        regular_label_numDaysPresent = new JLabel("Number of Days Present:"); 
        regular_label_numDaysPresent.setBounds(20, 300, 160, 25);
        regular_label_numDaysPresent.setFont(labelFont);
        regular_text_numDaysPresent = new JTextField();
        regular_text_numDaysPresent.setBounds(180, 300, 200, 25);
        
    
        
        // Regular Student panel: Clear button to clear all the inputs of regularStudentPanel
        regular_clear = new JButton("Clear");
        regular_clear.setBounds(530, 370, 100, 30);
        regular_clear.setBackground(mintGreen);
        regular_clear.setFont(buttonFont);
        // register listener
        regular_clear.addActionListener(this);
        
        // Regular Student panel: display button to display all the information of students
        regular_displayDetails = new JButton("Display"); 
        regular_displayDetails.setBounds(650, 370, 100, 30);
        regular_displayDetails.setBackground(limaBean);
        regular_displayDetails.setFont(buttonFont);
        // register listener
        regular_displayDetails.addActionListener(this);
        
        // Regular Student panel: Add button to add all the information of student
        addRegularStudent = new JButton("Add");
        addRegularStudent.setBounds(770, 370, 100, 30);
        addRegularStudent.setBackground(orchidOrange);
        addRegularStudent.setFont(buttonFont);
        // register listener
        addRegularStudent.addActionListener(this);
        
        // Regular Student panel: calculate present percentage button to open secondary frame
        calculatePresentPercentage = new JButton("Calculate Present Percentage");
        calculatePresentPercentage.setBounds(20, 370, 300, 30);
        calculatePresentPercentage.setFont(buttonFont);
        // register listener
        calculatePresentPercentage.addActionListener(this);
        
        // Regular Student panel: grant certificate button to open secondary frame
        grantCertificate = new JButton("Grant Certificate");
        grantCertificate.setBounds(20, 410, 200, 30);
        grantCertificate.setFont(buttonFont);
        //register listner
        grantCertificate.addActionListener(this);
        
        
        // Adding components to the Regular Student Panel
        // Label and TextField
        regularStudentPanel.add(regular_label_studentName);
        regularStudentPanel.add(regular_text_studentName);
        regularStudentPanel.add(regular_label_enrollmentId);
        regularStudentPanel.add(regular_text_enrollmentId);
        regularStudentPanel.add(regular_label_courseName);
        regularStudentPanel.add(regular_text_courseName);
        regularStudentPanel.add(regular_label_courseDuration);
        regularStudentPanel.add(regular_text_courseDuration);
        regularStudentPanel.add(regular_label_tuitionFee);
        regularStudentPanel.add(regular_text_tuitionFee);
        regularStudentPanel.add(regular_label_numModules);
        regularStudentPanel.add(regular_text_numModules);
        regularStudentPanel.add(regular_label_numCreditHours);
        regularStudentPanel.add(regular_text_numCreditHours);
        regularStudentPanel.add(regular_label_numDaysPresent);
        regularStudentPanel.add(regular_text_numDaysPresent);
        // ComboBox
        regularStudentPanel.add(regular_label_dateOfBirth);
        regularStudentPanel.add(regular_comboBox_DOB_year);
        regularStudentPanel.add(regular_comboBox_DOB_month);
        regularStudentPanel.add(regular_comboBox_DOB_day);
        regularStudentPanel.add(regular_label_dateOfEnrollment);
        regularStudentPanel.add(regular_comboBox_DOE_year);
        regularStudentPanel.add(regular_comboBox_DOE_month);
        regularStudentPanel.add(regular_comboBox_DOE_day);
        // buttons
        regularStudentPanel.add(addRegularStudent);
        regularStudentPanel.add(regular_displayDetails);
        regularStudentPanel.add(regular_clear);
        regularStudentPanel.add(calculatePresentPercentage);
        regularStudentPanel.add(grantCertificate);
        
        
        
        // Dropout Student panel: label and text field for Enrollment Id
        dropout_label_enrollmentId = new JLabel("Enrollment ID:");
        dropout_label_enrollmentId.setBounds(20, 50, 100, 25);
        dropout_label_enrollmentId.setFont(labelFont);
        dropout_text_enrollmentId = new JTextField();
        dropout_text_enrollmentId.setBounds(180, 50, 80, 25);
        
        // Dropout Student panel: label and text field for Student Name
        dropout_label_studentName = new JLabel("Student Name:");
        dropout_label_studentName.setBounds(20, 100, 100, 25);
        dropout_label_studentName.setFont(labelFont);
        dropout_text_studentName = new JTextField();
        dropout_text_studentName.setBounds(180, 100, 200, 25);
        
        // Dropout Student panel: label for Date of Birth
        dropout_label_dateOfBirth = new JLabel("Date of Birth:");
        dropout_label_dateOfBirth.setBounds(480, 100, 100, 25);
        dropout_label_dateOfBirth.setFont(labelFont);
        
        // Dropout Student panel: combo box for Date of Birth (year)
        dropout_comboBox_DOB_year = new JComboBox<String>(array_year);
        dropout_comboBox_DOB_year.setBounds(640, 100, 80, 25);
        dropout_comboBox_DOB_year.setBackground(white);
        
        // Dropout Student panel: combo box for Date of Birth (month)
        dropout_comboBox_DOB_month = new JComboBox<String>(array_month);
        dropout_comboBox_DOB_month.setBounds(740, 100, 60, 25);
        dropout_comboBox_DOB_month.setBackground(white);
        
        // Dropout Student panel: combo box for Date of Birth (day)
        dropout_comboBox_DOB_day = new JComboBox<String>(array_day);
        dropout_comboBox_DOB_day.setBounds(820, 100, 50, 25);
        dropout_comboBox_DOB_day.setBackground(white);
        
        // Dropout Student panel: label and text field for Course Name
        dropout_label_courseName = new JLabel("Course Name:");
        dropout_label_courseName.setBounds(20, 150, 100, 25);
        dropout_label_courseName.setFont(labelFont);
        dropout_text_courseName = new JTextField();
        dropout_text_courseName.setBounds(180, 150, 200, 25);
        
        // Dropout Student panel: label and text field for Course Duration
        dropout_label_courseDuration = new JLabel("Course Duration (months):"); 
        dropout_label_courseDuration.setBounds(480, 150, 200, 25);
        dropout_label_courseDuration.setFont(labelFont);
        dropout_text_courseDuration = new JTextField();
        dropout_text_courseDuration.setBounds(640, 150, 200, 25);
       
        // Dropout Student panel: label and text field for Tuition Fee
        dropout_label_tuitionFee = new JLabel("Tuition Fee:");
        dropout_label_tuitionFee.setBounds(20, 200, 150, 25);
        dropout_label_tuitionFee.setFont(labelFont);
        dropout_text_tuitionFee = new JTextField();
        dropout_text_tuitionFee.setBounds(180, 200, 200, 25);
        
        // Dropout Student panel: label for Date of Enrollment
        dropout_label_dateOfEnrollment = new JLabel("Date of Enrollment:");
        dropout_label_dateOfEnrollment.setBounds(480, 200, 125, 25);
        dropout_label_dateOfEnrollment.setFont(labelFont);
        
        // Dropout Student panel: combo box for Date of Enrollment (year)
        dropout_comboBox_DOE_year = new JComboBox<String>(enrollment_years);
        dropout_comboBox_DOE_year.setBounds(640, 200, 80, 25);
        dropout_comboBox_DOE_year.setBackground(white);
        
        // Dropout Student panel: combo box for Date of Enrollment (month)
        dropout_comboBox_DOE_month = new JComboBox<String>(array_month);
        dropout_comboBox_DOE_month.setBounds(740, 200, 60, 25);
        dropout_comboBox_DOE_month.setBackground(white);
        
        // Dropout Student panel: combo box for Date of Enrollment (day)
        dropout_comboBox_DOE_day = new JComboBox<String>(array_day);
        dropout_comboBox_DOE_day.setBounds(820, 200, 50, 25);
        dropout_comboBox_DOE_day.setBackground(white);
        
        // Dropout Student panel: label and text field for Number of Remaining Modules
        dropout_label_numRemainingModules = new JLabel("Remaining Modules:"); 
        dropout_label_numRemainingModules.setBounds(20, 250, 170, 25);
        dropout_label_numRemainingModules.setFont(labelFont);
        dropout_text_numRemainingModules = new JTextField();
        dropout_text_numRemainingModules.setBounds(180, 250, 200, 25);
        
        // Dropout Student panel: label for Date of Dropout
        dropout_label_dateOfDropout = new JLabel("Date of Dropout:"); 
        dropout_label_dateOfDropout.setBounds(480, 250, 160, 25);
        dropout_label_dateOfDropout.setFont(labelFont);
        
        // Dropout Student panel: combo box for Date of Dropout (year)
        String[] dropout_years = {"2020", "2021", "2022", "2023"};
        dropout_comboBox_DOD_year = new JComboBox<String>(dropout_years);
        dropout_comboBox_DOD_year.setBounds(640, 250, 80, 25);
        dropout_comboBox_DOD_year.setBackground(white);
        
        // Dropout Student panel: combo box for Date of Dropout (month)
        dropout_comboBox_DOD_month = new JComboBox<String>(array_month);
        dropout_comboBox_DOD_month.setBounds(740, 250, 60, 25);
        dropout_comboBox_DOD_month.setBackground(white);
        
        // Dropout Student panel: combo box for Date of Dropout (day)
        dropout_comboBox_DOD_day = new JComboBox<String>(array_day);
        dropout_comboBox_DOD_day.setBounds(820, 250, 50, 25);
        dropout_comboBox_DOD_day.setBackground(white);
        
        // Dropout Student panel: label and text field for Number of Months Attended
        dropout_label_numMonthsAttended = new JLabel("Months Attended: "); 
        dropout_label_numMonthsAttended.setBounds(20, 300, 160, 25);
        dropout_label_numMonthsAttended.setFont(labelFont);
        dropout_text_numMonthsAttended = new JTextField();
        dropout_text_numMonthsAttended.setBounds(180, 300, 200, 25);
        
        // Dropout Student panel: label and text field for Remaining Amount
        dropout_label_remainingAmount = new JLabel("Remaining Amount:"); 
        dropout_label_remainingAmount.setBounds(480, 300, 160, 25);
        dropout_label_remainingAmount.setFont(labelFont);
        dropout_text_remainingAmount = new JTextField();
        dropout_text_remainingAmount.setBounds(640, 300, 200, 25);
        

        
        // / Dropout Student panel: Clear button to clear all the inputs of dropoutStudent
        dropout_clear = new JButton("Clear");
        dropout_clear.setBounds(530, 380, 100, 30);
        dropout_clear.setBackground(mintGreen);
        dropout_clear.setFont(buttonFont);
        // register listener
        dropout_clear.addActionListener(this);
        
        // Dropout Student panel: display button to display all the information of students
        dropout_displayDetails = new JButton("Display"); 
        dropout_displayDetails.setBounds(650, 380, 100, 30);
        dropout_displayDetails.setBackground(limaBean);
        dropout_displayDetails.setFont(buttonFont);
        // register listener
        dropout_displayDetails.addActionListener(this);
        
        // Dropout Student panel: Add button to add all the information of dropoutStudent
        addDropoutStudent = new JButton("Add");
        addDropoutStudent.setBounds(770, 380, 100, 30);
        addDropoutStudent.setBackground(orchidOrange);
        addDropoutStudent.setFont(buttonFont);
        // register listener
        addDropoutStudent.addActionListener(this);
       
        
        // Dropout Student panel: pay bills button to open secondary frame
        payBills = new JButton("Pay Bills");
        payBills.setBounds(20, 380, 150, 30);
        payBills.setFont(buttonFont);
        //register listner
        payBills.addActionListener(this);
        
        // Dropout Student panel: remove student button to open secondary frame
        removeStudent = new JButton("Remove Student");
        removeStudent.setBounds(20, 420, 200, 30);
        removeStudent.setFont(buttonFont);
        // register listener
        removeStudent.addActionListener(this);
        
        
        // Adding components to the Dropout Student panel
        // Label and Text Field
        dropoutStudentPanel.add(dropout_label_studentName);
        dropoutStudentPanel.add(dropout_text_studentName);
        dropoutStudentPanel.add(dropout_label_enrollmentId);
        dropoutStudentPanel.add(dropout_text_enrollmentId);
        dropoutStudentPanel.add(dropout_label_courseName);
        dropoutStudentPanel.add(dropout_text_courseName);
        dropoutStudentPanel.add(dropout_label_courseDuration);
        dropoutStudentPanel.add(dropout_text_courseDuration);
        dropoutStudentPanel.add(dropout_label_tuitionFee);
        dropoutStudentPanel.add(dropout_text_tuitionFee);
        dropoutStudentPanel.add(dropout_label_numRemainingModules);
        dropoutStudentPanel.add(dropout_text_numRemainingModules);
        dropoutStudentPanel.add(dropout_label_numMonthsAttended);
        dropoutStudentPanel.add(dropout_text_numMonthsAttended);
        dropoutStudentPanel.add(dropout_label_remainingAmount);
        dropoutStudentPanel.add(dropout_text_remainingAmount);
        // ComboBox
        dropoutStudentPanel.add(dropout_label_dateOfBirth);
        dropoutStudentPanel.add(dropout_comboBox_DOB_year);
        dropoutStudentPanel.add(dropout_comboBox_DOB_month);
        dropoutStudentPanel.add(dropout_comboBox_DOB_day);
        dropoutStudentPanel.add(dropout_label_dateOfEnrollment);
        dropoutStudentPanel.add(dropout_comboBox_DOE_year);
        dropoutStudentPanel.add(dropout_comboBox_DOE_month);
        dropoutStudentPanel.add(dropout_comboBox_DOE_day);
        dropoutStudentPanel.add(dropout_label_dateOfDropout);
        dropoutStudentPanel.add(dropout_comboBox_DOD_year);
        dropoutStudentPanel.add(dropout_comboBox_DOD_month);
        dropoutStudentPanel.add(dropout_comboBox_DOD_day);
        // Buttons
        dropoutStudentPanel.add(dropout_clear);
        dropoutStudentPanel.add(dropout_displayDetails);
        dropoutStudentPanel.add(addDropoutStudent);
        dropoutStudentPanel.add(payBills);
        dropoutStudentPanel.add(removeStudent);
        
        
        
        // settings for regularStudentPanel
        regularStudentPanel.setBackground(skyBlue);
        regularStudentPanel.setLayout(null);

        
        // settings for dropoutStudentPanel
        dropoutStudentPanel.setBackground(skyBlue);
        dropoutStudentPanel.setLayout(null);
        
        // settings for tabbed pane
        tabbedPane.setBackground(Color.WHITE);
        // adding regularStudent and dropoutStudent panels to the tabbed pane
        tabbedPane.addTab("Regular Student", regularStudentPanel);
        tabbedPane.add("Dropout Student", dropoutStudentPanel);
        
        
        // adding tabbedPane to the frame using BorderLayout
        frame.add(tabbedPane, BorderLayout.CENTER);
        
        // settings for frame
        frame.setSize(920, 650);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // overriding the actionPerformed() method of ActionListener interface
    @Override
    public void actionPerformed(ActionEvent event){
        
        // event handling for addRegularStudent button
        if (event.getSource() == addRegularStudent){
            // if any of the text field is empty, ask the user to fill all the information
             if (regular_text_enrollmentId.getText().isEmpty() || regular_text_studentName.getText().isEmpty() || regular_text_courseName.getText().isEmpty() || 
                regular_text_courseDuration.getText().isEmpty() || regular_text_numModules.getText().isEmpty() || regular_text_numCreditHours.getText().isEmpty()||
                regular_text_numDaysPresent.getText().isEmpty() || regular_text_tuitionFee.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Please fill all the information.", "Insufficient Information",JOptionPane.WARNING_MESSAGE);  
            }
            else{
                /*
                 exception handling while converting string to integer
                 while converting from integer to string, if any value is invalid, notify the user and ask them to input correct value
                 */
                try{
                    // retrieving the value from the text fields, converting the necessary values to integer and store them in corresponding variables
                    int enrollmentId = Integer.parseInt(regular_text_enrollmentId.getText());
                    int courseDuration = Integer.parseInt(regular_text_courseDuration.getText());
                    int numModules = Integer.parseInt(regular_text_numModules.getText());
                    int numCreditHours = Integer.parseInt(regular_text_numCreditHours.getText());
                    int numDaysPresent = Integer.parseInt(regular_text_numDaysPresent.getText());
                    int tuitionFee = Integer.parseInt(regular_text_tuitionFee.getText());
                    
                    String studentName = regular_text_studentName.getText();
                    String courseName = regular_text_courseName.getText();
                    
                    String DOB_year = String.valueOf(regular_comboBox_DOB_year.getSelectedItem());
                    String DOB_month = String.valueOf(regular_comboBox_DOB_month.getSelectedItem());
                    String DOB_day = String.valueOf(regular_comboBox_DOB_day.getSelectedItem());
                    // whole date of birth
                    String dateOfBirth = DOB_year + "-" + DOB_month + "-" + DOB_day;
                    
                    String DOE_year = String.valueOf(regular_comboBox_DOE_year.getSelectedItem());
                    String DOE_month = String.valueOf(regular_comboBox_DOE_month.getSelectedItem());
                    String DOE_day = String.valueOf(regular_comboBox_DOE_day.getSelectedItem());
                    // whole date of enrollment
                    String dateOfEnrollment = DOE_year + "-" + DOE_month + "-" + DOE_day;
                    
                    // if list is empty, add the object directly to the list
                    if (list.isEmpty()){
                        // creating the object of Regular Class
                        Regular regularStudent = new Regular(enrollmentId, dateOfBirth, courseName, studentName, dateOfEnrollment, courseDuration, tuitionFee, numModules, numCreditHours, numDaysPresent);
                    
                        // adding the object of Regular Class to the list
                        list.add(regularStudent);
                        
                        // after adding the regular student to the list, we can remove the values in input field
                        regular_text_enrollmentId.setText("");
                        regular_text_studentName.setText("");
                        regular_comboBox_DOB_year.setSelectedIndex(-1);
                        regular_comboBox_DOB_month.setSelectedIndex(-1);
                        regular_comboBox_DOB_day.setSelectedIndex(-1);
                        regular_text_courseName.setText("");
                        regular_text_courseDuration.setText("");
                        regular_text_numModules.setText("");
                        regular_comboBox_DOE_year.setSelectedIndex(-1);
                        regular_comboBox_DOE_month.setSelectedIndex(-1);
                        regular_comboBox_DOE_day.setSelectedIndex(-1);
                        regular_text_numCreditHours.setText("");
                        regular_text_numDaysPresent.setText("");
                        regular_text_tuitionFee.setText("");
                    
                        // dialog box with relevant information after successfully adding Regular class object to the list
                        JOptionPane.showMessageDialog(frame, "Regular student is added to the system.", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                    }
                    // if list is not empty, iterate through the list and check if the enrollment id is already within the system 
                    else{
                        // iterate through the list
                        Iterator<Student> iterator = list.iterator();
                        boolean existing_regular_EnrollmentId = false;
                        /*
                         we first checked if the enrollment id is repeated or not, then proceeded to make changes in the list
                         this is because, we can't change the contents of list while iterating over the list
                        */
                        while(iterator.hasNext()){
                            Student student = iterator.next();
                            // if the enrollmentId, is already within the system, break the loop and notify the user, and ask them to input new value    
                            if (student instanceof Regular && student.getEnrollmentID() == enrollmentId){
                                existing_regular_EnrollmentId = true;
                                break;
                            }
                        }
                        
                        
                        // if the enrollmentID is already within the system, give the message to the user
                        if (existing_regular_EnrollmentId){
                            JOptionPane.showMessageDialog(frame, "Student with the given EnrollmentID already exists within the system.", "Invalid EnrollmentID", JOptionPane.WARNING_MESSAGE);   
                        }
                        // if the enrollmentId is not present in the system, add the object to the list, notify the user and clear the text fields
                        else{
                            // creating the object of Regular Class
                            Regular regularStudent = new Regular(enrollmentId, dateOfBirth, courseName, studentName, dateOfEnrollment, courseDuration, tuitionFee, numModules, numCreditHours, numDaysPresent);
                            
                            // adding the object of Regular Class to the list
                            list.add(regularStudent);
                            
                            // after adding the regular student to the list, we can remove the values in input field
                            regular_text_enrollmentId.setText("");
                            regular_text_studentName.setText("");
                            regular_comboBox_DOB_year.setSelectedIndex(-1);
                            regular_comboBox_DOB_month.setSelectedIndex(-1);
                            regular_comboBox_DOB_day.setSelectedIndex(-1);
                            regular_text_courseName.setText("");
                            regular_text_courseDuration.setText("");
                            regular_text_numModules.setText("");
                            regular_comboBox_DOE_year.setSelectedIndex(-1);
                            regular_comboBox_DOE_month.setSelectedIndex(-1);
                            regular_comboBox_DOE_day.setSelectedIndex(-1);
                            regular_text_numCreditHours.setText("");
                            regular_text_numDaysPresent.setText("");
                            regular_text_tuitionFee.setText("");
                            
                            // dialog box with relevant information after successfully adding Regular class object to the list
                            JOptionPane.showMessageDialog(frame, "Regular student is added to the system.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
                        }
                    }
                }
                // while converting from string to integer if any error occurred, catch the exception and notify the user about the invalid value
                catch(NumberFormatException e){
                    
                    JOptionPane.showMessageDialog(frame, "The input you have entered is not valid. \n Please check the input and try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);  
                
                }
            }
        }
        
        // event handling for clear button on regular student panel
        else if (event.getSource() == regular_clear){
            //clearing all the values in the text fields
            regular_text_enrollmentId.setText("");
            regular_text_studentName.setText("");
            regular_text_courseName.setText("");
            regular_text_courseDuration.setText("");
            regular_text_numModules.setText("");
            regular_text_numCreditHours.setText("");                
            regular_text_numDaysPresent.setText("");
            regular_text_tuitionFee.setText("");
            
            // resetting the value of combobox to the value of index 0
            regular_comboBox_DOB_year.setSelectedIndex(-1);
            regular_comboBox_DOB_month.setSelectedIndex(-1);
            regular_comboBox_DOB_day.setSelectedIndex(-1);
            regular_comboBox_DOE_year.setSelectedIndex(-1);
            regular_comboBox_DOE_month.setSelectedIndex(-1);
            regular_comboBox_DOE_day.setSelectedIndex(-1);
            
            // dialog box with relevant message after successfully clearing the input values
            JOptionPane.showMessageDialog(frame, "All the input is cleared", "CLEAR", JOptionPane.INFORMATION_MESSAGE);   
        
        }
        
        // event handling for display button on regular student panel
        else if (event.getSource() == regular_displayDetails){
            if (list.isEmpty()){
                // if the list is empty, show a relevant message in the dialog box
                JOptionPane.showMessageDialog(frame, "No details regarding Regular Student in the system.", "Data Not Found", JOptionPane.INFORMATION_MESSAGE);  
            }
            else{ 
                // student object is used because list is of student object type
                 for (Student student : list) {
                    if (student instanceof Regular) {
                        /*
                         downcasting
                         student is downcasted to the regularStudent of type Regular
                        */
                        Regular regularStudent = (Regular) student;
                        
                        // calling the display method of Regular Class
                        regularStudent.display();
                    }
                }
            }
        }   
        
        /*
         event handling for calculatePresentPercentage button on regular student panel
         opens a new frame with labels, input fields and button
        */
        else if (event.getSource() == calculatePresentPercentage){
            // creating a new frame for calculating present percentage
            presentPercentageFrame = new JFrame("Calculate Present Percentage");
            
            // Calculate Present Percentage frame: label and text field for Enrollment Id
            PP_enrollmentId = new JLabel("Enrollment ID:");
            PP_enrollmentId.setBounds(20, 20, 150, 25);
            PP_text_enrollmentId = new JTextField();
            PP_text_enrollmentId.setBounds(200, 20, 120, 25);
            
            // Calculate Present Percentage frame: label and text field for Number of Days Present
            PP_numPresentDays = new JLabel("Number of days present:");
            PP_numPresentDays.setBounds(20, 60, 150, 25);
            PP_text_numPresentDays = new JTextField();
            PP_text_numPresentDays.setBounds(200, 60, 120, 25);
            
            // Calculate Present Percentage frame: calculate button for calculating present percentage
            PP_calculate_presentPercentage = new JButton("Calculate");
            PP_calculate_presentPercentage.setBounds(120, 110, 100, 35);
            PP_calculate_presentPercentage.setBackground(paleTurquoise);
            PP_calculate_presentPercentage.setFont(buttonFont);
            // register listener
            PP_calculate_presentPercentage.addActionListener(this);
        
            // adding components to the present percentage frame
            presentPercentageFrame.add(PP_enrollmentId);
            presentPercentageFrame.add(PP_text_enrollmentId);
            presentPercentageFrame.add(PP_numPresentDays);
            presentPercentageFrame.add(PP_text_numPresentDays);
            presentPercentageFrame.add(PP_calculate_presentPercentage);
            
            // settings for present percentage frame
            presentPercentageFrame.getContentPane().setBackground(lightRed);
            presentPercentageFrame.setLayout(null);
            presentPercentageFrame.setResizable(false);
            presentPercentageFrame.setBounds(300, 200, 360, 200);
            presentPercentageFrame.setVisible(true);
            
        }
        
        /*
         event handling for calculate present percentage button on Present Percentage frame
         calculates the present percentage
        */
        else if (event.getSource() == PP_calculate_presentPercentage){
            // if the textfield is empty, inform the user with appropriate message in the dialog box
            if (PP_text_enrollmentId.getText().isEmpty() || PP_text_numPresentDays.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please insert values in all the fields", "Insufficient Information", JOptionPane.WARNING_MESSAGE); 
            }
            /*
             if the text field is not empty, then retrieve the values from the text field, and then convert them into integer
             if the string can't be converted into integer, inform the user and ask them to input correct information
            */
            else{
                try{
                    int PresentP_enrollmentID = Integer.parseInt(PP_text_enrollmentId.getText());
                    int PresentP_numPresentDays = Integer.parseInt(PP_text_numPresentDays.getText());
                    
                    Regular regularStudent = null;

                    for(Student student: list){
                        /*
                         checking if student object is a instance of Regular class
                         finding the regular student in the list using given enrollment ID
                        */
                        if (student instanceof Regular && student.getEnrollmentID() == PresentP_enrollmentID){
                            /*
                             downcasting
                             student is downcasted to the regularStudent of type Regular
                            */
                            regularStudent = (Regular) student;
                            break;
                        }
                    }
                    
                    // calculate present percentage and display the result
                    if (regularStudent != null){
                        // calling the presentPercentage() method of Regular class and passing PresentP_numPresentDays as parameter
                        char presentPercentageGrade = regularStudent.presentPercentage(PresentP_numPresentDays);
                        
                        if (presentPercentageGrade == 0){
                            // if number of days present is less than 0 or number of present days is greater than course duration
                            JOptionPane.showMessageDialog(frame, "Invalid Input", "Invalid", JOptionPane.WARNING_MESSAGE); 
                        }
                        else{
                            // displaying a dialog box with present percentage grade
                            JOptionPane.showMessageDialog(frame, "Present Percentage Grade: "  + presentPercentageGrade, "Present Percentage", JOptionPane.INFORMATION_MESSAGE); 
                        }
                        // clearing the text fields after calculating the present percentage
                        PP_text_enrollmentId.setText("");
                        PP_text_numPresentDays.setText("");
                    }else{
                        // displaying a dialog box with relevant message after the enrollment id not found
                        JOptionPane.showMessageDialog(frame, "Regular student with the given Enrollment ID not found" , "Student Not Found", JOptionPane.WARNING_MESSAGE);
                    
                    }                    
                }
                // checking for number format exception while converting string to integer
                catch(NumberFormatException e){
                    // displaying a dialog box with relevant message after NumberFormatException is caught
                    JOptionPane.showMessageDialog(frame, "The input you have entered is not valid. \n Please check the input and try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);  

                }
            }
        }
        
        /*
         event handling for grantCertificate button on regular student panel
         opens a new frame with labels, input fields, combo boxes and button 
        */
        else if(event.getSource() == grantCertificate){
            // creating a new frame
            grantCertificateFrame = new JFrame("Grant Certificate");
            
            // Grant Certificate frame: label and text field for Enrollment Id
            GC_enrollmentId = new JLabel("Enrollment ID:");
            GC_enrollmentId.setBounds(20, 20, 150, 25);
            GC_text_enrollmentId = new JTextField();
            GC_text_enrollmentId.setBounds(170, 20, 150, 25);
            
            // Grant Certificate frame: label and text field for Course Name
            GC_courseName = new JLabel("Course Name:");
            GC_courseName.setBounds(20, 60, 150, 25);
            GC_text_courseName = new JTextField();
            GC_text_courseName.setBounds(170, 60, 150, 25);
            
            // Grant Certificate frame: label for Date of Enrollment
            GC_dateOfEnrollment = new JLabel("Date of Enrollment:");
            GC_dateOfEnrollment.setBounds(20, 100, 155, 25);
            
            // Grant Certificate frame: combo box for Date of Enrollment (year)
            String[] enrollment_years = {"2018", "2019", "2020", "2021", "2022", "2023"};
            GC_comboBox_DOE_year = new JComboBox<String>(enrollment_years);
            GC_comboBox_DOE_year.setBounds(170, 100, 80, 25);
            GC_comboBox_DOE_year.setBackground(white);
            
            // array of month
            String[] array_month = new String[12];
            for (int i = 1; i <= array_month.length; i++){
                array_month[i - 1] = String.valueOf(i);
            }
            
            // array of days
            String[] array_day = new String[32];
            for (int i = 1; i <= array_day.length; i++){
                array_day[i - 1] = String.valueOf(i);
            }
            
            // Grant Certificate frame: combo box for Date of Enrollment (month)
            GC_comboBox_DOE_month = new JComboBox<String>(array_month);
            GC_comboBox_DOE_month.setBounds(270, 100, 60, 25);
            GC_comboBox_DOE_month.setBackground(white);
            
            // Grant Certificate frame: combo box for Date of Enrollment (day)
            GC_comboBox_DOE_day = new JComboBox<String>(array_day);
            GC_comboBox_DOE_day.setBounds(350, 100, 50, 25);
            GC_comboBox_DOE_day.setBackground(white);
            
            // Grant Certificate frame: button for grant certificate
            // grants certificate/ displays certificate with details
            GC_grantCertificate = new JButton("Grant Certificate");
            GC_grantCertificate.setBounds(145, 150, 150, 35);
            GC_grantCertificate.setBackground(paleTurquoise);
            GC_grantCertificate.setFont(buttonFont);
            // register listener
            GC_grantCertificate.addActionListener(this);
            
            // adding components to the Grant Certificate frame
            grantCertificateFrame.add(GC_enrollmentId);
            grantCertificateFrame.add(GC_text_enrollmentId);
            grantCertificateFrame.add(GC_courseName);
            grantCertificateFrame.add(GC_text_courseName);
            grantCertificateFrame.add(GC_dateOfEnrollment);
            grantCertificateFrame.add(GC_comboBox_DOE_year);
            grantCertificateFrame.add(GC_comboBox_DOE_month);
            grantCertificateFrame.add(GC_comboBox_DOE_day);
            grantCertificateFrame.add(GC_grantCertificate);
            
            // settings for Grant Certificate frame
            grantCertificateFrame.getContentPane().setBackground(lightRed);
            grantCertificateFrame.setLayout(null);
            grantCertificateFrame.setResizable(false);
            grantCertificateFrame.setBounds(220, 200, 440, 250);
            grantCertificateFrame.setVisible(true);
        }
        
        /*
         event handling for grant certificate button on Grant Certificate frame
         grants certificate/ displays certificate with details
        */
        else if (event.getSource() == GC_grantCertificate){
            // if the textfield is empty, inform the user with appropriate message in the dialog box
            if (GC_text_enrollmentId.getText().isEmpty() || GC_text_courseName.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please insert values in all the fields", "Insufficient Information.", JOptionPane.WARNING_MESSAGE);   
            }
            /*
             if the text field is not empty, then retrieve the values from the text field, and then convert them into integer
             if the string can't be converted into integer, inform the user and ask them to input correct information
            */
            else{
                try{
                    int certificate_enrollmentID = Integer.parseInt(GC_text_enrollmentId.getText());
                    String certificate_courseName = GC_text_courseName.getText();
                    //retrieving the text from year, month and day combobox and storing them in single string variable 
                    String certificate_DOE = String.valueOf(GC_comboBox_DOE_year.getSelectedItem()) + "-" + String.valueOf(GC_comboBox_DOE_month.getSelectedItem()) + "-" + String.valueOf(GC_comboBox_DOE_day.getSelectedItem()); 
                    
                    Regular regularStudent = null;
                    // iterating through the list
                    for (Student student: list){
                        // finding the regular student in the list using give enrollmentId
                        if (student instanceof Regular && student.getEnrollmentID() == certificate_enrollmentID){
                            // downcasting
                            // student is downcasted to the regularStudent of type Regular
                            regularStudent = (Regular) student;
                            break;
                        }
                    }
                    
                    if (regularStudent != null){
                        // if the list is not empty and has regular student object, call Grant certificate funtion in regular class, to print details and grant scholarship
                        regularStudent.grantCertificate(certificate_courseName, certificate_enrollmentID, certificate_DOE);
                        
                        // display relevent message after granting certificate in a dialog box
                        JOptionPane.showMessageDialog(frame, "Certificate has been granted.", "Certificate Granted", JOptionPane.INFORMATION_MESSAGE); 
                        
                        // clearing the text fields after granting the certificate of student
                        GC_text_enrollmentId.setText("");
                        GC_text_courseName.setText("");
                        // reseting the index of combo box to -1
                        GC_comboBox_DOE_year.setSelectedItem(-1);
                        GC_comboBox_DOE_year.setSelectedItem(-1);
                        GC_comboBox_DOE_year.setSelectedItem(-1);
                    }
                    else{
                        // if the list is empty or does not have regular student object
                        JOptionPane.showMessageDialog(frame, "Regular Student with given Enrollment Id not found", "Student Not Found", JOptionPane.WARNING_MESSAGE);  
                    }
                }
                // catching number format exception while converting string to integer
                catch(NumberFormatException e){
                    // displaying relevant message after the input is invalid using dialog box
                    JOptionPane.showMessageDialog(frame, "The input you have entered is not valid. \n Please check the input and try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);   
                }
            }
        }
        
        
        // event handling for addDropoutStudent button
        else if (event.getSource() == addDropoutStudent){
            // if any of the text field is empty, ask the user to fill all the information using dialog box
            if (dropout_text_enrollmentId.getText().isEmpty() || dropout_text_studentName.getText().isEmpty() || dropout_text_courseName.getText().isEmpty() || 
                dropout_text_courseDuration.getText().isEmpty() || dropout_text_numRemainingModules.getText().isEmpty() || dropout_text_numMonthsAttended.getText().isEmpty() ||
                dropout_text_remainingAmount.getText().isEmpty() || dropout_text_tuitionFee.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Please fill all the information.", "Insufficient Information",JOptionPane.WARNING_MESSAGE);  
            } 
            else{
                // exception handling while converting string to integer
                try{
                    // retrieving the value from the text fields, converting the necessary values to integer and store them in corresponding variables
                    int dropout_enrollmentId = Integer.parseInt(dropout_text_enrollmentId.getText());
                    int dropout_courseDuration = Integer.parseInt(dropout_text_courseDuration.getText());
                    int dropout_numRemainingModules = Integer.parseInt(dropout_text_numRemainingModules.getText());
                    int dropout_numMonthsAttended = Integer.parseInt(dropout_text_numMonthsAttended.getText());
                    int dropout_remainingAmount = Integer.parseInt(dropout_text_remainingAmount.getText());
                    int dropout_tuitionFee = Integer.parseInt(dropout_text_tuitionFee.getText());
    
                    String dropout_courseName = dropout_text_courseName.getText();
                    String dropout_studentName = dropout_text_studentName.getText();
                    
                    String dropout_DOB_year = String.valueOf(dropout_comboBox_DOB_year.getSelectedItem());
                    String dropout_DOB_month = String.valueOf(dropout_comboBox_DOB_month.getSelectedItem());
                    String dropout_DOB_day = String.valueOf(dropout_comboBox_DOB_day.getSelectedItem());
                    // whole date of birth
                    String dropout_dateOfBirth = dropout_DOB_year + "-" + dropout_DOB_month + "-" + dropout_DOB_day;
                    
                    String dropout_DOE_year = String.valueOf(dropout_comboBox_DOE_year.getSelectedItem());
                    String dropout_DOE_month = String.valueOf(dropout_comboBox_DOE_month.getSelectedItem());
                    String dropout_DOE_day = String.valueOf(dropout_comboBox_DOE_day.getSelectedItem());
                    // whole date of enrollment
                    String dropout_dateOfEnrollment = dropout_DOE_year + "-" + dropout_DOE_month + "-" + dropout_DOE_day;
        
                    String dropout_DOD_year = String.valueOf(dropout_comboBox_DOD_year.getSelectedItem());
                    String dropout_DOD_month = String.valueOf(dropout_comboBox_DOD_month.getSelectedItem());
                    String dropout_DOD_day = String.valueOf(dropout_comboBox_DOD_day.getSelectedItem());
                    // whole date of enrollment
                    String dropout_dateOfDropout = dropout_DOD_year + "-" + dropout_DOD_month + "-" + dropout_DOD_day;
    
                    // if list is empty, add the object directly to the list
                    if (list.isEmpty()){
                        // creating the object of Dropout class
                        Dropout dropoutStudent = new Dropout(dropout_dateOfBirth, dropout_studentName, dropout_courseDuration, dropout_tuitionFee, dropout_numRemainingModules, dropout_numMonthsAttended, dropout_dateOfDropout);
                    
                        // call the setters method using object of Dropout class, and pass the corresponding parameters
                        dropoutStudent.setEnrollmentID(dropout_enrollmentId);
                        dropoutStudent.setCourseName(dropout_courseName);
                        dropoutStudent.setDateOfEnrollment(dropout_dateOfEnrollment);
                        dropoutStudent.setRemainingAmount(dropout_remainingAmount);
                        
                        // adding the object of Dropout class to the list
                        list.add(dropoutStudent);
                        
                        // clearing the text fields, after adding dropoutStudent to the list
                        dropout_text_enrollmentId.setText("");
                        dropout_text_studentName.setText("");
                        dropout_text_courseName.setText("");
                        dropout_text_courseDuration.setText("");
                        dropout_text_numRemainingModules.setText("");
                        dropout_text_numMonthsAttended.setText("");
                        dropout_text_remainingAmount.setText("");
                        dropout_text_tuitionFee.setText("");
                        
                        // setting the indexing of combox box to -1 after adding dropoutStudent to the list
                        dropout_comboBox_DOB_year.setSelectedIndex(-1);
                        dropout_comboBox_DOB_month.setSelectedIndex(-1);
                        dropout_comboBox_DOB_day.setSelectedIndex(-1);
                        dropout_comboBox_DOE_year.setSelectedIndex(-1);
                        dropout_comboBox_DOE_month.setSelectedIndex(-1);
                        dropout_comboBox_DOE_day.setSelectedIndex(-1);
                        dropout_comboBox_DOD_year.setSelectedIndex(-1);
                        dropout_comboBox_DOD_month.setSelectedIndex(-1);
                        dropout_comboBox_DOD_day.setSelectedIndex(-1);
                    
                        // displaying relevant message in the dialog box after adding dropoutStudent to the list
                        JOptionPane.showMessageDialog(frame, "Dropout student is added to the system.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                     // if list is not empty, iterate through the list and check if the enrollment id is already within the system 
                    else{
                        Iterator<Student> iterator = list.iterator();
                        boolean existing_dropout_EnrollmentId = false;
                        
                        // we first checked if the enrollment id is repeated or not, then proceeded to make changes in the list
                        // this is because, we can't change the contents of list while iterating over the list
                        while(iterator.hasNext()){
                            Student student = iterator.next();
                            // if the enrollmentId, is already within the system, break the loop and notify the user, and ask them to input new value    
                            if (student instanceof Dropout && student.getEnrollmentID() == dropout_enrollmentId){
                                existing_dropout_EnrollmentId = true;
                                break;
                            }
                        }
                        // if the enrollment id already exists in the system, give relevant message to the user using dialog box
                        if (existing_dropout_EnrollmentId){
                                
                                JOptionPane.showMessageDialog(frame, "Student with the given EnrollmentID already exists within the system", "", JOptionPane.WARNING_MESSAGE); 

                        }
                        // if the enrollmentId is not present in the system, add the object to the list, notify the user and clear the text fields
                        else{   
                            // creating a object of Dropout class
                            Dropout dropoutStudent = new Dropout(dropout_dateOfBirth, dropout_studentName, dropout_courseDuration, dropout_tuitionFee, dropout_numRemainingModules, dropout_numMonthsAttended, dropout_dateOfDropout);
                            
                            // call the setters method using object of Dropout class, and pass the corresponding parameters
                            dropoutStudent.setEnrollmentID(dropout_enrollmentId);
                            dropoutStudent.setCourseName(dropout_courseName);
                            dropoutStudent.setDateOfEnrollment(dropout_dateOfEnrollment);
                            dropoutStudent.setRemainingAmount(dropout_remainingAmount);
                            
                            // adding the object of Dropout class to the list
                            list.add(dropoutStudent);
                            
                            // clearing the text fields, after adding dropoutStudent to the list
                            dropout_text_enrollmentId.setText("");
                            dropout_text_studentName.setText("");
                            dropout_text_courseName.setText("");
                            dropout_text_courseDuration.setText("");
                            dropout_text_numRemainingModules.setText("");
                            dropout_text_numMonthsAttended.setText("");
                            dropout_text_remainingAmount.setText("");
                            dropout_text_tuitionFee.setText("");
                            
                            // setting the indexing of combox box to -1 after adding dropoutStudent to the list
                            dropout_comboBox_DOB_year.setSelectedIndex(-1);
                            dropout_comboBox_DOB_month.setSelectedIndex(-1);
                            dropout_comboBox_DOB_day.setSelectedIndex(-1);
                            dropout_comboBox_DOE_year.setSelectedIndex(-1);
                            dropout_comboBox_DOE_month.setSelectedIndex(-1);
                            dropout_comboBox_DOE_day.setSelectedIndex(-1);
                            dropout_comboBox_DOD_year.setSelectedIndex(-1);
                            dropout_comboBox_DOD_month.setSelectedIndex(-1);
                            dropout_comboBox_DOD_day.setSelectedIndex(-1);
                        
                            // displaying relevant message in the dialog box after adding dropoutStudent to the list
                            JOptionPane.showMessageDialog(frame, "Dropout student is added to the system.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            

                            }
                        }
                    // while converting from string to integer if any error occurred, catch the exception and notify the user about the invalid value
                }catch(NumberFormatException e){
                    
                    JOptionPane.showMessageDialog(frame, "The input you have entered is not valid. \n Please check the input and try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);  
                
                }
            }
        }
        
        // event handling for clear button on Dropout Student panel
        else if (event.getSource() == dropout_clear){
            
            // clearing the values in the text fields
            dropout_text_enrollmentId.setText("");
            dropout_text_studentName.setText("");
            dropout_text_courseName.setText("");
            dropout_text_courseDuration.setText("");
            dropout_text_numRemainingModules.setText("");
            dropout_text_numMonthsAttended.setText("");
            dropout_text_remainingAmount.setText("");
            dropout_text_tuitionFee.setText("");
            
            // resetting the indexing of combobox to 0
            dropout_comboBox_DOB_year.setSelectedIndex(0);
            dropout_comboBox_DOB_month.setSelectedIndex(0);
            dropout_comboBox_DOB_day.setSelectedIndex(0);
            dropout_comboBox_DOE_year.setSelectedIndex(0);
            dropout_comboBox_DOE_month.setSelectedIndex(0);
            dropout_comboBox_DOE_day.setSelectedIndex(0);
            dropout_comboBox_DOD_year.setSelectedIndex(0);
            dropout_comboBox_DOD_month.setSelectedIndex(0);
            dropout_comboBox_DOD_day.setSelectedIndex(0);
            
            // displaying relevant message using dialog box after all the values are cleard
            JOptionPane.showMessageDialog(frame, "All the input is cleared", "CLEAR", JOptionPane.INFORMATION_MESSAGE);   
        
        }
        
        // event handling for display button on Dropout Student panel
        else if (event.getSource() == dropout_displayDetails){
            // if the list is empty, display the relevant message using dialog box
            if (list.isEmpty()){
                JOptionPane.showMessageDialog(frame, "No details regarding Dropout Student in the system.", "Data Not Found", JOptionPane.INFORMATION_MESSAGE);  
            }
            // if list is not empty, display all the details of Dropout students
            else{
                // student object is used because list is of student object type
                 for (Student student : list) {
                    if (student instanceof Dropout) {
                        // downcasting
                        // student is downcasted to the dropoutStudent of type Dropout
                        Dropout dropoutStudent = (Dropout) student;
                        
                        // calling the display() method of Dropout Class 
                        dropoutStudent.display();
                    }
                }
            }
        }
        
        /*
         event handling for payBills button on dropout student panel
         opens a new frame with label, input field and button
        */
        else if (event.getSource() == payBills){
            // creating a new frame
            payBillsFrame = new JFrame("Pay Bills");
            
            // Pay Bills frame: label and text field for Enrollment Id
            PB_enrollmentId = new JLabel("Enrollment ID:");
            PB_enrollmentId.setBounds(20, 20, 150, 25);
            PB_text_enrollmentId = new JTextField();
            PB_text_enrollmentId.setBounds(200, 20, 120, 25);
            
            // Pay Bills frame: pay button for paying the bills
            PB_payBills = new JButton("Pay");
            PB_payBills.setBounds(120, 75, 100, 35);
            PB_payBills.setBackground(paleTurquoise);
            PB_payBills.setFont(buttonFont);
            // register listener
            PB_payBills.addActionListener(this);
            
            // adding components to the Pay Bills frame
            payBillsFrame.add(PB_enrollmentId);
            payBillsFrame.add(PB_text_enrollmentId);
            payBillsFrame.add(PB_payBills);
            
            
            // settings for Pay Bills frame
            payBillsFrame.getContentPane().setBackground(lightRed);
            payBillsFrame.setLayout(null);
            payBillsFrame.setResizable(false);
            payBillsFrame.setBounds(300, 200, 360, 170);
            payBillsFrame.setVisible(true);
        }
        
        /*
         event handling for pay bills button on Pay Bills frame
         grants certificate/ displays certificate with details
        */
        else if (event.getSource() == PB_payBills){
            // if the text field is empty, inform the user and ask them to insert a value using dialog box
            if (PB_text_enrollmentId.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please insert a value in the text field.", "Insufficient Information", JOptionPane.WARNING_MESSAGE); 
            }
            else{
                // if text field is not empty, then retrieve the values from the text field, and then convert them to integer
                try{
                    // retrieving the value from the text field and converting the value into integer
                    int payBills_enrollmentID = Integer.parseInt(PB_text_enrollmentId.getText());
            
                    Dropout dropoutStudent = null;
                    // iterating through the list
                    for(Student student: list){
                        /*
                         if student object is a instance of Dropout class
                         and existing enrollment id in the list is equal to given enrollment id
                        */
                        if (student instanceof Dropout && student.getEnrollmentID() == payBills_enrollmentID){
                            /*
                             downcasting
                             student is downcasted to the dropoutStudent of type Dropout
                            */
                            dropoutStudent = (Dropout) student;
                            break;
                        }
                    }
                    
                    // if the object of dropout student is present in the list, pay the bills
                    if (dropoutStudent != null){
                        // calling the billsPayble() method from Dropout class
                        dropoutStudent.billsPayable();
                        
                        // displaying a relevant message in a dialog box after the bill is paid
                        JOptionPane.showMessageDialog(frame, "Bills of given Student is paid.", "Bills Paid", JOptionPane.INFORMATION_MESSAGE);  
                        
                        // clearing the text field after the bill is paid
                        PB_text_enrollmentId.setText("");
                    }else{
                        // displaying a relevant message using dialog box if the object of dropout student is not present in the list
                        JOptionPane.showMessageDialog(frame, "Dropout student with the given Enrollment Id not found" , "Student Not Found", JOptionPane.WARNING_MESSAGE);
                     
                    }
                }
                // displaying a relevant message after NumberFormatException occurred while converting string to integer
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(frame, "The input you have entered is not valid. \n Please check the input and try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);   
                }
            }
        }
        
        /*
         event handling for removeStudent button on dropout student panel
         opens a new frame with label, input field and button
        */
        else if (event.getSource() == removeStudent){
            // creating a new frame
            removeStudentFrame = new JFrame("Remove Student");
        
            // Remove Student frame: label and text field for Enrollment Id
            RS_enrollmentId = new JLabel("Enrollment ID:");
            RS_enrollmentId.setBounds(20, 20, 150, 25);
            RS_text_enrollmentId = new JTextField();
            RS_text_enrollmentId.setBounds(200, 20, 120, 25);
            
            /*
             Remove Student frame: button for remove student
             Used to remove the student from the system
            */
            RS_removeStudent = new JButton("Remove");
            RS_removeStudent.setBounds(120, 75, 100, 35);
            RS_removeStudent.setBackground(paleTurquoise);
            RS_removeStudent.setFont(buttonFont);
            // register listener
            RS_removeStudent.addActionListener(this);
            
            // adding the components to the Remove Student frame
            removeStudentFrame.add(RS_enrollmentId);
            removeStudentFrame.add(RS_text_enrollmentId);
            removeStudentFrame.add(RS_removeStudent);
            
            // settings for Remove Student frame
            removeStudentFrame.getContentPane().setBackground(lightRed);
            removeStudentFrame.setLayout(null);
            removeStudentFrame.setResizable(false);
            removeStudentFrame.setBounds(300, 200, 360, 170);
            removeStudentFrame.setVisible(true);

        }
        
        /*
         event handling for remove student button on Remove Student frame
         Remove the student from the system 
        */
        else if (event.getSource() == RS_removeStudent){
            // if the text field is empty, inform the user with appropriate message using dialog box
            if (RS_text_enrollmentId.getText().isEmpty()){
                 JOptionPane.showMessageDialog(frame, "Please insert values in all the fields", "Insufficient Information", JOptionPane.WARNING_MESSAGE); 
            }
            // if the text field is not empty, then retrieve the values from the text field, and then convert the value to integer
            else{
                try{
                    // retrieving the value from the text field, converting to integer and storing in corresponding variable
                    int remove_enrollmentID = Integer.parseInt(RS_text_enrollmentId.getText());

                    Dropout dropoutStudent = null;
                    // iterate through the list
                    for(Student student: list){
                        /*
                         if the student object is a instance of Dropout class
                         and existing enrollment id in the list is equal to given enrollment id
                        */
                        if (student instanceof Dropout && student.getEnrollmentID() == remove_enrollmentID){
                            /*
                             downcasting
                             student is downcasted to the dropoutStudent of type Dropout
                            */
                            dropoutStudent = (Dropout) student;
                            break;
                        }
                    }
                    
                    // if the object dropoutStudent is not null
                    if (dropoutStudent != null){
                        // calling the method removeStudent() from Dropout class
                        dropoutStudent.removeStudent();
                        
                        // displaying a relevant message using dialog box after the student is removed from the system
                        JOptionPane.showMessageDialog(frame, "Student is removed from the system.", "Student Removed", JOptionPane.INFORMATION_MESSAGE);
                        
                        // clearing the text field after the student have been removed from the system
                        RS_text_enrollmentId.setText("");
                    }
                    // if the object of dropoutStudent is null, show a relevant message using dialog box
                    else{
                        JOptionPane.showMessageDialog(frame, "Dropout student with the given Enrollment Id not found" , "Student Not Found", JOptionPane.WARNING_MESSAGE);
                    }
                }
                /*
                 catch NumberFormatException that occurred, while converting string to integer
                 Then, display relevant message using dialog box
                */
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(frame, "The input you have entered is not valid. \n Please check the input and try again.", "Invalid Input", JOptionPane.WARNING_MESSAGE);   
                }
            }
        }
    } 
    
    // main method
    public static void main(String[] args){
        // creating an instance of StudentGUI class
        new StudentGUI();
    }   
}
