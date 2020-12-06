////////////////////////////////////////////////////////////////////
// DIEGO PIOLA 1193414
////////////////////////////////////////////////////////////////////
package it.unipd.tos.bill;

public class RestaurantBillException extends Exception {

    public RestaurantBillException(String s) {
        super(s);
    }

    //anche per il metodo getMessage() mi affido alla classe base.
    public String getMessage() {
        return super.getMessage();
    }
}