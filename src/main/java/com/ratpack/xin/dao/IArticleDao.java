package com.ratpack.xin.dao;

import com.google.inject.Inject;
import com.ratpack.xin.db.tables.pojos.Article;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;

import static com.ratpack.xin.db.tables.Article.ARTICLE;

import java.util.List;
import java.util.UUID;

/**
 * Created by zhangx on 2017/9/14
 */
public interface IArticleDao {
    Integer insertArticle(Article article);
    List<Article> listArticleByUser(String user);
    List<Article> listArticleAll();
    List<Article> articleInfo(String uuid);
    Integer countByType(String typeUUID);
    List<Article> listArticleByType(String typeUUID);
    List<Article> listArticleByTypeUser(String typeUUID,String user);
    Integer articleCount();
    List<Article> listArticleByUserPage(String user,int row,int rowNum);
}
