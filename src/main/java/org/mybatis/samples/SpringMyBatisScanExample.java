package org.mybatis.samples;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.samples.mappers.TransactionAnnotationDao;
import org.mybatis.samples.model.Transaction;
import org.mybatis.samples.service.TransactionAnnotationService;
import org.mybatis.samples.service.TransactionService;
import org.mybatis.samples.xml.TransactionDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Example with usage of an annotation mapper which is created via scan packages functionality
 * <mybatis:scan base-package="org.mybatis.samples.mappers" />
 *
 * Using dao directly and via sqlSessionFactory
 *
 * Look into the logs for the details.
 * Invocations of TransactionAnnotationDao with caches 1 level with sql session, 2 level within different sessions
 *
 * TransactionMapper with Type TransactionAnnotationDao is used. However in the application-context transactionMapper is
 * of type org.mybatis.spring.mapper.MapperFactoryBean . It works because actually proxy is created
 */
public class SpringMyBatisScanExample {

    public static void main( String[] args ) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:mybatis/application-context-scan.xml"});

        SqlSessionFactory sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);
        SqlSession session = sqlSessionFactory.openSession();
        session.getMapper(TransactionDao.class).findAll();
        session.getMapper(TransactionDao.class).findAll();
        session.close();


        TransactionAnnotationDao transactionAnnotationDao = applicationContext.getBean(TransactionAnnotationDao.class);
        transactionAnnotationDao.findAll();
        transactionAnnotationDao.findAll();
    }
}
