
import com.alibaba.fastjson.JSON;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.*;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.params.GroupParams;
import org.apache.solr.common.params.MapSolrParams;
import org.junit.Test;

import java.util.*;

public class solrTest {

    public static HttpSolrClient getSolrClient() {
        return new HttpSolrClient("http://127.0.0.1:8983/solr/solrhome");
    }

    /**
     * 查询
     *
     * @throws Exception
     */
    @Test
    public void querySolr() throws Exception {

        HttpSolrClient client = getSolrClient();
        //[2]封装查询参数
        Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put("q", "*:*");
        //[3]添加到SolrParams对象
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);
        //[4]执行查询返回QueryResponse
        QueryResponse response = client.query(queryParams);
        //[5]获取doc文档
        SolrDocumentList documents = response.getResults();
        //[6]内容遍历
        for (SolrDocument doc : documents) {
            System.out.println("id:" + doc.get("id")
                    + "\tproduct_name:" + doc.get("product_name")
                    + "\tproduct_catalog_name:" + doc.get("product_catalog_name")
                    + "\tproduct_number:" + doc.get("product_number")
                    + "\tproduct_price:" + doc.get("product_price")
                    + "\tproduct_picture:" + doc.get("product_picture"));
        }
        client.close();
    }

    /**
     * 2、使用 SolrParams 的子类 SolrQuery,它提供了一些方便的方法,极大地简化了查询操作。
     *
     * @throws Exception
     */
    @Test
    public void querySolr2() throws Exception {
        HttpSolrClient client = getSolrClient();

        //[2]封装查询参数
        SolrQuery query = new SolrQuery("*:*");
        //[3]添加需要回显得内容
        query.addField("id");
        query.addField("productId_s");
        query.addField("type_i");
        query.addField("name_s");
        query.addField("cata_i");
        query.addField("product_number_i");
        query.addField("item_image_s");
        query.setRows(20);//设置每页显示多少条
        //[4]执行查询返回QueryResponse
        QueryResponse response = client.query(query);
        //[5]获取doc文档
        SolrDocumentList documents = response.getResults();
        //[6]内容遍历
        for (SolrDocument doc : documents) {
            System.out.println("id:" + doc.get("id")
                    + "\tproductId_s:" + doc.get("productId_s")
                    + "\ttype_i:" + doc.get("type_i")
                    + "\tname_s:" + doc.get("name_s")
                    + "\tcata_i:" + doc.get("cata_i")
                    + "\tproduct_number_i:" + doc.get("product_number_i")
                    + "\titem_image_s:" + doc.get("item_image_s"));
        }
        client.close();
    }


    /**
     * 2、使用 SolrParams 的子类 SolrQuery,它提供了一些方便的方法,极大地简化了查询操作。
     *
     * @throws Exception
     */
    @Test
    public void querySolr3() throws Exception {
        HttpSolrClient client = getSolrClient();

        //[2]封装查询参数
        SolrQuery query = new SolrQuery("*:*");
        query.set(CommonParams.Q,"(productId_s:8888888888 AND name_s:sansung爆炸牌手机-1787558661) OR (productId_s:99999999999999 AND name_s:sansung爆炸牌手机131471161)");
        //[3]添加需要回显得内容
        query.set(CommonParams.FL,
                "id",
                "productId_s",
                "type_i",
                "name_s",
                "cata_i",
                "product_number_i",
                "item_image_s")
                //开启分组功能
                .set(GroupParams.GROUP, true)
                //按照品牌分组
//                .set(GroupParams.GROUP_FIELD, "productId_s", "cata_i")
                .set(GroupParams.GROUP_FIELD, "productId_s")
                //设置每个分组里从第几条数据开始返回，用于组内分页，这里不进行分页
                .set(GroupParams.GROUP_OFFSET, 0)
                //设置每个分组最多返回几条数据，这里设置一个比较大的数
                .set(GroupParams.GROUP_LIMIT, 10)
                //是否返回总的组数
                .set(GroupParams.GROUP_TOTAL_COUNT, true)
                //组内排序
//                .set(GroupParams.GROUP_SORT, "product_number_i asc")
                //组间排序
//                .set(CommonParams.SORT, "product_number_i desc")
                .set("fq", "{!geofilt}")          //距离过滤函数
                .set("pt", "121.227985 39.410722") //当前经纬度
                .set("sfield", "position_srpt")   //经纬度的字段
                .set("d", "50000")   //就近 d km的所有数据
//params.set("score", "kilometers");
                .set("sort", "geodist() asc")  //根据距离排序：由近到远
                .set("start", "0")  //记录开始位置
                .set("rows", "100")  //查询的行数
                .set("fl", "*,_dist_:geodist(),score");//查询的结果中添加距离和score
//        query.setRows(20);//设置每页显示多少条？
        //[4]执行查询返回QueryResponse
        QueryResponse response = client.query(query);
        //获取查询结果列表
        GroupResponse groupResponse = response.getGroupResponse();
        //获取根据不同分组方式查询到的结果
        List<GroupCommand> groupCommandList = groupResponse.getValues();
        //由于这里只有一种分组策略，所以直接取第一个对象
        GroupCommand groupCommand = groupCommandList.get(0);
        List<Group> groups = groupCommand.getValues();
        //打印每个分组信息
        SolrDocumentList list = null;
        for (Group group : groups) {
            //获取每个分组内的数据
            list = group.getResult();
            System.out.println("------------");
            for (SolrDocument solrDocument : list) {
                //方便演示，直接转换成json打印
                String string = JSON.toJSONString(solrDocument);
                System.out.println(string);
            }
        }
        System.out.println("---------------------------------------------------------------------------------");
        /*GroupCommand groupCommand2 = groupCommandList.get(1);
        List<Group> groups2 = groupCommand2.getValues();
        //打印每个分组信息
        SolrDocumentList list2 = null;
        for (Group group : groups2) {
            //获取每个分组内的数据
            list2 = group.getResult();
            System.out.println("------------");
            for (SolrDocument solrDocument : list2) {
                //方便演示，直接转换成json打印
                String string = JSON.toJSONString(solrDocument);
                System.out.println(string);
            }
        }*/
    }


    @Test

    public void testSave() throws Exception {
        //1.创建连接对象
        HttpSolrClient solrServer = getSolrClient();
        //2.创建一个文档对象

        //向文档中添加域以及对应的值,注意：所有的域必须在schema.xml中定义过,前面已经给出过我定义的域。

        String type = "1";
        for (int i = 0; i < 3; i++) {

            SolrInputDocument inputDocument = new SolrInputDocument();
            String id = UUID.randomUUID().toString();
            inputDocument.addField("id", type + "_" + id);
            inputDocument.addField("productId_s", "bbbbbbbbbbbb");

            inputDocument.addField("type_i", 1);
            inputDocument.addField("name_s", "sansung爆炸牌手机" + new Random().nextInt());
            inputDocument.addField("cata_i", 55555);
            inputDocument.addField("product_number_i", 100);
            inputDocument.addField("item_image_s", "www.boom.png");
            inputDocument.addField("position_srpt", "12.013242 43.034234");
            //3.将文档写入索引库中
            UpdateResponse updateResponse = solrServer.add(inputDocument);
            System.out.println(updateResponse);
            //提交
            solrServer.commit();
        }
    }

    @Test
    public void solrDeleteList() throws Exception {
        //[1]获取连接
        HttpSolrClient client = getSolrClient();
        //[2]通过id删除
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("30000");
        ids.add("1");
        client.deleteById(ids);
        //[2]通过id删除
//        client.deleteById("30000");
        //[3]提交
        client.commit();
        //[4]关闭资源
        client.close();
    }

    /**
     * 8、通过deleteByQuery删除索引
     */
    @Test
    public void deleteBean() throws Exception {
        //[1]获取连接
        // HttpSolrClient client= new HttpSolrClient.Builder("http://127.0.0.1:8080/solr/core1").build();
        //创建solrClient同时指定超时时间，不指定走默认配置
        HttpSolrClient client = getSolrClient();
        //[2]执行删除
//          client.deleteByQuery("id:100");
        client.deleteByQuery("*:*");
        //[3]提交操作
        client.commit();
        //[4]关闭资源
        client.close();
    }


}
