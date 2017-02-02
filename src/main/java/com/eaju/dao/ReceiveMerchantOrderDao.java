package com.eaju.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eaju.po.MerchantInfo;
import com.eaju.po.ReceiveMerchantOrderBean;



/**
 * 
 * @author Aries
 * @date 2016年11月17日 下午5:29:31
 * @Discripition 接收三方商家报文的Dao接口
 *               <p>
 *               Company: eaju
 *               </p>
 * @version 1.0
 */
public interface ReceiveMerchantOrderDao {

	/**
	 * @return
	 * 
	 * @Title: receiveMeiBiaoOrderDao
	 * @Description: 接收美标报文的Dao接口
	 * @param @param
	 *            receiveMeiBiaoOrderBean 设定文件
	 * @return void
	 * @author Aries
	 * @throws receiveMeiBiaoOrderDao
	 */
	int insertMerchantOrderDao(ReceiveMerchantOrderBean receiveMeiBiaoOrderBean);

	/**
	 * 
	 * @Title: updateMerchantOrderDao @Description: TODO @param @param
	 *         receiveMeiBiaoOrderBean @param @return 设定文件 @return int 返回类型
	 * 
	 * 
	 * @author Aries @throws
	 */
	int updateMerchantOrderDao(ReceiveMerchantOrderBean receiveMeiBiaoOrderBean);

	List<Map<String, Object>> selectMerchantOrder(ReceiveMerchantOrderBean receiveMeiBiaoOrderBean);

	
	/**
	 * 以下是维护介入的三方商家的接口信息
	 */
	
	/**
	 * 
	* @Title: insertMerchantInfo 
	* @Description: 维护商家信息道数据库
	* @param @param merchantToken
	* @param @param merchantType
	* @param @return    设定文件 
	* @return int    返回类型 
	* @author  shun
	* @throws
	 */
	int insertMerchantInfo(@Param("merchantToken") String merchantToken,
	                       @Param("merchantType") String merchantType
	        );
	
	/**
	 * 
	* @Title: selectMerchantInfo 
	* @Description: 查询商家信息
	* @param @param token
	* @param @return    设定文件 
	* @return MerchantInfo    返回类型 
	* @author  shun
	* @throws
	 */
	
	MerchantInfo selectMerchantInfo(String token);
	
	
	
	
	
	
	
}
