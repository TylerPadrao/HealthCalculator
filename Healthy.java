import java.util.*;

/**
* Description: A class for calculating a person's BMR, BMU, TDEE, and weight classification.
* Course: ISTE-120-01-2020
* HW: 08
*
* @author: Tyler Padrao
* @version: 03/10/2020
*/

public class Healthy
{
   private String name; // Private string variable for person's name
   private String gender; // Private string variable for person's gender
   private double weight; // Private double variable for person's weight
   private double height; // Private double variable for person's height
   private int age; // Private int variable for person's age
   private int activityLevel; // Private int variable for person's activity level
   private double BMR; // Private double variable for person's BMR
   private double BMI; // Private double variable for person's BMI
   private double TDEE; // Private double variable for person's TDEE
   private String weightClassification; // Private string variable for person's weight classification
   private final double WEIGHT_CONVERSION = 2.2046; // Private constant for weight conversion
   private final double HEIGHT_CONVERSION = 2.54; // Private constant for height conversion
   
   /**
   * Default constructor
   * Initializes all of the attributes.
   */
   public Healthy()
   {
      name = "";
      gender = "";
      weight = 0.0;
      height = 0.0;
      age = 0;
      activityLevel = 0;
      BMR = 0.0;
      BMI = 0.0;
      TDEE = 0.0;
      weightClassification = "";
   }
   
   /**
   * Accessor for the name attribute
   * @return the name attribute
   */
   public String getName()
   {
      return name;
   }
   
   /**
   * Mutator for the patient's name
   * @param _name   The name of a patient
   * @return false if input is not valid
   * @return true if input is valid
   */
   public boolean setName(String _name)
   {
      // if name is less than one character
      if(_name.length() < 1)
      {
         return false;
      }
      // if name is greater than or equal to one character
      else
      {
         name = _name;
         return true;
      }
   }
   
   /**
   * Accessor for the gender attribute
   * @return the gender attribute
   */
   public String getGender()
   {
      return gender;
   }
   
   /**
   * Mutator for the patient's gender
   * @param _gender   The gender of a patient
   * @return false if input is not valid
   * @return true if input is valid
   */
   public boolean setGender(String _gender)
   {
      // if gender is not M, m, F, or f, the input is invalid
      if(!(_gender.equalsIgnoreCase("M") || _gender.equalsIgnoreCase("F")))
      {
         return false;
      }
      // if gender is M, m, F, or f
      else
      {
         gender = _gender;
         return true;
      }
   }
   
   /**
   * Accessor for the weight attribute
   * @return the weight attribute
   */
   public double getWeight()
   {
      return weight;
   } 
   
   /**
   * Mutator for the patient's weight
   * @param _weight   The weight of a patient
   * @return false if input is not valid
   * @return true if input is valid
   */
   public boolean setWeight(double _weight)
   {
      // if weight is less than 100, it's invalid
      if(_weight < 100)
      {
         return false;
      }
      // if weight is greater than or equal to a 100
      else
      {
         weight = _weight;
         return true;
      }
   }
   
   /**
   * Accessor for the height attribute
   * @return the height attribute
   */
   public double getHeight()
   {
      return height;
   }
   
   /**
   * Mutator for the patient's height
   * @param _height   The height of a patient
   * @return false if input is not valid
   * @return true if input is valid
   */
   public boolean setHeight(double _height)
   {
      // if height is less than 60 or greater than 84, it's invalid
      if(_height < 60.0 || _height > 84.0)
      {
         return false;
      }
      // if height is in between 60 and 84 inclusively
      else
      {
         height = _height;
         return true;
      }
   }
   
   /**
   * Accessor for the age attribute
   * @return the age attribute
   */
   public int getAge()
   {
      return age;
   }
   
   /**
   * Mutator for the patient's age
   * @param _age   The age of a patient
   * @return false if input is not valid
   * @return true if input is valid
   */
   public boolean setAge(int _age)
   {
      // if age is less than 18, it's invalid
      if(_age < 18)
      {
         return false;
      }
      // if age is 18 or greater
      else
      {
         age = _age;
         return true;
      }
   }
   
