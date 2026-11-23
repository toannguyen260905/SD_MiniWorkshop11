import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import shoppingcart.item.Book;
import shoppingcart.item.DigitalProduct;
import shoppingcart.item.Fruit;
import shoppingcart.ShoppingCart;
import shoppingcart.visitor.DiscountVisitor;
import shoppingcart.visitor.PriceVisitor;
import shoppingcart.visitor.ReceiptVisitor;
import shoppingcart.visitor.ShippingFeeVisitor;

public class StateMachine {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Book("Sách Java", 120_000));
        cart.add(new Fruit("Táo", 40_000, 2));
        cart.add(new DigitalProduct("Ebook UML", 60_000));

        // Bản ban đầu: chạy hai thao tác trên cùng một giỏ hàng.
        PriceVisitor price = new PriceVisitor();
        ShippingFeeVisitor shipping = new ShippingFeeVisitor();
        cart.apply(price);
        cart.apply(shipping);
        System.out.printf("Tổng tiền hàng: %d đồng%n", price.getTotal());
        System.out.printf("Phí vận chuyển: %d đồng%n", shipping.getTotal());

        // Bản mở rộng: tái sử dụng giỏ hàng và các lớp mặt hàng.
        DiscountVisitor discount = new DiscountVisitor();
        ReceiptVisitor receipt = new ReceiptVisitor();
        cart.apply(discount);
        cart.apply(receipt);
        System.out.println("Chi tiết hóa đơn:");
        receipt.getLines().forEach(System.out::println);
        System.out.printf("Tiền giảm: %d đồng%n", discount.getTotal());
        System.out.printf("Phải trả: %d đồng%n", price.getTotal() + shipping.getTotal() - discount.getTotal());
    }
}
