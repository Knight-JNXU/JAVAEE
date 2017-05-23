/**
 
* Copyright (c) 2014 Baozun All Rights Reserved.
 
*
 
* This software is the confidential and proprietary information of Baozun.
 
* You shall not disclose such Confidential Information and shall use it only in
 
* accordance with the terms of the license agreement you entered into
 
* with Baozun.
 
*
 
* BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 
* SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 
* IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 
* PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 
* SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 
* THIS SOFTWARE OR ITS DERIVATIVES.
 
*
 
*/
package TestCode;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * @author liuwen
 * @version 1.0
 * @date 2017年5月23日
 *       funcation :
 */
public class TBookTest{

    private final static String SOLR_URL = "http://localhost:8983/solr/";

    private final static String CORE = "mydb";
    
    public HttpSolrClient createSolrClient(){
        HttpSolrClient solrClient = null;
        solrClient = new HttpSolrClient(SOLR_URL + CORE);
        return solrClient;
    }

    /**
     * 增
     * 
     * @throws Exception
     */
    public void addDoc() throws Exception{
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", 3);
        document.addField("name", "sw");
        document.addField("isbn", "false");
        HttpSolrClient solrClient = createSolrClient();
        solrClient.add(document);
        solrClient.commit();
        solrClient.close();
    }

    /**
     * 根据id删除
     * 
     * @throws Exception
     */
    public void deleteDocById() throws Exception{
        HttpSolrClient solrClient = createSolrClient();
        solrClient.deleteById("3");
        solrClient.commit();
        solrClient.close();
    }

    /**
     * 查
     * 
     * @throws Exception
     */
    public void querySolr() throws Exception{
        HttpSolrClient solrClient = createSolrClient();
        SolrQuery query = new SolrQuery();
        //相关查询
        query.set("id", "2");
        //添加过滤条件
        query.addFilterQuery("id:[0 TO 10]");
        //设置搜索域
        query.set("df", "name");
        //设置排序规则
        query.setSort("id", SolrQuery.ORDER.desc);
        //设置分页
        query.setStart(0);
        query.setStart(10);
        //设置高亮
        query.setHighlight(true);
        //设置高亮的字段
        query.addHighlightField("id");
        //设置高亮的样式
        query.setHighlightSimplePre("<font color='red'");
        query.setHighlightSimplePost("</font>");
        //获取查询结果
        QueryResponse response = solrClient.query(query);
        
        //查询得到文档的集合
        SolrDocumentList solrDocumentList = response.getResults();
        System.out.println("通过文档集合获取查询的结果");
        System.out.println("查询结果的总数量:"+solrDocumentList.getNumFound());
        //遍历
        for(SolrDocument document : solrDocumentList){
            System.out.println(document.toString());
        }
        
        List<Book> tempList = response.getBeans(Book.class);
        if(null!=tempList && tempList.size()>0){
            System.out.println("得到实体对象list");
            for (Book book : tempList){
                System.out.println(book.toString());
            }
        }
    }
    
    public void simpleQuerySolr() throws Exception{
        HttpSolrClient solrClient = createSolrClient();
        SolrQuery query = new SolrQuery();
        query.setQuery("id:1");
        
        //设置高亮
        query.setHighlight(true);
        //设置高亮的字段
        query.addHighlightField("id");
        query.setHighlightSimplePre("<font color='red'");
        query.setHighlightSimplePost("</font>");
        
        //获取查询结果
        QueryResponse response = solrClient.query(query);

        //查询得到文档的集合
        SolrDocumentList solrDocumentList = response.getResults();
        System.out.println("通过文档集合获取查询的结果");
        System.out.println("查询结果的总数量:"+solrDocumentList.getNumFound());
        //遍历
        for(SolrDocument document : solrDocumentList){
            System.out.println(document.toString());
        }
    }
    
    @Test
    public void test(){
        try{
//            addDoc();
//            querySolr();
            simpleQuerySolr();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
