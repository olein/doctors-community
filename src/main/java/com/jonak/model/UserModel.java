package com.jonak.model;


// import custom
import com.jonak.lib.Hash;
import com.jonak.lib.Tools;
import com.jonak.model.BaseModel;

// import default
import java.util.Date;

/**
 * user model class
 *
 */
public class UserModel extends BaseModel {
    // no need for id
    // its defined in base model

    // all the variables of user table
	private String email;
	private String password;
	private String firstName;
    private String lastName;
	private String address;
	private String district;
	private int dateOfBirth;
    private int gender;
    private int type;
    private int lastLoginAt;
	private int allowMessage;
    private int status;
    private String token;
    private int createdAt;

    public UserModel()
    {
        super();
        this.tableName = "user";
    }

<<<<<<< HEAD
    protected void prepareFields()
    {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add( "email" ); this.types.add( "String" ); this.values.add( this.getEmail() );
        this.fields.add( "password" ); this.types.add( "String" ); this.values.add( this.getPassword() );
        this.fields.add( "first_name" ); this.types.add( "String" ); this.values.add( this.getFirstName() );
        this.fields.add( "last_name" ); this.types.add( "String" ); this.values.add( this.getLastName() );
        this.fields.add( "address" ); this.types.add( "String" ); this.values.add( this.getAddress() );
        this.fields.add( "district" ); this.types.add( "String" ); this.values.add( this.getDistrict() );
        this.fields.add( "date_of_birth" ); this.types.add( "int" ); this.values.add( this.getDateOfBirth() );
        this.fields.add( "gender" ); this.types.add( "int" ); this.values.add( this.getGender() );
        this.fields.add( "type" ); this.types.add( "int" ); this.values.add( this.getType() );
        this.fields.add( "last_login_at" ); this.types.add( "int" ); this.values.add( this.getLastLoginAt() );
        this.fields.add( "allow_message" ); this.types.add( "int" ); this.values.add( this.getAllowMessage() );
        this.fields.add( "status" ); this.types.add( "int" ); this.values.add( this.getStatus() );
        this.fields.add( "created_at" ); this.types.add( "int" ); this.values.add( this.getCreatedAt() );
        this.fields.add( "token" ); this.types.add( "String" ); this.values.add( this.getKey() );

    }

=======
>>>>>>> upstream/master
    public int getId() {
        return this.id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.fields.add( "email" ); this.types.add( "String" ); this.values.add( this.email );
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.fields.add( "password" ); this.types.add( "String" ); this.values.add( Hash.md5( this.password ) );
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.fields.add( "first_name" ); this.types.add( "String" ); this.values.add( this.firstName );
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.fields.add( "last_name" ); this.types.add( "String" ); this.values.add( this.lastName );
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.fields.add( "address" ); this.types.add( "String" ); this.values.add( this.address );
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
        this.fields.add( "district" ); this.types.add( "String" ); this.values.add( this.district );
    }

    public Date getDateOfBirth() throws Exception
    {
        return Tools.getDate( this.dateOfBirth );
    }

    public int getDateOfBirth( boolean b)
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.fields.add( "date_of_birth" ); this.types.add( "int" ); this.values.add( this.dateOfBirth );
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
        this.fields.add( "gender" ); this.types.add( "int" ); this.values.add( this.gender );
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
        this.fields.add( "type" ); this.types.add( "int" ); this.values.add( this.type );
    }

    public Date getLastLoginAt() throws Exception
    {
        return Tools.getDate( this.lastLoginAt );
    }

    public void setLastLoginAt(int lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
        this.fields.add( "last_login_at" ); this.types.add( "int" ); this.values.add( this.lastLoginAt );
    }

    public int getAllowMessage() {
        return this.allowMessage;
    }

    public void setAllowMessage(int allowMessage) {
        this.allowMessage = allowMessage;
        this.fields.add( "allow_message" ); this.types.add( "int" ); this.values.add( this.allowMessage );
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
        this.fields.add( "status" ); this.types.add( "int" ); this.values.add( this.status );
    }

    public Date getCreatedAt() throws Exception
    {
        return Tools.getDate( this.createdAt );
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
        this.fields.add( "created_at" ); this.types.add( "int" ); this.values.add( this.createdAt );
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
        this.fields.add( "token" ); this.types.add( "String" ); this.values.add( this.token );
    }

    // very important
    public void clear()
    {
        this.fields.clear();
        this.types.clear();
        this.values.clear();
    }
}
