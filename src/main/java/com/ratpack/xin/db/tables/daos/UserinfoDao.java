/*
 * This file is generated by jOOQ.
*/
package com.ratpack.xin.db.tables.daos;


import com.ratpack.xin.db.tables.Userinfo;
import com.ratpack.xin.db.tables.records.UserinfoRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class UserinfoDao extends DAOImpl<UserinfoRecord, com.ratpack.xin.db.tables.pojos.Userinfo, String> {

    /**
     * Create a new UserinfoDao without any configuration
     */
    public UserinfoDao() {
        super(Userinfo.USERINFO, com.ratpack.xin.db.tables.pojos.Userinfo.class);
    }

    /**
     * Create a new UserinfoDao with an attached configuration
     */
    public UserinfoDao(Configuration configuration) {
        super(Userinfo.USERINFO, com.ratpack.xin.db.tables.pojos.Userinfo.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(com.ratpack.xin.db.tables.pojos.Userinfo object) {
        return object.getUserid();
    }

    /**
     * Fetch records that have <code>userid IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUserid(String... values) {
        return fetch(Userinfo.USERINFO.USERID, values);
    }

    /**
     * Fetch a unique record that has <code>userid = value</code>
     */
    public com.ratpack.xin.db.tables.pojos.Userinfo fetchOneByUserid(String value) {
        return fetchOne(Userinfo.USERINFO.USERID, value);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUsername(String... values) {
        return fetch(Userinfo.USERINFO.USERNAME, values);
    }

    /**
     * Fetch records that have <code>userpassword IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUserpassword(String... values) {
        return fetch(Userinfo.USERINFO.USERPASSWORD, values);
    }

    /**
     * Fetch records that have <code>userphone IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUserphone(String... values) {
        return fetch(Userinfo.USERINFO.USERPHONE, values);
    }

    /**
     * Fetch records that have <code>usersex IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUsersex(String... values) {
        return fetch(Userinfo.USERINFO.USERSEX, values);
    }

    /**
     * Fetch records that have <code>usercountry IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUsercountry(String... values) {
        return fetch(Userinfo.USERINFO.USERCOUNTRY, values);
    }

    /**
     * Fetch records that have <code>userprovince IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUserprovince(String... values) {
        return fetch(Userinfo.USERINFO.USERPROVINCE, values);
    }

    /**
     * Fetch records that have <code>usercity IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUsercity(String... values) {
        return fetch(Userinfo.USERINFO.USERCITY, values);
    }

    /**
     * Fetch records that have <code>userarea IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUserarea(String... values) {
        return fetch(Userinfo.USERINFO.USERAREA, values);
    }

    /**
     * Fetch records that have <code>usercreatetime IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUsercreatetime(String... values) {
        return fetch(Userinfo.USERINFO.USERCREATETIME, values);
    }

    /**
     * Fetch records that have <code>userhead IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByUserhead(String... values) {
        return fetch(Userinfo.USERINFO.USERHEAD, values);
    }

    /**
     * Fetch records that have <code>qqid IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByQqid(String... values) {
        return fetch(Userinfo.USERINFO.QQID, values);
    }

    /**
     * Fetch records that have <code>wxid IN (values)</code>
     */
    public List<com.ratpack.xin.db.tables.pojos.Userinfo> fetchByWxid(String... values) {
        return fetch(Userinfo.USERINFO.WXID, values);
    }
}
