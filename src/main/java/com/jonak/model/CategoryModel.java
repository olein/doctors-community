package com.jonak.model;

import com.jonak.lib.Tools;

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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
        this.fields.add("parent_id");   this.types.add("int");        this.values.add(this.getParentId());
    }

    public Date getCreatedAt() throws Exception{
        return Tools.getDate(createdAt);
    }

    public int getCreatedAt(boolean b) {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreatedAt(true));
    }

}
