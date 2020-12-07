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
    //Per test sul totale
    public static List<MenuItem> listTotal;
    public static TakeAwayBill totalTest;
    //per test sconto se acquistati più di 5 gelati
    public static List<MenuItem> list6Gelati;
    public static TakeAwayBill gelati6Order;
    //per test sconto 10% se budini e gelati superano i 50 euro
    public static List<MenuItem> listSconto10;
    public static TakeAwayBill orderSconto10;
    @BeforeClass
    public static void beforeClass()
    {
        //istanzio test per il totale
        listTotal = new ArrayList<>();
        MenuItem x = new MenuItem(ItemType.Gelati,"banana",2.00);
        for(int i=0;i<5;++i) {
            listTotal.add(x);
        }
        totalTest = new TakeAwayBill(listTotal,new User(1,"Diego","Piola",21),0);
        //istanzio test per lo sconto del 50% sul gelato meno caro
        list6Gelati = new ArrayList<>();
        for(int i=0; i < 6;++i)
            list6Gelati.add(x);
        gelati6Order = new TakeAwayBill(list6Gelati,new User(1,"Diego","Piola",21),0);
        //istanzio test per verificare lo sconto del 10%
        listSconto10 = new ArrayList<>();
        for(int i = 0;i<2;++i)
        {
            listSconto10.add(new MenuItem(ItemType.Budini,"Pinguino",15.00));
            listSconto10.add(new MenuItem(ItemType.Gelati,"Banana",15.00));
            listSconto10.add(new MenuItem(ItemType.Bevande,"Banana",20.00));
        }
        orderSconto10 = new TakeAwayBill(listSconto10,new User(1,"Diego","Piola",21),0);
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
        assertEquals(10.00,totalTest.getOrderPrice(listTotal, totalTest.getUser()),0.00);
    }

    @Test
    public void sconto5GelatiTest() throws RestaurantBillException
    {
        assertEquals(11.00,gelati6Order.getOrderPrice(list6Gelati, gelati6Order.getUser()),0.00);
    }

    @Test
    public void sconto10SeMaggioreDi50Test() throws RestaurantBillException
    {
        assertEquals(90.00,orderSconto10.getOrderPrice(orderSconto10.getLista(), orderSconto10.getUser()),0.00);
    }

    @Test(expected = RestaurantBillException.class)
    public void testNoMoreThan30ElementsAllowed() throws RestaurantBillException {
        var items = List.of(
                new MenuItem(ItemType.Gelati, "gelato 1", 1),
                new MenuItem(ItemType.Gelati, "gelato 2", 2),
                new MenuItem(ItemType.Gelati, "gelato 3", 3),
                new MenuItem(ItemType.Gelati, "gelato 4", 4),
                new MenuItem(ItemType.Gelati, "gelato 5", 5),
                new MenuItem(ItemType.Gelati, "gelato 6", 6),
                new MenuItem(ItemType.Gelati, "gelato 7", 7),
                new MenuItem(ItemType.Gelati, "gelato 8", 8),
                new MenuItem(ItemType.Gelati, "gelato 9", 9),
                new MenuItem(ItemType.Gelati, "gelato 10", 10),
                new MenuItem(ItemType.Gelati, "gelato 11", 11),
                new MenuItem(ItemType.Gelati, "gelato 12", 12),
                new MenuItem(ItemType.Gelati, "gelato 13", 13),
                new MenuItem(ItemType.Gelati, "gelato 14", 14),
                new MenuItem(ItemType.Gelati, "gelato 15", 15),
                new MenuItem(ItemType.Gelati, "gelato 16", 16),
                new MenuItem(ItemType.Gelati, "gelato 17", 17),
                new MenuItem(ItemType.Gelati, "gelato 18", 18),
                new MenuItem(ItemType.Gelati, "gelato 19", 19),
                new MenuItem(ItemType.Gelati, "gelato 20", 20),
                new MenuItem(ItemType.Gelati, "gelato 21", 21),
                new MenuItem(ItemType.Gelati, "gelato 22", 22),
                new MenuItem(ItemType.Gelati, "gelato 23", 23),
                new MenuItem(ItemType.Gelati, "gelato 24", 24),
                new MenuItem(ItemType.Gelati, "gelato 25", 25),
                new MenuItem(ItemType.Gelati, "gelato 26", 26),
                new MenuItem(ItemType.Gelati, "gelato 27", 27),
                new MenuItem(ItemType.Gelati, "gelato 28", 28),
                new MenuItem(ItemType.Gelati, "gelato 29", 29),
                new MenuItem(ItemType.Gelati, "gelato 30", 30),
                new MenuItem(ItemType.Budini, "budino 1", 31),
                new MenuItem(ItemType.Bevande, "bevanda 1", 32)
        );
        TakeAwayBill order = new TakeAwayBill(items, new User(-1, "Test", "Sas",20),0);
        order.getOrderPrice(items,new User(-1, "Test", "Sas",20));
    }

    @Test
    public void testCommission() throws RestaurantBillException
    {
        var items = List.of(
                new MenuItem(ItemType.Gelati, "gelato 1", 1.00),
                new MenuItem(ItemType.Gelati, "gelato 2", 2.00),
                new MenuItem(ItemType.Gelati, "gelato 3", 3.00)
        );
        TakeAwayBill order = new TakeAwayBill(items,new User(2,"Diego","Piola",21),0);
        assertEquals(6.50,order.getOrderPrice(items,new User(2,"Diego","Piola",21)),0.00);
    }

    @Test
    public void verifyGratis() throws RestaurantBillException
    {
        List<TakeAwayBill> orders;
        List<MenuItem> orderListGratis;

        orders = new ArrayList<>();
        orderListGratis = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            MenuItem m = new MenuItem(ItemType.Gelati, "Banana", 4.00);
            MenuItem b = new MenuItem(ItemType.Budini, "merda", 10.00);
            orderListGratis.add(m);
            orderListGratis.add(b);
        }
        String [] names = {"Diego","Paolo","Jonny","Riccardo","Giulia","Sara","Michele","Stefano","Agnese","Pietro","Stefania","Alberto"};
        String [] surnames = {"Piola","Sassata","Sega","Tallone","Boh","Porca","Pressing","Tzuje","Figa","Pollo","Santa","Manigoldo"};
        for (int j = 0; j < 12; ++j)
        {
            User tmp = new User(j,names[j],surnames[j],17-j);
            TakeAwayBill orderG = new TakeAwayBill(orderListGratis,tmp,68000+j);
            orders.add(orderG);
        }
        //verifico che siano 10

        assertEquals(10, orders.get(0).gratisOrder(orders).size());

        List<TakeAwayBill> tmp = orders.get(0).gratisOrder(orders);
        //verifico che il prezzo sia a 0 per tutti gli ordini, iè tutti uguai, ne vardo uno

            //metto 0.5 perchè cè il sovraprezzo in caso non si spendano almeno 10 euro 
            for(int i=0;i< tmp.size();++i) {
                assertEquals(0.50, tmp.get(i).getOrderPrice(tmp.get(i).getLista(), tmp.get(i).getUser()), 0);
            }
    }

}