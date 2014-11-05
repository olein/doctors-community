package com.jonak.model;

// import default

// import custom
import com.jonak.model.BaseModel;

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
    private int createdAt;

    public UserModel() { super(); }

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
    }

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
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLastLoginAt() {
        return this.lastLoginAt;
    }

    public void setLastLoginAt(int lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public int getAllowMessage() {
        return this.allowMessage;
    }

    public void setAllowMessage(int allowMessage) {
        this.allowMessage = allowMessage;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }
}
