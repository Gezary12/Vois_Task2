import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Utilities;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homepage;

    private Utilities util = new Utilities();
    private String URL = util.readTestData(1, 0);


    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-application-cache");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void goBookingPage() {
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get(URL);
        homepage = new HomePage(driver);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}