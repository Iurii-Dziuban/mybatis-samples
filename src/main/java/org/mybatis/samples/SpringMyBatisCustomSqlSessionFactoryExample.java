package org.mybatis.samples;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.samples.mappers.TransactionAnnotationDao;
import org.mybatis.samples.model.Transaction;
import org.mybatis.samples.service.TransactionService;
import org.mybatis.samples.xml.TransactionDao;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by iurii.dziuban on 02.08.2016.
 */

/**
 * Example with custom sql session factory in order to read mybatis config and apply settings from there.
 * Like settings for specific environment like datasource, etc.
 *
 * Look into the logs for the details.
 * Invocations of TransactionDao with caches 1 level with sql session, 2 level within different sessions
 *
 * TransactionMapper with Type TransactionDao is used. However in the application-context transactionMapper is
 * of type org.mybatis.spring.mapper.MapperFactoryBean . It works because actually proxy is created
 */

public class SpringMyBatisCustomSqlSessionFactoryExample {

    private static Logger LOGGER = LoggerFactory.getLogger(SpringMyBatisCustomSqlSessionFactoryExample.class);

    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:mybatis/application-context-custom-sql-session-factory.xml"});

        SqlSessionFactory sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);
        SqlSession session = sqlSessionFactory.openSession();

        // checking session cache 1 level
        session.getMapper(TransactionDao.class).findAll();
        session.getMapper(TransactionDao.class).findAll();

        session.close();
        LOGGER.debug("Session closed");

        TransactionService transactionService = applicationContext.getBean(TransactionService.class);

        // checking cache 2 level configuration
        transactionService.getTransactionDao().findAll();
        transactionService.getTransactionDao().findAll();

        // Working because proxy is used
        TransactionDao transactionMapper = applicationContext.getBean("transactionMapper", TransactionDao.class);
        transactionMapper.findAll();
    }
}
