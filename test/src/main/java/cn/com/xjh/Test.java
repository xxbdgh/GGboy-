package cn.com.xjh;

import cn.com.xjh.test.AccountDao;
import cn.com.xjh.test.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

import java.sql.SQLException;

@SpringBootApplication
public class Test {

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);

    }

    @Bean
    public String getAccount(AccountService service) throws SQLException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        service.transfer(1,2,100);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
        return null;
    }

}
