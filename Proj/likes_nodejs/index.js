const express = require('express')
const mysql = require('mysql2');
const app = express();
const port = process.env.PORT || 3000;

// const routes = require('./api/routes');
// routes(app);
app.listen(port, function() {
   console.log('Server started on port: ' + port);
});

const bodyParser = require('body-parser');
app.use(bodyParser.json()); 
app.use(
  express.urlencoded({
    extended: true,
  })
);

//IMPORTS
// const getRoutes = require('./api/routes/gets');
const routes = require('./routes')
// const postRoutes = require('./api/routes/posts');

// app.use('/get', getRoutes);

// app.use('/post', postRoutes);

// app.get("/", (req, res) => {
//   res.json({ message: "ok" });
// });


// app.post("/", (req, res) => {
//   res.json({ message: "ok" });
// });

app.use("/likes", routes);

/* Error handler middleware */
app.use((err, req, res, next) => {
  const statusCode = err.statusCode || 500;
  console.error(err.message, err.stack);
  res.status(statusCode).json({ message: err.message });
  return;
});

// con.connect(function(err) {
//   if (err) {
//     return console.error('error: ' + err.message);
//   }

//   console.log('Connected to the MySQL server.');
// });