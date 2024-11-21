package com.elasticSearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Configuration
public class ElasticSearchConfig {
	
	@Bean
	public RestClient getRestClient() {
		RestClient restClient = RestClient.builder(
				new HttpHost("localhost",9200)).build();
		return restClient;
	}
	
	@Bean
	public ElasticsearchTransport getelasticsearchTransport() {
		return new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
	}
	
	@Bean
	public ElasticsearchClient getElasticsearchClient() {
		ElasticsearchClient elasticsearchClient = new ElasticsearchClient(getelasticsearchTransport());
		return elasticsearchClient;
	}
}
