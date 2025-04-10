package com.solvd;

import com.solvd.entity.Product;
import com.solvd.pages.base.ProductDetailPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.ProductBase;
import com.solvd.pages.base.elements.SortBase;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ProductPageTest extends BaseMobileTest {

    @Test(description = "Check if product information are the same before and after click on product")
    public void productsDetailsTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened after login");
        int productsNum = productPage.countProducts();
        for (int i = 1 ; i <= productsNum; i++) {
            ProductBase product = initPage(ProductBase.class);
            Product productFromProductsPage = new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i));
            ProductDetailPageBase productDetailPage = product.clickOnProduct(i);
            assertTrue(productDetailPage.isOpened(), "Product detail page is not opened");
            Product productFromDetailPage = new Product(productDetailPage.getImageUrl(),
                    productFromProductsPage.title(), productFromProductsPage.price());
            assertEquals(productFromDetailPage, productFromProductsPage, "Products are not the same!");
            productDetailPage.clickBackToProductsButton();
        }
    }

    @Test
    public void productSortNameAToZTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened after login");
        int productNum = productPage.countProducts();
        ProductBase product = initPage(ProductBase.class);
        List<Product> sortedProducts = IntStream.range(1, productNum).mapToObj(i ->
                new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .sorted(Comparator.comparing(Product::title))
                .toList();
        SortBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        productPage = sort.clickSortNameAToZ();
        assertTrue(productPage.isOpened(), "Product page is not opened after sort option clicked!");
        List<Product> productsAfterSortClick = IntStream.range(1, productNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                        .toList();
      assertEquals(productsAfterSortClick, sortedProducts, "Products are not sorted A to Z!");
    }
//
//    @Test
//    public void productSortNameZToATest() {
//        ProductPageBase productPage = loginService.loginToApp();
//        assertTrue(productPage.isOpened(), "Product page is not opened after login");
//        List<Product> sortedProducts = productPage.getProducts()
//                .stream()
//                .map(productBase ->
//                        new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
//                .sorted(Comparator.comparing(Product::title).reversed())
//                .toList();
//        SortBase sort = productPage.clickOnSortButton();
//        assertTrue(sort.isOpened(), "Sort did not open!");
//        productPage = sort.clickSortNameZToA();
//        List<Product> productsAfterSortClick = productPage.getProducts()
//                .stream()
//                .map(productBase -> new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
//                .toList();
//        assertEquals(productsAfterSortClick, sortedProducts, "Product are not sorted Z to A");
//    }
//
//    @Test
//    public void productSortPriceLowToHighTest() {
//        ProductPageBase productPage = loginService.loginToApp();
//        assertTrue(productPage.isOpened(), "Product page is not opened after login");
//        List<Product> sortedProducts = productPage.getProducts()
//                .stream()
//                .map(productBase ->
//                        new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
//                .sorted(Comparator.comparing(Product::price))
//                .toList();
//        SortBase sort = productPage.clickOnSortButton();
//        assertTrue(sort.isOpened(), "Sort did not open!");
//        productPage = sort.clickSortPriceLowToHigh();
//        List<Product> productsAfterSortClick = productPage.getProducts()
//                .stream()
//                .map(productBase -> new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
//                .toList();
//        assertEquals(productsAfterSortClick, sortedProducts, "Products are not sorted Low to High Price!");
//    }
//
//    @Test
//    public void productSortPriceHighToLowTest() {
//        ProductPageBase productPage = loginService.loginToApp();
//        assertTrue(productPage.isOpened(), "Product page is not opened after login");
//        List<Product> sortedProducts = productPage.getProducts()
//                .stream()
//                .map(productBase ->
//                        new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
//                .sorted(Comparator.comparing(Product::price).reversed().thenComparing(Product::title, Comparator.reverseOrder()))
//                .toList();
//        SortBase sort = productPage.clickOnSortButton();
//        assertTrue(sort.isOpened(), "Sort did not open!");
//        productPage = sort.clickSortPriceHighToLow();
//        List<Product> productsAfterSortClick = productPage.getProducts()
//                .stream()
//                .map(productBase -> new Product(productBase.getImage(), productBase.getTitle(), productBase.getPrice()))
//                .toList();
//        assertEquals(productsAfterSortClick, sortedProducts, "Products are not the sorted High to Low Price!");
//    }
//
//    @Test(description = "Button clicked on ProductsPage does change on Details Product page, and then back on ProductPage")
//    public void productShouldKeepSameButtonTest() {
//        ProductPageBase productPage = loginService.loginToApp();
//        assertTrue(productPage.isOpened(), "Product page is not opened after login");
//        List<? extends ProductBase> products = productPage.getProducts();
//        for (ProductBase product : products) {
//            product.clickAddToCartButton();
//            assertTrue(product.getRemoveFromCartButton().isElementPresent(),
//                    "Button didn't change to Remove on product page!");
//            ProductDetailPageBase productDetailPage = product.clickOnProduct();
//            assertTrue(productDetailPage.getRemoveFromCartButton().isElementPresent(),
//                    "Remove button is not present, didn't change accordingly");
//            productDetailPage.clickRemoveFromCartButton();
//            assertTrue(productDetailPage.getAddToCartButton().isElementPresent(),
//                    "Button didn't change to Add To Cart on detail product page!");
//            productDetailPage.clickBackToProductsButton();
//            assertTrue(product.getAddToCartButton().isElementPresent(),
//                    "Add to cart button is not present, didn't change accordingly");
//        }
//    }

}
