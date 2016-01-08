package com.kwi.mposlogger;

import java.sql.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends PagingAndSortingRepository<MPOS_LOGGER, Long> {
    
    //Set<Log> findByDateRange(Date d1,Date d2);
    
    @Query(value = "SELECT * FROM MPOS_LOGGER p WHERE p.message_lg like :pattern", nativeQuery = true)
    Set<MPOS_LOGGER> searchNativelyDate(@Param("pattern") String pattern);
    
  //  @Query(value = "FROM MPOS_LOGGER p WHERE p.message_lg like :pattern")
  //  Set<Log> search(@Param("pattern") String pattern);
    
    @Query(value = "SELECT * FROM MPOS_LOGGER", nativeQuery = true)
    Set<MPOS_LOGGER> searchNatively();
}
    
    
