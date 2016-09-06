package org.mybatis.samples.mappers;

import org.mybatis.samples.model.Transaction;

import java.util.List;

/**
 * Created by iurii.dziuban on 18.07.2016.
 */

/**
 * Dao based on XML mapping
 */
public interface TransactionDao {

    List<Transaction> findAll();

    void insertTransaction(Transaction transaction);
}
