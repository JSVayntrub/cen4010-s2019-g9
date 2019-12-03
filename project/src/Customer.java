/*
 * Customer.class
 * extends the functionality of the User class
 */
package Shop_Mart;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class Customer extends User
{  
    /**
     * constructor
     * @param username username of customer
     * @param password password of customer
     * @precondition: none
     * @postcondition: initializes values
     */
    public Customer(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.type = true; //isCutomer
        shoppingCart = new ShoppingCart();
    }
    
    ProductList shoppingCart;
}
