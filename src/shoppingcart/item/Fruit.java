package shoppingcart.item;

import shoppingcart.visitor.ShoppingCartVisitor;

public record Fruit(String name, long pricePerKg, int kg) implements ItemElement {
    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}
