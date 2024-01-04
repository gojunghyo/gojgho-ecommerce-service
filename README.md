# Ecommerce-side-project 

## 모듈 구조
todo


## 개발환경 구성


### Download And [Docker](https://www.docker.com/get-started) Install
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

1. 최초로 마이그레이션을 실행할 때는 전체 데이터베이스를 초기화 할 수 있습니다.
2. 이후부터는 `flywayMigrate` 만 실행하여 테스트 데이터는 남겨두고 계속 DB 스키마만 변경할 수 있습니다.

```
[맥, 리눅스 환경]
./flyway-migration.sh

[윈도우 환경]
./flyway-migration.bat
```

### flyway-migration 실행후 아래와 같이 Data가 들어왔다면 셋팅 완료
![local_db_flyway](https://github.com/gojunghyo/gojgho-ecommerce-service/assets/128199051/b756a4df-ac1c-4760-ac50-86066bd2c21a)


### Swagger 주소
1. http://localhost:9090/swagger-ui/index.html
