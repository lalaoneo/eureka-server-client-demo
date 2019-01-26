package com.lori.eureka.consumer.feign.client;

import com.lori.eureka.provider.api.HelloWord;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-provider")
public interface HelloWordClient extends HelloWord {
}
