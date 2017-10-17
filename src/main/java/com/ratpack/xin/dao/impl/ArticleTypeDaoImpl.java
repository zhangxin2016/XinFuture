package com.ratpack.xin.dao.impl;

import com.google.inject.Inject;
import com.ratpack.xin.dao.IArticleTypeDao;
import com.ratpack.xin.db.tables.pojos.Articletype;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import static com.ratpack.xin.db.tables.Articletype.ARTICLETYPE;

import java.util.List;

@Log4j2
public class ArticleTypeDaoImpl implements IArticleTypeDao{
    @Inject
    private static DSLContext dslContext;
    @Inject
    public ArticleTypeDaoImpl(DSLContext dslContext) {
        ArticleTypeDaoImpl.dslContext = dslContext;
    }
    @Override
    public List<Articletype> listArticleTypeByUser(String user) {
        List<Articletype> articleTypeList = dslContext.selectFrom(ARTICLETYPE).where(ARTICLETYPE.CREATE_USER.eq(user)).fetch().map(record -> {
            Articletype articletype = record.into(Articletype.class);
            return articletype;
        });
        return articleTypeList;
    }

    @Override
    public List<Articletype> listArticleType() {
        List<Articletype> articleTypeList = dslContext.selectFrom(ARTICLETYPE).fetch().map(record -> {
            Articletype articletype = record.into(Articletype.class);
            return articletype;
        });
        return articleTypeList;
    }
}
