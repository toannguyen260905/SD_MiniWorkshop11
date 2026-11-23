package shoppingcart.visitor;

import java.util.ArrayList;
import java.util.List;

import shoppingcart.item.Book;
import shoppingcart.item.DigitalProduct;
import shoppingcart.item.Fruit;

public final class ReceiptVisitor implements ShoppingCartVisitor {
    private final List<String> lines = new ArrayList<>();

    public List<String> getLines() {
        return List.copyOf(lines);
    }

    @Override
    public void visit(Book book) {
        lines.add("- Sách: " + book.name());
    }

    @Override
    public void visit(Fruit fruit) {
        lines.add("- Trái cây: " + fruit.name() + " (" + fruit.kg() + " kg)");
    }

    @Override
    public void visit(DigitalProduct product) {
        lines.add("- Sản phẩm số: " + product.name());
    }
}
