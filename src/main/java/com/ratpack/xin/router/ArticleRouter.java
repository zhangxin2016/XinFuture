package com.ratpack.xin.router;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.db.tables.pojos.Article;
import com.ratpack.xin.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangx on 2017/9/6
 */
@Log4j2
public class ArticleRouter implements Action<Chain> {
    @Inject
    private IArticleDao iArticleDao;
    @Inject
    @Named("articleAddHandler")
    private Handler articleAddHandler;
    @Inject
    @Named("articleListHandler")
    private Handler articleListHandler;
    @Inject
    @Named("articleByUuidHandler")
    private Handler articleByUuidHandler;
    @Override
    public void execute(Chain chain) throws Exception {
        chain.post("insert",articleAddHandler);
        chain.get("list",articleListHandler);
        chain.get("get",articleByUuidHandler);
        chain.get("listByType",this::articleListByType);

    }
    public void articleListByType(Context context){
        String user = context.getRequest().getQueryParams().get("username");
        String uuid = context.getRequest().getQueryParams().get("typeuuid");
        List<Article> articleList = new ArrayList<>();
        if (user.equals("admin")){
            articleList = iArticleDao.listArticleByType(uuid);
        }else {
            articleList = iArticleDao.listArticleByTypeUser(uuid,user);
        }
        log.debug("articleListByType articleList:{}",articleList);
        context.render(ResultVo.success(articleList));
    }
}
