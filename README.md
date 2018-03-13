```shell
$ gradle flywayClean

$ gradle flywayMigrate -i

$ gradle flywayClean && gradle flywayMigrate -i
```





```shell
$ docker run \
  --name postgres \
  -e POSTGRES_PASSWORD=123456 \
  -e POSTGRES_USER=iamdemos \
  -e POSTGRES_DB=iamdemos \
  -p 5432:5432 \
  -d \
  --rm \
  postgres:10.3
  
  
$ docker run -p 6379:6379 --name redis -d --rm redis:3.2


$ docker run -it --link redis --rm redis:3.2 redis-cli -h redis -p 6379
```



```
$ keys *

$ type <key>

$ get string-key
$ HGETALL hash-key


get slow::boot
del slow::boot
```





```
--spring.profiles.active=mysql

# properties name
application-mysql.properties
```

