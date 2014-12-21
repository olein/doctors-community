package com.jonak.lib;

// import default
import java.sql.*;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;

/**
 * database class
 *
 * @author lenin
 */
public class MySQLDatabase {

    //=====================
    // variables
    //=====================

    // the connection instance
    private Connection conn;

    // prepared statement
    private PreparedStatement ps;

    // result set
    private ResultSet rs;

    // mysql driver url
    private String url;

    // mysql driver
    private String driver;

    // database name
    private String dbName;

    // database username
    private String dbUser;

    // database password
    private String dbPass;


    //=====================
    // methods
    //=====================

    // constructor
    public MySQLDatabase()
    {
        this.url = "jdbc:mysql://localhost:3306/";
        this.driver = "com.mysql.jdbc.Driver";

        this.dbName = "doctors_community";
        this.dbUser = "root";
        this.dbPass = "rootuser";

        // initialize conneciton
        this.dbConnection();
    }

    /**
     * initialize the database connection
     *
     * @param - null
     * @return - null
     */
    private void dbConnection() /*throws SQLException*/
    {
        try {
            // mysql load driver
            Class.forName(this.driver).newInstance();

            this.conn = DriverManager.getConnection(this.url + this.dbName, this.dbUser, this.dbPass);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * close connection
     *
     * @param - null
     * @return - null
     * @throws - SQLException
     */
    public void closeConnection() throws SQLException
    {
        try {
            this.conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * executes select query
     *
     * @param - String
     * @param - String
     * @param - ArrayList
     * @param - ArrayList
     * @param - ArrayList
     * @return - ResultSet
     * @throws SQLException
     */
    public ResultSet executeSelectQuery(String tableName,
                                        String fieldName,
                                        ArrayList fields,
                                        ArrayList types,
                                        ArrayList values,
                                        String filter) throws SQLException
    {
        String sql = " select " + fieldName + " from " + tableName + " ";
        int i, size = fields.size();
        if (size > 0) {
            sql += " where ";
            for (i = 0; i < size; i++) {
                if(i > 0) {
                    sql += " and ";
                }
                sql += fields.get(i)+"=? ";
            }
        }

        if( ! filter.isEmpty() ) {
            sql += filter;
        }

//        System.out.println(sql);
        this.ps = this.conn.prepareStatement(sql);
        this.ps = this.setFields( this.ps, types, values);
        System.out.println( this.ps);
        this.rs = this.ps.executeQuery();

        return this.rs;
    }

    /**
     * executes select query
     *
     * @param - String
     * @param - String
     * @param - ArrayList
     * @param - ArrayList
     * @param - ArrayList
     * @return - ResultSet
     * @throws SQLException
     */
    public ResultSet executeSelectQuery(String sql,
                                        ArrayList values) throws SQLException
    {
        int i=1, size = values.size();

//        System.out.println(sql);
        this.ps = this.conn.prepareStatement(sql);

        for(Object value : values) {
            if (value instanceof String) {
                this.ps.setString(i, (String) value);
            } else if (value instanceof Integer) {
                this.ps.setInt(i, (Integer) value);
            } else if (value instanceof Long) {
                this.ps.setLong(i, (Long) value);
            } else if (value instanceof Float) {
                this.ps.setFloat(i, (Float) value);
            } else if (value instanceof Double) {
                this.ps.setDouble(i, (Double) value);
            }
            i++;
        }

        System.out.println(this.ps);
        this.rs = this.ps.executeQuery();

        return this.rs;
    }

    /**
     * executes insert query
     *
     * @param - String
     * @param - ArrayList
     * @param - ArrayList
     * @param - ArrayList
     * @return - boolean
     * @throws SQLException
     */
    public boolean executeInsertQuery(String tableName,
                                      ArrayList fields,
                                      ArrayList types,
                                      ArrayList values) throws SQLException
    {
        String sql = "insert into " + tableName + "(";
        int i, size = fields.size();

        for ( i = 0; i < size; i++)
        {
            if( i > 0 )
            {
                sql += ", ";
            }
            sql += fields.get( i );
        }

        sql += ") values (";

        for ( i = 0; i < size ; i++)
        {
            if( i > 0 )
            {
                sql += ", ";
            }
            sql += "?";
        }
        sql += " ) ";

        this.ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        this.ps = this.setFields(this.ps, types, values);
        System.out.println(this.ps);
        this.ps.executeUpdate();

        return true;
    }

    /**
     * executes update query
     * @param - String
     * @param - ArrayList
     * @param - ArrayList
     * @param - ArrayList
     * @param - int
     * @return - boolean
     * @throws SQLException
     */
    public boolean executeUpdateQuery(String tableName,
                                      ArrayList fields,
                                      ArrayList types,
                                      ArrayList values,
                                      int id) throws SQLException
    {
        String sql = "update " + tableName + " set ";
        int i, size = fields.size();

        for ( i = 0; i < size; i++ )
        {
            if( i > 0 )
            {
                sql += ", ";
            }
            sql += fields.get(i)+"=? ";
        }

        sql += " where id=? ";

        this.ps = this.conn.prepareStatement( sql );
        this.ps = this.setFields( this.ps, types, values );
        System.out.println(this.ps);
        this.ps.setInt( size+1, id );
        this.ps.executeUpdate();

        return true;
    }

    /**
     * executes delete query
     *
     * @param - String
     * @param - int
     * @return - boolean
     * @throws SQLException
     */
    public boolean executeDeleteQuery(String tableName,
                                      int id) throws SQLException
    {
        String sql = "delete from " + tableName+" where id=?";

        this.ps = this.conn.prepareStatement( sql );
        this.ps.setInt( 1, id );
        this.ps.executeUpdate();

        return true;
    }

    /**
     * sets the value parameter in the sql by their type
     *
     * @param - PreparedStatement
     * @param - ArrayList
     * @param - ArrayList
     * @return - PreparedStatement
     */
    private PreparedStatement setFields(PreparedStatement ps,
                                        ArrayList types,
                                        ArrayList values) throws SQLException
    {
        int i, size = types.size();

        for (i = 0; i < size; i++)
        {
            if ( types.get( i ).equals( "String" ) || types.get( i ).equals( "string" ) )
            {
                String value = ( String ) values.get( i );
                ps.setString( (i+1), value );
            }
            else if ( types.get( i ).equals( "int" ) )
            {
                int value = ( Integer ) values.get( i );
                ps.setInt( (i+1), value );
            }
            else if ( types.get( i ).equals( "double" ) )
            {
                double value = ( Double ) values.get( i );
                ps.setDouble( (i+1), value );
            }
        }

        return ps;
    }

    /**
     * get last inserted id
     */
    public int getLastInsertId() throws Exception
    {
        ResultSet rs = this.ps.getGeneratedKeys();
        if ( rs.next() ) {
            return rs.getInt(1);
        }

        return (-1);
    }
}
