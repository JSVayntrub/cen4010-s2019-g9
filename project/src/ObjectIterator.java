/*
 * ObjectIterator.java
 * ITERATOR PATTERN: the information read from file is iterated through
 * giving access to it's values but does not expose its internal structure
 *
 */
package Shop_Mart;
import java.util.Iterator;

/**
 *
 * @author abdullahshafique, jasonmichel
 */
public interface ObjectIterator
{
    public Iterator createIterator();
}
