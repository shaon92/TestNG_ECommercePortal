package TestRunner;

import Pages.Shop;
import Setup.Setup;
import org.testng.annotations.Test;

public class ShopTestRunner extends Setup {

    @Test(priority = 0, description = "Sort Product By Latest")
    public void sortProductByLatestRunner() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/shop");
        Shop shop=new Shop(driver);
        shop.sortProductByLatest();
    }

    @Test(priority = 1, description = "Filter by color")
    public void filterByColorRunner() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/shop");
        Shop shop=new Shop(driver);
        shop.filterBySpecificColor();
    }

    @Test(priority = 2, description = "Price slider")
    public void slidePriceFilterRunner() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/shop");
        Shop shop=new Shop(driver);
        shop.slidePriceFilter(1,1); // from $20 to $90
    }

    @Test(priority = 3, description = "Add to cart from all products from Shop Page")
    public void addCartFromAllProductFromShopPageRunner() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/shop");
        Shop shop=new Shop(driver);
        shop.addCartFromAllProductFromShopPage();
    }
    @Test(priority = 4, groups = "purchase", description = "Select a product from Shop Page")
    public void selectProductFromShopPageRunner() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/shop");
        Shop shop=new Shop(driver);
        shop.selectProductFromShopPage();
    }
}
