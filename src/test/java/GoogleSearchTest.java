import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleSearchTest {
    private WebDriver driver;
    String URL = "https://www.google.com/";


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/cnstantin/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    @Parameters({"keyword"})
    public void search(@Optional("Selenium") String keyword){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword);
        searchBox.submit();

        Assert.assertTrue(driver.findElement(By.cssSelector("textarea[name='q']")).getText().equals(keyword));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
