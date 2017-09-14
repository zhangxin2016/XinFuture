package com.ratpack.xin.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.tools.JsonTool;
import com.ratpack.xin.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.List;
import java.util.UUID;

import static com.ratpack.xin.db.tables.Article.ARTICLE;
import static ratpack.jackson.Jackson.json;
import static ratpack.jackson.Jackson.jsonNode;
import static ratpack.rx.RxRatpack.observe;

@Log4j2
public class ArticleAddHandler implements Handler{
    @Inject
    private IArticleDao iArticleDao;
    @Override
    public void handle(Context context) throws Exception {
        Promise<JsonNode> promise = context.parse(jsonNode());
        observe(promise).subscribe(bodyJsonNode -> {
            Article article = JsonTool.convertValue(bodyJsonNode,Article.class);
            article.setCreateUuid(UUID.randomUUID().toString());
            Integer insertResult = iArticleDao.insertArticle(article);
            log.debug("插入数据库结果:{},内容:{}",insertResult,article);
            if(insertResult>0){
                context.render(ResultVo.success(article));
            }else {
                context.render(ResultVo.error(500,"插入数据库发生异常",article));
            }
        });
    }

}
