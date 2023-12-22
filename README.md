# Ecommerce-side-project 


## 개발환경 구성


### [Docker](https://www.docker.com/get-started) Install
```
1. docker-compose up -d  (도커 실행후 mysql, localstack-s3 셋팅)
```


### MySQL Create Batch Database

```
1. docker exec -ti ecommerce-service-mysql57 bash
2. mysql -u root -p
3. root
4. mysql> CREATE DATABASE ecommerce_service_batch DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Mysql 접속 정보

* host / port: `localhost:3306`
* username: `root`
* password: `root`

### Data Migration (flyway)

최초로 마이그레이션을 실행할 때는 전체 데이터베이스를 초기화 할 수 있습니다.

```
[맥, 리눅스 환경]
./flyway-migration.sh

[윈도우 환경]
./flyway-migration.bat
```
