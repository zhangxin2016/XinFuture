package com.ratpack.xin.handler;

import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.tools.Page;
import com.ratpack.xin.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.ArrayList;
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
        String user = ctx.getRequest().getQueryParams().get("username");
        List<Article> articleList = new ArrayList<>();
        if (user.equals("admin")){
            articleList = iArticleDao.listArticleAll();
        }else {
            articleList = iArticleDao.listArticleByUser(user);
        }
        log.debug("ArticleListHandler articleList:{}",articleList);
        ctx.render(ResultVo.success(articleList));
    }

    /*
     * 分页查询文章列表
     */
    public void dataOperating(List<Article> articleList){
        int count = iArticleDao.articleCount();
        Page page = new Page(count,10);
    }
}
