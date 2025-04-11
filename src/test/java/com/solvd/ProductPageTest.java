package com.solvd;

import com.solvd.entity.Product;
import com.solvd.pages.base.ProductDetailPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.ProductBase;
import com.solvd.pages.base.elements.SortBoxBase;
import com.solvd.utilis.enums.Sorter;
import org.testng.annotations.Test;

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
        int productsNum = productPage.getProductCount();
        for (int i = 1 ; i < productsNum; i++) {
            ProductBase product = initPage(ProductBase.class);
            Product productFromProductsPage = new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i));
            ProductDetailPageBase productDetailPage = product.clickOnProduct(i);
            assertTrue(productDetailPage.isOpened(), "Product detail page is not opened");
            Product productFromDetailPage = new Product(productDetailPage.getImageUrl(),
                    productDetailPage.getTitleLabel(), productDetailPage.getPriceLabel());
            assertEquals(productFromDetailPage, productFromProductsPage, "Products are not the same!");
            productDetailPage.clickBackToProductsButton();
        }
    }

    @Test
    public void productSortNameAToZTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened after login");
        int productsNum = productPage.getProductCount();
        ProductBase product = initPage(ProductBase.class);
        List<Product> sortedProducts = IntStream.range(1, productsNum).mapToObj(i ->
                new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .sorted(Comparator.comparing(Product::title))
                .toList();
        SortBoxBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        sort.clickSortButton(Sorter.A_TO_Z);
        assertTrue(productPage.isOpened(), "Product page is not opened after sort option clicked!");
        List<Product> productsAfterSortClick = IntStream.range(1, productsNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .toList();
      assertEquals(productsAfterSortClick, sortedProducts, "Products are not sorted A to Z!");
    }

    @Test
    public void productSortNameZToATest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened after login");
        int productsNum = productPage.getProductCount();
        ProductBase product = initPage(ProductBase.class);
        List<Product> sortedProducts = IntStream.range(1, productsNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .sorted(Comparator.comparing(Product::title).reversed())
                .toList();
        SortBoxBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        sort.clickSortButton(Sorter.Z_TO_A);
        assertTrue(productPage.isOpened(), "Product page is not opened after sort option clicked!");
        List<Product> productsAfterSortClick = IntStream.range(1, productsNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .toList();
        assertEquals(productsAfterSortClick, sortedProducts, "Product are not sorted Z to A");
    }

    @Test
    public void productSortPriceLowToHighTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened after login");
        int productsNum = productPage.getProductCount();
        ProductBase product = initPage(ProductBase.class);
        List<Product> sortedProducts = IntStream.range(1, productsNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .sorted(Comparator.comparing(Product::price))
                .toList();
        SortBoxBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        sort.clickSortButton(Sorter.LOW_TO_HIGH);
        assertTrue(productPage.isOpened(), "Product page is not opened after sort option clicked!");
        List<Product> productsAfterSortClick = IntStream.range(1, productsNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .toList();
        assertEquals(productsAfterSortClick, sortedProducts, "Products are not sorted Low to High Price!");
    }

    @Test
    public void productSortPriceHighToLowTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened after login");
        int productsNum = productPage.getProductCount();
        ProductBase product = initPage(ProductBase.class);
        List<Product> sortedProducts = IntStream.range(1, productsNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .sorted(Comparator.comparing(Product::price).reversed().thenComparing(Product::title, Comparator.reverseOrder()))
                .toList();
        SortBoxBase sort = productPage.clickOnSortButton();
        assertTrue(sort.isOpened(), "Sort did not open!");
        sort.clickSortButton(Sorter.HIGH_TO_LOW);
        assertTrue(productPage.isOpened(), "Product page is not opened after sort option clicked!");
        List<Product> productsAfterSortClick = IntStream.range(1, productsNum)
                .mapToObj(i ->
                        new Product(product.getImageUrl(i), product.getTitle(i), product.getPrice(i)))
                .toList();
        assertEquals(productsAfterSortClick, sortedProducts, "Products are not the sorted High to Low Price!");
    }

    @Test(description = "Button clicked on ProductsPage does change on Details Product page, and then back on ProductPage")
    public void productShouldKeepSameButtonTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not opened after login");
        int productsNum = productPage.getProductCount();
        ProductBase product = initPage(ProductBase.class);
        for (int i = 1; i < productsNum; i++) {
            product.clickAddToCartButton(i);
            assertTrue(product.isRemoveFromCartButtonPresent(i),
                    "Button didn't change to Remove on product page!");
            ProductDetailPageBase productDetailPage = product.clickOnProduct(i);
            assertTrue(productDetailPage.isRemoveFromCartButtonPresent(),
                    "Remove button is not present, didn't change accordingly");
            productDetailPage.clickRemoveFromCartButton();
            assertTrue(productDetailPage.isAddToCartButtonPresent(),
                    "Button didn't change to Add To Cart on detail product page!");
            productDetailPage.clickBackToProductsButton();
            assertTrue(product.isAddToCartButtonPresent(i),
                    "Add to cart button is not present, didn't change accordingly");
        }
    }

}
