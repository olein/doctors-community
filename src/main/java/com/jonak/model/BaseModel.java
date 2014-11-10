package com.jonak.model;

// import default
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

// import custom
import com.jonak.lib.MySQLDatabase;
import com.jonak.lib.SessionLib;
import org.apache.struts2.ServletActionContext;

/**
 * BaseModel class
 */
public class BaseModel {
    //=====================
    // variables
    //=====================

    // id of the object
    protected int id;
    protected int user_id;
    // table name
    protected String tableName;

    // database instance
    protected MySQLDatabase db;

    // other necessary variables
    protected ArrayList fields;
    protected ArrayList types;
    protected ArrayList values;
    //=====================
    // methods
    //=====================

    // constructor method
    public BaseModel()
    {
        // set initial values
        this.id = 0;
        this.user_id = 0;
        this.fields = new ArrayList();
        this.types  = new ArrayList();
        this.values = new ArrayList();
    }

    /**
     * save method
     *
     * @param - null
     * @return - null
     */
    public void save() throws SQLException
    {
        // if id is given (greater than 0) that mean it is update call
       if( this.user_id > 0 ) {
            this.update(this.user_id);
       }

       else if( this.id > 0 ) {
            this.update();
       }
       else{
            // id is not given so it is add new call
            this.add();
       }
    }

    /**
     * delete method
     *
     * @param - null
     * @return - null
     */
    public void delete() throws SQLException
    {
        this.db = new MySQLDatabase();
        id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
        this.db.executeDeleteQuery( this.tableName, this.id );
        this.db.closeConnection();
    }

    /**
     * update method
     *
     * @param - null
     * @return - null
     * @throws SQLException
     */
    private void update() throws SQLException
    {
        this.db = new MySQLDatabase();

        // prepare fields (fields, types, values)
        this.prepareFields();

        this.db.executeUpdateQuery( this.tableName, this.fields, this.types, this.values, this.id );
        this.db.closeConnection();
    }

    public void update(int id) throws SQLException
    {
        this.db = new MySQLDatabase();

        this.prepareFields();

        this.db.executeUpdateQuery( this.tableName, this.fields, this.types, this.values, id );
        this.db.closeConnection();
    }

    /**
     * add method
     *
     * @param - null
     * @return - null
     * @throws SQLException
     */
    private void add() throws SQLException
    {
        this.db = new MySQLDatabase();

        this.prepareFields();

        this.db.executeInsertQuery( this.tableName, this.fields, this.types, this.values );
        this.db.closeConnection();
    }

    // MUST override this method

    /**
     * prepare methods
     *
     */
    protected void prepareFields()
    {
        // override this from child class
    }
}
