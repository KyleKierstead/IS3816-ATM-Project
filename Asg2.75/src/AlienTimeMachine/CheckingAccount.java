/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AlienTimeMachine;

/**
 *
 * @author kckqt4
 */
public class CheckingAccount extends Account 
    {
     @Override
     public void CalcInt() 
     {
      int datediff = seconddate - firstdate;
      rate = .05/365;
      double ratetime = Math.pow(1+rate,datediff);
      AcctBal = AcctBal * ratetime;
      firstdate = seconddate; 
      
    }
 
}