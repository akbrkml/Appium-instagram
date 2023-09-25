package tests;

import com.appium.manager.AppiumDriverManager;
import com.asliri.SocialMediaBuzzer;
import com.asliri.driver.Driver;
import com.asliri.driver.DriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public abstract class BaseTest {

    protected SocialMediaBuzzer buzzer = new SocialMediaBuzzer();

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        setupSocialMediaHandler();
    }

    @AfterMethod
    public void tearDown() {
        Driver.deinit();
    }

    protected abstract void setupSocialMediaHandler();

}
