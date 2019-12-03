/*
 * SellerView.java
 * MVC PATTERN:  this is the view component of the MVC PATTERN.
 * It is used for all the UI logic of the application.
 */
package Shop_Mart;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.event.TableModelListener;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class SellerView extends JFrame
{
    private final JButton addButton;
    private final JButton prcButton;
    private final JTable productTable;
    private final JButton signOut;
    //----------------------
    private final JButton cancelButton;
    private final JButton addProductButton;
    private final JTextField productTextField;
    private final JTextField invoiceTextField;
    private final JTextField priceTextField;
    
    /**
     * 
     * @param seller seller currently logged in
     * @precondition: none
     * @postcondition: none
     */
    public SellerView(Seller seller)
    {
        addButton = new JButton();
        prcButton = new JButton();
        productTable = new JTable();
        signOut = new JButton();
        //-------------------
        cancelButton = new JButton();
        addProductButton =  new JButton();
        productTextField = new JTextField();  
        invoiceTextField = new JTextField();
        priceTextField = new JTextField();
        //-------------------
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new java.awt.Dimension(480, 500));
        //display initial panel
        initPanel(seller);
    }
    
    /**
     * initializes the JFrame
     *
     * @precondition: none
     * @postcondition: none
     */
    public final void initPanel(Seller seller)
    {
        //clear contentpane
        this.getContentPane().removeAll();
        
        //set up initial panel
        JLabel greeting = new JLabel();
        JLabel inventoryLabel = new JLabel();
        JPanel mainPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        JSeparator seperator = new JSeparator();
        JLabel titleLabel = new JLabel();
        
        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setText("Shop Mart");
        
        greeting.setText("Hello, " + seller.getUsername());

        prcButton.setText("Profit/Revenue/Cost");

        addButton.setText("+");

        inventoryLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inventoryLabel.setText("Inventory:");

        signOut.setText("Sign-out");
        
        Object[][] data = new Object[seller.inventory.size()][4];
        
        for(int i = 0; i < data.length; i++)
        {
            data[i] = new Object[]{seller.inventory.getProduct(i).type, seller.inventory.getProduct(i).sellerQuantity,
            seller.inventory.getProduct(i).sellPrice, seller.inventory.getProduct(i).invoicePrice};
        }
        
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            data, new String [] { "Product", "Quantity", "Sell Price", "Invoice Price"}) 
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        productTable.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(productTable);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(seperator)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signOut))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(greeting)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(inventoryLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prcButton)))
                        .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(signOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greeting)
                .addGap(36, 36, 36)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prcButton)
                        .addComponent(addButton))
                    .addComponent(inventoryLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }
    
    /**
     * initializes the JFrame
     *
     * @precondition: none
     * @postcondition: none
     */
    public void newProductPanel()
    {
        // clear content pane
        this.getContentPane().removeAll();
        
        //set up panel
        JPanel addProductPanel = new JPanel();
        JLabel desc = new JLabel();
        JLabel invoiceLabel = new JLabel();
        JLabel sellLabel = new JLabel();
        JLabel productLabel = new JLabel();
        JSeparator seperator = new JSeparator();
        JLabel titleLabel = new JLabel();
        
        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setText("Shop Mart");

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc.setText("Add a New Product to Inventory:");

        addProductButton.setText("Add Product");
        productLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        productLabel.setText("Name of Product:");
        
        invoiceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        invoiceLabel.setText("Invoice Price:");
        
        sellLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sellLabel.setText("Sell Price:");
        
        cancelButton.setText("Cancel");
        
        javax.swing.GroupLayout addProductPanelLayout = new javax.swing.GroupLayout(addProductPanel);
        addProductPanel.setLayout(addProductPanelLayout);
        addProductPanelLayout.setHorizontalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(seperator)
            .addGroup(addProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addProductButton))
                    .addComponent(productTextField)
                    .addComponent(invoiceTextField)
                    .addComponent(priceTextField)
                    .addGroup(addProductPanelLayout.createSequentialGroup()
                        .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc)
                            .addComponent(productLabel)
                            .addComponent(invoiceLabel)
                            .addComponent(sellLabel)
                            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addProductPanelLayout.setVerticalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductPanelLayout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desc)
                .addGap(18, 18, 18)
                .addComponent(productLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(invoiceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sellLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addProductPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }
    
    /**
     * adds a listener for addButton
     *
     * @param listener listener for the addButton
     * @precondition: none
     * @postcondition: none
     */
    void addButtonListener(ActionListener listen)
    {
        addButton.addActionListener(listen);   
    }
    
    /**
     * adds a listener for PRCButton
     *
     * @param listener listener for the PRCButton
     * @precondition: none
     * @postcondition: none
     */
    void addPRCButtonLIstener(ActionListener listen)
    {
        prcButton.addActionListener(listen);
    }
    
    /**
     * used to display the profit, revenue, and cost for the seller
     *
     * @param prc profit,revenue,cost to display to user
     * @preconditon: none
     * @postconditon: nome
     */
    void DisplayPRCMessage(String prc)
    {
        JOptionPane.showMessageDialog(this, prc);
    }
    
    /**
     * adds a listener for ProductTable
     *
     * @param listener listener for the ProductTable
     * @precondition: none
     * @postcondition: none
     */
    void addProductTableListener(TableModelListener listen)
    {
        productTable.getModel().addTableModelListener(listen);
    }
    
    /**
     * adds a listener for signOut button
     *
     * @param listener listener for the signOut button
     * @precondition: none
     * @postcondition: none
     */
    void addSignoutListener(ActionListener listen)
    {
        signOut.addActionListener(listen);
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
    
    //----------------------------------------------------
    /**
     * adds a listener for CancelButton
     *
     * @param listener listener for the CancelButtonn
     * @precondition: none
     * @postcondition: none
     */
    void addCancelButtonListener(ActionListener listen)
    {
        cancelButton.addActionListener(listen);   
    }
    
    /**
     * adds a listener for addProductButton
     *
     * @param listener listener for the addProductButton
     * @precondition: none
     * @postcondition: none
     */
    void addProductButtonListener(ActionListener listen)
    {
        addProductButton.addActionListener(listen);   
    }
    
    /**
     * gets the text from the text Field
     *
     * @return returns the information entered by user if any
     * @precondtion: none
     * @postcondition: none
     */
    String getProductField()
    {
        return productTextField.getText();
    }
    
    /**
     * gets the invoice value from the text Field
     *
     * @return returns the information entered by user if any
     * @precondtion: none
     * @postcondition: none
     */
    double getInvoiceField()
    {
        return Double.parseDouble(invoiceTextField.getText());
    }
    
    /**
     * gets the price value from the text Field
     *
     * @return returns the information entered by user if any
     * @precondtion: none
     * @postcondition: none
     */
    double getPriceField()
    {
        return Double.parseDouble(priceTextField.getText());
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

    void clearTextFields() 
    {
        productTextField.setText(null);
        invoiceTextField.setText(null);
        priceTextField.setText(null);
    }

    
}
