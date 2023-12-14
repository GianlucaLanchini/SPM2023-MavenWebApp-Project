package unicam.spm2023.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumWebAppTest {

    private final static Logger LOGGER = Logger.getLogger("SeleniumWebAppTest");

    static ChromeOptions options = new ChromeOptions();

    static WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        options.addArguments("--headless");
    }

    @BeforeEach
    void setUp() throws Exception {
        driver = new ChromeDriver(options);
    }

    @Test
    @Tag("AcceptanceTest")
    void checkWebApp() throws InterruptedException {

        /*
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/java/unicam/spm2023/drivers/chromedriver");
        */

        driver.get("http://localhost:8080/SPM2023-WebApp/");

        Thread.sleep(1000);

        String title = driver.getTitle();
        String trueTitle = "SPM 2023";

        //System.out.println(at);
        Thread.sleep(1000);

        assertEquals(title, trueTitle);

        Thread.sleep(1000);

        String h2 = driver.findElement(By.xpath("//h2")).getText();
        String realh2 = "Hello World!";

        Thread.sleep(1000);

        assertEquals(h2, realh2);

        Thread.sleep(1000);

        String h3 = driver.findElement(By.xpath("//h3")).getText();
        String realh3 = "Today is the 28th of November.";

        Thread.sleep(1000);

        assertEquals(h2, realh2);

        LOGGER.info("All elements in the page are correct");

        driver.close();
        driver.quit();

    }


}
