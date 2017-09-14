package com.ratpack.xin.dao;

import com.google.inject.Inject;
import com.ratpack.xin.db.tables.pojos.Article;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;

import static com.ratpack.xin.db.tables.Article.ARTICLE;
import java.util.UUID;

/**
 * Created by zhangx on 2017/9/14
 */
public interface IArticleDao {
    Integer insertArticle(Article article);
}
