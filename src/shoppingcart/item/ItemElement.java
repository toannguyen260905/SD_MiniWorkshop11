package shoppingcart.item;

import shoppingcart.visitor.ShoppingCartVisitor;

public interface ItemElement {
    void accept(ShoppingCartVisitor visitor);
}
