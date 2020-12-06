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
    public static List<MenuItem> list6Gelati;
    public static TakeAwayBill gelati6Order;

    @BeforeClass
    public static void beforeClass()
    {
        //istanzio test per il totale
        listTotal = new ArrayList<>();
        MenuItem x = new MenuItem(ItemType.Gelati,"banana",2.00);
        listTotal.add(x);
        listTotal.add(x);
        totalTest = new TakeAwayBill(listTotal,new User(1,"Diego","Piola",21),0);
        //istanzio test per lo sconto del 50% sul gelato meno caro
        list6Gelati = new ArrayList<>();
        for(int i=0; i < 6;++i)
            list6Gelati.add(x);
        gelati6Order = new TakeAwayBill(list6Gelati,new User(1,"Diego","Piola",21),0);
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

    @Test
    public void sconto5GelatiTest() throws RestaurantBillException
    {
        assertEquals(11.00,gelati6Order.getOrderPrice(list6Gelati, gelati6Order.getUser()),0.00);
    }

}