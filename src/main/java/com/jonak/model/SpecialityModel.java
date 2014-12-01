package com.jonak.model;

/**
 * Created by Fahim on 12/11/2014.
 */
public class SpecialityModel extends BaseModel
{
    private int userId;
    private int categoryId;
    private String categoryName;

    public SpecialityModel()
    {
        super();
        this.tableName = "category_user_relation";
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        this.fields.add("category_id");  this.types.add("int");        this.values.add(this.getCategoryId());
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        this.fields.add("user_id");   this.types.add("int");        this.values.add(this.getUserId());
    }
}
