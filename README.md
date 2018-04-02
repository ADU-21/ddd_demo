# This is demo for DDD workshop

- Prepare DB: docker run --name mysql -p 3306:3306 -v /your/local/path/ddd/db/:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=<PassWord> -d daocloud.io/mysql:latest
- Prepare Nginx: docker run --name nginx -d -p 8080:80 -v /your/local/path/ddd/nginx/:/etc/nginx/  daocloud.io/nginx
- Prepare API: ./gradlew clean build
