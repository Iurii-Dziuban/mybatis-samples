package org.mybatis.samples.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.mybatis.samples.model.Transaction;

import java.util.List;

/**
 * Created by iurii.dziuban on 19.07.2016.
 */

/**
 * Annotations based mapping with CRUD operations on transactions object
 */

/**
 * Case1: Caching of 2nd level. @CacheNamespace
 * (1 level within session and is enable by default, 2 level for different sessions)
 */

/* Case2: To run with readWrite=true Transaction class should be serializable. Try to run with (readWrite=true)
* Transaction not Serializable exception will be thrown
*/

/**
 * Case3: By default mapping to results (@Results) is done by name column <-> property. If they are different use @Results
 * Try to change id -> id1 for example and run. Inspect the exception is thrown, because of impossibility to map.
 */

/**
 * Case4: Mapping parameters to named parameters inside sql queries, done via (@Param) with name to be bind to.
 */
@CacheNamespace(eviction = FifoCache.class, flushInterval=60000, size=512, readWrite=false)
public interface TransactionAnnotationDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
    })
    @Select("SELECT * FROM TRANSACTIONS")
    List<Transaction> findAll();

    @Insert("INSERT INTO TRANSACTIONS (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "ID", keyColumn = "ID")
    void insertTransaction(Transaction transaction);

    @Delete("DELETE FROM TRANSACTIONS where id = #{id}")
    void deleteTransactionById(@Param(value = "id") int id);

    @Delete("UPDATE TRANSACTIONS set name = #{name} WHERE id = #{id}")
    void updateTransactionById(@Param(value = "id") int id, @Param(value = "name") String newName);

}
