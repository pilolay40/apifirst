package com.apifirst.test.price.infrastruture.db.repository;

import com.apifirst.test.price.infrastruture.db.entity.PriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.List;

public interface SpringDataPriceRepository extends CrudRepository<PriceEntity, Long> {

    @Query(value = "select * from PRICES where BRAND_ID =:brandId AND PRODUCT_ID =:productId AND START_DATE <=to_date(:applyDate,'YYYY-MM-DD HH24:MI:SS') AND END_DATE >=to_date(:applyDate,'YYYY-MM-DD HH24:MI:SS')", nativeQuery = true)
    List<PriceEntity> findPriceByProductIdAndBrandIdAndApplyDate(@Param("productId") Integer productId,
                                                                 @Param("brandId") Integer brandId,
                                                                 @Param("applyDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Timestamp applyDate);

}
