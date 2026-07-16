import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotDondExceptTest {
    @Test
    void removeProduct() {
        ShopRepository shop = new ShopRepository();
        Product product = new Product(0,"0", 0);
        product.setPrice(1);
        product.setTitle("1");
        shop.add(product);
        shop.remove(product.getId());
        assertEquals(0, shop.findAll().length);
    }

    @Test
    void removeNotExistProduct() {
        ShopRepository shop = new ShopRepository();
        Product product = new Product(0,"0", 0);
        shop.add(product);
        NotFoundException.removeById(shop ,1);
        assertEquals(1, shop.findAll().length);
    }
}
