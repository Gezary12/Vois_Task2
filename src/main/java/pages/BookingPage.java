package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingPage {

    private WebDriver driver;

    private By seatButton = By.xpath("//div[text()='Select Seats']");
    private By avaliableSeatNumber = By.xpath("//div[contains(@style, 'rgb(30, 178, 75)')]");
    private By boardingPoint = By.xpath("//div[@class='pick--val']");
    private By droppingPointfield = By.xpath("//div[text()='Select Dropping Point']");
    private By droppingPoint = By.cssSelector(".drop--val");
    private By detailsButton = By.xpath("//div[@class='btnPassDetails']");
    private By mobileNumber = By.xpath("//input[@name='mobileNo']");
    private By email = By.xpath("//input[@name='email']");
    private By proceedButton = By.xpath("//div[normalize-space()='PROCEED TO passenger detail as guest user']");
    private By nameField = By.xpath("//input[@placeholder=\"Name\"]");
    private By genderField = By.xpath(" //input[@droptype=\"onward_gender\"]");
    private By selectGender= By.xpath("//div[text()='Male']");
    private By ageField = By.xpath(" //input[@type=\"tel\"]");
    private By concessionButton = By.xpath("//input[@droptype=\"onward_concession\"]");
    private By selectConsession= By.xpath("//div[text()='GENERAL PUBLIC']");
    private By proceedToCheckout= By.xpath("//div[text()=\"Proceed to Checkout\"]");

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSelectSeatButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(seatButton));
        driver.findElement(seatButton).click();
    }

    public void selectAvaliableSeat() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(avaliableSeatNumber));
        driver.findElement(avaliableSeatNumber).click();
    }

    public void selectBoardingPoint() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(boardingPoint));
        driver.findElement(boardingPoint).click();
    }

    public void selectDroppingPoint() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(droppingPointfield));
        driver.findElement(droppingPointfield).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(droppingPoint));
        driver.findElement(droppingPoint).click();
    }

    public void clickOnProvidePassengerDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(detailsButton));
        driver.findElement(detailsButton).click();
    }

    public void enterCustomerDetails(String mobileNumberData,String emailData) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));
        driver.findElement(mobileNumber).sendKeys(mobileNumberData);
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).sendKeys(emailData);

    }


    public void clickOnProceedButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedButton));
        driver.findElement(proceedButton).click();
    }

    public void enterPassengerDetails(String passengerNameData,String passengerAgeData){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(passengerNameData);
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderField));
        driver.findElement(genderField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectGender));
        driver.findElement(selectGender).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ageField));
        driver.findElement(ageField).sendKeys(passengerAgeData);
        wait.until(ExpectedConditions.visibilityOfElementLocated(concessionButton));
        driver.findElement(concessionButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectConsession));
        driver.findElement(selectConsession).click();

    }

    public PaymentPage proccedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout));
        driver.findElement(proceedToCheckout).click();
        return new PaymentPage(driver);


    }


}
