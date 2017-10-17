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
    /**
     * 插入文章
     * @param article
     * @return
     */
    Integer insertArticle(Article article);

    /**
     * 根据用户展示文章列表
     * @param user
     * @return
     */
    List<Article> listArticleByUser(String user);

    /**
     * 展示所有的文章列表
     * @return
     */
    List<Article> listArticleAll();

    /**
     * 文章的详细信息
     * @param uuid
     * @return
     */
    List<Article> articleInfo(String uuid);

    /**
     * 获取每种类型的数量
     * @param typeUUID
     * @return
     */
    Integer countByType(String typeUUID);

    /**
     * 根据类型获取文章
     * @param typeUUID
     * @return
     */
    List<Article> listArticleByType(String typeUUID);

    /**
     * 根据类型以及用户获取文章
     * @param typeUUID
     * @param user
     * @return
     */
    List<Article> listArticleByTypeUser(String typeUUID,String user);

    /**
     * 展示所有的文章个数
     * @return
     */
    Integer articleCount();

    /**
     * 根据用户获取文章列表 分页用
     * @param user
     * @param row
     * @param rowNum
     * @return
     */
    List<Article> listArticleByUserPage(String user,int row,int rowNum);

    /**
     * 模糊查询文章列表
     * @param name
     * @return
     */
    List<Article> searchArticleList(String name);
}
