package com.ledger.es_test1.connection;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author ledger
 * @version 1.0
 **/
public class ElasticSearchConnection {
    private volatile static RestHighLevelClient client;

    private static final int CONNECTION_TIMEOUT_MS = 600000;

    public static RestHighLevelClient getClient() {
        if (client == null) {
            synchronized (ElasticSearchConnection.class) {
                if (client == null) {
                    client = new RestHighLevelClient(
                            RestClient.builder(
                                    new HttpHost("106.54.9.19", 9200, "http"))
                                    .setHttpClientConfigCallback(httpClientBuilder -> {
                                        // 设置连接池的最大连接数
                                        httpClientBuilder.setMaxConnTotal(20); // 设置最大连接数
                                        httpClientBuilder.setMaxConnPerRoute(10); // 设置每个路由的最大连接数
                                        return httpClientBuilder;
                                    })
                    );
                }
            }
        }
        return client;
    }

    public static RequestOptions getOption() {

        //配置连接超时
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(600000)
                .build();

        return RequestOptions.DEFAULT.toBuilder()
                .setRequestConfig(requestConfig)
                .build();
    }

    public static void closeClient() {
        //不关闭连接就不会报错
//        if (client != null) {
//            try {
//                client.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
