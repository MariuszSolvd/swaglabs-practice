package com.solvd;

import com.solvd.entity.Product;
import com.solvd.pages.base.ProductDetailPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.ProductBase;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ProductPageTest extends BaseMobileTest {

    @Test(description = "Check if product information are the same before and after click on product")
    public void productsDetailsTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened");
        List<? extends ProductBase> products = productPage.getProducts();
        for (ProductBase product : products) {
            Product productFromProductsPage = new Product(product.getImage(), product.getTitle(), product.getPrice());
            ProductDetailPageBase productDetailPage = product.clickOnProduct();
            Product productFromDetailPage = new Product(productDetailPage.getImage(),
                    productFromProductsPage.title(), productFromProductsPage.price());
            assertEquals(productFromDetailPage, productFromProductsPage, "Products are not the same!");
            productDetailPage.clickBackToProductsButton();
        }
    }

}
