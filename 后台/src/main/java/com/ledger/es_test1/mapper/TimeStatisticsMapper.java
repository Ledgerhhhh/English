package com.ledger.es_test1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ledger.es_test1.domain.TimeStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TimeStatisticsMapper extends BaseMapper<TimeStatistics> {


    List<TimeStatistics> getRecentTime(@Param("days") Integer days);
}
