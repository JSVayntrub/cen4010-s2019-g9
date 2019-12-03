/*
 * SellerController.java
 * MVC PATTERN: this is the controller that controlls interactions between
 * the model/view class of similar name.
 * OBSERVER PATTERN: the classes below that implement action listeners use the
 * observer pattern by generating an event and notifying the elements in the view
 * class to update
 */
package Shop_Mart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class SellerController 
{
    private final SellerView view;
    private final SellerModel model;
    private final Seller seller;
    private final double[] prc; //profit, revenue, cost 
    
    /**
     * default constructor
     * @param seller seller that is logged in
     * @precondition: none
     * @postcondition: view set visible
     */
    public SellerController(Seller seller)
    {
        this.seller = seller;
        model = new SellerModel(this.seller);
        //get prc value of seller
        prc = model.getPRC(this.seller);
        view = new SellerView(this.seller);
        view.setVisible(true);
        
        //------------initpanel listeners
        view.addButtonListener(new addButtonListener());
        view.addPRCButtonLIstener(new PRCButtonListener());
        view.addProductTableListener(new TableListener());
        view.addSignoutListener(new SignoutListener());
        
        //------------newProductPanel listeners
        view.addProductButtonListener(new ProductButtonListener());
        view.addCancelButtonListener(new CancelButtonListener());
    }
    
    //------------------------------------------------init page
    class addButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            view.newProductPanel();
        }
    }
    
    class PRCButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            //process prc then save it as string to display in message prompt
            view.DisplayPRCMessage("Profit: " + prc[0] + "\nRevenue: " + prc[1] + "\nCost: " + prc[2]);
        }
    }
    
    class TableListener implements TableModelListener
    {
        @Override
        public void tableChanged(TableModelEvent tme) 
        {
            int row = tme.getFirstRow();
            int column = tme.getColumn();
            TableModel tableModel = (TableModel)tme.getSource();
            
            String columnName = tableModel.getColumnName(column);
            Object data = tableModel.getValueAt(row, column);
            
            //if user assigns 0 or less in the quantity column: remove product from list
            if(column == 1)
            {
                int temp = (int)data;
                if(temp <= 0)
                {
                    seller.inventory.remove(row);
                    mainScreen();
                    return; // end function
                }
            }
            else if(column > 1) //if data is negative: deny it as a valid input
            {
                double temp = (double)data;
                if(temp <= 0)
                {
                    javax.swing.JOptionPane.showMessageDialog(null, temp + " is not a valid " + columnName + ".");
                    mainScreen();
                    return; //end function
                }
            }
            //update seller inventory to input
            seller.inventory.update(row, model.updateProduct(column, data, seller.inventory.getProduct(row)));
        }
    }
    
    class SignoutListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            //save user using tableModel and close application
            //model will search through file and update information of sellers data.
            model.SaveInventory(seller);
            
            //model.SavePRC();
            view.exit();
        }
    }
    
    //------------------------------------------------new product page
    class ProductButtonListener implements ActionListener
    {   
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            String type;
            double invoice,  price;
            String error = "Invalid information. Try again.";
            try
            {
                type = view.getProductField();
                invoice = view.getInvoiceField();
                price = view.getPriceField();
                //check if productname is empty
                if(type.trim().isEmpty())
                {
                    throw new java.lang.RuntimeException(error);//throw error
                }
                if(invoice <= 0 || price <= 0)
                {
                    throw new java.lang.RuntimeException(error);
                }
                //check if seller already has a product with same name
                for(int i = 0; i < seller.inventory.size(); i++)
                {
                    //if the seller already has a product with same name, append a * to entered name
                    if(seller.inventory.getProduct(i).type.equals(type))
                    {
                        type += "*";
                        break;
                    }
                }
                 //perform operation for new product using tableModel then add to inventory
                seller.inventory.add(model.newProduct(seller.getUsername(), type, invoice, price));
                
                //clear text fields and return to initial panel
                view.clearTextFields();
                mainScreen();
            }
            catch(RuntimeException e)
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
            //clear text fields and return to main Screen
            view.clearTextFields();
            mainScreen();
        }
    }
    
   /**
    * return to initial panel
    * @precondition: current panel != initial panel
    * @poscondtion: panel changed
    */
   public void mainScreen()
   {
       view.initPanel(seller);
       view.addProductTableListener( new TableListener());
   }
}
