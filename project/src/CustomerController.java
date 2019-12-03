/*
 * CustomerController.java
 * MVC PATTERN: this is the controller that controlls interactions between
 * the model/view class of similar name.
 * OBSERVER PATTERN: the classes below that implement action listeners use the
 * observer pattern by generating an event and notifying the elements in the view
 * class to update
 */
package Shop_Mart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class CustomerController
{

    /**
     * constructor
     *
     * @param customer a customer who has logged in
     * @precondition: user == customer
     * @postconditon: view enabled
     */
    public CustomerController(Customer customer)
    {
        this.currentCustomer = customer;
        checkoutCart = new LinkedList();
        customerModel = new CustomerModel(currentCustomer); //retrieve all products
        customerView = new CustomerView();
        customerView.setWelcomeMessage(currentCustomer.username);
        customerView.addAllProductsToList(customerModel.getProducts(currentCustomer));
        customerView.setVisible(true);
        //listeners---------------------------------------------------
        customerView.addToCartButtonListner(new addToCartListener());
        customerView.checkOutButtonListner(new checkOutListener());
        customerView.addSignoutButtonListner(new SignoutListner());
    }

    class addToCartListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            customerModel.addToCart(customerView.getSelectedProducts(), currentCustomer);
            customerView.addAllProductsToList(customerModel.getProducts(currentCustomer));
        }
    }

    class SignoutListner implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            customerView.exit();//exit application
        }
    }

    class checkOutListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (customerModel.CustomerHasItem(currentCustomer))
            {
                customerView.setVisible(false);
                checkoutCart = customerModel.CheckedProducts(currentCustomer);
                //launch the check out window
                CartandCheckoutController checkOut = new CartandCheckoutController(currentCustomer, checkoutCart);
            }
            else
            {
                customerView.DisplayErrorMessage("You Have No Items To Check Out."); //display error message
            }
        }
    }

    private final Customer currentCustomer;
    private final CustomerView customerView;
    private final CustomerModel customerModel;
    private LinkedList<Product> checkoutCart;
}
