package com.ratpack.xin.router;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Handler;

/**
 * Created by zhangx on 2017/8/7
 */
public class UserInfoRouter implements Action<Chain> {
    @Inject
    @Named("getUserHandler")
    private Handler getUserHandler;
    @Inject
    @Named("addUserInfoHandler")
    private Handler addUserInfoHandler;
    @Inject
    @Named("updateUserInfoHandler")
    private Handler updateUserInfoHandler;
    @Inject
    @Named("deleteUserInfoHandler")
    private Handler deleteUserInfoHandler;
    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("addUser",addUserInfoHandler);
        chain.get("updateUser",updateUserInfoHandler);
        chain.get("deleteUser",deleteUserInfoHandler);
        chain.get("getUser",getUserHandler);
    }
}
