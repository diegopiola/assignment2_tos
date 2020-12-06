////////////////////////////////////////////////////////////////////
// DIEGO PIOLA 1193414
////////////////////////////////////////////////////////////////////
package it.unipd.tos.bill;

import it.unipd.tos.MenuItem;
import it.unipd.tos.User;

import java.util.List;

public interface TakeAwayBillInterface
{
    double getOrderPrice(List<MenuItem> itemsOrdered, User user)
            throws RestaurantBillException;
}