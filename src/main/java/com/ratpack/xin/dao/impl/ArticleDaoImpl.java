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

    @Override
    public List<Article> listArticleByUser(String user) {
        List<Article> articleList = dslContext.selectFrom(ARTICLE).where(ARTICLE.BLOGAUTHOR.eq(user)).fetch().map(record -> {
            Article article = record.into(Article.class);
            return article;
        });
        return articleList;
    }

    @Override
    public List<Article> listArticleAll() {
        List<Article> articleList = dslContext.selectFrom(ARTICLE).fetch().map(record -> {
            Article article = record.into(Article.class);
            return article;
        });
        return articleList;
    }

    @Override
    public Article articleInfo(String uuid) {
        Article article = dslContext.selectFrom(ARTICLE).where(ARTICLE.CREATE_UUID.equal(uuid)).fetchOne().map(record -> {
            Article article1 = record.into(Article.class);
            return article1;
        });
        return article;
    }
}
