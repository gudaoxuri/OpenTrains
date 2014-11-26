package com.ecfront;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.platform.Verticle;

public class PingVerticle extends Verticle {
    public void start() {
        vertx.eventBus().registerHandler("ping-address", new Handler<Message<String>>() {
            @Override
            public void handle(Message<String> message) {
                container.logger().info(message.body());
                message.reply("pong!");
            }
        });
        container.logger().info("PingVerticle started");
        vertx.setPeriodic(1000,new Handler<Long>() {
            @Override
            public void handle(Long event) {
                vertx.eventBus().send("ping-address", "ping!", new Handler<Message<String>>() {
                    @Override
                    public void handle(Message<String> reply) {
                        container.logger().info(reply.body());
                    }
                });
            }
        });
    }
}
