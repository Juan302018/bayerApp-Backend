package cl.bayer.customer.utils;

import org.springframework.core.Ordered;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
public class SecurityConfig {
	  @Bean
	  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http
	      .requiresChannel(channel -> 
	          channel.anyRequest().requiresSecure())
	      .authorizeRequests(authorize ->
	          authorize.anyRequest().permitAll())
	      .build();
	    }
}
