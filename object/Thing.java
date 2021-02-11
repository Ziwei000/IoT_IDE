package com.group5.ide_vss.object;


       
public class Thing {

    private String id;

    private String space_id;

    private String name;

    private String model;

    private String vendor;

    private String owner;

    private String description;

    private String OS;


    public Thing(String id, String space_id, String name,  String model, String vendor, String owner, String description, String OS) {
        this.id = id;
        this.space_id = space_id;
        this.name = name;
        this.model = model;
        this.vendor = vendor;
        this.owner = owner;
        this.description = description;
        this.OS = OS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpace_id() {
        return space_id;
    }

    public void setSpace_id(String space_id) {
        this.space_id = space_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
