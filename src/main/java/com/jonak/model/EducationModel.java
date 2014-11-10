package com.jonak.model;

/**
 * Created by Fahim on 10/11/2014.
 */
public class EducationModel extends BaseModel
{
    private int id;
    private int user_id;
    private String degree;
    private String institute;
    private String result;
    private String update;
    private String delete;


    public EducationModel()
    {
        super();
        this.tableName = "education";
    }
    protected void prepareFields()
    {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("user_id");     this.types.add("int");        this.values.add(this.getUser_id());
        this.fields.add("degree");       this.types.add("String");     this.values.add(this.getDegree());
        this.fields.add("institute"); this.types.add("String");     this.values.add(this.getInstitute());
        this.fields.add("result"); this.types.add("String");     this.values.add(this.getResult());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
