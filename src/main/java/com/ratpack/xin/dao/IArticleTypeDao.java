package com.ratpack.xin.dao;

import com.ratpack.xin.db.tables.pojos.Articletype;

import java.util.List;

public interface IArticleTypeDao {
    List<Articletype> listArticleTypeByUser(String user);
    List<Articletype> listArticleType();
}
