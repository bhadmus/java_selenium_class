package SaucePackage;

import FirstSelenium.FirstScript;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.*;


public class SauceClass {
    FirstScript firstScript = new FirstScript();

    Dotenv env = Dotenv.load();

    @BeforeMethod
    public void setUp(){
        firstScript.startSession();
    }

    @AfterMethod
    public void tearDown(){
        firstScript.terminateSession();
    }

    @Test(priority = 0)
    public void signInStandardUser(){
        String standardUser = env.get("STANDARD");
        String password = env.get("ACCESS_KEY");
        firstScript.accessSauceDemo(standardUser, password);
    }

    @Test(priority = 2)
    public void signInProblemUser(){
        String problemUser = env.get("PROBLEM");
        String password = env.get("ACCESS_KEY");
        firstScript.accessSauceDemo(problemUser, password);
    }

    @Test(priority = 1)
    public void signInLockedUser(){
        String lockedUser = env.get("LOCKED");
        String password = env.get("ACCESS_KEY");
        firstScript.accessSauceDemo(lockedUser, password);
    }

    @Test(priority = 3)
    public void signInGlitchUser(){
        String glitchUser = env.get("GLITCH");
        String password = env.get("ACCESS_KEY");
        firstScript.accessSauceDemo(glitchUser, password);
    }

}
