package TestRunner;

import Pages.Sale;
import Setup.Setup;
import org.testng.annotations.Test;

public class SaleTestRunner extends Setup {

    @Test(priority = 0, description = "Get Page headline")
    public void getPageHeadlineRunner() {
        driver.get("https://envothemes.com/envo-ecommerce/sale");
        Sale sale=new Sale(driver);
        sale.getPageHeadline();
    }
    @Test(priority = 1, description = "Discount calculation for Sale")
    public void discountCalculationOnSaleRunner() {
        driver.get("https://envothemes.com/envo-ecommerce/sale");
        Sale sale=new Sale(driver);
        sale.discountCalculationOnSale();
    }
    @Test(priority = 2, description = "Check if 'Sale!' Tag is present on each product in Sale page")
    public void checkSaleTagOnProductsRunner() {
        driver.get("https://envothemes.com/envo-ecommerce/sale");
        Sale sale=new Sale(driver);
        sale.checkSaleTagOnProducts();
    }
    @Test(priority = 3, description = "Add to cart from all products from Sale Page")
    public void addCartFromAllProductFromSalePageRunner() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/sale");
        Sale sale=new Sale(driver);
        sale.addCartFromAllProductFromSalePage();
    }
    @Test(priority = 4, groups = "purchase", description = "Select a product from Sale Page")
    public void selectOneProductFromSalePageRunner() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/sale");
        Sale sale=new Sale(driver);
        sale.selectOneProductFromSalePage();
    }
}
