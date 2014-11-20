package com.jonak.model;

import java.util.Date;

/**
 * Created by Fahim on 11/11/2014.
 */
public class CategoryModel extends BaseModel
{

    private String name;
    private String detail;
    private int parent_id;
    private int created_at;
    private Date date;
    private String category_name;
    private String update;
    private String delete;

    public CategoryModel()
    {
        super();
        this.tableName = "category";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("name");        this.types.add("String");     this.values.add(this.getName());
        this.fields.add("detail");      this.types.add("String");     this.values.add(this.getDetail());
        this.fields.add("parent_id");   this.types.add("int");        this.values.add(this.getParent_id());
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreated_at());
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

}
