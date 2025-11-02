package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PaymentPage {

    private WebDriver driver;

    private By paymentGateway= By.xpath("(//div[@class=\"pay-opts-item\"])[1]");
    private By amountToBePaid = By.className("final--amount--paid");


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectPaymentGateway(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentGateway));
        WebElement paymentGatewaySelection = driver.findElement(paymentGateway);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",paymentGatewaySelection);
        paymentGatewaySelection.click();
    }

    public String checkTripPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountToBePaid));
        System.out.println(driver.findElement(amountToBePaid).getText());
        return driver.findElement(amountToBePaid).getText();

    }
}
