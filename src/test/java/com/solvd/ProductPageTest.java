package com.solvd;

import com.solvd.entity.Product;
import com.solvd.pages.base.ProductDetailPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.ProductBase;
import com.solvd.pages.base.elements.SortBase;
import org.testng.annotations.Test;

import java.util.Comparator;
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
            assertTrue(productDetailPage.isOpened(), "Product detail page is not opened");
            Product productFromDetailPage = new Product(productDetailPage.getImage(),
                    productFromProductsPage.title(), productFromProductsPage.price());
            assertEquals(productFromDetailPage, productFromProductsPage, "Products are not the same!");
            productDetailPage.clickBackToProductsButton();
        }
    }

    @Test
    public void productSortNameAToZTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened");
        List<Product> sortedProducts = productPage.getProducts()
                .stream()
                .sorted(Comparator.comparing(ProductBase::getTitle))
                .map(productBase ->
                        new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
                .toList();
        SortBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        productPage = sort.clickSortNameAToZ();
        List<Product> productsAfterSortClick = productPage.getProducts()
                .stream()
                .map(productBase -> new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
                .toList();
      assertEquals(productsAfterSortClick, sortedProducts, "Products are not sorted A to Z!");
    }

    @Test
    public void productSortNameZToATest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened");
        List<Product> sortedProducts = productPage.getProducts()
                .stream()
                .map(productBase ->
                        new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
                .sorted(Comparator.comparing(Product::title).reversed())
                .toList();
        SortBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        productPage = sort.clickSortNameZToA();
        List<Product> productsAfterSortClick = productPage.getProducts()
                .stream()
                .map(productBase -> new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
                .toList();
        assertEquals(productsAfterSortClick, sortedProducts, "Product are not sorted Z to A");
    }

    @Test
    public void productSortPriceLowToHighTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened");
        List<Product> sortedProducts = productPage.getProducts()
                .stream()
                .map(productBase ->
                        new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
                .sorted(Comparator.comparing(Product::price))
                .toList();
        SortBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        productPage = sort.clickSortPriceLowToHigh();
        List<Product> productsAfterSortClick = productPage.getProducts()
                .stream()
                .map(productBase -> new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
                .toList();
        assertEquals(productsAfterSortClick, sortedProducts, "Products are not sorted Low to High Price!");
    }
}
