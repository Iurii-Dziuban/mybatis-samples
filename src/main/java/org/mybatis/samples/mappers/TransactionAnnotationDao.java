package org.mybatis.samples.mappers;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.mybatis.samples.cache.CustomDefaultCache;
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
@CacheNamespace(implementation = CustomDefaultCache.class, eviction = FifoCache.class, flushInterval=60000, size=512, readWrite=false,
properties = {@Property(name = "stringProperty", value = "${stringProperty}"),
        @Property(name = "integerProperty", value = "${integerProperty}")}
)
public interface TransactionAnnotationDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
    })
    @Select("SELECT * FROM TRANSACTIONS")
    List<Transaction> findAll();

    /* Example of using default method in the interface*/
    default List<Transaction> defaultFindAll() {
        return findAll();
    }

    @Insert("INSERT INTO TRANSACTIONS (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertTransaction(Transaction transaction);

    @Delete("DELETE FROM TRANSACTIONS where id = #{id}")
    void deleteTransactionById(@Param(value = "id") int id);

    @Delete("UPDATE TRANSACTIONS set name = #{name} WHERE id = #{id}")
    void updateTransactionById(@Param(value = "id") int id, @Param(value = "name") String newName);

}
