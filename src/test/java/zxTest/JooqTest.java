package zxTest;

import com.ratpack.xin.db.tables.pojos.Userinfo;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;

import static com.ratpack.xin.db.tables.Userinfo.USERINFO;

/**
 * Created by zhangx on 2017/8/14
 */
@Log4j2
public class JooqTest {
    private static DSLContext dslContext;
    public static Userinfo selectAll(String id){
        System.out.println("qwe");
        Userinfo userinfo = dslContext.selectFrom(USERINFO).where(USERINFO.USERID.eq(id)).fetchOneInto(Userinfo.class);
        log.debug("dal getUserfirestwelfare id:{} {}",id,USERINFO);
        return userinfo;
    }

    public static void main(String[] args) {
        selectAll("1");
    }
}
