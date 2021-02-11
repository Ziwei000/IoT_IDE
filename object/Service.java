package com.group5.ide_vss.object;

public class Service {

    private String ip;//10.254.0.3

    private int port;//6668

    private String name;

    private String thing_id;

    private String entity_id;

    private String space_id;

    private String vendor;

    private String api;

    private String type;

    private String appcategory;

    private String description;

    private String keywords;

    @Override
    public String toString() {
        return "Service{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", name='" + name + '\'' +
                ", thing_id='" + thing_id + '\'' +
                ", entity_id='" + entity_id + '\'' +
                ", space_id='" + space_id + '\'' +
                ", vendor='" + vendor + '\'' +
                ", api='" + api + '\'' +
                ", type='" + type + '\'' +
                ", appcategory='" + appcategory + '\'' +
                ", description='" + description + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }

    public Service(String ip, int port, String name, String thing_id, String entity_id, String space_id, String vendor, String api, String type, String appcategory, String description, String keywords) {
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.thing_id = thing_id;
        this.entity_id = entity_id;
        this.space_id = space_id;
        this.vendor = vendor;
        this.api = api;
        this.type = type;
        this.appcategory = appcategory;
        this.description = description;
        this.keywords = keywords;
    }

    public Service( String name, String thing_id, String entity_id, String space_id, String vendor, String api, String type, String appcategory, String description, String keywords) {
        this.name = name;
        this.thing_id = thing_id;
        this.entity_id = entity_id;
        this.space_id = space_id;
        this.vendor = vendor;
        this.api = api;
        this.type = type;
        this.appcategory = appcategory;
        this.description = description;
        this.keywords = keywords;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThing_id() {
        return thing_id;
    }

    public void setThing_id(String thing_id) {
        this.thing_id = thing_id;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getSpace_id() {
        return space_id;
    }

    public void setSpace_id(String space_id) {
        this.space_id = space_id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.space_id = api;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppcategory() {
        return appcategory;
    }

    public void setAppcategory(String appcategory) {
        this.appcategory = appcategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


}
