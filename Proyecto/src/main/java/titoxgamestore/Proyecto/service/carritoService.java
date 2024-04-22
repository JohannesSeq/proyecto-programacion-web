package titoxgamestore.Proyecto.service;

import titoxgamestore.Proyecto.domain.Item;

import java.util.List;

public interface carritoService {
    void addToCart(Item item);
    void removeFromCart(Long itemId);
    void updateItemInCart(Item item);
    List<Item> getCartItems();
}
