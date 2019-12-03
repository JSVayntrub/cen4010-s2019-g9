/*
 * LogInView.java
 * MVC PATTERN:  this is the view component of the MVC PATTERN.
 * It is used for all the UI logic of the application.
 */
package Shop_Mart;

import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class LogInView extends JFrame
{

    //login panel------------------------
    private final JButton loginButton;
    private final JButton newAccountButton;
    private final JPasswordField passwordTextField;
    private final JTextField userTextField;
    //newAccount panel-------------------
    private final JComboBox<String> accountComboBox;
    private final JButton cancelButton;
    private final JButton createButton;
    private final JTextField newPasswordTextField;
    private final JTextField newUserTextField;

    public LogInView()
    {
        //---Login panel---------------
        loginButton = new JButton();
        newAccountButton = new JButton();
        passwordTextField = new JPasswordField();
        userTextField = new JTextField();
        //---newAccount panel----------
        accountComboBox = new JComboBox();
        cancelButton = new JButton();
        createButton = new JButton();
        newPasswordTextField = new JTextField();
        newUserTextField = new JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        loginPanel();
    }

    /**
     * initializes the JFrame
     *
     * @precondition: none
     * @postcondition: none
     */
    public final void loginPanel()
    {
        this.getContentPane().removeAll();
        JPanel loginPanel = new JPanel();
        JLabel passwordLabel = new JLabel();
        JLabel titleLabel = new JLabel();
        JLabel usernameLabel = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setText("Welcome to Shop Mart!");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");

        newAccountButton.setText("New Account");

        loginButton.setText("Login");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(userTextField)
                                                        .addComponent(passwordTextField)))
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addComponent(titleLabel)
                                                .addGap(0, 197, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(newAccountButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(loginButton)))
                                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }

    /**
     * initializes the JFrame
     *
     * @precondition: none
     * @postcondition: none
     */
    public void newAccountPanel()
    {
        this.getContentPane().removeAll();
        JLabel AccountLabel = new JLabel();
        JPanel newAccountPanel = new JPanel();
        JLabel passwordLabel = new JLabel();
        JLabel titleLabel = new JLabel();
        JLabel usernameLabel = new JLabel();

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setText("New Account");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");

        AccountLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AccountLabel.setText("Account Type:");

        accountComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
        {
            "Customer", "Seller"
        }));

        cancelButton.setText("Cancel");

        createButton.setText("Create Account");

        javax.swing.GroupLayout newAccountPanelLayout = new javax.swing.GroupLayout(newAccountPanel);
        newAccountPanel.setLayout(newAccountPanelLayout);
        newAccountPanelLayout.setHorizontalGroup(
                newAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newAccountPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(newAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(newAccountPanelLayout.createSequentialGroup()
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(newAccountPanelLayout.createSequentialGroup()
                                                .addComponent(AccountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(229, 229, 229))
                                        .addGroup(newAccountPanelLayout.createSequentialGroup()
                                                .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newUserTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(newAccountPanelLayout.createSequentialGroup()
                                                .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newAccountPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(createButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton)))
                                .addContainerGap())
        );
        newAccountPanelLayout.setVerticalGroup(
                newAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newAccountPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(newAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(newUserTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(newAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(newAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AccountLabel)
                                        .addComponent(accountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(newAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(createButton))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newAccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newAccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }

    /**
     * adds a listener for LoginButton
     *
     * @param listener listener for the LoginButton
     * @precondition: none
     * @postcondition: none
     */
    void addLoginButtonListener(ActionListener listen)
    {
        loginButton.addActionListener(listen);
    }

    /**
     * adds a listener for NewAccountButton
     *
     * @param listener listener for the NewAccountButton
     * @precondition: none
     * @postcondition: none
     */
    void addNewAccountButtonListener(ActionListener listen)
    {
        newAccountButton.addActionListener(listen);
    }

    /**
     * gets the text from the text Field
     *
     * @return returns the information entered by user if any
     * @precondtion: none
     * @postcondition: none
     */
    public String getUserField()
    {
        return userTextField.getText();
    }

    /**
     * gets the text from the text Field
     *
     * @return returns the password information entered
     * @precondtion: none
     * @postcondition: none
     */
    public String getPasswordField()
    {
        return passwordTextField.getText();
    }

    /**
     * used to display an error message to the user when they do incorrect
     * things
     *
     * @param error message to display to user
     * @preconditon: string.length() > 0
     * @postconditon: nome
     */
    void DisplayErrorMessage(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }

    /**
     * clears all text fields
     *
     * @precondtion: none
     * @postcondition: all textfields == null
     */
    void clearTextFields()
    {
        passwordTextField.setText(null);
        userTextField.setText(null);
        newPasswordTextField.setText(null);
        newUserTextField.setText(null);
    }
    //-----------------------addAccount---------------------------------------------

    /**
     * gets the text from the text Field
     *
     * @return returns the username information entered
     * @precondtion: none
     * @postcondition: none
     */
    public String getNewUserField()
    {
        return newUserTextField.getText();
    }

    /**
     * gets the text from the text Field
     *
     * @return returns the password information entered
     * @precondtion: none
     * @postcondition: none
     */
    public String getNewPasswordField()
    {
        return newPasswordTextField.getText();
    }

    /**
     * gets the text from the text Field
     *
     * @return returns the account type information from combo box
     * @precondtion: none
     * @postcondition: none
     */
    public String getaccountComboBox()
    {
        return String.valueOf(accountComboBox.getSelectedItem());
    }

    /**
     * adds a listener for CancelButton
     *
     * @param listener listener for the CancelButton
     * @precondition: none
     * @postcondition: none
     */
    void addCancelButtonListener(ActionListener listen)
    {
        cancelButton.addActionListener(listen);
    }

    /**
     * adds a listener for CreateButton
     *
     * @param listener listener for the CreateButton
     * @precondition: none
     * @postcondition: none
     */
    void addCreateButtonListener(ActionListener listen)
    {
        createButton.addActionListener(listen);
    }
}
