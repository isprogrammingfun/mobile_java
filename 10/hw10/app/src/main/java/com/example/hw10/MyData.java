package com.example.hw10;

public class MyData {

    private long _id;
    private String name;
    private String address;
    private String state;

    public MyData(int _id, String name, String address, String state){
        this._id = _id;
        this.name = name;
        this.address = address;
        this.state = state;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState(){return state;}

    public void set_state(String state) { this.state = state;}
}
