package com.its.enities;

public class Demo {
    int id;
    String info;
    String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
