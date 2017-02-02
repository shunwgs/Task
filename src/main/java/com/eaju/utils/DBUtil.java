package com.eaju.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


/**
 * 
 * @author shun
 * @date 2016年12月28日 上午10:05:59
 * @Discripition 该类用来管理连接，数据库信息保存在属性文件中，使用连接池获取连接
 * <p>Company: eaju</p>
 * @version 1.0
 */
public class DBUtil {

    private static BasicDataSource ds;
    
    static{
        
        try {
            //加载属性配置文件数据
            Properties prop = new Properties();
            prop.load(DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            String driverclass = prop.getProperty("81jdbc.driver");
            String url = prop.getProperty("81jdbc.url");
            String user = prop.getProperty("81jdbc.username");
            String password = prop.getProperty("81jdbc.password");
            String strMaxActive= prop.getProperty("81jdbc.maxActive");
            String strInitSize= prop.getProperty("81jdbc.initialSize");
            //实例化，并初始化连接池
            ds = new BasicDataSource();
            ds.setDriverClassName(driverclass);
            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(password);
            ds.setMaxActive(Integer.parseInt(strMaxActive));
            ds.setInitialSize(Integer.parseInt(strInitSize));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取属性文件错误",e);
        }
    }
    
    //2.创建连接
    public static  Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
    //3.归还连接
    public static void close(Connection conn){
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //测试
    public static void main(String[] args)throws SQLException{
       Connection conn = getConnection();
       System.out.println(conn.getClass().getName());
       close(conn);
    }
    
    
    
    
    
    
}
