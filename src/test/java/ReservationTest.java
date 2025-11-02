import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import pages.BookingPage;
import pages.PaymentPage;
import utils.Utilities;

public class ReservationTest extends BaseTest {

    private Utilities util = new Utilities();
    private String departureCityData = util.readTestData(1, 1);
    private String destinationCityData = util.readTestData(2, 1);
    private String mobileNumberData = util.readTestData(1, 2);
    private String emailData = util.readTestData(1, 3);
    private String passengerNameData = util.readTestData(1, 4);
    private String passengerAgeData = util.readTestData(1, 5);


    @Test
    public void verifyUserCanSelectDepartureCity() {

       homepage.clickOnDepartureCity(departureCityData);
       homepage.clickOnDestinationCity(destinationCityData);
       homepage.chooseDepartureDate();
       BookingPage bookingPage=homepage.clickOnSearchButton();
        bookingPage.clickSelectSeatButton();
        bookingPage.selectAvaliableSeat();
        bookingPage.selectBoardingPoint();
        bookingPage.selectDroppingPoint();
        bookingPage.clickOnProvidePassengerDetails();
        bookingPage.enterCustomerDetails(mobileNumberData,emailData);
        bookingPage.clickOnProceedButton();
        bookingPage.enterPassengerDetails(passengerNameData,passengerAgeData);
        PaymentPage paymentPage=bookingPage.proccedToCheckout();
        paymentPage.selectPaymentGateway();
        Assert.assertNotEquals(paymentPage.checkTripPrice(), 0, "The user has filled in all the details until the actual payment step!");




    }
}
