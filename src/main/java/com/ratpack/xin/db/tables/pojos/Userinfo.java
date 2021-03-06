/*
 * This file is generated by jOOQ.
*/
package com.ratpack.xin.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Userinfo implements Serializable {

    private static final long serialVersionUID = -1989073628;

    private String userid;
    private String username;
    private String userpassword;
    private String userphone;
    private String usersex;
    private String usercountry;
    private String userprovince;
    private String usercity;
    private String userarea;
    private String usercreatetime;
    private String userhead;
    private String qqid;
    private String wxid;

    public Userinfo() {}

    public Userinfo(Userinfo value) {
        this.userid = value.userid;
        this.username = value.username;
        this.userpassword = value.userpassword;
        this.userphone = value.userphone;
        this.usersex = value.usersex;
        this.usercountry = value.usercountry;
        this.userprovince = value.userprovince;
        this.usercity = value.usercity;
        this.userarea = value.userarea;
        this.usercreatetime = value.usercreatetime;
        this.userhead = value.userhead;
        this.qqid = value.qqid;
        this.wxid = value.wxid;
    }

    public Userinfo(
        String userid,
        String username,
        String userpassword,
        String userphone,
        String usersex,
        String usercountry,
        String userprovince,
        String usercity,
        String userarea,
        String usercreatetime,
        String userhead,
        String qqid,
        String wxid
    ) {
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
        this.userphone = userphone;
        this.usersex = usersex;
        this.usercountry = usercountry;
        this.userprovince = userprovince;
        this.usercity = usercity;
        this.userarea = userarea;
        this.usercreatetime = usercreatetime;
        this.userhead = userhead;
        this.qqid = qqid;
        this.wxid = wxid;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return this.userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserphone() {
        return this.userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUsersex() {
        return this.usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUsercountry() {
        return this.usercountry;
    }

    public void setUsercountry(String usercountry) {
        this.usercountry = usercountry;
    }

    public String getUserprovince() {
        return this.userprovince;
    }

    public void setUserprovince(String userprovince) {
        this.userprovince = userprovince;
    }

    public String getUsercity() {
        return this.usercity;
    }

    public void setUsercity(String usercity) {
        this.usercity = usercity;
    }

    public String getUserarea() {
        return this.userarea;
    }

    public void setUserarea(String userarea) {
        this.userarea = userarea;
    }

    public String getUsercreatetime() {
        return this.usercreatetime;
    }

    public void setUsercreatetime(String usercreatetime) {
        this.usercreatetime = usercreatetime;
    }

    public String getUserhead() {
        return this.userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public String getQqid() {
        return this.qqid;
    }

    public void setQqid(String qqid) {
        this.qqid = qqid;
    }

    public String getWxid() {
        return this.wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Userinfo (");

        sb.append(userid);
        sb.append(", ").append(username);
        sb.append(", ").append(userpassword);
        sb.append(", ").append(userphone);
        sb.append(", ").append(usersex);
        sb.append(", ").append(usercountry);
        sb.append(", ").append(userprovince);
        sb.append(", ").append(usercity);
        sb.append(", ").append(userarea);
        sb.append(", ").append(usercreatetime);
        sb.append(", ").append(userhead);
        sb.append(", ").append(qqid);
        sb.append(", ").append(wxid);

        sb.append(")");
        return sb.toString();
    }
}
