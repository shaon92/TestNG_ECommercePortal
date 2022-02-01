package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Sale {
    WebDriver driver;
    @FindBy(tagName = "h1")
    WebElement lblPageHeadLine;
    @FindBy(tagName = "bdi")
    List<WebElement> price;
    @FindBy(className = "onsale")
    List<WebElement> saleTag;
    @FindBy(xpath = "//a[contains(text(),\"Add to cart\")]")
    List<WebElement> btnAddCartFromAllProducts;
    @FindBy(xpath = "//a[contains(text(),\"View cart\")]")
    List<WebElement> viewCart;
    @FindBy(xpath = "//a[contains(text(),\"Proceed to checkout\")]")
    WebElement btnCheckout;
    @FindBy(css = "img")
    List<WebElement> imgProducts;

    public Sale(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void getPageHeadline() {
        System.out.println("Page headline: "+lblPageHeadLine.getText());
        Assert.assertTrue(lblPageHeadLine.getText().contains("SALE"));
    }
    public void discountCalculationOnSale() {
        double givenPrice, discountPrice,expectedDiscountPrice;
        givenPrice = Double.parseDouble(price.get(10).getText().substring(1));
        discountPrice = Double.parseDouble(price.get(11).getText().substring(1));
        expectedDiscountPrice = givenPrice - Math.floor(givenPrice*.30); // 30% Sale
        System.out.println("Calculated Discount Price: "+ expectedDiscountPrice);
        org.testng.Assert.assertEquals(discountPrice,expectedDiscountPrice);
    }
    public void checkSaleTagOnProducts() {
        System.out.println("Tag on product: "+saleTag.get(5).getText());
        Assert.assertTrue(saleTag.get(5).getText().contains("Sale!"));
    }
    public void addCartFromAllProductFromSalePage() throws InterruptedException {
        btnAddCartFromAllProducts.get(4).click();
        Thread.sleep(1000);
        viewCart.get(2).click();
        Thread.sleep(1000);
        btnCheckout.click();
    }
    public void selectOneProductFromSalePage() throws InterruptedException {
        imgProducts.get(7).click();
        Thread.sleep(500);
    }
}
