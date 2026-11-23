package shoppingcart.visitor;

import shoppingcart.item.Book;
import shoppingcart.item.DigitalProduct;
import shoppingcart.item.Fruit;

public final class DiscountVisitor implements ShoppingCartVisitor {
    private long total;

    public long getTotal() {
        return total;
    }

    @Override
    public void visit(Book book) {
        if (book.price() >= 100_000) {
            total += book.price() / 10;
        }
    }

    @Override
    public void visit(Fruit fruit) {
        // Trái cây không có ưu đãi trong ví dụ này.
    }

    @Override
    public void visit(DigitalProduct product) {
        total += product.price() / 20;
    }
}
