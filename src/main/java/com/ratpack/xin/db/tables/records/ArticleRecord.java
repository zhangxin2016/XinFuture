/*
 * This file is generated by jOOQ.
*/
package com.ratpack.xin.db.tables.records;


import com.ratpack.xin.db.tables.Article;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ArticleRecord extends UpdatableRecordImpl<ArticleRecord> implements Record9<Long, String, Timestamp, String, String, String, String, String, String> {

    private static final long serialVersionUID = 681300211;

    /**
     * Setter for <code>ratpack.article.id</code>. id
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ratpack.article.id</code>. id
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ratpack.article.create_uuid</code>. 创建者唯一标记
     */
    public void setCreateUuid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ratpack.article.create_uuid</code>. 创建者唯一标记
     */
    public String getCreateUuid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ratpack.article.create_time</code>. 创建时间
     */
    public void setCreateTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>ratpack.article.create_time</code>. 创建时间
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>ratpack.article.blogauthor</code>. 作者
     */
    public void setBlogauthor(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>ratpack.article.blogauthor</code>. 作者
     */
    public String getBlogauthor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>ratpack.article.blogtype</code>. 类型
     */
    public void setBlogtype(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>ratpack.article.blogtype</code>. 类型
     */
    public String getBlogtype() {
        return (String) get(4);
    }

    /**
     * Setter for <code>ratpack.article.blogtitie</code>. 文章标题
     */
    public void setBlogtitie(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>ratpack.article.blogtitie</code>. 文章标题
     */
    public String getBlogtitie() {
        return (String) get(5);
    }

    /**
     * Setter for <code>ratpack.article.blogkeywords</code>. 关键词
     */
    public void setBlogkeywords(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>ratpack.article.blogkeywords</code>. 关键词
     */
    public String getBlogkeywords() {
        return (String) get(6);
    }

    /**
     * Setter for <code>ratpack.article.blogabstract</code>. 文章摘要
     */
    public void setBlogabstract(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>ratpack.article.blogabstract</code>. 文章摘要
     */
    public String getBlogabstract() {
        return (String) get(7);
    }

    /**
     * Setter for <code>ratpack.article.blogcontent</code>. 文章内容
     */
    public void setBlogcontent(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>ratpack.article.blogcontent</code>. 文章内容
     */
    public String getBlogcontent() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, Timestamp, String, String, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, Timestamp, String, String, String, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Article.ARTICLE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Article.ARTICLE.CREATE_UUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Article.ARTICLE.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Article.ARTICLE.BLOGAUTHOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Article.ARTICLE.BLOGTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Article.ARTICLE.BLOGTITIE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Article.ARTICLE.BLOGKEYWORDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Article.ARTICLE.BLOGABSTRACT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Article.ARTICLE.BLOGCONTENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCreateUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getBlogauthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getBlogtype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getBlogtitie();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getBlogkeywords();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getBlogabstract();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getBlogcontent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value2(String value) {
        setCreateUuid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value3(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value4(String value) {
        setBlogauthor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value5(String value) {
        setBlogtype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value6(String value) {
        setBlogtitie(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value7(String value) {
        setBlogkeywords(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value8(String value) {
        setBlogabstract(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord value9(String value) {
        setBlogcontent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleRecord values(Long value1, String value2, Timestamp value3, String value4, String value5, String value6, String value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ArticleRecord
     */
    public ArticleRecord() {
        super(Article.ARTICLE);
    }

    /**
     * Create a detached, initialised ArticleRecord
     */
    public ArticleRecord(Long id, String createUuid, Timestamp createTime, String blogauthor, String blogtype, String blogtitie, String blogkeywords, String blogabstract, String blogcontent) {
        super(Article.ARTICLE);

        set(0, id);
        set(1, createUuid);
        set(2, createTime);
        set(3, blogauthor);
        set(4, blogtype);
        set(5, blogtitie);
        set(6, blogkeywords);
        set(7, blogabstract);
        set(8, blogcontent);
    }
}