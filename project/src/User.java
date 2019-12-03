/*
 * User.java
 * holds values/functions shared by sellers and customers
 */
package Shop_Mart;

import java.io.Serializable;

/**
 *
 * @author abdullahshafique,jasonmichel
 */
public class User implements Serializable
{
    private static final long serialVersionUID = 6529685098267757690L;
    protected String username;
    protected String password;
    protected boolean type;

    /**
     * sets the password of user to whats passed
     * @param password password of user
     * @precondition: none
     * @postcondition: this.password == password
     */
    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        return username + " " + password + " " + type;
    }
}
