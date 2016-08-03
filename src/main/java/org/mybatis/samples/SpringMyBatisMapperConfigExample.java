package org.mybatis.samples;

import org.mybatis.samples.mappers.TransactionAnnotationDao;
import org.mybatis.samples.model.Transaction;
import org.mybatis.samples.service.TransactionAnnotationService;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example with usage of an annotation mapper
 *
 * Look into the logs for the details.
 * Invocations of TransactionAnnotationDao with caches 1 level with sql session, 2 level within different sessions
 *
 * TransactionMapper with Type TransactionAnnotationDao is used. However in the application-context transactionMapper is
 * of type org.mybatis.spring.mapper.MapperFactoryBean . It works because actually proxy is created
 */
public class SpringMyBatisMapperConfigExample {

    public static void main( String[] args ) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:mybatis/application-context-mapper-config.xml"});

        TransactionAnnotationService transactionService = applicationContext.getBean(TransactionAnnotationService.class);

        Transaction transactionToBeInserted = new Transaction();
        transactionToBeInserted.setName("DeutchePost");

        transactionService.getTransactionAnnotationDao().findAll();
        transactionService.getTransactionAnnotationDao().findAll();
        transactionService.getTransactionAnnotationDao().insertTransaction(transactionToBeInserted);
        transactionService.getTransactionAnnotationDao().updateTransactionById(2, "Bill Gates");
        transactionService.getTransactionAnnotationDao().deleteTransactionById(3);

        TransactionAnnotationDao transactionAnnotationMapper = applicationContext.getBean("transactionAnnotationMapper", TransactionAnnotationDao.class);
        transactionAnnotationMapper.findAll();

    }
}
