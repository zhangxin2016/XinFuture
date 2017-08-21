package com.ratpack.xin.Test;

import com.google.inject.Inject;
import com.ratpack.xin.pojo.InfoCommon;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class dbTest {
    @Inject
    private DataSource hikariDataSource;

    public List<InfoCommon.UserInfo.Builder> list() {
        String sql = " select *  from userinfo";
        return listFromSqlRepeatTrading(sql);
    }

    public List<InfoCommon.UserInfo.Builder> listFromSqlRepeatTrading(String sql) {
        try (Connection connection = hikariDataSource.getConnection()) {
            List<InfoCommon.UserInfo.Builder> list =new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                InfoCommon.UserInfo.Builder userInfo = InfoCommon.UserInfo.newBuilder();
                userInfo.setUserid(result.getString("userid"));
                userInfo.setUsername(result.getString("username"));
                userInfo.setUserpassword(result.getString("userpassword"));
                userInfo.setUserphone(result.getString("userphone"));
                userInfo.setUsersex(result.getString("usersex"));
                userInfo.setUsercountry(result.getString("usercountry"));
                userInfo.setUserprovince(result.getString("userprovince"));
                userInfo.setUsercity(result.getString("usercity"));
                userInfo.setUserarea(result.getString("userarea"));
                userInfo.setUsercreatetime(result.getString("usercreatetime"));
                userInfo.setUserhead(result.getString("userhead"));
                userInfo.setQqid(result.getString("qqid"));
                userInfo.setWxid(result.getString("wxid"));
                list.add(userInfo);
            }
            log.debug("queryRepeatTrading :{}", result, preparedStatement);
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
            log.warn("queryRepeatTrading e", e);
            return null;
        }
    }

    public static void main(String[] args) {
        //System.out.println("qwe");
        //String id = ctx.getRequest().getQueryParams().get("id");
        //List<InfoCommon.UserInfo.Builder> result = dbTest.list();
        //System.out.println("result:=="+result);
        //String id = "1";
    }
}
