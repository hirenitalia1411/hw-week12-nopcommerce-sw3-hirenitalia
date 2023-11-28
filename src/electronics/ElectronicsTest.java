package electronics;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;
import zmq.socket.radiodish.Radio;

import java.util.Random;

public class ElectronicsTest extends Utility {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // 1.3 Verify the text “Cell phones”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
    }

    // 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // 1.3 Verify the text “Cell phones”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"), "Nokia Lumia 1020");
        // 2.7 Verify the price “$349.00”
        verifyTheStringMessage(By.xpath("//span[@id='price-value-20']"), "$349.00");
        // 2.8 Change quantity to 2
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), s);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        // 2.10 Verify the Message "The product has been added to your shopping cart" on To green Bar After that close the bar clicking on the cross button.
        verifyTheStringMessage(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        // 2.12 Verify the message "Shopping cart"
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        // 2.13 Verify the quantity is 2
        String expectedValue = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        String actualValue = "2";
        Assert.assertEquals(expectedValue, actualValue);
        // 2.14 Verify the Total $698.00
        verifyTheStringMessage(By.xpath("//span[@class='product-subtotal']"), "$698.00");
        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"), "Welcome, Please Sign In!");
        // 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        // 2.19 Verify the text “Register”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Register']"), "Register");
        // 2.20 Fill the mandatory fields (First Name)
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Abcd");
        // 2.20 Fill the mandatory fields (Last Name)
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Xyz");
        // 2.20 Fill the mandatory fields (Email)
        Random random = new Random();
        sendTextToElement(By.xpath("//input[@id='Email']"), "abcd"+random.nextInt()+"@gmail.com");
        // 2.20 Fill the mandatory fields (Password)
        sendTextToElement(By.xpath("//input[@id='Password']"), "abcd123");
        // 2.20 Fill the mandatory fields (Confirm Password)
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "abcd123");
        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        // 2.22 Verify the message “Your registration completed”
        verifyTheStringMessage(By.xpath("//div[@class='result']"), "Your registration completed");
        // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 2.24 Verify the text “Shopping card”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.26 Click on “CHECKOUT”

        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.27 Fill the Mandatory fields

        // 2.28 Click on “CONTINUE”
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        // 2.30 Click on “CONTINUE”
        // 2.31 Select Radio Button “Credit Card”
        // 2.32 Select “Visa” From Select credit card dropdown
        // 2.33 Fill all the details
        // 2.34 Click on “CONTINUE”
        // 2.35 Verify “Payment Method” is “Credit Card”
        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        // 2.37 Verify Total is “$698.00”
        // 2.38 Click on “CONFIRM”
        // 2.39 Verify the Text “Thank You”
        // 2.40 Verify the message “Your order has been successfully processed!”
        // 2.41 Click on “CONTINUE”
        // 2.42 Verify the text “Welcome to our store”
        // 2.43 Click on “Logout” link
        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
    }


    @After
    public void tearDown() {
      //  closeBrowser();
    }
}
