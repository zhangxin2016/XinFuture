package com.ratpack.xin.dao.impl;

import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.guice.provider.TxJooq;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;

import java.util.List;

import static com.ratpack.xin.db.tables.Article.ARTICLE;

/**
 * Created by zhangx on 2017/9/14
 */
@Log4j2
public class ArticleDaoImpl implements IArticleDao {
    @Inject
    private static DSLContext dslContext;
    @Inject
    public ArticleDaoImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }
    /*
     * 新增文章
     */
    @Override
    public Integer insertArticle(Article article) {
        int result = dslContext.insertInto(ARTICLE)
                .set(ARTICLE.CREATE_UUID, article.getCreateUuid())
                .set(ARTICLE.BLOGAUTHOR, article.getBlogauthor())
                .set(ARTICLE.BLOGTYPE, article.getBlogtype())
                .set(ARTICLE.BLOGTITIE, article.getBlogtitie())
                .set(ARTICLE.BLOGKEYWORDS, article.getBlogkeywords())
                .set(ARTICLE.BLOGABSTRACT, article.getBlogabstract())
                .set(ARTICLE.BLOGCONTENT, article.getBlogcontent())
                .execute();
        return result;
    }
    /*
     * 根据用户查找文章列表
     */
    @Override
    public List<Article> listArticleByUser(String user) {
        List<Article> articleList = dslContext.selectFrom(ARTICLE).where(ARTICLE.BLOGAUTHOR.eq(user)).fetch().map(record -> {
            Article article = record.into(Article.class);
            return article;
        });
        return articleList;
    }

    /*
     * 所有文章列表
     */
    @Override
    public List<Article> listArticleAll() {
        List<Article> articleList = dslContext.selectFrom(ARTICLE).fetch().map(record -> {
            Article article = record.into(Article.class);
            return article;
        });
        return articleList;
    }
    /*
     * 文章详细信息
     */
    @Override
    public Article articleInfo(String uuid) {
        Article article = dslContext.selectFrom(ARTICLE).where(ARTICLE.CREATE_UUID.equal(uuid)).fetchOne().map(record -> {
            Article article1 = record.into(Article.class);
            return article1;
        });
        return article;
    }
    /*
     * 不同类型的文章个数
     */
    @Override
    public Integer countByType(String typeUUID) {
        Integer count = dslContext.fetchCount(dslContext.selectFrom(ARTICLE).where(ARTICLE.BLOGTYPE.eq(typeUUID)));
        return count;
    }
    /*
     * 根据类型获取文章列表
     */
    @Override
    public List<Article> listArticleByType(String typeUUID) {
        List<Article> articleList = dslContext.selectFrom(ARTICLE).where(ARTICLE.BLOGTYPE.eq(typeUUID)).limit(1,2).fetch().map(record -> {
            Article article = record.into(Article.class);
            return article;
        });
        return articleList;
    }
    /*
     * 每个用户不同类型的文章列表
     */
    @Override
    public List<Article> listArticleByTypeUser(String typeUUID, String user) {
        List<Article> articleList = dslContext.selectFrom(ARTICLE)
                .where(ARTICLE.BLOGTYPE.eq(typeUUID))
                .and(ARTICLE.BLOGAUTHOR.eq(user)).fetch()
                .map(record -> {
            Article article = record.into(Article.class);
            return article;
        });
        return articleList;
    }
    /*
     * 文章数量
     */
    @Override
    public Integer articleCount() {
        Integer count = dslContext.fetchCount(dslContext.selectFrom(ARTICLE));
        return count;
    }

    @Override
    public List<Article> listArticleByUserPage(String user, int row, int rowNum) {
        return null;
    }
}
