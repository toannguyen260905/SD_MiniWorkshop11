package shoppingcart.item;

import shoppingcart.visitor.ShoppingCartVisitor;

public record DigitalProduct(String name, long price) implements ItemElement {
    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}
