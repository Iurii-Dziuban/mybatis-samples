package org.mybatis.samples.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by iurii.dziuban on 02.08.2016.
 */

/**
 * Custom implementation of the SqlSessionFactoryBuilder in order to use all config data from config file
 * Default values are provided and can be overridden
 */
public class CustomSqlSessionFactoryBuilder {

    private String configFile = "mybatis/config/mybatis-config.xml";
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    private String environment = "development";

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public void setSqlSessionFactoryBuilder(SqlSessionFactoryBuilder sqlSessionFactoryBuilder) {
        this.sqlSessionFactoryBuilder = sqlSessionFactoryBuilder;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * Factory method to create session factory based on config,
     * environment from config and properties file to populate parameters in config ${param}
     */
    public SqlSessionFactory create() {
        InputStream inputStream = null;
        Properties properties = null;
        try {
            inputStream = Resources.getResourceAsStream(configFile);
            properties = Resources.getResourceAsProperties("mybatis/config/mybatis.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSessionFactoryBuilder.build(inputStream, environment, properties);
    }
}
