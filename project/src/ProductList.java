/*
 * ProductList.java
 * STRATEGY PATTERN: the strategy pattern is used here so that when a client
 * wants to implement a ProductList, different variations (Inventory, ShoppingCart)
 * of the algorithm is supplied giving custom versions of the algorithm.
 */
package Shop_Mart;

import java.util.LinkedList;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public interface ProductList
{

    public void add(Product p);

    public void remove(int id);

    public void update(int index, Product p);

    public int size();

    public Product getProduct(int index);

}

class Inventory implements ProductList
{

    LinkedList<Product> items;

    /**
     * default constructor
     *
     * @precondition: none
     * @postcondtion: value initialized
     */
    public Inventory()
    {
        items = new LinkedList();
    }

    /**
     * adds a product to the items list
     *
     * @param p product added to item
     * @preconditon: none
     * @postcondition: items += p
     */
    @Override
    public void add(Product p)
    {
        items.add(p);
    }

    /**
     * removes item based on passed id
     *
     * @param id index
     * @precondtion: items > 0
     * @postcondition: items -= items.get(id);
     */
    @Override
    public void remove(int id)
    {
        items.remove(id);
    }

    /**
     * gets the amount of items total
     *
     * @return returns the size of the items list
     * @precondtion: none
     * @postconditon: none
     */
    @Override
    public int size()
    {
        return items.size();
    }

    /**
     * updates the items list based on passed product
     *
     * @param index index
     * @param p product
     * @precondtion: items > 0
     * @postcondtion items.get(index) == p
     */
    @Override
    public void update(int index, Product p)
    {
        items.set(index, p);
    }

    /**
     * gets the product at specified index
     *
     * @param index
     * @return returns the product at index
     * @precondtion: items > 0
     * @postcondtion: none
     */
    @Override
    public Product getProduct(int index)
    {
        return items.get(index);
    }
}

class ShoppingCart implements ProductList
{

    LinkedList<Product> items;

    /**
     * default constructor
     *
     * @precondition: none
     * @postcondtion: value initialized
     */
    public ShoppingCart()
    {
        items = new LinkedList();
    }

    /**
     * adds a product to the items list
     *
     * @param p product added to item
     * @preconditon: none
     * @postcondition: items += p
     */
    @Override
    public void add(Product p)
    {
        items.add(p);
    }

    /**
     * clears all products within the items list
     *
     * @param id unused value
     * @precondition: none
     * @postcondtion: items.size() == 0
     */
    @Override
    public void remove(int id)
    {
        items.clear();
    }

    /**
     * gets the amount of items total
     *
     * @return returns the size of the items list
     * @precondtion: none
     * @postconditon: none
     */
    @Override
    public int size()
    {
        return items.size();
    }

    /**
     * gets the product at specified index
     *
     * @param index
     * @return returns the product at index
     * @precondtion: items > 0
     * @postcondtion: none
     */
    @Override
    public Product getProduct(int index)
    {
        return items.get(index);
    }

    /**
     * updates the items list based on passed product
     *
     * @param index index
     * @param p product
     * @precondtion: items > 0
     * @postcondtion items.get(index) == p
     */
    @Override
    public void update(int index, Product p)
    {
        items.set(index, p);
    }
}
