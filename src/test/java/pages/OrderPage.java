package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static driverManager.DriverManager.getDriver;

public class OrderPage extends BasePage {

    //Locators
    @FindBy(xpath = "//span[contains(., 'Women')]")
    WebElement womenMenu;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement nextAtShippingAddress;

    @FindBy(css = ".page-title-wrapper")
    WebElement womenMenuTitle;

    @FindBy(xpath = "//a[contains(text(), 'Jackets')]")
    WebElement jacketsCategoryBtn;

    @FindBy(xpath = "//a[contains(text(), 'Juno Jacket')]")
    WebElement specificProduct;

    @FindBy(xpath = "//div[@class='swatch-opt-1380']//div[@id='option-label-size-143-item-166']")
    WebElement xsSize;

    @FindBy(xpath = "//div[@class='swatch-opt-1380']//div[@id='option-label-color-93-item-53']")
    WebElement greenColor;

    @FindBy(xpath = "//li[2]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]//span[1]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[contains(text(), 'Proceed to Checkout')]")
    WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//div[normalize-space()='Shipping Address']")
    WebElement shippingAddressAssert;

    @FindBy(css = ".showcart")
    WebElement addToCartIcon;

    @FindBy(css = ".counter-number")
    WebElement cartCounter;

    @FindBy(css = "[role='alert'] span")
    WebElement shippingMethodMissingAssert;

    @FindBy(css = "[class='field required'] [type='email']")
    WebElement selectEmail;

    @FindBy(css = "[name='shippingAddress.firstname'] div input")
    WebElement selectFirstName;

    @FindBy(css = "[name='shippingAddress.lastname'] div input")
    WebElement selectLastName;

    @FindBy(css = "[name='shippingAddress.street.0'] div input")
    WebElement selectStreet;

    @FindBy(css = "[name='shippingAddress.city'] div input")
    WebElement selectCity;

    @FindBy(css = "[name='shippingAddress.region_id'] div")
    WebElement selectRegionDropdown;

    @FindBy(css = "[data-title='Alabama']")
    WebElement selectAlabama;

    @FindBy(css = "[name='shippingAddress.postcode'] div input")
    WebElement selectPostcode;

    @FindBy(css = "[name='telephone']")
    WebElement selectPhoneNo;

    @FindBy(css = "[value='flatrate_flatrate']")
    WebElement selectShippingMethod;

    @FindBy(css = "[title=\"Place Order\"]")
    WebElement selectPlaceOrder;

    @FindBy(css = "[data-ui-id=\"page-title-wrapper\"]")
    WebElement assertOrderConfirmation;


    //Utilities
    String baseURL = "https://magento.softwaretestingboard.com/";

    //Methods

    public void navigateToAWebPage() {
        getDriver().get(baseURL);
    }

    public void selectingWomenMenu() {
        clickOnElement(womenMenu);
        Assert.assertTrue(womenMenuTitle.isDisplayed());
    }

    public void selectingSpecificCategory() {
        clickOnElement(jacketsCategoryBtn);
        Assert.assertTrue(womenMenuTitle.isDisplayed());
    }


    public void selectSKU() {
        hoverElement(specificProduct);
    }

    public void selectTheColor() {
        clickOnElement(greenColor);
    }

    public void selectTheSize() {
        clickOnElement(xsSize);
    }

    public void addToCart() {
        clickOnElement(addToCartBtn);
    }

    public void selectTheCart() {
        waitForText(cartCounter, "1");
        clickOnElement(addToCartIcon);
    }

    public void clickOnCheckout() {
        clickOnElement(proceedToCheckoutBtn);
        waitForText(shippingAddressAssert, "Shipping Address");
    }

    public void shippingAddressNext() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(nextAtShippingAddress);
    }

    public void assertErrorAtNext() {
        waitForText(shippingMethodMissingAssert, "The shipping method is missing. Select the shipping method and try again.");
    }

    public void fillingForms() {
        explicitWait(selectPhoneNo);
        explicitWait(selectFirstName);
        type(selectEmail, "miha.pek@gmail.com");
        type(selectFirstName, "Andrei");
        type(selectLastName, "Pirvulescu");
        type(selectStreet, "Aleea 9 Primăverii");
        type(selectCity, "Craiova");
        clickOnElement(selectRegionDropdown);
        clickOnElement(selectAlabama);
        type(selectPostcode, "200103");
        type(selectPhoneNo, "07207111442");
        clickOnElement(selectShippingMethod);
    }

    public void clickPlaceOrder() throws InterruptedException {
        explicitWait(selectPlaceOrder);
        Thread.sleep(1000);
        clickOnElement(selectPlaceOrder);
    }

    public void assertOrderConfirmation() {
        explicitWait(assertOrderConfirmation);
        waitForText(assertOrderConfirmation, "Thank you for your purchase!");
    }
}