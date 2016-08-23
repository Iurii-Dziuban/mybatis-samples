package org.mytabis.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.samples.mappers.TransactionAnnotationDao;
import org.mybatis.samples.model.Transaction;
import org.mybatis.samples.service.TransactionAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Example with usage of an annotation mapper with CRUD operations
 *
 * Look into the logs for the details.
 * Invocations of TransactionAnnotationDao with caches 1 level with sql session, 2 level within different sessions
 *
 * TransactionMapper with Type TransactionAnnotationDao is used. However in the application-context transactionMapper is
 * of type org.mybatis.spring.mapper.MapperFactoryBean . It works because actually proxy is created
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis/application-context-mapper-config.xml"})
public class SpringMyBatisMapperConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {

        TransactionAnnotationService transactionService = applicationContext.getBean(TransactionAnnotationService.class);

        Transaction transactionToBeInserted = new Transaction();
        transactionToBeInserted.setName("DeutchePost");

        transactionService.getTransactionAnnotationDao().findAll();
        // check caching works
        transactionService.getTransactionAnnotationDao().findAll();
        transactionService.getTransactionAnnotationDao().insertTransaction(transactionToBeInserted);
        transactionService.getTransactionAnnotationDao().updateTransactionById(2, "Bill Gates");
        transactionService.getTransactionAnnotationDao().deleteTransactionById(3);

        TransactionAnnotationDao transactionAnnotationMapper = applicationContext.getBean("transactionAnnotationMapper", TransactionAnnotationDao.class);
        transactionAnnotationMapper.findAll();

    }
}
