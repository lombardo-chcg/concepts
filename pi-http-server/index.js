const http = require('http');
const URL = '********.ngrok.io'  // the url for the Pi
const postRequest = {
  hostname: URL,
  path: '/',
  method: 'POST'
}

const server = http.createServer(function(req, res) {

  http.request(postRequest, function(response) {
    var data = '';
    response.on('data', function(part) {
      data += part.toString();
    });
    response.on('end', function() {
      res.writeHead(200, {'Content-Type': 'text/xml'});
      res.end(`<?xml version="1.0" encoding="UTF-8"?>
        <Response>
          <Message>
            <Media>
              ${url}/${data}.jpg
            </Media>
          </Message>
        </Response>
      `);
    });
  }).end()

});

server.listen(1337);
