
package TestCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;
import org.junit.Test;

/**
 * @author liuwen
 * @version 1.0
 * @date 2017年5月22日
 * funcation : solr搜索测试
 */
public class TestSearch{
    private final String URL="http://localhost:8080/solr/new_core";
    private HttpSolrClient solrClient = null;
    private int timeout = 3000;
    
    @Test
    public void test(){
        init();
        addData();
    }
    
    private void init(){
//        solrClient = new HttpSolrClient.Builder(URL).build();
        solrClient = new HttpSolrClient(URL);
        solrClient.setConnectionTimeout(timeout);
    }
    
    private void addData(){
        Map<String, SolrInputField> fileMap = new HashMap<String, SolrInputField>();
        SolrInputField fa = new SolrInputField("id");
        fa.addValue("id_JJJJ", 1);
        SolrInputField fb = new SolrInputField("aa");
        fb.addValue("aaa", 1);
        fileMap.put("id", fa);
        SolrInputDocument doc = new SolrInputDocument(fileMap);
        try{
            solrClient.add(doc);
            solrClient.commit();
        }catch (SolrServerException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
