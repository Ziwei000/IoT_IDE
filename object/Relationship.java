package com.group5.ide_vss.object;

public class Relationship {

    private String parent;

    private String child;

    private String description;

    public Relationship(String parent, String child, String description) {
        this.parent = parent;
        this.child = child;
        this.description = description;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
