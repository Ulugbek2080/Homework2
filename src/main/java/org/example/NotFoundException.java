package org.example;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String s) {
        super(s);
    }
    public static Product findById(Product[] products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static void removeById(ShopRepository shop, int id) {
        if (findById((shop.findAll()), id) == null){
            System.out.println("Element with id: " + id + " not found");
        }else {
            shop.remove(id);
        }
    }
}
