package cn.liaozh.service.service.impl;

import cn.liaozh.pojo.vo.EsArticlePo;
import cn.liaozh.pojo.vo.IntactArticleVo;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class EsServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(EsServiceImpl.class);
    private final RestHighLevelClient restHighLevelClient;

    @Autowired
    public EsServiceImpl(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    public List<Object> inquiry(String index, String str) {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(false).field("content").field("title").preTags(new String[]{"<span style='color:red;'>"}).postTags(new String[]{"</span>"});
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(str, new String[]{"content", "title"});
        sourceBuilder.query(multiMatchQueryBuilder).highlighter(highlightBuilder);
        sourceBuilder.timeout(new TimeValue(60L, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = null;

        try {
            searchResponse = this.restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Object> esArticlePos = new ArrayList();

        for(SearchHit hit : hits) {
            Object parse = JSON.parse(hit.getSourceAsString());
            esArticlePos.add(parse);
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if (highlightFields.containsKey("content")) {
                log.info(String.valueOf(((HighlightField)highlightFields.get("content")).fragments()[0]));
            }

            if (highlightFields.containsKey("title")) {
                log.info(String.valueOf(((HighlightField)highlightFields.get("title")).fragments()[0]));
            }
        }

        return esArticlePos;
    }

    public void esCreateIndex(String str) {
        CreateIndexRequest request = new CreateIndexRequest(str);

        try {
            CreateIndexResponse e = this.restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exJudgmentIndex(String str) {
        GetIndexRequest request = new GetIndexRequest(new String[]{str});

        try {
            boolean e = this.restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void esAddDocuments(String indexs, Object obj, String id) {
        IndexRequest product = new IndexRequest(indexs);
        product.id(id);
        product.timeout("1s");
        product.source(JSON.toJSONString(obj), XContentType.JSON);

        try {
            this.restHighLevelClient.index(product, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean getOneDocumentation(String index, String id) {
        GetRequest getRequest = new GetRequest(index, "_doc", id);

        try {
            return this.restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        } catch (IOException var5) {
            return false;
        }
    }

    public void getDocumentInformation(String index, String id) {
        GetRequest getRequest = new GetRequest(index, "_doc", id);

        try {
            this.restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateDocumentation(String index, String id, Object obj) {
        UpdateRequest updateRequest = new UpdateRequest(index, "_doc", id);
        updateRequest.timeout("1s");
        updateRequest.doc(JSON.toJSONString(obj), XContentType.JSON);

        try {
            this.restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteDocumentation(String index, String id) {
        DeleteRequest deleteRequest = new DeleteRequest(index, "_doc", id);
        deleteRequest.timeout("1s");

        try {
            this.restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Boolean bulkAdd(String index, List<EsArticlePo> list) {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        for(EsArticlePo vo : list) {
            bulkRequest.add((new IndexRequest(index)).id(vo.getId()).source(new Object[]{JSON.toJSONString(vo)}));
        }

        try {
            BulkResponse bulk = this.restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            return bulk.hasFailures();
        } catch (IOException var6) {
            return true;
        }
    }

    public void bulkDelete(String index, List<IntactArticleVo> list) {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        for(IntactArticleVo vo : list) {
            bulkRequest.add((new DeleteRequest(index)).id(vo.getIntactArticleId()));
        }

        try {
            this.restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void esDeleteIndex(String str) {
        DeleteIndexRequest request = new DeleteIndexRequest(str);

        try {
            this.restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
