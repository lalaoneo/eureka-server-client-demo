# eureka-server-client-demo
eureka-server-client-demo

### 添加zipkin-server模块

* 添加pom依赖
```java
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.1.0.RC3</version>
        <exclusions>
            <exclusion>
                <artifactId>spring-boot-starter-logging</artifactId>
                <groupId>org.springframework.boot</groupId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>io.zipkin.java</groupId>
        <artifactId>zipkin-server</artifactId>
        <version>2.11.8</version>
    </dependency>
    <dependency>
        <groupId>io.zipkin.java</groupId>
        <artifactId>zipkin-autoconfigure-ui</artifactId>
        <version>2.11.12</version>
    </dependency>
</dependencies>
```

* 添加包名：`com.lori.eureka.server`

* 启动类代码
```java
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class,args);
    }
}
```

* 配置文件
```properties
server.port=9999

spring.application.name=zipkin-server

eureka.client.service-url.defaultZone=http://localhost:9090/eureka

management.metrics.web.server.auto-time-requests=false
```

* 地址：`http://localhost:9999/zipkin/`
