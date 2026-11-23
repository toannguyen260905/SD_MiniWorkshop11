package shoppingcart.visitor;

import shoppingcart.item.Book;
import shoppingcart.item.DigitalProduct;
import shoppingcart.item.Fruit;

public final class ShippingFeeVisitor implements ShoppingCartVisitor {
    private long total;

    public long getTotal() {
        return total;
    }

    @Override
    public void visit(Book book) {
        total += 10_000;
    }

    @Override
    public void visit(Fruit fruit) {
        total += 5_000L * fruit.kg();
    }

    @Override
    public void visit(DigitalProduct product) {
        // Sản phẩm số được giao online, phí vận chuyển bằng 0.
    }
}
