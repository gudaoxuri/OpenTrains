package com.ecfront.opentrains.fulltextsearch;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: SolrJ
 * User: 震宇
 * Date: 13-9-21
 */
public class SolrJ {

    String url = "http://localhost:8983/solr/db";
    SolrServer server = new HttpSolrServer(url);

    public void addIndex() throws IOException, SolrServerException {
        SolrInputDocument doc1 = new SolrInputDocument();
        doc1.addField("_PK", "1111");
        doc1.addField("name_ntcn", "xxx计算机");
        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        docs.add(doc1);
        server.add(docs);
        server.commit();
    }

    public void searchIndex() throws SolrServerException {
        SolrQuery query = new SolrQuery("计算机");
        QueryResponse response = server.query(query);
        SolrDocumentList docs = response.getResults();
        System.out.println("文档个数：" + docs.getNumFound());
        System.out.println("查询时间：" + response.getQTime());
        for (SolrDocument doc : docs) {
            System.out.println("id: " + doc.getFieldValue("_PK"));
            System.out.println("name: " + doc.getFieldValue("name_ntcn"));
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException, SolrServerException {
        SolrJ solrJ=new SolrJ();
        solrJ.addIndex();
        solrJ.searchIndex();
    }
}
