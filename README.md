# eureka-server-client-demo
* starter引入依赖:`web, eureka-serv, eureka-discovery, fegin, hystrix, ribbon`,所有依赖引入到子项目中后再删除.
 * 父pom删除test,dependencyManagement,build,repositories
 * dependencyManagement,build,repositories移入consumer,provider,eureka-server中

* 创建eureka-server模块,把eureka-server依赖引入进来,创建包名：`com.lori.eureka.server,@EnableEurekaServer
```properties
server.port=9090
```

* 创建eureka-provider-api模块,删除resource,test,创建包名：`com.lori.eureka.provider.api`,引入web依赖,把consul-demo的api接口copy过来

* 创建eureka-provider模块,创建包名：`com.lori.eureka.provider`,引入eureka-client,eureka-provider-api依赖,把consul-demo的api.impl实现类copy过来

* eureka-provider配置
```properties
server.port=8090

spring.application.name=eureka-provider-server

eureka.client.service-url.defaultZone=http://localhost:9090/eureka
````

* 创建eureka-consumer模块,创建包名：`com.lori.eureka.consumer`,把consul-demo的controller,fegin,client的类复制过来,引入eureka-provider-api,hystrix,ribbon,openfeign
  * 启动项增加：`@EnableFeignClients(basePackages = {"com.lori.eureka.consumer.feign.client"})`
  * feignclient的名称需要修改：`@FeignClient("eureka-provider")`
  * 配置
  ```properties
  server.port=8080

  spring.application.name=eureka-consumer
  
  eureka.client.service-url.defaultZone=http://localhost:9090/eureka
  ```
