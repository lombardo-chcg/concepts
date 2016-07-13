// ngrok http 9000

var http = require('http');
var childProcess = require('child_process');
var fs = require('fs'); //filesystem

var server = http.createServer(function(req, res) {
  var date = Date.now();
  if (req.method === "GET") {
    var fileName = req.url.split('/')[1];
    fs.readFile(__dirname + '/' + fileName, function(err, buffer) {
      if (err) {
        res.end('oh no something went wrong')
      } else {
        res.end(buffer)
      }
    });
  } else {
    childProcess.exec(`raspistill -o ${date}.jpg`, function() {
      res.end(date);
    });
  }
});

server.listen(9000);
