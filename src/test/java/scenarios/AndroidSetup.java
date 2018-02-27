package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "192.168.216.101:5555");
        capabilities.setCapability("app","C:\\Appium\\OneFootball\\apps\\app-full-rc-v13.1.0.343.apk");
        capabilities.setCapability("appPackage", "de.motain.iliga");
        capabilities.setCapability("appActivity", "de.motain.iliga.activity.MyStreamActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4725/wd/hub"), capabilities);

    }
}
