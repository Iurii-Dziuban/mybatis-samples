# mybatis-samples
A project with mybatis capabilities with spring framework based on http://www.mybatis.org/spring/index.html

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

# Samples
SpringMyBatisCustomSqlSessionFactoryExample - example with usage custom factory builder in order to
initialize sqlSessionFactory based on mybatis config file and properties and use one of data sources based on environment

SpringMyBatisExample - basic example with xml mapper

SpringMyBatisMapperConfigExample - example with using mapper for annotated class with CRUD operations

SpringMyBatisScanConfigurerExample - example with locating annotated mappers via scanConfigurer with caching capabilities

SpringMyBatisScanExample - example with using scan configuration for scanning annotation based mappers
