package shoppingcart.visitor;

import shoppingcart.item.Book;
import shoppingcart.item.DigitalProduct;
import shoppingcart.item.Fruit;

public interface ShoppingCartVisitor {
    void visit(Book book);
    void visit(Fruit fruit);
    void visit(DigitalProduct product);
}
