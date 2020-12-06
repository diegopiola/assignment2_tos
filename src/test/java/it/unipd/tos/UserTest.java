package it.unipd.tos;

import it.unipd.tos.User;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest
{
    public static User me;
    @BeforeClass
    public static void beforeClass()
    {
        me = new User(1,"Diego","Piola",21);
    }

    @Test
    public void getIdTest()
    {
        assertEquals(1,me.getId());
    }

    @Test
    public void getNameTest()
    {
        assertEquals("Diego",me.getName());
    }
    @Test
    public void getSurnameTest()
    {
        assertEquals("Piola",me.getSurname());
    }

    @Test
    public void getAgeTest()
    {
        assertEquals(21,me.getAge());
    }



}