const express = require('express');
const bodyParser = require("body-parser");
const morgan = require("morgan");
const app = express();

//Middleware
app.use(morgan(`Server Logger`));
app.use('/storage/avatar', express.static('storage/avatar'));
app.use('/storage/wallpaper', express.static('storage/wallpaper'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use((req, res, next) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header(
        "Access-Control-Allow-Headers",
        "Origin, X-Requested-With, Content-Type, Accept, Authorization"
    );
    if (req.method === "OPTIONS") {
        res.header("Access-Control-Allow-Methods", "PUT, POST, PATCH, DELETE, GET");
        return res.status(200).json({});
    }
    next();
});

//Routers
const API_VERSION = "/v1/";
const feedRoutes = require('./api/routes/feed');
const userRoutes = require('./api/routes/user');
const questionRoutes = require('./api/routes/question');
const answerRoutes = require('./api/routes/answer');
const followRoutes = require('./api/routes/follow');
const reactRoutes = require('./api/routes/react');
const notificationRoutes = require('./api/routes/notification');

//Get All Users: http://localhost:3000/v1/users
//Get User by Id: http://localhost:3000/v1/users/:id (path variables (value=id))
//Get Search user: http://localhost:3000/v1/users/search (key=q , value(email))
//Post Login: http://localhost:3000/v1/users/login (email,password)
//Post Register: http://localhost:3000/v1/users/register (email,username,password,name)
//Put Change Name: http://localhost:3000/v1/users/name (Bearer token) (name, email)
//Delete User: http://localhost:3000/v1/users/ (Bearer token) (email)


//Bind routers
app.use(API_VERSION + 'users', userRoutes);
app.use(API_VERSION + 'feeds', feedRoutes);
app.use(API_VERSION + 'questions', questionRoutes);
app.use(API_VERSION + 'answers', answerRoutes);
app.use(API_VERSION + 'follows', followRoutes);
app.use(API_VERSION + 'reacts', reactRoutes);
app.use(API_VERSION + 'notifications', notificationRoutes);

//Errors handle
app.use((req, res, next) => {
    const error = new Error("Not found");
    error.status = 404;
    next(error);
});

app.use((error, req, res, next) => {
    const status = error.status || 500;
    res.status(status);
    res.json({
        error: {
            message: error.message
        }
    });
});

module.exports = app;