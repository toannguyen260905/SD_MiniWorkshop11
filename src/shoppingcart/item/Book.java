package shoppingcart.item;

import shoppingcart.visitor.ShoppingCartVisitor;

public record Book(String name, long price) implements ItemElement {
    @Override
    public void accept(ShoppingCartVisitor visitor) {
        // Kiểu cụ thể của this chọn đúng phiên bản visit(Book).
        visitor.visit(this);
    }
}
