package com.hmall.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.PrimitiveIterator;

@Data
@ConfigurationProperties(prefix = "hm.cart")
@Component
public class CartProperties {

    private Integer maxItems;
}
