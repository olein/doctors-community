package com.jonak.model;

/**
 * Created by Fahim on 14/11/2014.
 */
public class ContentCategoryModel extends BaseModel
{
    private int id;
    private int category_id;
    private int content_id;

    public ContentCategoryModel()
    {
        super();
        this.tableName = "category_content_relation";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("category_id");        this.types.add("int");     this.values.add(this.getCategory_id());
        this.fields.add("content_id");      this.types.add("int");     this.values.add(this.getContent_id());
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
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }
}
