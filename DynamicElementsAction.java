package com.elements;

import org.openqa.selenium.StaleElementReferenceException;



/**
* This class should be used, when you need to do an action against 'dynamic'
elements, i.e. elements, which can be removed from the Dom
* in every moment. This is very common, when checking for values in a grid, as
the data displayed is replaced when the response from server
* side comes back.
* @author Roman Kusnierz
*/

public abstract class DynamicElementsAction { 

     private static final int ATTEMPT_NUM = 10; 

     public abstract void doAction();

     public void run() {
            run(ATTEMPT_NUM);
     }

     public void run(int attemptscount) {
            int attempts = 0;
            Exception lastException = null;
            while(attempts < attemptscount) {
       try {
            doAction();
            return;
       } catch(StaleElementReferenceException e) {
            lastException = e; 
            System.out.println("staleElementReferenceException for the " + (attempts+1) + " time: " + e.getMessage()); 
            System.out.println(e);
         // new Timer().holdonATick(); 
       } finally {
            attempts++;
       }

       throw new RuntimeException("StaleElementReferenceException for the " + (attempts+1) + " time. Giving up.", lastException);
            }
   }
}