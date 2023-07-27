package config;

import org.junit.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateMent {
    public static Statement getStateMent() {
        return stateMent;
    }

    private static Statement stateMent;

    public StateMent() {
        try {
            makeStat();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Statement makeStat() throws SQLException {
        Conect c =null;
        c=new Conect();
        Connection con=c.newConnection();
        stateMent=con.createStatement();
        return stateMent;
    }

    public void selectAll() throws SQLException {
        ResultSet resultSet= stateMent.executeQuery("SELECT * FROM sys.hilel2403;");
        while(resultSet.next()){
            System.out.println(resultSet.getString("id")+" "+resultSet.getString("name")+" "+resultSet.getString("adress"));
        }
    }

    public List<Map<String,String>> getRows() throws SQLException {
        ResultSet resultSet=stateMent.executeQuery("SELECT * FROM sys.hilel2403;");
        List<Map<String,String>> list=new ArrayList<>();
        while(resultSet.next()){
            Map<String,String> map=new HashMap<>();
            map.put("id",resultSet.getString("id"));
            map.put("name",resultSet.getString("name"));
            map.put("adress",resultSet.getString("adress"));
            list.add(map);
        }
        return list;
    }

    public static void selectNameCiti() throws SQLException {
        ResultSet resultSet= stateMent.executeQuery("SELECT name, adress FROM sys.hilel2403 WHERE adress IN (SELECT adress FROM " +
                "sys.hilel2403 GROUP BY adress HAVING COUNT(*) > 1);");
        while(resultSet.next()){
            System.out.println(resultSet.getString("name")+" "+resultSet.getString("adress"));
        }
    }

    public static void selectName() throws SQLException {
        ResultSet resultSet= stateMent.executeQuery("SELECT name, adress FROM sys.hilel2403 WHERE id='1'");
        while(resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
    }
}