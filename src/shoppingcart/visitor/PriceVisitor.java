package shoppingcart.visitor;

import shoppingcart.item.Book;
import shoppingcart.item.DigitalProduct;
import shoppingcart.item.Fruit;

public final class PriceVisitor implements ShoppingCartVisitor {
    private long total;

    public long getTotal() {
        return total;
    }

    @Override
    public void visit(Book book) {
        total += book.price();
    }

    @Override
    public void visit(Fruit fruit) {
        total += fruit.pricePerKg() * fruit.kg();
    }

    @Override
    public void visit(DigitalProduct product) {
        total += product.price();
    }
}
