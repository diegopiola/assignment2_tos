package it.unipd.tos;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuItemTest
{
    private static MenuItem mi;

    @BeforeClass
    public static void beforeClass()
    {
        mi = new MenuItem(ItemType.Budini,"Coppa Nafta", 5.00);
    }

    @Test
    public void getTypeTest()
    {
        assertEquals(ItemType.Budini, mi.getType());
    }
    @Test
    public void getNameTest()
    {
        assertEquals("Coppa Nafta",mi.getName());
    }
    @Test
    public void getPriceTest()
    {
        assertEquals(5.00,mi.getPrice(),0);
    }
}