# mybatis-samples
A project with demo of mybatis capabilities with spring framework based on http://www.mybatis.org/spring/index.html

H2 database is used in demo samples because of ease of use

# Project structure
Project structure is simple. Basically it is a maven project:
- Samples under `src/main/java/org.mybatis.samples`
- Custom factory builder implementation under `src/main/java/org.mybatis.samples.factory`
- Annotation based mapper under `src/main/java/org.mybatis.samples.mappers`
- Model Transaction class with two fields under `src/main/java/org.mybatis.samples.model`
- Services for Dao under `src/main/java/org.mybatis.samples.service`
- XML based mapper under `src/main/java/org.mybatis.samples.xml` and mapper config under `src/main/resources/mybatis/mappers/mybatis.xml`

Resources
- DB scripts with test tables and data `src/main/resources/db-scripts`
- Mybatis xml configuration under `src/main/resources/mybatis/config`
- Spring application contexts used in the samples under `src/main/resources/mybatis`
- Log4j configuration under `src/main/resources/log4j.xml`

# Pom.xml
Libraries: mybatis, mybatis spring, spring framework, spring jdbc for spring jdbc migrations, commons-dbcp2 for database connection pool, h2 file based database for ease of db usage, log4j logging (possibility to configure) via slf4j.

# Logging
MyBatis provides logging information through the use of an internal log factory. The internal log factory will delegate logging information to one of the following log implementations:
- SLF4J
- Apache Commons Logging
- Log4j 2
- Log4j
- JDK logging

# Building project
`mvn clean install`

# Running samples
Samples are located under `src/main/java/org.mybatis.samples` directly
- SpringMyBatisCustomSqlSessionFactoryExample
- SpringMyBatisExample
- SpringMyBatisMapperConfigExample
- SpringMyBatisScanConfigurerExample
- SpringMyBatisScanExample

No parameters required. Just run the main method in the class

`Comments in the files and logging should be sufficient to play with samples to see results and experiment with annotated and xml mappers, caching, sql invocations`

# Samples
`SpringMyBatisCustomSqlSessionFactoryExample` - example with usage custom factory builder in order to
initialize sqlSessionFactory based on mybatis config file and properties and use one of data sources based on environment

`SpringMyBatisExample` - basic example with xml mapper with caching capabilities

`SpringMyBatisMapperConfigExample` - example with using mapper for annotated class with CRUD operations

`SpringMyBatisScanConfigurerExample` - example with locating annotated mappers via scanConfigurer with caching capabilities

`SpringMyBatisScanExample` - example with using scan configuration for scanning annotation based mappers
