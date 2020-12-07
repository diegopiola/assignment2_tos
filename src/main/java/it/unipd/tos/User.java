////////////////////////////////////////////////////////////////////
// DIEGO PIOLA 1193414
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import java.util.Date;

public class User
{
    private int id,age;
    private String name,surname;

    public User(int id, String name, String surname, int age)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public int getAge()
    {return age;}

    public int getId(){return id;}

    public String getName() {return name;}

    public String getSurname() {return surname;}



}