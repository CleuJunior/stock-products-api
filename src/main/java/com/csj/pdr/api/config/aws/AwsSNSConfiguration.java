package com.csj.pdr.api.config.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AwsSNSConfiguration {

    @Bean
    @Profile("!local")
    public AmazonSNS amazonSNS() {
        return AmazonSNSClientBuilder.defaultClient();
    }

    @Bean
    @Profile("local")
    public AmazonSNS amazonSnsLocal(@Value("${aws.config.sns.url}") String endpoint,
                                    @Value("${aws.config.region}") String region) {

        return AmazonSNSClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .withCredentials(localCredentials())
                .build();
    }

    private AWSStaticCredentialsProvider localCredentials() {
        var localCredentials = new BasicAWSCredentials("none", "none");

        return new AWSStaticCredentialsProvider(localCredentials);
    }
}
