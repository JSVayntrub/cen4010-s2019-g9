/*
 * CartandCheckoutController.java
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
public class CartandCheckoutController
{

    /**
     * constructor
     *
     * @param customer a customer who has logged in
     * @param checkCart a list of products that the user selected to purchase
     * @precondition: user == customer
     * @postconditon: view enabled
     */
    public CartandCheckoutController(Customer customer, LinkedList<Product> checkCart)
    {
        currentCustomer = customer;
        checkoutCart = checkCart;
        cartandCheckoutModel = new CartandCheckoutModel();
        //add shopping cart to view
        cartandCheckoutView = new CartandCheckoutView(cartandCheckoutModel.CheckedItemsToString(checkoutCart));
        cartandCheckoutView.setVisible(true);

        //---Listeners---------------------------------------------------
        cartandCheckoutView.addRemoveButtonListener(new RemoveButtonListener());
        cartandCheckoutView.addCompleteTransactionButtonListener(new CompleteTransactionListener());
        cartandCheckoutView.addClearStartButtonListener(new ClearStartListener());
    }

    class CompleteTransactionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String input;
            String error = "Please enter Credit Card Information.";
            try
            {
                input = cartandCheckoutView.getCreditCardTF();
                //check if customer entered anything for creditcard information
                if (input.trim().isEmpty())
                {
                    throw new java.lang.RuntimeException(error); //throw error
                }
                cartandCheckoutModel.checkOut(currentCustomer, checkoutCart);
                cartandCheckoutView.setVisible(false);
                //goto the customer controller
                CustomerController customerController = new CustomerController(currentCustomer);
            }
            catch (RuntimeException e)
            {
                //customer did not enter credit card information
                cartandCheckoutView.DisplayErrorMessage(error);
            }
        }
    }

    class RemoveButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            cartandCheckoutModel.RemoveFromCart(cartandCheckoutView.getSelectedProducts(), checkoutCart);
            cartandCheckoutView.addAllProductsToList(cartandCheckoutModel.CheckedItemsToString(checkoutCart));
        }

    }

    class ClearStartListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            cartandCheckoutView.setVisible(false);
            currentCustomer.shoppingCart.remove(0);
            CustomerController customerController = new CustomerController(currentCustomer);
        }

    }
    private final CartandCheckoutView cartandCheckoutView;
    private final CartandCheckoutModel cartandCheckoutModel;
    private final Customer currentCustomer;
    private final LinkedList<Product> checkoutCart;
}
