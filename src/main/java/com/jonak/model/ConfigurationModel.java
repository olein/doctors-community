package com.jonak.model;
import com.jonak.model.BaseModel;
/**
 * Created by Fahim on 13/11/2014.
 */
public class ConfigurationModel extends BaseModel
{
    private int id;
    private String key;
    private String value;
    private String update;
    private String delete;

    public ConfigurationModel()
    {
        super();
        this.tableName = "configuration";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("key_value");        this.types.add("String");        this.values.add(this.getKey());
        this.fields.add("value");        this.types.add("String");      this.values.add(this.getValue());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
}
