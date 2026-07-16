import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotDondExceptTest {

    @Test
    void removeProduct() {
        ShopRepository shop = new ShopRepository();
        shop.add(new Product(0, "1", 1));

        shop.remove(0);

        assertEquals(0, shop.findAll().length);
    }

    @Test
    void removeNotExistProduct() {
        ShopRepository shop = new ShopRepository();
        shop.add(new Product(0, "0", 0));

        NotFoundException.removeById(shop, 1);

        assertEquals(1, shop.findAll().length);
    }

    @Test
    void constructorTest() {
        Product product = new Product(1, "Phone", 100);

        assertEquals(1, product.getId());
        assertEquals("Phone", product.getTitle());
        assertEquals(100, product.getPrice());
    }

    @Test
    void settersTest() {
        Product product = new Product(0, "", 0);

        product.setTitle("TV");
        product.setPrice(200);

        assertEquals("TV", product.getTitle());
        assertEquals(200, product.getPrice());
    }

    @Test
    void equalsTest() {
        Product p1 = new Product(1, "A", 10);
        Product p2 = new Product(1, "A", 10);

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void equalsSelf() {
        Product product = new Product(1, "A", 10);

        assertEquals(product, product);
    }

    @Test
    void equalsNull() {
        Product product = new Product(1, "A", 10);

        assertNotEquals(null, product);
    }

    @Test
    void equalsAnotherClass() {
        Product product = new Product(1, "A", 10);

        assertNotEquals(product, "text");
    }

    @Test
    void findById() {
        Product product = new Product(1, "A", 10);
        Product[] products = {product};

        assertEquals(product, NotFoundException.findById(products, 1));
    }

    @Test
    void findByIdNotFound() {
        Product[] products = {
                new Product(1, "A", 10)
        };

        assertNull(NotFoundException.findById(products, 2));
    }


    @Test
    void equalsFalse() {
        Product p1 = new Product(1, "A", 10);
        Product p2 = new Product(2, "B", 20);

        assertFalse(p1.equals(p2));
    }

    @Test
    void findByIdFound() {
        Product product = new Product(1, "A", 10);

        assertEquals(product,
                NotFoundException.findById(new Product[]{product}, 1));
    }

    @Test
    void removeByIdFound() {
        ShopRepository shop = new ShopRepository();
        shop.add(new Product(1, "A", 10));

        NotFoundException.removeById(shop, 1);

        assertEquals(0, shop.findAll().length);
    }

    @Test
    void removeByIdNotFound() {
        ShopRepository shop = new ShopRepository();
        shop.add(new Product(1, "A", 10));

        NotFoundException.removeById(shop, 2);

        assertEquals(1, shop.findAll().length);
    }

    @Test
    void addTwoProducts() {
        ShopRepository shop = new ShopRepository();

        shop.add(new Product(1, "A", 10));
        shop.add(new Product(2, "B", 20));

        assertEquals(2, shop.findAll().length);
        assertEquals(2, shop.findAll()[1].getId());
    }

    @Test
    void removeFirstProduct() {
        ShopRepository shop = new ShopRepository();

        shop.add(new Product(1, "A", 10));
        shop.add(new Product(2, "B", 20));

        shop.remove(1);

        assertEquals(1, shop.findAll().length);
        assertEquals(2, shop.findAll()[0].getId());
    }
}