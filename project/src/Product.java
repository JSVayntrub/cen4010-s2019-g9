/*
 * Product.java
 * Holds all the information pertaining to a product
 */
package Shop_Mart;

import java.io.Serializable;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public class Product implements Serializable 
{
    //used for serialization
    private static final long serialVersionUID = 42L;
    
    public String id;
    public String type;
    public int sellerQuantity;
    public int customerQuantity;
    public int sales;
    public double sellPrice;
    public double invoicePrice;

}
