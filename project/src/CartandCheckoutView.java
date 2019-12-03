/*
 * CartandCheckoutView.java
 * MVC PATTERN:  this is the view component of the MVC PATTERN.
 * It is used for all the UI logic of the application.
 */
package Shop_Mart;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class CartandCheckoutView extends javax.swing.JFrame
{

    private final JButton completeTransactionButton;
    private final JTextField creditCardTF;
    private final JList<String> productsList;
    private final JButton removeItemButton;
    private final JScrollPane scrollPane;
    private final JButton clearStartButton;
    
    /**
     * constructor
     * @param lines represents the options available for the user to select
     * @precondition: requires controller
     * @postconditon: variables set
     */
    public CartandCheckoutView(LinkedList<String> lines)
    {
        completeTransactionButton = new JButton();
        creditCardTF = new JTextField();
        productsList = new JList();
        removeItemButton = new JButton();
        scrollPane = new JScrollPane();
        clearStartButton = new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponent(lines);
    }
    /**
     * sets up the initial look of the jFrame
     * @param lines represents the options available for the user to select
     * @precondtion: none
     * @postcondtion: variables set
     */
    public final void initComponent(LinkedList<String> lines)
    {
        JLabel creditLabel = new JLabel();
        JSeparator separator = new JSeparator();
        JLabel shopMartLabel = new JLabel();
        JLabel shopcartLabel = new JLabel();

        shopMartLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        shopMartLabel.setText("Shop Mart");

        shopcartLabel.setText("Shopping Cart:");

        addAllProductsToList(lines);
        scrollPane.setViewportView(productsList);

        completeTransactionButton.setText("Check Out");

        removeItemButton.setText("Remove Item");

        creditLabel.setText("Credit Card #:");
        clearStartButton.setText("Clear Cart and Start Over");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(shopcartLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(removeItemButton))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(shopMartLabel)
                                                .addGap(0, 369, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(creditLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(creditCardTF))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(completeTransactionButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(clearStartButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(shopMartLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(removeItemButton)
                                        .addComponent(shopcartLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(creditCardTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(creditLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(completeTransactionButton)
                                        .addComponent(clearStartButton))
                                .addContainerGap())
        );
        pack();
    }
    
    /**
     * takes passed list of strings and uses it in JList
     * @param lines represents the options available for the user to select
     * @preconditon: lines.size() > 0
     * @postcondition: productList displays lines
     */
    public void addAllProductsToList(LinkedList<String> lines)
    {
        productsList.removeAll();
        DefaultListModel productsInStrings = new DefaultListModel();
        for (String s : lines)
        {
            productsInStrings.addElement(s);
        }
        productsList.setModel(productsInStrings);
    }

    /**
     * gets the text from the text Field
     * @return returns the credit card information entered
     * @precondtion: none
     * @postcondition: none
     */
    public String getCreditCardTF()
    {
        return creditCardTF.getText();
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
     * adds a listener for removeItemButton
     * @param listener listener for the removeItemButton
     * @precondition: none 
     * @postcondition: none
     */
    public void addRemoveButtonListener(ActionListener listener)
    {
        removeItemButton.addActionListener(listener);
    }

    /**
     * adds a listener for completeTransactionButton
     * @param listener listener for the completeTransactionButton
     * @precondition: none 
     * @postcondition: none
     */
    public void addCompleteTransactionButtonListener(ActionListener listener)
    {
        completeTransactionButton.addActionListener(listener);
    }
    
    /**
     * adds a listener for clearStartButton
     * @param listener listener for the clearStartButton
     * @precondition: none 
     * @postcondition: none
     */
    public void addClearStartButtonListener(ActionListener listener)
    {
        clearStartButton.addActionListener(listener);
    }
    
    /**
     * used to display an error message to the user when they do incorrect things
     * @param error message to display to user
     * @preconditon: string.length() > 0
     * @postconditon: nome
     */
    void DisplayErrorMessage(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }

}
