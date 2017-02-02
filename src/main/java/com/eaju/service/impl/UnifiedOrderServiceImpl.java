package com.eaju.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.eaju.dao.ReceiveMerchantOrderDao;
import com.eaju.dao81.F554281Mapper;
import com.eaju.po.F554281;
import com.eaju.po.F554282;
import com.eaju.po.ReceiveMerchantOrderBean;
import com.eaju.service.ReceiveMerchantOrderService;
import com.eaju.service.UnifiedOrder;
import com.eaju.utils.ResourcesUtil;
import com.eaju.vo.BaseResponse;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.xml.XMLSerializer;
@Component
@Service
public class UnifiedOrderServiceImpl implements UnifiedOrder {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(UnifiedOrderServiceImpl.class);
  
    @Resource
    private F554281Mapper f554281Mapper;
 
    @Resource
    private ReceiveMerchantOrderDao receiveMerchantOrderDao;
 
    @Resource
    private ReceiveMerchantOrderService receiveMerchantOrderService;

    BigDecimal sodoco;
    Object souser;
    String SOVR01;
    public void findAllOrder() {
        if (logger.isDebugEnabled()) {
            logger.debug("findAllOrder() - start");
        }
        logger.info("job active!");
        String merchantType = ResourcesUtil.getValue("config", "merchantType");
        String token = ResourcesUtil.getValue("config", "token");
        Gson gson = new Gson();
        Map < String, String > params = new HashMap < String, String > ();
        try {
            
            //每次查出50条
             List < F554281 > findAll81Order = f554281Mapper.findAll81Order(params);
            if (findAll81Order.size() > 0) {
                List < BigDecimal > bigs = new ArrayList < BigDecimal > ();
                ReceiveMerchantOrderBean receiveOrderBean = new ReceiveMerchantOrderBean();
                for (F554281 f554281: findAll81Order) {
                      sodoco = f554281.getSodoco();
                    souser = f554281.getSouser();                     
                    SOVR01 = (String) f554281.getSovr01();              
                    //判断：如果外部订单号tm113.llsd 为空或 tm.  后面无数据，按照客户订单号到81表中查数据
                    if (StringUtils.isEmpty(SOVR01.trim()) || SOVR01.trim().endsWith(".")) {
                        List < F554282 > findAll82Order = f554281Mapper.findAll82Order(sodoco);
                        List < F554281 > findBySodocoList = new ArrayList < F554281 > ();
                        f554281.setF554282(findAll82Order);
                        findBySodocoList.add(f554281);
                        String json = gson.toJson(f554281);
                        logger.info(json);
                        /*
                         * 由掉接口改成自己往数据库写
                         */
                        receiveOrderBean.setBusinessKey(sodoco.toString());
                        receiveOrderBean.setMerchantType(merchantType);
                        receiveOrderBean.setOrderType(souser.toString());
                        receiveOrderBean.setToken(token);
                        receiveOrderBean.setTextContent(json);                        
                        BaseResponse receiveOrderResult = receiveMerchantOrderService.ReceiveMerchantOrder(receiveOrderBean);
                        logger.info(receiveOrderResult);
                        if (receiveOrderResult.getReturnCode() == 200) {
                            Map < String, Object > param = new HashMap < String, Object > ();
                            param.put("code", 1);
                            param.put("item", sodoco);
                            f554281Mapper.update81OrderStatus(param);
                        }
                    } else {
                        
                        /*
                         *如果外部订单号不为空，则按照外部订单号查询81表中的数据，通过外部订单号可能会查出多条数据，根据客户订单号循环取出81 以及82表中的数据放到list中转为json存到
                         *老APP后台
                         */
                        List < F554281 > find81OrderBySovr01 = f554281Mapper.find81OrderBySovr01(SOVR01);
                        List < F554281 > findBySovr01List = new ArrayList < F554281 > ();
                        for (F554281 f554281Order: find81OrderBySovr01) {
                            List < F554282 > findAll82Order = f554281Mapper.findAll82Order(f554281Order.getSodoco());
                            f554281Order.setF554282(findAll82Order);
                            findBySovr01List.add(f554281Order);
                            BigDecimal sodoco2 = f554281Order.getSodoco();
                            bigs.add(sodoco2);
                        }
                        if (find81OrderBySovr01.size() != 0) {
 
                            String Sovr01ListJson = gson.toJson(findBySovr01List);
                            /*
                            JSONArray jsonObject = JSONArray.fromObject(Sovr01ListJson);  
                            XMLSerializer xmlSerial = new XMLSerializer();  
                            String xml = xmlSerial.write(jsonObject); 
                            System.out.println(xml);  */ 
                            receiveOrderBean.setBusinessKey(SOVR01);
                            receiveOrderBean.setMerchantType(merchantType);
                            receiveOrderBean.setOrderType(souser.toString());
                            receiveOrderBean.setToken(token);
                            receiveOrderBean.setTextContent(Sovr01ListJson);                            
                            BaseResponse receiveOrderResult = receiveMerchantOrderService.ReceiveMerchantOrder(receiveOrderBean);
                            logger.info(receiveOrderResult);
                            if (receiveOrderResult.getReturnCode() == 200) {
                                Map < String, Object > param = new HashMap < String, Object > ();
                                param.put("code", 1);
                                param.put("bigs", bigs);
                                int update81OrderBySovr01Result = f554281Mapper.update81OrderBySovr01(param);
                                logger.info(update81OrderBySovr01Result);
                                bigs.removeAll(bigs);
                            }
                        }
                    }
                }
 
            }
        } catch (Exception e) {
            logger.error("findAllOrder()", e);
 
            e.printStackTrace();
            throw new RuntimeException("select DB Exception", e);
        }
 
        if (logger.isDebugEnabled()) {
            logger.debug("findAllOrder() - end");
        }
    }
 
}