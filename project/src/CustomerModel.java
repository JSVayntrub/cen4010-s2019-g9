/*
 * CustomerModel.java
 * MVC PATTERN: this is the model which corresponds to all 
 * the data-related logic that the user works with
 * ITERATOR PATTERN: the information read from file is iterated through
 * giving access to it's values but does not expose its internal structure
 */
package Shop_Mart;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class CustomerModel extends Model implements ObjectIterator
{

    private final String FILE_NAME;

    @Override
    public Iterator createIterator()
    {
        return super.ReadFromFile(FILE_NAME).iterator();
    }
    
    /**
     * default constructor
     * @precondition: none
     * @postcondition: FILE_NAME set
     */
    public CustomerModel()
    {
        this.FILE_NAME = "products.dat";
    }
    
    /**
     * constructor
     * @param customer customer that is logged in
     * @precondition: none
     * @postcondition:FILE_NAME is set && customer.shoppingCart >=0
     */
    public CustomerModel(Customer customer)
    {
        this.FILE_NAME = "products.dat";
        getInventory(customer);
    }

    /**
     * checks the customer's shoppingCart and returns the selected products
     * @param customer customer that is logged in
     * @return returns the items that the customer selected to check out
     * @precondition customer.shoppingCart > 0
     * @postcondition: customer.shoppingCart -=  user selected items
     */
    public LinkedList<Product> CheckedProducts(Customer customer)
    {
        LinkedList<Product> products = new LinkedList();
        LinkedList<Product> sc = new LinkedList();
        //for all products in shopping cart: accumilate user selected products
        for (int i = 0; i < customer.shoppingCart.size(); i++)
        {
            if (customer.shoppingCart.getProduct(i).customerQuantity > 0)
            {
                products.add(customer.shoppingCart.getProduct(i));
                continue;
            }
            sc.add(customer.shoppingCart.getProduct(i));
        }

        //update shopping cart to sc
        customer.shoppingCart.remove(0);
        for (Product p : sc)
        {
            customer.shoppingCart.add(p);
        }

        return products;
    }

    /**
     * assigns all products offered to shopping cart
     * @param customer customer that is logged in
     * @preconditon: none
     * @postcondition: customer.shoppingCart >= 0
     */
    private void getInventory(Customer customer)
    {
        customer.shoppingCart.remove(0);
        Iterator iterator;
        try
        {
            iterator = new CustomerModel().createIterator();
        }
        catch (Exception e)
        {
            //there are no products
            return;
        }
        //iterate through iterator and assign to list
        while (iterator.hasNext())
        {
            Product p = (Product) iterator.next();
            customer.shoppingCart.add(p);
        }
    }

    /**
     * change selected item(s) product information to denote addition to cart
     * @param index index of selected items by user
     * @param customer customer that is logged in
     * @precondtion: index > 0
     * @postcondtion: customer.shoppingCart updated
     */
    public void addToCart(int[] index, Customer customer)
    {
        //maybe here
        for (int i = 0; i < index.length; i++)
        {
            int j = index[i];
            if (customer.shoppingCart.getProduct(j).sellerQuantity > 0)
            {
                customer.shoppingCart.getProduct(j).sellerQuantity--;
                customer.shoppingCart.getProduct(j).customerQuantity++;
                customer.shoppingCart.getProduct(j).sales++;
            }
        }
    }
    
    /**
     * gets all products that are within customer's cart as a list
     * @param customer customer that is currently logged in
     * @return returns all products within shopping cart
     * @precondition: none
     * @postcondition: none
     */
    public LinkedList<Product> getProducts(Customer customer)
    {
        LinkedList<Product> products = new LinkedList();
        for (int i = 0; i < customer.shoppingCart.size(); i++)
        {
            products.add(customer.shoppingCart.getProduct(i));
        }
        return products;
    }
    
    /**
     * determines whether customer has an item
     * @param customer customer that is logged in
     * @return return the result of whether the customer has an item
     * @precondition: none
     * @postcondition: none
     */
    public boolean CustomerHasItem(Customer customer)
    {
        for (int i = 0; i < customer.shoppingCart.size(); i++)
        {
            if (customer.shoppingCart.getProduct(i).customerQuantity > 0)
            {
                return true;
            }
        }
        return false;
    }
}
