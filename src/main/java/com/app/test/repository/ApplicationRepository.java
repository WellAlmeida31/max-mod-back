package com.app.test.repository;

import com.app.test.domain.MaxMod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends JpaRepository<MaxMod, Long> {

    @Query("select case when count(m) > 0 then true " +
            "else false end " +
            "from MaxMod m " +
            "where m.x = :x " +
            "and m.y = :y " +
            "and m.n = :n")
    boolean existMaxMod(@Param("x") int x, @Param("y") int y, @Param("n") int n);
}
