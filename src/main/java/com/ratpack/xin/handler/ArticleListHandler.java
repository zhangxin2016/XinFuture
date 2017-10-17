package com.ratpack.xin.handler;

import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.tools.JsonTool;
import com.ratpack.xin.tools.Page;
import com.ratpack.xin.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.ArrayList;
import java.util.List;

import static ratpack.jackson.Jackson.json;

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
        if ("admin".equals(user)){
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
    public void dataOperating(List<Article> articleList,String currentPage){
        int count = iArticleDao.articleCount();
        int pageNumber = 1;
        Page page = new Page(count,6);
        if(null != currentPage && ""!=currentPage){
            page.setCurrentPage(Integer.parseInt(currentPage));
            pageNumber = Integer.parseInt(currentPage);
        }else {
            page.setCurrentPage(pageNumber);
        }
        articleList = iArticleDao.listArticleByUserPage("admin",page.getStart(),page.getMaxRows());
        json(JsonTool.createObjectNode()
                .put("totalPage",page.getTotalPage())
                .put("currentPage",pageNumber)
                .put("totalNumber",count)
                .set("result", JsonTool.readJsonNodeValue(articleList)));
    }
}
