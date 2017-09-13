/*
 * This file is generated by jOOQ.
*/
package com.ratpack.xin.db.tables;


import com.ratpack.xin.db.Keys;
import com.ratpack.xin.db.Ratpack;
import com.ratpack.xin.db.tables.records.ArticleRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Article extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = 1153765518;

    /**
     * The reference instance of <code>ratpack.article</code>
     */
    public static final Article ARTICLE = new Article();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticleRecord> getRecordType() {
        return ArticleRecord.class;
    }

    /**
     * The column <code>ratpack.article.id</code>. id
     */
    public final TableField<ArticleRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "id");

    /**
     * The column <code>ratpack.article.create_uuid</code>. 创建者唯一标记
     */
    public final TableField<ArticleRecord, String> CREATE_UUID = createField("create_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(22), this, "创建者唯一标记");

    /**
     * The column <code>ratpack.article.create_time</code>. 创建时间
     */
    public final TableField<ArticleRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");

    /**
     * The column <code>ratpack.article.blogauthor</code>. 作者
     */
    public final TableField<ArticleRecord, String> BLOGAUTHOR = createField("blogauthor", org.jooq.impl.SQLDataType.VARCHAR.length(22), this, "作者");

    /**
     * The column <code>ratpack.article.blogtype</code>. 类型
     */
    public final TableField<ArticleRecord, String> BLOGTYPE = createField("blogtype", org.jooq.impl.SQLDataType.VARCHAR.length(22), this, "类型");

    /**
     * The column <code>ratpack.article.blogtitie</code>. 文章标题
     */
    public final TableField<ArticleRecord, String> BLOGTITIE = createField("blogtitie", org.jooq.impl.SQLDataType.VARCHAR.length(22), this, "文章标题");

    /**
     * The column <code>ratpack.article.blogkeywords</code>. 关键词
     */
    public final TableField<ArticleRecord, String> BLOGKEYWORDS = createField("blogkeywords", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "关键词");

    /**
     * The column <code>ratpack.article.blogabstract</code>. 文章摘要
     */
    public final TableField<ArticleRecord, String> BLOGABSTRACT = createField("blogabstract", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "文章摘要");

    /**
     * The column <code>ratpack.article.blogcontent</code>. 文章内容
     */
    public final TableField<ArticleRecord, String> BLOGCONTENT = createField("blogcontent", org.jooq.impl.SQLDataType.VARCHAR.length(20000), this, "文章内容");

    /**
     * Create a <code>ratpack.article</code> table reference
     */
    public Article() {
        this("article", null);
    }

    /**
     * Create an aliased <code>ratpack.article</code> table reference
     */
    public Article(String alias) {
        this(alias, ARTICLE);
    }

    private Article(String alias, Table<ArticleRecord> aliased) {
        this(alias, aliased, null);
    }

    private Article(String alias, Table<ArticleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Ratpack.RATPACK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ArticleRecord, Long> getIdentity() {
        return Keys.IDENTITY_ARTICLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticleRecord> getPrimaryKey() {
        return Keys.KEY_ARTICLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleRecord>>asList(Keys.KEY_ARTICLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article as(String alias) {
        return new Article(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Article rename(String name) {
        return new Article(name, null);
    }
}
