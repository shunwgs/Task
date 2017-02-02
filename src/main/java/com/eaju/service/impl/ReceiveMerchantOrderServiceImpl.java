package com.eaju.service.impl;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.eaju.dao.ReceiveMerchantOrderDao;
import com.eaju.po.MerchantInfo;
import com.eaju.po.ReceiveMerchantOrderBean;
import com.eaju.service.ReceiveMerchantOrderService;
import com.eaju.utils.ReturnCode;
import com.eaju.vo.BaseResponse;

/**
 * 
 * @author Aries
 * @date 2016年11月17日 下午6:46:38
 * @Discripition 用来接收美标报文的实现类
 *               <p>
 *               Company: eaju
 *               </p>
 * @version 1.0
 */
@Service("receiveMerchantOrderService")
public class ReceiveMerchantOrderServiceImpl implements ReceiveMerchantOrderService {

	@Resource
	private ReceiveMerchantOrderDao receiveMerchantOrderDao;
	BaseResponse response = new BaseResponse();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Override
	public BaseResponse ReceiveMerchantOrder(ReceiveMerchantOrderBean receiveOrderBean) {
	    
	    /*
	     * //加密  
        System.out.println("加密前：" + content);  
        byte[] encryptResult = encrypt(content, password);  
        //解密  
        byte[] decryptResult = decrypt(encryptResult,password); 
	     */
	    
	    try {
            MerchantInfo selectMerchantInfoResult = receiveMerchantOrderDao.selectMerchantInfo(receiveOrderBean.getToken());
            if(selectMerchantInfoResult !=null){
                
           /*   //加密  
                System.out.println("加密前：" + receiveOrderBean.getTextContent());  
                byte[] encryptResult = AesEncrypt.encrypt(receiveOrderBean.getTextContent(), selectMerchantInfoResult.getMerchantKey());  
                byte[] decryptFrom = AesEncrypt.parseHexStr2Byte(receiveOrderBean.getTextContent());
                byte[] decryptResult = AesEncrypt.decrypt(decryptFrom, selectMerchantInfoResult.getMerchantKey());
                String merchantOrderDecrypt = new String(decryptResult);
                System.out.println("解密后：" + merchantOrderDecrypt);*/
                receiveOrderBean.setCreator(selectMerchantInfoResult.getMerchantType());
                receiveOrderBean.setModifier(selectMerchantInfoResult.getMerchantType());
                receiveOrderBean.setTextContent(receiveOrderBean.getTextContent());
                receiveOrderBean.setOperateStatus(1);
                receiveOrderBean.setOrderType(receiveOrderBean.getOrderType());
                receiveMerchantOrderDao.insertMerchantOrderDao(receiveOrderBean);
                response.setData(receiveOrderBean.getBusinessKey());
                response.setInfo(ReturnCode.OK);
                response.setReturnCode(200);
                return response;
            }else{
                response.setInfo(ReturnCode.ERROR);
                response.setReturnCode(ReturnCode.STATUS_10000);
                return response;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.setData(null);
            response.setInfo(ReturnCode.ERROR);
            response.setReturnCode(ReturnCode.STATUS_500);
            return response;
        }
	} 
	    
	

	@Override
	public BaseResponse updateMerchantOrderDao(ReceiveMerchantOrderBean updateOrderBean) {

		
		try {
		    int updateResult = receiveMerchantOrderDao.updateMerchantOrderDao(updateOrderBean);
			response.setData(updateResult);
			response.setInfo("跟新三方商家推送的订单状态信息成功");
			response.setReturnCode(ReturnCode.STATUS_200);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("跟新三方商家推送的订单状态信息失败", e);

		}
	}
	//@Param("merchantType") String merchantType
	@Override
	public BaseResponse selectMerchantOrder(ReceiveMerchantOrderBean selectOrderBean) {
		// TODO Auto-generated method stub List<ReceiveMerchantOrderBean>
		try {
			ReceiveMerchantOrderBean orderBean = new ReceiveMerchantOrderBean();
			// 查询所有订单
			//orderBean.setBusinessKey(receiveMeiBiaoOrderBean);
			List<Map<String, Object>> merchantOrder = receiveMerchantOrderDao.selectMerchantOrder(selectOrderBean);
			if(merchantOrder.size()>0){
			    response.setData(merchantOrder);
			    //response.setInfo("Select ThirdMerchant Order Success");
			    response.setInfo("Success");
	            response.setReturnCode(ReturnCode.STATUS_200);
	            return response;
			}else{
			    response.setData(merchantOrder);
                response.setInfo("empty");
                response.setReturnCode(ReturnCode.STATUS_200);
                return response;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Select ThirdMerchant Order Fail", e);
		}
	}


	/*
	 * 以下是三方商家信息的查询和维护
	 */
    
	/**
	 * 维护三方商家信息
	 */
    @Override
    public BaseResponse insertMerchantInfo(@Param("merchantToken") String merchantToken,
            @Param("merchantType") String merchantType) {
        int insertMerchantInfo = receiveMerchantOrderDao.insertMerchantInfo(merchantToken,merchantType);
        response.setData(insertMerchantInfo);
        response.setInfo("维护三方商家信息成功");
        response.setReturnCode(ReturnCode.STATUS_200);
        return response;
    }
    
    /**
     * 查询三方商家信息
     */
    @Override
    public BaseResponse selectMerchantInfo(String token) {
        MerchantInfo selectMerchantInfo = receiveMerchantOrderDao.selectMerchantInfo(token);
        response.setData(selectMerchantInfo);
        response.setInfo("查询三方商家信息成功");
        response.setReturnCode(ReturnCode.STATUS_200);
        return response;
    }



   
}