   /**
   * Accessor for the activity level attribute
   * @return the activity level attribute
   */
   public int getActivityLevel()
   {
      return activityLevel;
   }
   
   /**
   * Mutator for the patient's activity level
   * @param _activityLevel   The activity level of a patient
   * @return false if input is not valid
   * @return true if input is valid
   */
   public boolean setActivityLevel(int _activityLevel)
   {
      // if activity level is less than 1 and greater than 5
      if(_activityLevel < 1 || _activityLevel > 5)
      {
         return false;
      }
      // if activity level is between 1 and 5
      else
      {
         activityLevel = _activityLevel;
         return true;
      }
   }
   
   /**
   * A method that calculates a person's BMR depending if they are male or female. 
   */
   private void calculateBMR()
   {
      // if the person's gender is male, the BMR will be calculated for a male.
      if(gender.equals("M") || gender.equals("m"))
      {
         BMR = 66 + (13.7 * (weight/WEIGHT_CONVERSION)) + (5 * (height*HEIGHT_CONVERSION)) - (6.8 * age);
      }
      // if the person's gender is female, the BMR will be calculated for a female.
      else if(gender.equals("F") || gender.equals("f"))
      {
         BMR = 655 + (9.6 * (weight/WEIGHT_CONVERSION)) + (1.8 * (height*HEIGHT_CONVERSION)) - (4.7 * age);
      }
   }
   
   /**
   * Accessor for the BMR calculation.
   * @return the BMR attribute
   */
   public double getBMR()
   {
      calculateBMR(); // calls calculateBMR method.
      return BMR;
   }
   
   /**
   * Mutator for the patient's calculates BMR
   * @param _BMR   The BMR of a patient
   * @return false if input is not valid
   * @return true if input is valid
   */
   public boolean setBMR(double _BMR)
   {
      if(BMR == 1)
      {
         BMR = _BMR;
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
   * A method that calculates a person's BMI.
   */
   private void calculateBMI()
   {
      BMI = ((weight) / (Math.pow(height, 2))) * 703;   
   }
   
   /**
   * Accessor for the BMI calculation.
   * @return the BMI attribute
   */
   public double getBMI()
   {
      calculateBMI(); // calls calculateBMI method.
      return BMI;
   }
   
   /**
   * A method that calculates a person's TDEE based on their activity level.
   */
   private void calculateTDEE()
   {
      // if the activity level is sedentary
      if(activityLevel == 1)
      {
         TDEE = BMR * 1.2;
      }
      // if the activity level is lightly active
      else if(activityLevel == 2)
      {
         TDEE = BMR * 1.375;
      }
      // if the activity level is moderately active
      else if(activityLevel == 3)
      {
         TDEE = BMR * 1.55;
      }
      // if the activity level is very active
      else if(activityLevel == 4)
      {
         TDEE = BMR * 1.725;
      }
      // if the activity level is extra active
      else if(activityLevel == 5)
      {
         TDEE = BMR * 1.9;
      }
   }
   
   /**
   * Accessor for the TDEE calculation
   * @return the TDEE attribute
   */
   public double getTDEE()
   {
      calculateTDEE(); // calls calculateTDEE method.
      return TDEE;
   }
   
   /**
   * A method that returns a person's weight classification depending on their BMI. 
   * @return "under weight"
   * @return "normal weight"
   * @return "over weight"
   * @return "obese"
   */
   private String weightClassification()
   {
      // if a person's BMI is less than 18.5
      if(BMI < 18.5)
      {
         return "under weight";
      } 
      // if a person's BMI is greater or equal to 18.5 and less than 25
      else if(BMI >= 18.5 && BMI < 25)
      {
         return "normal weight";
      }
      // if a person's BMI is greater or equal to 25 and less than 30
      else if(BMI >= 25 && BMI < 30)
      {
         return "over weight";
      }
      // if a person's BMI is anything over 30
      else
      {
         return "obese";
      }
   }
   
   /**
   * Accessor for the weightClassification
   * @return the weightClassification method
   */
   public String getWeightClassification()
   {
      return weightClassification();
   }
}