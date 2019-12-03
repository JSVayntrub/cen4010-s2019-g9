/*
 * CartandCheckoutModel.java
 * MVC PATTERN: this is the model which corresponds to all 
 * the data-related logic that the user works with
 */
package Shop_Mart;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class CartandCheckoutModel extends Model implements ObjectIterator
{

    private final String FILE_NAME;
    /**
     * default constructor
     * @precondition: none
     * @postcondition: sets FILE_NAME to string value
     */
    public CartandCheckoutModel()
    {
        FILE_NAME = "products.dat";
    }

    /**
     * updates and saves all products to file
     * @param customer customer thats logged in
     * @param cart list of products that the customer has picked
     * @precondition: none
     * @postcondition: customer.shoppingCart += cart.products
     */
    public void checkOut(Customer customer, LinkedList<Product> cart)
    {
        LinkedList<Object> toBeSaved = new LinkedList();
        //add check out cart to shoppingCart
        for (int i = 0; i < cart.size(); i++)
        {
            cart.get(i).customerQuantity = 0;
            customer.shoppingCart.add(cart.get(i));
        }
        //add products to object list
        for(int i = 0; i < customer.shoppingCart.size(); i++)
        {
            Product p = customer.shoppingCart.getProduct(i);
            toBeSaved.add((Object)p);
        }
        //save and clear
        super.WriteToFile(toBeSaved, FILE_NAME);
        customer.shoppingCart.remove(1);
    }
    
    /**
     * converts a list of products to strings showing specified values
     * @param cart list of products that the user has sellected
     * @return returns a list of formatted strings
     * @precondition: none
     * @postcondition: cart.toString()
     */
    public LinkedList<String> CheckedItemsToString(LinkedList<Product> cart)
    {
        //get checked products
        LinkedList<Product> products = new LinkedList();
        for (int i = 0; i < cart.size(); i++)
        {
            //if the cart quantity for the item is greater than zero add it.
            if (cart.get(i).customerQuantity > 0)
            {
                products.add(cart.get(i));
            }
        }
        //convert them to strings
        LinkedList<String> strings = new LinkedList();
        for (Product p : products)
        {
            String s = "Name: " + p.type + " | Quantity: " + p.customerQuantity + " | Price: $" + p.sellPrice + " | Seller: " + p.id;
            strings.add(s);
        }
        return strings;
    }
    
    /**
     * removes specified product from the view list
     * @param index index of the option that the user selected
     * @param cart cart containing the items from the selection menu
     * @precondition: view list > 0
     * @postcondtion: view list == view list - removed products
     */
    public void RemoveFromCart(int[] index, LinkedList<Product> cart)
    {
        //remove the selected product(s) from customers cart
        for (int i = 0; i < index.length; i++)
        {
            int j = index[i];
            cart.get(j).customerQuantity--;
            cart.get(j).sales--;
            cart.get(j).sellerQuantity++;
        }
    }

    @Override
    public Iterator createIterator()
    {
        return super.ReadFromFile(FILE_NAME).iterator();
    }

}
