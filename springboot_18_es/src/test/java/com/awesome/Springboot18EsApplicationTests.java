package com.awesome;

import com.alibaba.fastjson2.JSON;
import com.awesome.domain.Book;
import com.awesome.mapper.BookMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class Springboot18EsApplicationTests {

    @Autowired
    private BookMapper bookMapper;

//    @Autowired
//    private ElasticsearchRestTemplate template;
//
//    @Test
//    void contextLoads() {
//    }

    private RestHighLevelClient client;

    @BeforeEach
    void setUp() {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }

    @Test
    void testCreateClient() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testCreateClientByIK() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        String json = "{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testCreateDoc() throws IOException {
        Book book = bookMapper.selectById(1);

        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    void testCreateDocAll() throws IOException {
        List<Book> books = bookMapper.selectList(null);

        BulkRequest bulk = new BulkRequest();

        for (Book book : books) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);
            bulk.add(request);
        }

        client.bulk(bulk, RequestOptions.DEFAULT);
    }

    @Test
    void testGet() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String sourceAsString = response.getSourceAsString();
        System.out.println(sourceAsString);
    }

    @Test
    void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("books");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchPhraseQuery("type", "MODERN"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        }
    }

}
