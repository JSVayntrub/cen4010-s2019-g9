/*
 * Seller.class
 * extends the functionality of the User class
 */
package Shop_Mart;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class Seller extends User
{
    ProductList inventory;
    /**
     * constructor
     * @param username user's username
     * @param password user's password
     * @precondtion: none
     * @postcondtion: values initialized
     */
    public Seller(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.type = false;
        inventory = new Inventory();
    }
    
    /**
     * gets the user's username
     * @return returns username
     * @precondtion: none
     * @postcondtion: none
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * sets the user's username
     * @param username username to set this.username to
     * @precondtion: none
     * @postcondtion: this.username == username
     */
    public void SetUsername(String username)
    {
        this.username = username;
    }
}
