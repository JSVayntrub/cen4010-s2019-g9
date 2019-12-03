/*
 * LogInController.java
 * MVC PATTERN: this is the controller that controlls interactions between
 * the model/view class of similar name.
 * OBSERVER PATTERN: the classes below that implement action listeners use the
 * observer pattern by generating an event and notifying the elements in the view
 * class to update
 * main resides in this Class so the program starts running here
 */
package Shop_Mart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class LogInController
{
    /**
     * default constructor
     * @precondition: none
     * @postcondition: view set visible
     */
    public LogInController()
    {
        model = new LogInModel();
        view = new LogInView();
        view.setVisible(true);

        //------------loginlisteners
        view.addLoginButtonListener(new loginButtonListener());
        view.addNewAccountButtonListener(new NewAccountButtonListener());
        //------------addAccount listeners
        view.addCreateButtonListener(new CreateButtonListener());
        view.addCancelButtonListener(new CancelButtonListener());
    }
    
    
    class loginButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String username, password;
            String error = "Invalid information. Try again."; //error msg
            try
            {
                username = view.getUserField();
                password = view.getPasswordField();
                User user = null;
                //check if username/password is empty
                if (username.trim().isEmpty() || password.trim().isEmpty())
                {
                    throw new java.lang.RuntimeException(error); //throw error
                }
                //determine whether the information belongs to a registered user
                user = model.getUser(username, password);
                error = username + " is not a registered user.";
                //if user is a customer
                if (user.type)
                {
                    view.setVisible(false);
                    CustomerController cc = new CustomerController((Customer) user); //launch customer controller
                }
                else
                {
                    view.setVisible(false);
                    SellerController sc = new SellerController((Seller) user); //else launch seller controller
                }
            }
            catch (RuntimeException e)
            {
                view.DisplayErrorMessage(error);
            }
        }
    }

    class NewAccountButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            view.clearTextFields();
            view.newAccountPanel();
        }
    }

    //----------------------------add acount page action listeners
    class CreateButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String username, password;
            String error = "Invalid information. Try again.";
            boolean isCustomer;
            //if the combo box has customer selected
            if (view.getaccountComboBox().equals("Customer"))
            {
                isCustomer = true; //user is a customer
            }
            else
            {
                isCustomer = false; // user is a seller
            }

            try
            {
                username = view.getNewUserField();
                password = view.getNewPasswordField();
                //check if username/password is empty
                if (username.trim().isEmpty() || password.trim().isEmpty())
                {
                    throw new java.lang.RuntimeException(error);
                }
                if (model.saveUser(username, password, isCustomer))
                {
                    view.clearTextFields();
                    view.loginPanel();
                }
                else
                {
                    error = "Username/Password is already taken, Try Agian.";
                    throw new java.lang.RuntimeException(error);
                }

            }
            catch (RuntimeException e)
            {
                view.DisplayErrorMessage(error);
            }
        }
    }

    class CancelButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            view.clearTextFields();
            view.loginPanel();
        }
    }

    /**
     * main method
     * @param args arguments
     */
    public static void main(String[] args)
    {
        LogInController lc = new LogInController();

    }

    private final LogInView view;
    private final LogInModel model;
}
