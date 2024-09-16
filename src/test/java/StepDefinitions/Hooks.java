package StepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    @After
    public  void afterScenario(){
        DriverManager.getDriver().driver.close();
    }

}