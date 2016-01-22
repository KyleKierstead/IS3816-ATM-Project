/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlienTimeMachine;

import java.text.*;
import java.util.*;
import java.io.*;



/**
 *
 * @author Kyle
 */
public abstract class Account implements Serializable
{
    protected double balance;
    protected int firstdate;//WORK ON THIS, ADD DATES 
    protected int seconddate;
    protected Calendar cal1 = new GregorianCalendar();
    protected Calendar cal2 = new GregorianCalendar();
    protected boolean dateflag = false;
    protected double rate ;
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    private String ID; 
    int i;
    double AcctBal;
    
public void setID(String s)
    {
        ID = new String(s);
    }

public String getID()
{
    return ID;
}
protected abstract void CalcInt();
//   {
//       
//       int datediff = seconddate - firstdate;
//        rate = .05/365;//this is where you can play with what rate is going to be.
//       double ratetime = Math.pow(1+rate,datediff); 
//               //math.pow(1+rate,datediff);
//        AcctBal = AcctBal * ratetime;
//        firstdate = seconddate;
//        //accounts[i] += intamount;
//   }

 public void menu() throws IOException
    {
     
     
     //while(cont == true)
     {
        //System.out.println("Welcome to the Alien Time Machine");
        System.out.println("What would you like to do");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter 1 for deposit, 2 for withdraw, 3 for check balence, 4 to exit to Account Menu, 5 to activate the ATM " );
        int input = 0 ;
        //input = sc.nextInt();    
        try{
                input = sc.nextInt();
            } 
            catch(InputMismatchException e)
            {
                System.out.println("You made a mistake, try again");
                menu();
            }
                
        if(input == 1)
        {
        if(dateflag == true)
        {
             getDate2();
          CalcInt();
                deposit();
        }

            else 
            {
                getDate1();
                deposit();
            }
            
            
            
           
        }
        else if (input == 2)
        {
         if(dateflag == true)
        {
           getDate2();
         CalcInt();
            withdraw();
        }

        else 
        {
            getDate1();
            withdraw();
}
            
            
            
        }
        
        else if(input == 3)
        {
            checkBalance();
        } 
        else if (input == 5)
        {
            TimeMachine();
            menu();
        }
        else if(input == 4)
        {
         // System.out.println("Have a nice day!");
          // cont = false;
        
        //AcctMenu();
        }
        else
        {
         System.out.println("try reading the directions");
         menu();
        }
        
     }
    
}
 public void deposit() throws IOException
    {
     //int choice;
     //Scanner sc = new Scanner(System.in);
      //System.out.println("Which account would you like to access(1,2,3)?");
     //choice = 0;
        // choice = sc.nextInt();
      double Amount;
      //try{
        //        choice = sc.nextInt();
          //  } 
            //catch(InputMismatchException e)
           // {
             //   System.out.println("You made a mistake, try again");
               // deposit();
            //}
      
  //    if( choice == 1)
      {
       Scanner sc = new Scanner(System.in);
        System.out.println("Your current balence is: " + fmt.format( AcctBal));
          System.out.print("How much would you like to deposit?? ");
          Amount = sc.nextDouble();
          if (Amount >=0)
          {
          AcctBal += Amount;
          
          System.out.println("Your new balence is: " + fmt.format( AcctBal));
      }
          else{
              System.out.println("Invalid amount");
              deposit();
          }
      }
   /*   else if( choice ==2)
      {
          System.out.println("Your current balence is: " + fmt.format(accounts[1]));
          System.out.print("How much would you like to deposit?? ");
          Amount = sc.nextDouble();
          if (Amount >=0)
          {
          accounts[1] += Amount;
          
          System.out.println("Your new balence is: " + fmt.format(accounts[1]));
      }
          else{
              System.out.println("Invalid amount");
              deposit();
          }
      }
      else if (choice == 3)
      {
          System.out.println("Your current balence is: " +fmt.format( accounts[2]));
          System.out.print("How much would you like to deposit?? ");
          Amount = sc.nextDouble();
          if (Amount >=0)
          {
          accounts[2] += Amount;
          
          System.out.println("Your new balence is: " + fmt.format(accounts[2]));
      }
          else{
              System.out.println("Invalid amount");
              deposit();
          }
      }
      else
      {
      System.out.println("Invalid input");
      deposit();
      }
       */ menu();
    }
    
