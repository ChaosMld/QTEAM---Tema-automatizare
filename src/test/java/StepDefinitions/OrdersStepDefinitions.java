package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OrderPage;

import java.time.Duration;

import static driverManager.DriverManager.getDriver;

public class OrdersStepDefinitions {

    OrderPage orderPage = new OrderPage();
    @Given("I navigate to homePage")
    public void iNavigateToHomePage() {
        orderPage.navigateToAWebPage();
    }

    @And("I click on Women Category")
    public void iClickOnWomenCategory() {
        orderPage.selectingWomenMenu();
    }

    @And("I select a specific category")
    public void iSelectASpecificCategory() {
        orderPage.selectingSpecificCategory();
    }

    @And("I select the SKU")
    public void iSelectTheSKU() {
        orderPage.selectSKU();
    }

    @And("I select the color")
    public void iSelectTheColor() {
        orderPage.selectTheColor();
    }

    @And("I select the size")
    public void iSelectTheSize() {
        orderPage.selectTheSize();
    }

    @When("I click on Add to Cart")
    public void iClickOnAddToCart() {
        orderPage.addToCart();
    }

    @Then("I select the cart")
    public void iSelectTheCart() {
       orderPage.selectTheCart();
    }

    @And("I click on Checkout")
    public void iClickOnCheckout() {
        orderPage.clickOnCheckout();
    }

    @Then("I click on Next")
    public void iClickOnNext() throws InterruptedException {
        orderPage.shippingAddressNext();
    }

    @And("I check the error validation")
    public void iCheckTheErrorValidation() {
        orderPage.assertErrorAtNext();
    }

    @And("I fill in the Shipping details")
    public void iFillInTheShippingDetails() {
        orderPage.fillingForms();
    }

    @And("I click on Place Order")
    public void iClickOnPlaceOrder() throws InterruptedException {
    orderPage.clickPlaceOrder();
    }

    @Then("I check the Order Confirmation Text")
    public void iCheckTheOrderConfirmationText() {
        orderPage.assertOrderConfirmation();
    }
}
