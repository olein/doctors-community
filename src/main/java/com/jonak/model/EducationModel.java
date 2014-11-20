package com.jonak.model;

/**
 * Created by Fahim on 10/11/2014.
 */
public class EducationModel extends BaseModel
{

    private int user_id;
    private String degree;
    private String institute;
    private String result;

    public EducationModel()
    {
        super();
        this.tableName = "education";
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
        this.fields.add("user_id");     this.types.add("int");        this.values.add(this.getUser_id());
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
        this.fields.add("degree");       this.types.add("String");     this.values.add(this.getDegree());
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
        this.fields.add("institute"); this.types.add("String");     this.values.add(this.getInstitute());
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        this.fields.add("result"); this.types.add("String");     this.values.add(this.getResult());
    }
    public void clear()
    {
        this.fields.clear();
        this.types.clear();
        this.values.clear();
    }
}
