package com.ratpack.xin.handler;

import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.List;

/**
 * Created by zhangx on 2017/9/14
 */
@Log4j2
public class ArticleListHandler implements Handler{

    @Inject
    private IArticleDao iArticleDao;
    @Override
    public void handle(Context ctx) throws Exception {
        List<Article> articleList = iArticleDao.listArticle();
        log.debug("ArticleListHandler articleList:{}",articleList);
        ctx.render(ResultVo.success(articleList));
    }
}
