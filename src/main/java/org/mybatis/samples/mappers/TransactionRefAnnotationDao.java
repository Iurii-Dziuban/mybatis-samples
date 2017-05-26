package org.mybatis.samples.mappers;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.samples.model.Transaction;

import java.util.List;

/**
 * Created by iurii.dziuban on 19.07.2016.
 *
 * Example of referencing to other cache configuration
 */
@CacheNamespaceRef(value = TransactionAnnotationDao.class/*, name = "org.mybatis.samples.mappers.TransactionAnnotationDao"*/)
public interface TransactionRefAnnotationDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
    })
    @Select("SELECT * FROM TRANSACTIONS")
    List<Transaction> findAll();
}
