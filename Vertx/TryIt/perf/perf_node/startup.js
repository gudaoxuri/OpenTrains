var http = require('http');
http.createServer(function (req, res) {
    setTimeout(function () {
        res.writeHead(200, {'Content-Type': 'text/plain'});
        res.end('Hello Node');
    }, 500);
}).listen(8080, '127.0.0.1');
console.log('Server running.');