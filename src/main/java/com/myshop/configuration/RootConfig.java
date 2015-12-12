package com.myshop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kot on 10.12.15.
 */
@Configuration
@ComponentScan(basePackages = {"com.myshop.book", "com.myshop.service"})
public class RootConfig {
}
