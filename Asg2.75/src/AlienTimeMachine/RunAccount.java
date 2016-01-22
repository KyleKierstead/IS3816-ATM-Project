/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlienTimeMachine;
import java.io.*;
import java.text.*;
import java.util.*;
/**
 *
 * @author Kyle
 */




public class RunAccount implements Serializable
{
    int i;
    String I;
    Scanner sc = new Scanner(System.in);
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    
    Account[] acctArray = new Account[3];
    
    public static void main(String args[]) throws IOException 
        {
            RunAccount ra = new RunAccount();
            
            ra.CheckRetUser();
            ra.AcctMenu();
            
            
        }
    
 
    public void AcctMenu() throws IOException
    {
        boolean cont = true;
        while(cont != false)
        {
        System.out.println("Welcome to the Alien Time Machine");
        Scanner sc = new Scanner(System.in);
        System.out.println("Which account would you like to access?"
                + "\n1 "+ acctArray[0].getID()
                + "\n2 " +acctArray[1].getID() 
                + "\n3 " +acctArray[2].getID()
                + "\n4 View All Current Account Balances"
                + "\n5 Exit");
        
        try{
            I = sc.next();
            i = Integer.parseInt(I);
             
        }
            catch(NumberFormatException e)
                    {
                    System.out.println("You made a mistake, try again");
                AcctMenu();
                    }
          if(i == 1)
          {
             i= 0;
             acctArray[i].menu();
              
          }
          else if(i == 2)
          {
              i = 1;
              acctArray[i].menu();
          }
          else if(i == 3 )
          {
              i = 2;
              acctArray[i].menu();
          }
          
          
          else if( i ==5)
          {
             System.out.println("Thank You and\n"
                     + "Have a Nice Day");
             writeArray();
             System.exit(0);
          }
          else if( i == 4)
          {
              System.out.println("Currently in Account "+ acctArray[0].getID() + " you have " + fmt.format(acctArray[0].AcctBal)); 
              System.out.println("Currently in Account "+ acctArray[1].getID() + " you have " + fmt.format(acctArray[1].AcctBal));
              System.out.println("Currently in Account "+acctArray[2].getID() + " you have " + fmt.format(acctArray[2].AcctBal));
              System.out.println(" ");
              AcctMenu();
          }
          else 
          {
              System.out.println("You made an error");
              AcctMenu();
          }
    }
    }
    
    
    
    
    

    


    

     public void populateaccts()
    {
      int g = 1;
      int h = 1;
        for( int i=0;i <acctArray.length;i++)
       {
          
          System.out.println("Please enter if you want a Checking or Savings Account [C or S]");
          String input = sc.next();
          
          if(input.equalsIgnoreCase("C"))
          {
              
              acctArray[i] = new CheckingAccount();
              acctArray[i].setID("C0000" + g);
              g++;  
          }
         else if(input.equalsIgnoreCase("S"))
          {
              
              acctArray[i] = new SavingsAccount();
              acctArray[i].setID("S0000" + h);
              h++;  
          }
       }
    }
    
      public void CheckRetUser() throws IOException
   {
     boolean lo = true;
       String UserSelct;  
     boolean Ret = false;
     while(lo==true)
     {
     System.out.println("Are you a returning user?(Yes or No)");
     UserSelct = sc.next();
     if(UserSelct.equalsIgnoreCase("yes"))
     {
         Ret = true;
         lo = false;
         
         ReadFile(); 
        //System.out.println("Test");
     }
     else if (UserSelct.equalsIgnoreCase("no"))
     {
         Ret = false;
         lo = false;
         populateaccts(); 
         //getDate1();
         
        //System.out.println("Test");
     }
     else
     {
         System.out.println("You made an error");
     }
     }
        //if yes it would read in the user 
       //WORK ON THIS going to be a boolean yes no to change values if returning, insert text like if new user "welcome"  "goodbye" etc 
   }
   public void writeArray()
{
   
    {
        try{
        
   
   
    FileOutputStream fout = new FileOutputStream("test.txt");
     ObjectOutputStream oos = new ObjectOutputStream(fout);
     oos.writeObject(acctArray);//Breaks when it hits 
     oos.flush();
     fout.close();
   
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
    

}
   public void ReadFile() //throws IOException
   {
    
      // RunAccount acctArray = null;
       try
       {
     FileInputStream fis = new FileInputStream("test.txt");
     ObjectInputStream ois = new ObjectInputStream(fis);
     acctArray = (Account[])ois.readObject();
     fis.close();
       }
       catch(Exception e)
       {
           
       }
    
    
}
}