    public void getDate1() throws IOException 
    {
        System.out.print("Enter todays date(mm/dd/yyyy): ");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String inputText = br.readLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(inputText, pos);
        
        cal1.setTime(date);
        
        firstdate = cal1.get(Calendar.DAY_OF_YEAR);
        dateflag = true;
    }
    
    public void getDate2() throws IOException
    {
       
        System.out.print("Enter todays date (mm/dd/yyyy): ");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String inputText = br.readLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(inputText, pos);
        
        cal2.setTime(date);
        seconddate = cal2.get(Calendar.DAY_OF_YEAR);
        
        if( firstdate>seconddate)
        {
            System.out.println("You must enter a future date");
            getDate2();
        }
    }
    
    
    public void withdraw() throws IOException
    {
   //  int choice;
  //   Scanner sc = new Scanner(System.in);
    //  System.out.println("Which account would you like to access(1,2,3)?");
    //  choice = 0;
    //choice = sc.nextInt();
      double Amount;
    
      //try{
        //        choice = sc.nextInt();
       //     } 
         //   catch(InputMismatchException e)
          //  {
            //    System.out.println("You made a mistake, try again");
              //  withdraw();
            //}
      //if( choice == 1)
      //{
      Scanner sc = new Scanner(System.in);   
      System.out.println("Your current balence is: " + fmt.format(AcctBal));
          System.out.print("How much would you like to withdraw?? ");
          Amount = sc.nextDouble();
          if (Amount >=0 && Amount<= AcctBal)
          {
          AcctBal -= Amount;
          
          System.out.println("Your new balence is: " +fmt.format( AcctBal));
      }
          else{
              System.out.println("Invalid amount");
              withdraw();
          }
      menu(); 
            }/*
      else if( choice ==2 )
      {
          System.out.println("Your current balence is: " +fmt.format( accounts[1]));
          System.out.print("How much would you like to withdraw?? ");
          Amount = sc.nextDouble();
          if (Amount >=0 && Amount<= accounts[1])
          {
          accounts[1] -= Amount;
          
          System.out.println("Your new balence is: " +fmt.format( accounts[1]));
      }
          else{
              System.out.println("Invalid amount");
              withdraw();
          }
      }
      else if (choice == 3)
      {
          System.out.println("Your current balence is: " +fmt.format( accounts[2]));
          System.out.print("How much would you like to withdraw?? ");
          Amount = sc.nextDouble();
          if (Amount >=0 && Amount<= accounts[2])
          {
          accounts[2] -= Amount;
          
          System.out.println("Your new balence is: " + fmt.format(accounts[2]));
      }
          else{
              System.out.println("Invalid amount");
              withdraw();
          }
      }
      else
      {
      System.out.println("Invalid input");
      withdraw();
      }
        */// menu();
    //}
    
    
    public void checkBalance() throws IOException
    {
        //int choice;
       //Scanner sc = new Scanner(System.in);
      //System.out.println("Which account would you like to access(1,2,3)?");
      //choice = 0;  
    //choice = sc.nextInt();
      //double Amount;
     // try{
       //         choice = sc.nextInt();
         //   } 
           // catch(InputMismatchException e)
           // {
             //   System.out.println("You made a mistake, try again");
               // checkBalance();
            //}
      //if( choice == 1)
      //{
         System.out.println("Your current balance is "+fmt.format(AcctBal));
      //}
    /*
        else if(choice == 2)
      {
         System.out.println("Your current balance in account 2 is "+fmt.format(accounts[1]));
      }
        else if( choice == 3)
      {
         System.out.println("Your current balance in account 3 is "+fmt.format(accounts[2]));
      }*/
     menu();
    //} 

}
     public void TimeMachine()
    {
        System.out.println("Thank you for activating the Alien Time Machine");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("><><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("<><><><><><><><><><><><><><<><><><><><><><><><><><><><><><><><><><><><><>");
         System.out.println("                   Your dates have now been reset");
        dateflag = false;
        
        
    }
}




