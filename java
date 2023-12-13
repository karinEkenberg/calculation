/*
        Pseudocode 

        Step 1:
        Declare Constants.
        CONSTANT1
        CONSTANT2

        Step 2:
        Declare Variables. 
        double hour;  
        double minute;  
        string month;
        int day;

        Step 3:
        Ask for user input.
        What is the date? 

        Step 4:
        Ask for more user input.
        Save answer in int
        What time was the sunrise?
        Save answer in int

        Step 5:
        same as 4.
        What time was the sunset?
        Save answer in int

        Step 6:
        Calculating.

        Step 7:
        Print the results.

        
*/
//Calling the class scanner to scan input from the user.
import java.util.Scanner;

public class Main {


  
    public static void main(String[] args) {
    
    //Declaring the scanner that will scan user input.
          Scanner userInput = new Scanner(System.in);
    //step 1 declaring constants, these values will not change during the program.
          double WOLTAGE_166 = 166;
          double CASH_09 = 0.9;
          double DAYS_JUNE_MAX = 30;
          double DAYS_JULY_MAX = 31;
          double MINUTES_OF_HOUR_MAX = 60;
          double JUNE = 6.0;
          double JULY = 7.0;
          double MAX_HOURS = 24.0;
          double NR_OF_PANELS = 26.0;
          double SOLAR_RADIATION = 166;
          double PANEL_WIDTH = 1.7;
          double PANEL_HEIGHT = 1;
          double EFFICIENCY = 0.2;
          double PANEL_AREA = PANEL_WIDTH * PANEL_HEIGHT;
          double SUN_RISE_EARLIEST = 1.0;
          double SUN_RISE_LATEST = 4.0;
          double SUN_SET_EARLIEST = 21.0;
          double SUN_SET_LATEST = 23.30;

      
    //Step 2, declaring variables, they will change in value during the program.
          double day, month;
          double hourUp = 0;
          double minUp = 0;
          double hourDown = 0;
          double minDown = 0;   
          double sunHours = 0;
          double production = 0;

      
    //Step 3 asking for todays date.
        
    //Using the useDelimiter method which works well with the scanner and will seperate tokens 
    //from input data, could add more such as , or !.
              userInput.useDelimiter("[-:>|\\s]");
    //Asking for user to enter date, then reading it as doubles as month and day.      
              System.out.println("Enter today's date [mm-dd]>");
              month = userInput.nextDouble();
              day = userInput.nextDouble();
      
    //Using the if statement to check that user input is correct.
    //If user enters the wrong months an error message will appear.         
              if (month != JUNE && month != JULY ){
                  System.out.println("You can only enter June or July!!");
                  //Using system exit if the answer is wrong to shut the program down
                  System.exit(0);
              }
    //If the user enters a day below 1 an error message will appear. 
              if (day < 1){
                  System.out.println("That day does not exist.");
                  System.exit(0);
              }
    /*If the user enters a day that does not exist in june 
      (1-30) they will recieve a error message.*/  
              if (month == JUNE){
                  if (day > DAYS_JUNE_MAX){
                   System.out.println("Valid days for June are 1-30.");
                   System.exit(0);
                  }
              }
     //Same here but for july. 
              if (month == JULY){
                  if (day > DAYS_JULY_MAX){
                   System.out.println("Valid days for July is 1-31.");
                   System.exit(0);
                  }
              } 

      
      
    //Step 4 asking for sunrise. 
              System.out.println("Enter today's time of sunrise hh:mm:");
              hourUp = userInput.nextDouble();
              minUp = userInput.nextDouble();
    //If the user enters hours that is not between 0-23 they will receive an error message.  
              if (hourUp > MAX_HOURS){
                 System.out.println("Valid hours are 0-23!!"); 
                 System.exit(0);
                }
    //If the user enters hours that is not between 01-04 an error message will appear.  
             if  (hourUp < SUN_RISE_EARLIEST || hourUp > SUN_RISE_LATEST){
                 System.out.println("The sun rises between 01.00-04.00!");
                 System.exit(0);
              }
    //If the user does not enter minutes within 0-59 they receive an error message.  
              if (minUp > MINUTES_OF_HOUR_MAX){
                System.out.println("Valid minutes are 0-59!!");
                System.exit(0);
               }
              if (minUp < 0){
                System.out.println("Valid minutes are 0-59!!");
                System.exit(0);
              }
    //Same goes for hours but within 0-23
              if (hourUp < 0){
                System.out.println("Valid hours are 0-23!!");
                System.exit(0);
              }

      
    //Step 5 asking for sunset
              System.out.println("Enter today's time of sunset hh:mm:");
              hourDown = userInput.nextDouble();
              minDown = userInput.nextDouble();
              if (hourDown > MAX_HOURS){
                 System.out.println("Valid hours are 0-23!!"); 
                  System.exit(0);
                }
              if (hourDown <= hourUp){
              if (hourDown == hourUp && minDown <= minUp){
                  System.out.println("Sunset cannot be before sunrise!!");
                  System.exit(0);
                }else{
                 System.out.println("You have not entered the right amount of hours!!");
                System.exit(0);
                }   
              }
             if  (hourDown < SUN_SET_EARLIEST || hourDown > SUN_SET_LATEST){
                 System.out.println("The sun goes down between 21.00-23.00!!");
                 System.exit(0);
              }
              if (minDown > MINUTES_OF_HOUR_MAX){
                System.out.println("Valid minutes are 0-59!!");
                System.exit(0);
               }
              if (minDown < 0){
                System.out.println("Valid minutes are 0-59!!");
                System.exit(0);
              }
              if (hourDown < 0){
                System.out.println("Valid hours are 0-23!!");
                System.exit(0);
              }



    //Step 6 calculating. 
    //Calculating the amount of sunhours and then calculates the production that it generates.  
            System.out.println("======================================");
            sunHours = (hourDown - hourUp) + ((minDown - minUp)/60);
            System.out.println("Sunhours: " + sunHours);
            production = SOLAR_RADIATION * EFFICIENCY * PANEL_AREA * sunHours * NR_OF_PANELS / 1000; 


   //Step 7 print out.
   //Using printf to print out the results of the calculation   
            System.out.printf("The production is " + "%.2f", production);
            System.out.printf(" kWh to a value of: SEK " + "%.2f", production * CASH_09);

   //Closing the scanner with the method close.   
            userInput.close();
    }
}
