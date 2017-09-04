package life.game.xcs.com.mylife.data;

import android.support.annotation.Nullable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by xcs on 2017/8/29 0029.
 */

public class Bill {

    private String id;
    private String type;
    private String title;
    private float money;
    private String date;
    private String account;
    private String member;
    private String description;

public Bill(String type, String title, float money, String date, String account, String member, String description){
    this.id = UUID.randomUUID().toString();
    this.title = title;
    this.money = money;
    this.date = date;
    this.account = account;
    this.member = member;
    this.description = description;
    this.type = type;
  }

    public Bill(String id,String type, String title, float money, String date, String account, String member, String description){
        this.id = id;
        this.title = title;
        this.money = money;
        this.date = date;
        this.account = account;
        this.member = member;
        this.description = description;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
