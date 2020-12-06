////////////////////////////////////////////////////////////////////
// DIEGO PIOLA 1193414
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

public class MenuItem
{

    ItemType type;
    String name;
    double price;
    public MenuItem(ItemType type, String name, double price)
    {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    public double getPrice() {return price;}

    public ItemType getType(){return type;}

    public String getName() {return name;}

    public void setPrice(double price)
    {
        this.price = price;
    }

}