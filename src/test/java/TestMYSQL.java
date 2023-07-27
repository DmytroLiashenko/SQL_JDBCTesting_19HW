
import config.StateMent;
import object.Person;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static config.StateMent.*;
import static work.SQuery.*;
import java.sql.SQLException;
import java.util.Map;
public class TestMYSQL {

    static StateMent stateMent;

    @BeforeClass
    public static void bh() {
        stateMent = new StateMent();
    }

    @Test
    public void test1() throws SQLException {
        for (Map<String, String> row : stateMent.getRows()) {
            System.out.println(row);
        }
    }

    @Test
    public void test2() throws SQLException {
        StateMent.selectNameCiti();
    }
    @Test
    public void test3() throws SQLException {
        StateMent.selectName();
    }

}
