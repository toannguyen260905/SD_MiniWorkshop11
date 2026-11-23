package shoppingcart;

import java.util.ArrayList;
import java.util.List;

import shoppingcart.item.ItemElement;
import shoppingcart.visitor.ShoppingCartVisitor;

public final class ShoppingCart {
    private final List<ItemElement> items = new ArrayList<>();

    public void add(ItemElement item) {
        items.add(item);
    }

    public void apply(ShoppingCartVisitor visitor) {
        for (ItemElement item : items) {
            item.accept(visitor);
        }
    }
}
