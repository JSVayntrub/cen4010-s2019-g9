/*
 * LogInModel.java
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
public class LogInModel extends Model implements ObjectIterator
{

    private final String FILE_NAME;

    /**
     * default constructor
     *
     * @precondtion: none
     * @postcondtion: initialize variables
     */
    public LogInModel()
    {
        FILE_NAME = "users.dat";
    }

    /**
     * saves the information that the user enters into the users file
     *
     * @param username username of user
     * @param password password of user
     * @param isCustomer determines if the user is a customer of not
     * @return returns a boolean value of whether the user was saved or rejected
     * @preconditon: none
     * @postconditon: user saved || user rejected
     */
    public boolean saveUser(String username, String password, boolean isCustomer)
    {
        Iterator iterator;
        try
        {
            iterator = new LogInModel().createIterator();
        }
        catch (Exception e)
        {
            //create file since there isn't one
            LinkedList<Object> objects = new LinkedList();
            objects.clear();
            String user = username + " " + password + " " + isCustomer;
            objects.add((Object) user);
            WriteToFile(objects, FILE_NAME);
            System.out.println("File Created.");
            return true;
        }
        String user = username + " " + password + " " + isCustomer;
        LinkedList objects = new LinkedList();
        while (iterator.hasNext())
        {
            objects.add(iterator.next());
        }

        for (Object obj : objects)
        {
            if (obj.toString().equals(user))
            {
                return false;
            }
        }
        objects.add(user);
        WriteToFile(objects, FILE_NAME);
        return true;
    }

    /**
     * Gets the user based on the information entered by user
     *
     * @param username username of the user
     * @param password password of the user
     * @return returns a customer/seller/null based on what the user passes in
     * as values
     * @precondition: none
     * @postcondtion: none
     */
    public User getUser(String username, String password)
    {
        Iterator iterator;
        try
        {
            iterator = new LogInModel().createIterator();
        }
        catch (Exception e)
        {
            //there are no users in shop mart
            return null;
        }
        String user = username + " " + password + " ";

        while (iterator.hasNext())
        {
            Object obj = iterator.next();

            if (obj.toString().equals(user + true))
            {
                return new Customer(username, password);
            }
            else if (obj.equals(user + false))
            {
                return new Seller(username, password);
            }
        }
        return null;
    }

    @Override
    public Iterator createIterator()
    {
        return super.ReadFromFile(FILE_NAME).iterator();
    }

}
