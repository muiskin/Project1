package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    // ThreadLocal to maintain a separate WebDriver instance per thread
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    // Private constructor to prevent instantiation
    private Driver() { }

    public static WebDriver getDriver() {

        final ChromeOptions chromeOptions = getChromeOptions();

        // If no WebDriver instance is assigned to the current thread, create a new one
        if (driverThread.get() == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "edge":
                    driverThread.set(new EdgeDriver());
                    break;
                case "firefox":
                    driverThread.set(new FirefoxDriver());
                    break;
                case "headless":
                    driverThread.set(new ChromeDriver(new ChromeOptions().addArguments("--headless")));
                    break;
                default:
                    driverThread.set(new ChromeDriver(getChromeOptions()));
            }

            // WebDriver configuration common for all instances
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

        // Return the WebDriver instance specific to the current thread
        return driverThread.get();
    }

    private static ChromeOptions getChromeOptions() {
        final Map<String, Object> chromePrefs = new HashMap<>();   // This option for "the password you just used was found in a data breach" pop up on chrome
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        return chromeOptions;
    }

    public static void closeDriver() {
        // Quit and remove WebDriver instance for the current thread
        if (driverThread.get() != null) {
            try {
                Thread.sleep(3000); // Optional sleep, can be removed if not needed
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driverThread.get().quit();
            driverThread.remove(); // Remove instance to prevent memory leaks
        }
    }
}
