vertx.createHttpServer().requestHandler(function (req) {
	vertx.setTimer(500, function (id) {
		req.response().headers().set("Content-Type", "text/html; charset=UTF-8");
        req.response().end("Hello Vertx js");
    });
}).listen(8080);




