# This is demo for DDD workshop [![Build Status](https://travis-ci.org/ADU-21/ddd_demo.svg?branch=master)](https://travis-ci.org/ADU-21/ddd_demo) 

- Prepare DB: 
```
docker run --name mysql -p 3306:3306 -v /your/local/path/ddd/db/:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=<PassWord> -d daocloud.io/mysql:latest
```
- Prepare Nginx: 
```
docker run --name nginx -d -p 80:80 -v /your/local/path/ddd/nginx/:/etc/nginx/  daocloud.io/nginx
```
- Prepare API: 
```
./gradlew clean build
```
