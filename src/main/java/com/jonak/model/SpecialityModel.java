package com.jonak.model;

/**
 * Created by Fahim on 12/11/2014.
 */
public class SpecialityModel extends BaseModel
{
    private int user_id;
    private int category_id;
    private String delete;
    private String category_name;

    public SpecialityModel()
    {
        super();
        this.tableName = "category_user_relation";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("user_id");   this.types.add("int");        this.values.add(this.getUser_id());
        this.fields.add("category_id");  this.types.add("int");        this.values.add(this.getCategory_id());
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
