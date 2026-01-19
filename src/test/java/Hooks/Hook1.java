package Hooks;

import Browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hook1 {
    @Before
    public void beforeMethod(){
        System.out.println("Before Scenario");
    }
//    @BeforeStep
//    public void beforeEverySteps(){
//        System.out.println("Before every steps");
//    }

//    @AfterStep
//    public void afterEverySteps(){
//        System.out.println("After every steps");
//    }
    @After
    public void afterMethod(){
        System.out.println("After Scenario");
        Browser.closeBrowser();
    }

//    @Before("@Smoke")
//    public void beforeSmoke(){
//        System.out.println("Before Smoke Scenario only");
//    }
//
//    @After("@Smoke")
//    public void afterSmoke(){
//        System.out.println("After Smoke Scenario only");
//    }

}
