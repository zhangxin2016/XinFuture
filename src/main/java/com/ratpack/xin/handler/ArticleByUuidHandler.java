package com.ratpack.xin.handler;

import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Created by zhangx on 2017/9/15
 */
@Log4j2
public class ArticleByUuidHandler implements Handler{
    @Inject
    private IArticleDao iArticleDao;
    @Override
    public void handle(Context ctx) throws Exception {
        String uuid = ctx.getRequest().getQueryParams().get("create_uuid");
        Article article = iArticleDao.articleInfo(uuid);
        log.debug("ArticleByUuidHandler article:{}",article);
        ctx.render(ResultVo.success(article));
    }
}
