/*
 * CustomerView.java
 * MVC PATTERN:  this is the view component of the MVC PATTERN.
 * It is used for all the UI logic of the application.
 */
package Shop_Mart;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * 
 * @author abdullahshafique, jasonmichel
 */
public class CustomerView extends javax.swing.JFrame
{

    private final javax.swing.JButton addToCartButton;
    private final javax.swing.JButton checkOutButton;
    private final javax.swing.JButton signoutButton;
    private final javax.swing.JLabel jLabel2;
    private final javax.swing.JScrollPane jScrollPane1;
    private final javax.swing.JSeparator jSeparator1;
    private final javax.swing.JList<String> productsList;
    private final javax.swing.JLabel shopMartLabel;
    private final javax.swing.JLabel welcomeUserLabel;

    /**
     * default constructor
     * @precondition: none
     * @postcondition: none
     */
    public CustomerView()
    {
        shopMartLabel = new javax.swing.JLabel();
        signoutButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        welcomeUserLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsList = new javax.swing.JList<>();
        addToCartButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponent();
    }

    /**
     * initializes the JFrame
     *
     * @precondition: none
     * @postcondition: none
     */
    public final void initComponent()
    {
        shopMartLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        shopMartLabel.setText("Shop Mart");

        signoutButton.setText("Sign Out");

        welcomeUserLabel.setText("Hello, username");

        jLabel2.setText("Products:");

        productsList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings =
            {
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
            };

            @Override
            public int getSize()
            {
                return strings.length;
            }

            @Override
            public String getElementAt(int i)
            {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(productsList);

        addToCartButton.setText("Add to Cart");

        checkOutButton.setText("Check Out");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(shopMartLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(signoutButton)
                                        .addGap(7, 7, 7))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addContainerGap())
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(welcomeUserLabel)
                                                .addComponent(jLabel2)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(addToCartButton)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(checkOutButton)))
                                        .addContainerGap(262, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(shopMartLabel)
                                .addComponent(signoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(welcomeUserLabel)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addToCartButton)
                                .addComponent(checkOutButton))
                        .addContainerGap())
        );

        pack();
    }

    /**
     * adds a listener for addToCartButton
     *
     * @param listener listener for the addToCartButton
     * @precondition: none
     * @postcondition: none
     */
    public void addToCartButtonListner(ActionListener listener)
    {
        addToCartButton.addActionListener(listener);
    }

    /**
     * adds a listener for addSignoutButton
     *
     * @param listener listener for the addSignoutButton
     * @precondition: none
     * @postcondition: none
     */
    public void addSignoutButtonListner(ActionListener listener)
    {
        signoutButton.addActionListener(listener);
    }

    /**
     * adds a listener for checkOutButtonListner
     *
     * @param listener listener for the checkOutButtonListner
     * @precondition: none
     * @postcondition: none
     */
    public void checkOutButtonListner(ActionListener listener)
    {
        checkOutButton.addActionListener(listener);
    }

    /**
     * displays a welcome message with the user's name concatenated to it
     * @param customerName username of the user
     * @precondtion: none
     * @postcondtion: none
     */
    public void setWelcomeMessage(String customerName)
    {
        welcomeUserLabel.setText("Hello, " + customerName);
    }

    /**
     * gets the JList selected indices by the user
     * @return returns the selected indices
     * @precondtion: none
     * @postcondition: none
     */
    public int[] getSelectedProducts()
    {
        return productsList.getSelectedIndices();
    }

    /**
     * takes in a list of products and displays them to the user by using a JList
     * @param products products to be displayed
     * @precondtion: products > 0
     * @postconditon JList == products.toString()
     */
    public void addAllProductsToList(LinkedList<Product> products)
    {
        productsList.removeAll();
        DefaultListModel productsInStrings = new DefaultListModel();
        for (int i = 0; i < products.size(); i++)
        {
            Product product = products.get(i);

            productsInStrings.addElement("Name: " + product.type + " | Quantity: "
                    + product.sellerQuantity + " | Price: $" + product.sellPrice + " | Seller: " + product.id);

        }
        productsList.setModel(productsInStrings);
    }

    /**
     * terminates the application running
     *
     * @preconditon: application == running
     * @postcondition: application terminated
     */
    void exit()
    {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
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
}
