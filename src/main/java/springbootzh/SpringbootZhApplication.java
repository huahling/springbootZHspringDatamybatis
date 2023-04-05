package springbootzh;

//import comyz.config.DBConfig1;

import comyz.config.DBConfig1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.EnableAsync;


////@SpringBootApplication
//@ComponentScan(basePackages = {"comyz","springbootzh"})//"demo.feng",demo.shujuyuan
//@MapperScan(basePackages ={"comyz.dao"}) //mybatis  //"demo.feng",
////@EnableJpaRepositories(basePackages = "comyz.dao")
////@EntityScan("comyz.entities")
//@EnableAutoConfiguration
//@EnableConfigurationProperties(value = { DBConfig1.class})
//@EntityScan("comyz.entities")

//@EnableCaching
//@EnableScheduling
//@EnableAsync


//mybatis
@SpringBootApplication
@ComponentScan(basePackages = {"comyz", "springbootzh"})//"demo.feng",demo.shujuyuan
@MapperScan(basePackages = {"comyz.dao"}) //mybatis  //"demo.feng",
@EnableConfigurationProperties(value = {DBConfig1.class})
@EntityScan("comyz.entities")
@EnableJpaRepositories(basePackages = "comyz.dao")

public class SpringbootZhApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootZhApplication.class, args);
    }

}
