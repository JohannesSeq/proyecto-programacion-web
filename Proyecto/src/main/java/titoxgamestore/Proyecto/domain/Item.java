package titoxgamestore.Proyecto.domain;

public class Item {
    private catalogo catalogoItem;
    private int cantidad;

    // Constructors, getters, and setters
    public Item() {}

    public Item(catalogo catalogoItem, int cantidad) {
        this.catalogoItem = catalogoItem;
        this.cantidad = cantidad;
    }

    public catalogo getCatalogoItem() {
        return catalogoItem;
    }

    public void setCatalogoItem(catalogo catalogoItem) {
        this.catalogoItem = catalogoItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
