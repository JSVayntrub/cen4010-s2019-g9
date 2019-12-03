/*
 * SellerModel.java
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
public class SellerModel extends Model implements ObjectIterator
{

    private final String FILE_NAME;

    /**
     * constructor
     *
     * @param filename
     * @precondition: none
     * @postcondition: variable initialized
     */
    public SellerModel(String filename)
    {
        this.FILE_NAME = filename;
    }

    /**
     * constructor
     *
     * @param seller the seller logged in
     * @precondition: none
     * @postcondtion: seller.inventory.size() >= 0
     */
    public SellerModel(Seller seller)
    {
        this.FILE_NAME = "products.dat";
        getInventory(seller);
    }

    /**
     * defines a product based on the passed parameters
     *
     * @param sellerUsername the username of the seller
     * @param type the product type
     * @param invoice the invoice price
     * @param sellPrice the selle price
     * @return return a new product based on the passed information
     * @precondition: none
     * @postcondition: none
     */
    public Product newProduct(String sellerUsername, String type, double invoice, double sellPrice)
    {
        Product p = new Product();
        p.id = sellerUsername;
        p.type = type;
        p.sellerQuantity = 1;
        p.customerQuantity = 0;
        p.sales = 0;
        p.invoicePrice = invoice;
        p.sellPrice = sellPrice;
        return p;
    }

    /**
     * updates the product's field based on column number
     *
     * @param column the column in which the field is on
     * @param value the value contained within the field
     * @param p the product to update
     * @return returns a product with updated information
     * @precondition: column == 0 || column == 1 || column == 2 || column == 3
     * @postcondition: none
     */
    public Product updateProduct(int column, Object value, Product p)
    {
        //based on what column is, it decides which value to update
        switch (column)
        {
            case 0:
                p.type = (String) value;
                break;
            case 1:
                p.sellerQuantity = (int) value;
                break;
            case 2:
                p.sellPrice = (double) value;
                break;
            case 3:
                p.invoicePrice = (double) value;
                break;
        }
        return p;
    }

    /**
     * saves the inventory of the seller to a file
     *
     * @param seller seller that is logged in
     * @precondition: none
     * @postconditon: seller.inventory saved to file
     */
    public void SaveInventory(Seller seller)
    {
        //add sellers edited inventory and save to file
        super.WriteToFile(addSellerInventory(seller), FILE_NAME);
    }

    /**
     * adds seller inventory to the list
     *
     * @param seller seller who's inventory will be added to list
     * @return return a list of objects with sellers added inventory
     * @precondition: none
     * @postcondtion: none
     */
    private LinkedList<Object> addSellerInventory(Seller seller)
    {
        LinkedList<Object> objList = new LinkedList(); //list to save to file

        Iterator iter;
        try
        {
            iter = new SellerModel(FILE_NAME).createIterator();
        }
        catch (Exception e)
        {
            //there was no file so pass the sellers inventory as the start of it
            for (int i = 0; i < seller.inventory.size(); i++)
            {
                Product p = seller.inventory.getProduct(i);
                objList.add((Object) p);
            }
            return objList;
        }

        //add all products to objList that don't belong to the seller
        while (iter.hasNext())
        {
            //cast object to product and check if it belongs to seller
            Product p = (Product) iter.next();
            if (!p.id.equals(seller.getUsername()))
            {
                //cast to object and add to object list
                objList.add((Object) p);
            }
        }

        //add current products for seller to list
        for (int i = 0; i < seller.inventory.size(); i++)
        {
            //cast to object and add it to object list
            objList.add((Object) seller.inventory.getProduct(i));
        }
        return objList;
    }

    /**
     * populates the sellers inventory
     *
     * @param seller seller
     * @precondition: none
     * @postcondtion: seller.inventory.size() >= 0
     */
    private void getInventory(Seller seller)
    {

        Iterator iterator;
        try
        {
            iterator = new SellerModel(FILE_NAME).createIterator();
        }
        catch (Exception e)
        {
            return;
        }
        while (iterator.hasNext())
        {
            Product p = (Product) iterator.next();
            //if product belongs to seller
            if (p.id.equals(seller.getUsername()))
            {
                seller.inventory.add(p);
            }
        }
    }

    @Override
    public Iterator createIterator()
    {
        return super.ReadFromFile(FILE_NAME).iterator();
    }

    /**
     * gets the profit, revenue, and cost of seller
     *
     * @param seller seller currently logged in
     * @return returns an array of doubles containing the profit, revenue. and
     * cost of seller
     * @precondition: none
     * @postcondtion: profit,revenue,cost saved to file
     */
    public double[] getPRC(Seller seller)
    {
        //all prc's in file;
        LinkedList<Object> allPRC = new LinkedList();

        //user's prc at default value
        Object[] userPRC = new Object[]
        {
            seller.getUsername(), (double) 0, (double) 0, (double) 0
        };

        Iterator iterator;
        try
        {
            iterator = new SellerModel("prc.dat").createIterator();

        }
        catch (Exception e)
        {
            //there was no prc file so by default user has 0 prc
            allPRC.add(userPRC);
            super.WriteToFile(allPRC, "prc.dat");
            //return the user's prc (profit, revenue, cost)
            return new double[]
            {
                (double) userPRC[1], (double) userPRC[2], (double) userPRC[3]
            };
        }

        //obtain all prc's
        while (iterator.hasNext())
        {
            Object[] o = (Object[]) iterator.next();
            allPRC.add(o);
        }
        //find prc to run calculations on
        for (int i = 0; i < allPRC.size(); i++)
        {
            Object[] o = (Object[]) allPRC.get(i);
            if (o[0].toString().equals(seller.getUsername()))
            {
                userPRC = CalculatePRC(seller, (Object[]) o);
                allPRC.set(i, userPRC);
                //save to file
                super.WriteToFile(allPRC, "prc.dat");
                return new double[]
                {
                    (double) userPRC[1], (double) userPRC[2], (double) userPRC[3]
                };
            }
        }
        //user is not in the prc.dat so add him/her
        userPRC = CalculatePRC(seller, userPRC);
        allPRC.add(userPRC);
        //write to file
        super.WriteToFile(allPRC, "prc.dat");
        return new double[]
        {
            (double) userPRC[1], (double) userPRC[2], (double) userPRC[3]
        };
    }

    /**
     *
     * @param seller seller thats logged in
     * @param prc object array holding the profit,revenue, and cost of seller
     * @return returns an object array of profit,revenue,and cost
     * @precondition
     */
    private Object[] CalculatePRC(Seller seller, Object[] prc)
    {
        //if seller doesn't have any items then return since no calculation is needed
        if (seller.inventory.size() < 1)
        {
            return prc;
        }
        double profit, revenue, cost;
        profit = revenue = cost = 0;

        //calculate prc : for all products in seller's inventory
        for (int i = 0; i < seller.inventory.size(); i++)
        {
            //if product was sold
            if (seller.inventory.getProduct(i).sales > 0)
            {
                //add it to revenue/cost the amount of times it was sold
                for (int j = 0; j < seller.inventory.getProduct(i).sales; j++)
                {
                    revenue += seller.inventory.getProduct(i).sellPrice;
                    cost += seller.inventory.getProduct(i).invoicePrice;
                }
                seller.inventory.getProduct(i).sales = 0; //prc is evaluated so set to 0
            }
        }
        profit += revenue - cost; //determine profit

        //return prc with updated information
        Object[] sum = new Object[]
        {
            prc[0].toString(), ((double) prc[1] + profit),
            ((double) prc[2] + revenue), ((double) prc[3] + cost)
        };
        return sum;
    }

}
