package com.jonak.model;

/**
 * Created by Fahim on 14/11/2014.
 */
public class ContentCategoryModel extends BaseModel
{
    private int category_id;
    private int content_id;

    public ContentCategoryModel()
    {
        super();
        this.tableName = "category_content_relation";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
        this.fields.add("category_id");        this.types.add("int");     this.values.add(this.getCategory_id());
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
        this.fields.add("content_id");      this.types.add("int");     this.values.add(this.getContent_id());
    }
    public void clear()
    {
        this.fields.clear();
        this.types.clear();
        this.values.clear();
    }
}
