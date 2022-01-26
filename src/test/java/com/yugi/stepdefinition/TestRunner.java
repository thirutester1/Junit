package com.yugi.stepdefinition;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

//import com.flipkart.stedefinition.Amazon;
//import com.flipkart.stedefinition.Flipkart;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({Flipkart.class,Amazon.class})
public class TestRunner {
	
	public static void main(String[] args) {
     Result r = JUnitCore.runClasses(Flipkart.class,Amazon.class);
     
     int run = r.getRunCount();
     System.out.println("Total run is :"+run);
     
     int failures = r.getFailureCount();
     System.out.println("Total failures are :"+failures);
     
     int ignoreCount = r.getIgnoreCount();
     System.out.println("Ignored methods are :"+ignoreCount);
     
     long runTime = r.getRunTime();
     System.out.println("Total runtime is :"+runTime);
		
		List<Failure> failures2 = r.getFailures();
		for (Failure failure : failures2) {
			System.out.println(failure);
		}
	}
	
}
