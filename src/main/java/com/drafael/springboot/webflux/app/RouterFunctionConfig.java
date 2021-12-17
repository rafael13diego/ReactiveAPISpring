package com.drafael.springboot.webflux.app;

import com.drafael.springboot.webflux.app.handler.ProductoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {



   @Bean
    public RouterFunction<ServerResponse> routes(ProductoHandler handler){

       return route(GET("/api/v2/productos").or(GET("/api/v3/productos")),
               handler::listar)
               .andRoute(GET("/api/v2/productos/{id}"),handler::ver);
               //.andRoute(GET("/api/v2/productos/{id}").and(contentType(MediaType.APPLICATION_JSON)),handler::ver);
    }

}
