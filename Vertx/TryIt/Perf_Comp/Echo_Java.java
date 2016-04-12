import io.vertx.core.AbstractVerticle;

public class Echo_Java extends AbstractVerticle {

    @Override
    public void start() throws Exception {			
        vertx.createHttpServer().requestHandler(req -> {
			vertx.setTimer(500, id -> {
                req.response().headers().set("Content-Type", "text/html; charset=UTF-8");
                req.response().end("Hello Vertx java");
            });
        }).listen(8080);
    }

}
