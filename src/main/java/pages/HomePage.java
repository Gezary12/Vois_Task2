package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private By departureCity = By.xpath("//span[normalize-space()='Select Departure City']");
    private By departureSearch = By.xpath("//div[@id='fromCity_chosen']//input[@placeholder='Search Your City Name']");
    private By destinationCity = By.cssSelector("div[id='toCity_chosen'] span");
    private By destinationSearch = By.cssSelector("div[id='toCity_chosen'] input[placeholder='Search Your City Name']");
    private By departureDate = By.xpath("//input[@id='departDate']");
    private By departureDateNumber = By.cssSelector(".ui-state-default.ui-state-highlight");
    private By searchButton = By.xpath("//div[@id='submitSearch']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnDepartureCity(String departureCityData) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureCity));
        driver.findElement(departureCity).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureSearch));
        driver.findElement(departureSearch).sendKeys(departureCityData + Keys.ENTER);
    }


    public void clickOnDestinationCity(String destinationCityData) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(destinationCity));
        driver.findElement(destinationCity).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(destinationSearch));
        driver.findElement(destinationSearch).sendKeys(destinationCityData + Keys.ENTER);
    }

    public void chooseDepartureDate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureDate));
        driver.findElement(departureDate).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(departureDateNumber));
        WebElement selectDate = driver.findElement(departureDateNumber);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectDate);
    }

    public BookingPage clickOnSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        driver.findElement(searchButton).click();
        return new BookingPage(driver);
    }



}
