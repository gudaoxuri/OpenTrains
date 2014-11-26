package com.ecfront.test.vertx;


import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

public class Server extends Verticle {
    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(final HttpServerRequest httpServerRequest) {
                vertx.setTimer(500, new Handler<Long>() {
                    @Override
                    public void handle(Long event) {
                        httpServerRequest.response().headers().set("Content-Type", "text/html; charset=UTF-8");
                        httpServerRequest.response().end("Hello Vertx");
                    }
                });
            }
        }).listen(8080);
    }
}
