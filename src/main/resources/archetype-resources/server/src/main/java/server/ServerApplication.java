#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ServerApplication TODO
 * date time: 2021/9/30 18:01
 * Copyright 2021 github.com/vencent-lu/giants-anemic-archetype Inc. All rights reserved.
 *
 * @author vencent-lu
 * @since 1.0
 */
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
