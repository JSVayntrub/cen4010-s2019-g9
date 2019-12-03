/*
 * Model.java
 * MVC PATTERN: this is the model which corresponds to all 
 * the data-related logic that the user works with
 * ITERATOR PATTERN: the information read from file is iterated through
 * giving access to it's values but does not expose its internal structure
 * all models in our system extends this model. it provides those class with
 * a way to save and read from a specified file
 */
package Shop_Mart;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;


public class Model
{
    /**
     * reads all objects within a file
     * @param filename name of the file to read from
     * @return returns a list of objects from the file
     * @precondition: none
     * @postcondtion: none
     */
    protected LinkedList<Object> ReadFromFile(String filename)
    {
        LinkedList<Object> objList = new LinkedList();

        //get all products contained in file
        ObjectInputStream in = null;
        try
        {
            FileInputStream fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            while (true)
            {
                try
                {
                    Object obj = in.readObject();
                    objList.add(obj);
                }
                catch (EOFException e)
                {
                    break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.print("There is no file, so create one.");
        }
        finally
        {
            try
            {
                in.close();
            }
            catch (IOException ex)
            {
                System.out.println("Error closing file!");
            }
        }
        return objList;
    }
    
    /**
     * writes the passed objects to a file
     * @param objects object list
     * @param filename name of file to save to
     * @precondition: none
     * @postcondtion: file created || file altered
     */
    protected void WriteToFile(LinkedList<Object> objects, String filename)
    {
        ObjectOutputStream oos = null;
        try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            for (Object obj : objects)
            {
                oos.writeObject(obj);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                oos.close();
            }
            catch (Exception e2)
            {
                System.out.println("Error closing!");
            }
        }
    }
    
}
