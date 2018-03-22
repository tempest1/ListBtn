package com.egoo.listbtn;

/**
 * Created by zd on 2017/4/24.
 */
public class Plan {
    public String name;

    public String avatar;

    public Plan(String name, String avatar) {
        super();
        this.name = name;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Plan [name=" + name + ", avatar=" + avatar + "]";
    }
}
