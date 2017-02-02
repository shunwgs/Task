package com.eaju.dao81;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eaju.po.F554281;
import com.eaju.po.F554282;
/**
 * 
 * @author shun
 * @date 2016年12月28日 下午5:58:22
 * @Discripition 查询81表中的数据
 * <p>Company: eaju</p>
 * @version 1.0
 */
public interface F554281Mapper {
    
    
    
    /**
     * 
    * @Title: findAllOrder 
    * @Description: TODO 查询81表中的数据 
    * @param @return    设定文件 
    * @return List<F554281>    返回类型 
    * @author  shun
    * @throws
     */
    
    List<F554281> findAll81Order(Map<String,String> params);  

    
    List<F554281> find81OrderBySovr01(@Param("SOVR01") String SOVR01);  
    
    //List<F554281> find81OrderBySovr01(@Param("sovr01") String sovr01);  
    
    /* 
     * 查询成功后跟新被查询的数据
     */

    int update81OrderStatus(Map<String,Object> param);
    
    int update81OrderBySovr01(Map<String,Object> sovr01);
    
    /*
     * 到82表中查明细
     */
    List<F554282> findAll82Order(@Param("sodoco") BigDecimal sddoco);
    
}
