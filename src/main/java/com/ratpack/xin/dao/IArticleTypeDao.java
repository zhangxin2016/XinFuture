package com.ratpack.xin.dao;

import com.ratpack.xin.db.tables.pojos.Articletype;

import java.util.List;

public interface IArticleTypeDao {
    /**
     * 根据用户获取文章类型List
     * @param user
     * @return
     */
    List<Articletype> listArticleTypeByUser(String user);

    /**
     * 所有的文章类型列表
     * @return
     */
    List<Articletype> listArticleType();
}
