package com.ratpack.xin.router;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Handler;

/**
 * Created by zhangx on 2017/9/6
 */
public class ArticleRouter implements Action<Chain> {

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

    }
}
