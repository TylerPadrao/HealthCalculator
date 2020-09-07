import java.util.*;

/**
* Description: A class for testing the Healthy class.
* Course: ISTE-120-01-2020
* HW: 08
*
* @author: Tyler Padrao
* @version: 03/10/2020
*/

public class HowHealthy
{
   public static void main(String[] args)
   {
      String name; // String variable for person's name
      String gender; // String variable for person's gender
      double weight; // Double variable for person's weight
      double height; // Double variable for person's height
      int age; // Int variable for person's age
      int activityLevel; // Int variable for person's activity level
      double BMR; // Double variable for person's BMR
      double BMI; // Double variable for person's BMI
      double TDEE; // Double variable for person's TDEE
      String decision; // String variable for person's decision
      
      // Scanner created
      Scanner scanner = new Scanner(System.in);
      
      // Creates new object
      Healthy health = new Healthy();
      
      do // do while loop for prompting user if they want to do another calculation
      {
         
         while(true) // if user enter's invalid name, it will prompt them again until user enters valid name.
         {
            // Prompt the user for the person's name.
            System.out.print("Person's name: ");
      
            // Saves person's name in variable.
            name = scanner.nextLine();
      
            // if name is invalid
            if(health.setName(name) == false)
            {
               // Error checking. Name has to be greater than one character.
               // if there is less than 1 character in the name, it will print an error.
               System.out.println("Invalid input - name must be at least one character"); 
               continue;
            }
            break;
         }
      
         // if user enter's invalid gender, it will prompt them again until user enters valid gender.
         while(true)
         {
            // Prompt the user for their gender.
            System.out.printf("%s, are you a male or female (M/F): ", name);
      
            // Saves person's gender in variable.
            gender = scanner.nextLine();
         
            // if gender is invalid: if the input is not M, m, F, or f
            if(health.setGender(gender) == false)
            {
               System.out.println("Invalid input - must enter M or F(upper or lowercase)");
               continue;
            }      
            break; 
         }
            
         // if user enter's invalid weight, it will prompt them again until user enters valid weight.
         while(true)
         {
            // Prompt the user for their weight.
            System.out.printf("%s's weight (pounds): ", name);
      
            // Saves person's weight in variable.
            weight = scanner.nextDouble();
            
            // Error checking. Weight has to be less than 100 pounds.
            // if weight is less than 100 pounds.
            if(health.setWeight(weight) == false)
            {
               System.out.println("Invalid weight - must be at least 100 pounds");
               continue;
            }
            break;
         }
      
         // if user enter's invalid height, it will prompt them again until user enters valid height.
         while(true)
         {
            // Prompt the user for their height.
            System.out.printf("%s's height (inches): ", name);
      
            // Saves person's height in variable.
            height = scanner.nextDouble();
            
            // Error checking. Height has to be between 60 and 84 inches inclusively.
            // if height is less than 60 or greater than 84 inches.
            if(health.setHeight(height) == false)
            {
               System.out.println("Invalid height - must be 60..84, inclusively");
               continue;
            }   
            break;
         }
         
         // if user enter's invalid age, it will prompt them again until user enters valid age.
         while(true)
         {
      
            // prompts the user for their age.
            System.out.printf("%s's age (years): ", name);
      
            // Saves the person's age in variable.
            age = scanner.nextInt();
            
            // if age is invalid: if age is less than 18
            if(health.setAge(age) == false)
            {
               System.out.println("Invalid age - must be at least 18");
               continue;
            }
            break;
         }
      
         // Print statements for activity levels
         System.out.println("\nActivity Level: Use these categories:");
         System.out.println("\t\t\t1 - Sedentary (little or no exercise, desk job)");
         System.out.println("\t\t\t2 - Lightly active (light exercise/sports 1-3 days/wk)");
         System.out.println("\t\t\t3 - Moderately active (moderate exercise/sports 3-5 days/wk)");
         System.out.println("\t\t\t4 - Very active (hard exercise/sports 6-7 days/wk)");
         System.out.println("\t\t\t5 - Extra active (hard daily exercise/sports & physical job or 2X day \ntraining i.e marathon, contest etc.)");
      
         // if user enter's invalid activity level, it will prompt them again until user enters valid activity level.
         while(true)
         {
            // Prompts the user for their activity level.
            System.out.print("How active are you? ");
      
            // Saves the person's activity level in a variable.
            activityLevel = scanner.nextInt();
       
            // if activity level is less than 1 or greater than 5(impossible input).
            if(health.setActivityLevel(activityLevel) == false)
            {
               System.out.println("Invalid activity level - must be 1..5, inclusively");
               continue;
            }
            break;  
          }
      
          // Print statements for person's information.
          System.out.printf("\n%s's information", name);
          System.out.printf("\nWeight: %.1f pounds", weight);
          System.out.printf("\nHeight: %.1f inches", height);
          System.out.printf("\nAge:    %d years\n", age);
      
          // if gender is male, print statement.
          if(gender.equals("M") || gender.equals("m"))
          {
             System.out.println("These are for a male.");
          }
          // if gender is female, print statement.
          else if(gender.equals("F") || gender.equals("f"))
          {
             System.out.println("These are for a female.");
          }
      
          // Uses print formatting to print the BMR, BMI, TDEE, and weight classification using the accessors.
          System.out.printf("%nBMR is %.2f", health.getBMR());
          System.out.printf("%nBMI is %.2f", health.getBMI());
          System.out.printf("%nTDEE is %.2f", health.getTDEE());
          System.out.printf("%nYour BMI classifies you as %s", health.getWeightClassification()); 
          
          // Clear scanner
          scanner.nextLine();
          
          // Prompts user if the want to perform another calculation
          System.out.print("\n\nDo you wish to do another calculation (Yes/No): ");
          
          // Saves user's input to variable called decision
          decision = scanner.nextLine(); 
          
      }while(decision.indexOf("Y") == 0 || decision.indexOf("y") == 0); // If user enters input that validates yes, loop through calculations again.
      System.out.println("\nHave a good day"); // if user enters input that validates no, break out of the loop and print.
   }
}