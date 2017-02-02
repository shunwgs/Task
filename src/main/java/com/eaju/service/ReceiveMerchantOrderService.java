package com.eaju.service;
import org.apache.ibatis.annotations.Param;
import com.eaju.po.ReceiveMerchantOrderBean;
import com.eaju.vo.BaseResponse;
/**
 * 
 * @author Aries
 * @date 2016年11月18日 下午4:01:15
 * @Discripition 
 * <p>Company: eaju</p>
 * @version 1.0
 */
public interface ReceiveMerchantOrderService {
   
    /**
     * 
    * @Title: ReceiveMeiBiaoMerchantOrder 
    * @Description: TODO 
    * @param @param receiveMeiBiaoOrderBean
    * @param @return    设定文件 
    * @return BaseResponse    返回类型 
    * @author  Aries
    * @throws
     */
    BaseResponse ReceiveMerchantOrder(ReceiveMerchantOrderBean receiveOrderBean);
    
    /**
     * 
    * @Title: updateMerchantOrderDao 
    * @Description: TODO 
    * @param @param receiveMeiBiaoOrderBean
    * @param @return    设定文件 
    * @return int    返回类型 
    * @author  Aries
    * @throws
     */
    BaseResponse updateMerchantOrderDao(ReceiveMerchantOrderBean updateOrderBean);
    
    /**
     * 
    * @Title: selectMerchantOrder 
    * @Description: TODO 
    * @param @param businessKey
    * @param @return    设定文件 
    * @return List<ReceiveMerchantOrderBean>    返回类型 
    * @author  Aries
    * @throws
     */
//    List<ReceiveMerchantOrderBean> selectMerchantOrder(@Param("businessKey")String businessKey);
   // BaseResponse selectMerchantOrder(@Param("businessKey")String businessKey);
    BaseResponse selectMerchantOrder(ReceiveMerchantOrderBean selectOrderBean);
    
    /**
     * 
     */
    
    BaseResponse selectMerchantInfo(String token);
    
    BaseResponse insertMerchantInfo(@Param("merchantToken") String merchantToken,@Param("merchantType") String merchantType);

   
    //BaseResponse selectMerchantOrder(String merchantType);
    
    
}
