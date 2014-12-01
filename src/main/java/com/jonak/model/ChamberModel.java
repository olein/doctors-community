package com.jonak.model;

/**
 * Created by Fahim on 10/11/2014.
 */
public class ChamberModel extends BaseModel
{
    private int userId;
    private String address;
    private String telephone;
    private String visitingHour;
    private String visitingDays;
    private String fees;
    private String name;

    public ChamberModel()
    {
        super();
        this.tableName = "chamber_detail";
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        this.fields.add("user_id");      this.types.add("int");        this.values.add(this.getUserId());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.fields.add("address");      this.types.add("String");     this.values.add(this.getAddress());
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
        this.fields.add("telephone");    this.types.add("String");     this.values.add(this.getTelephone());
    }
    public String getVisitingDays() {
        return visitingDays;
    }

    public void setVisitingDays(String visitingDays) {
        this.visitingDays = visitingDays;
        this.fields.add("visiting_days");    this.types.add("String");     this.values.add(this.getVisitingDays());
    }

    public String getVisitingHour() {
        return visitingHour;
    }

    public void setVisitingHour(String visitingHour) {
        this.visitingHour = visitingHour;
        this.fields.add("visiting_hour");    this.types.add("String");     this.values.add(this.getVisitingHour());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.fields.add("name");    this.types.add("String");     this.values.add(this.getName());
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
        this.fields.add("fees");         this.types.add("String");     this.values.add(this.getFees());
    }
    public void clear()
    {
        this.fields.clear();
        this.types.clear();
        this.values.clear();
    }
}
