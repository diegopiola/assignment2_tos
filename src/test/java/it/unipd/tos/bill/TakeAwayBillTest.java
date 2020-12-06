package it.unipd.tos.bill;

import it.unipd.tos.bill.RestaurantBillException;
import it.unipd.tos.bill.TakeAwayBill;
import it.unipd.tos.ItemType;
import it.unipd.tos.MenuItem;
import it.unipd.tos.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TakeAwayBillTest
{
    public static List<MenuItem> listTotal;
    public static TakeAwayBill totalTest;
    @BeforeClass
    public static void beforeClass(){
        listTotal = new ArrayList<>();
        MenuItem x = new MenuItem(ItemType.Gelati,"banana",2.00);
        listTotal.add(x);
        listTotal.add(x);
        totalTest = new TakeAwayBill(listTotal,new User(1,"Diego","Piola",21),0);
    }

    @Test
    public void getUserTest()
    {
        assertEquals("Diego",totalTest.getUser().getName());
        assertEquals("Piola",totalTest.getUser().getSurname());
    }

    @Test
    public void getTimeSecTest()
    {
        assertEquals(0,totalTest.getTimeSec());
    }

    @Test
    public void getListaTest()
    {
        assertEquals(totalTest.getLista(),totalTest.getLista());
    }

    @Test
    public void getTotalTest() throws RestaurantBillException
    {
        assertEquals(4.00,totalTest.getOrderPrice(listTotal, totalTest.getUser()),0.00);
    }

}