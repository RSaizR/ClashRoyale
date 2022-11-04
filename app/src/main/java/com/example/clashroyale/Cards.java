package com.example.clashroyale;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
@Entity
public class Cards implements Serializable, Comparable<Cards> {


    @PrimaryKey(autoGenerate = true)


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Hp")
    @Expose
    private Integer hp;
    @SerializedName("Damage")
    @Expose
    private Integer damage;
    @SerializedName("Speed")
    @Expose
    private String speed;
    @SerializedName("Img")
    @Expose
    private String img;
    @SerializedName("ImgD")
    @Expose
    private String imgD;
    @SerializedName("Data")
    @Expose
    private String data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgD() { return imgD; }

    public void setImgD(String imgD) { this.imgD = imgD; }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ", speed='" + speed + '\'' +
                ", img='" + img + '\'' +
                ", imgD='" + imgD + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cards c){
        String a = this.getHp()+"";
        String b = c.getHp()+"";
        return a.compareTo(b);
    }
}