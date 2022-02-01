package Pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Shop {
    WebDriver driver;
    @FindBy(name = "orderby")
    WebElement dropdown;
    @FindBy(xpath = "//option[contains(text(),'Sort by latest')]")
    WebElement lblOption;
    @FindBy(tagName = "span")
    List<WebElement> slider;
    @FindBy(xpath = "//button[contains(text(),\"Filter\")]")
    WebElement btnFilter;
    @FindBy(xpath = "//button[contains(text(),\"Apply\")]")
    WebElement btnApply;
    @FindBy(className = "from")
    WebElement lblFromPrice;
    @FindBy(className = "to")
    WebElement lblToPrice;
    @FindBy(className = "select2-search__field")
    WebElement colorInput;
    @FindBy(className = "select2-selection__choice")
    WebElement lblColor;
    @FindBy(xpath = "//a[contains(text(),\"Add to cart\")]")
    List<WebElement> btnAddCartFromAllProducts;
    @FindBy(xpath = "//a[contains(text(),\"View cart\")]")
    List<WebElement> viewCart;
    @FindBy(xpath = "//a[contains(text(),\"Proceed to checkout\")]")
    WebElement btnCheckout;
    @FindBy(css = "img")
    List<WebElement> imgProducts;

    public Shop(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortProductByLatest() throws InterruptedException {
        Select select = new Select(dropdown);
        select.selectByIndex(3);
        Thread.sleep(2000);
        Assert.assertTrue(lblOption.getText().contains("Sort by latest"));
    }

    public void filterBySpecificColor() throws InterruptedException {
        colorInput.sendKeys("Black");
        Actions action= new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);
        btnApply.click();
        Thread.sleep(500);
        System.out.println("Selected color:"+lblColor.getText());
        Assert.assertTrue(lblColor.getText().contains("Black"));
    }

    public void slidePriceFilter(int left, int right) throws InterruptedException {
        Actions action1= new Actions(driver);
        action1.click(slider.get(71)).build().perform();
        Thread.sleep(1000);
        for (int i = 1; i <= left; i++)
        {
            action1.sendKeys(Keys.ARROW_RIGHT).build().perform(); // Increasing $10 per right arrow press from $10
        }
        Thread.sleep(1000);

        Actions action2= new Actions(driver);
        action2.click(slider.get(72)).build().perform();
        for (int i = 1; i <= right; i++)
        {
            action2.sendKeys(Keys.ARROW_LEFT).build().perform(); // $Decreasing $10 per left arrow press from $100
        }
        Thread.sleep(1000);

        btnFilter.click();
        System.out.println("From: "+lblFromPrice.getText()+" to "+lblToPrice.getText());
        Assert.assertTrue(lblFromPrice.getText().contains("$20"));
        Assert.assertTrue(lblToPrice.getText().contains("$90"));
    }
    public void addCartFromAllProductFromShopPage() throws InterruptedException {
        btnAddCartFromAllProducts.get(1).click();
        Thread.sleep(2000);
        viewCart.get(2).click();
        Thread.sleep(2000);
        btnCheckout.click();
    }
    public void selectProductFromShopPage() throws InterruptedException {
        imgProducts.get(8).click();
        Thread.sleep(500);
    }
}
