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
    private String parent_name;


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

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
        this.fields.add("parent_id");   this.types.add("int");        this.values.add(this.getParent_id());
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreated_at());
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }



}
