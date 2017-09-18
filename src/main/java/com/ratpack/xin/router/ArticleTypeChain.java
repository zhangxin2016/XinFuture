package com.ratpack.xin.router;

import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.dao.IArticleTypeDao;
import com.ratpack.xin.db.tables.pojos.Articletype;
import com.ratpack.xin.pojo.ArticleTypeCount;
import com.ratpack.xin.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Context;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ArticleTypeChain implements Action<Chain> {

    @Inject
    private IArticleTypeDao iArticleTypeDao;
    @Inject
    private IArticleDao iArticleDao;
    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("list",this::listType);
    }

    public void listType(Context context){
        String user = context.getRequest().getQueryParams().get("user");
        List<Articletype> articleTypeList = new ArrayList<>();
        List<ArticleTypeCount> typeCountsList = new ArrayList<>();
        if (user.equals("admin")){
            articleTypeList = iArticleTypeDao.listArticleType();
        }else {
            articleTypeList = iArticleTypeDao.listArticleTypeByUser(user);
        }
        articleTypeList.forEach(articleType->{
            ArticleTypeCount articleTypeCount = new ArticleTypeCount();
            articleTypeCount.setTypeName(articleType.getTypeDesc());
            articleTypeCount.setCount(iArticleDao.countByType(articleType.getCreateUuid()));
            typeCountsList.add(articleTypeCount);
        });
        log.debug("listType articleTypeList:{}",articleTypeList);
        context.render(ResultVo.success(typeCountsList));

    }
}
