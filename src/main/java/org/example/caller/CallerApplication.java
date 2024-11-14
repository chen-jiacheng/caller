package org.example.caller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chenjiacheng on 2024/11/14 23:58
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class CallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallerApplication.class,args);
        log.info("caller server has been started.");
    }

}
