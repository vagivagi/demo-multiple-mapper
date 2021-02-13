# demo-multiple-mapper

demonstrate multiple OR(SQL) mapper(JPA, MyBatis)

## start

```shell script
$ ./mvnw spring-boot:run
```

## curl

``` shell script
$ curl http://localhost:8080/jpa/hanako
[{"id":1,"name":"Taro","createdBy":"data.sql"},{"id":2,"name":"hanako","createdBy":"JPA"}]
$ curl http://localhost:8080/mybatis/takashi
[{"id":1,"name":"Taro","createdBy":"data.sql"},{"id":2,"name":"hanako","createdBy":"JPA"},{"id":3,"name":"takashi","createdBy":"MyBatis"}]
$ curl http://localhost:8080/multiple/vagivagi
[{"id":1,"name":"Taro","createdBy":"data.sql"},{"id":2,"name":"hanako","createdBy":"JPA"},{"id":3,"name":"takashi","createdBy":"MyBatis"},{"id":4,"name":"vagivagi","createdBy":"JPA"},{"id":5,"name":"vagivagi","createdBy":"MyBatis"}]
```