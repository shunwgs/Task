package com.eaju.junitTest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eaju.dao81.F554281Mapper;
import com.eaju.po.F554281;
import com.eaju.po.F554282;
import com.eaju.service.UnifiedOrder;
import com.eaju.utils.HttpXmlClient;
import com.eaju.utils.ResourcesUtil;
import com.google.gson.Gson;

import net.sf.json.JSONObject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml"})
public class OrderTest {
    
    @Autowired
    F554281Mapper f554281Mapper;

	
	@Autowired
	private UnifiedOrder unifiedOrder;
	
	@Test
	public void ehdvQuery() {
	    unifiedOrder.findAllOrder();
	    
	}
	
	
	@Test
    public void testAAA() throws Exception {
	    System.out.println("job起作用了");
        String url = ResourcesUtil.getValue("config", "url");
        Gson gson = new Gson();
        Map<String, String>  params = new HashMap<String,String>();     
            List<F554281> findAll81Order = f554281Mapper.findAll81Order(params);
            for (F554281 f554281 : findAll81Order) {
                BigDecimal sodoco = f554281.getSodoco();
                List<F554282> findAll82Order = f554281Mapper.findAll82Order(sodoco);
                f554281.setF554282(findAll82Order);
                String json = gson.toJson(findAll81Order);
                System.out.println(json);
                params.put("businessKey", "81order");
                params.put("merchantType", "81order");
                params.put("orderType", "81");
                params.put("token", "81order");
                params.put("textContent",json);
                String post = HttpXmlClient.post(url, params);
                System.out.println(post);
                //f554281Mapper.update81OrderStatus(sodoco);
            }
	}
	
	public void jsonToXml(){
	    JSONObject.fromObject("");
	}
	
}
