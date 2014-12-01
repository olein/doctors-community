package com.jonak.model;

import java.util.Date;

/**
 * Created by Fahim on 11/11/2014.
 */
public class CategoryModel extends BaseModel
{

    private String name;
    private String detail;
    private int parentId;
    private int createdAt;
    private Date date;
    private String categoryName;

    public CategoryModel()
    {
        super();
        this.tableName = "category";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
        //this.fields.add("id");        this.types.add("int");     this.values.add(this.getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.fields.add("name");        this.types.add("String");     this.values.add(this.getName());
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
        this.fields.add("detail");      this.types.add("String");     this.values.add(this.getDetail());
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
        this.fields.add("parent_id");   this.types.add("int");        this.values.add(this.getParentId());
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreatedAt());
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
