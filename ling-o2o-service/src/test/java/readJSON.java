import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ling.common.utils.FileUtil;

import com.ling.enity.Foods;
import com.ling.enity.Goods;
import com.ling.enity.SellerSupports;
import com.ling.service.ContentService;
import com.ling.service.GoodsService;
import com.ling.service.SellerService;
import com.ling.service.SellerSupportsService;
import enity.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = {"classpath:spring/springmvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class readJSON {
    @Autowired
    private ContentService contentService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private SellerSupportsService sellerSupportsService;
    @Autowired
    private GoodsService goodsService;
    @Test
    public void test() {
        System.out.println(contentService.findAll());
        String filePath = "C:\\Users\\lingbin\\Desktop\\data.json";
        String jsonContent = FileUtil.ReadFile(filePath);
        String json = JSON.toJSONString(JSON.parseObject(jsonContent));
        JSONObject jsonddd = JSON.parseObject(json);

        Seller seller = JSON.parseObject(jsonddd.getString("seller"), Seller.class);
        System.out.println("seller: "+JSON.toJSONString(seller, true));
        com.ling.enity.Seller seller1=new com.ling.enity.Seller();
        BeanUtils.copyProperties(seller,seller1);
        System.out.println("seller1:  "+JSON.toJSONString(seller1, true));


        List<SellerSupports> sellerSupports=new ArrayList<>();
        for (enity.SellerSupports sellerSupports1:seller.getSupports()){
            SellerSupports ss=new SellerSupports();
            BeanUtils.copyProperties(sellerSupports1,ss);
            sellerSupports.add(ss);
        }
        seller1.setSellerSupportsList(sellerSupports);
        com.ling.enity.Seller seller2=sellerService.save(seller1);
//        sellerSupports.setSellerList(sellerList);
//        sellerSupportsService.save(sellerSupports);

        List<com.ling.enity.Goods> goods = JSON.parseArray(jsonddd.getString("goods"), com.ling.enity.Goods.class);
        System.out.println("goods:  "+JSON.toJSONString(goods, true));
        Goods goods1=JSON.parseObject(JSON.toJSONString(goods.get(0)),Goods.class);

        List<Foods> foodsList=new ArrayList<>();
        com.ling.enity.Foods foods=new com.ling.enity.Foods();
        foods.setName("44444444");
        foodsList.add(foods);
//        goods1.setFoodsList(goods.get(0).getFoodsList());   报错
        goods1.setFoodsList(foodsList);
//        goodsService.save(goods1);
        goodsService.save(jsonddd.getString("goods"));
        goodsService.save(foodsList);
        System.out.println(222);


    }

    @Test
    public void test2() {

        com.ling.enity.Seller seller3=sellerService.findSellerByid(1L);
        System.out.println(JSON.toJSONString(seller3.getId()));
    }
}
