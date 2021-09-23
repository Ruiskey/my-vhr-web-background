package org.ruiscoder.myvhr.mapper;

import org.ruiscoder.myvhr.model.Flyway_Schema_History;

public interface Flyway_Schema_HistoryMapper {
    int deleteByPrimaryKey(Integer installedRank);

    int insert(Flyway_Schema_History record);

    int insertSelective(Flyway_Schema_History record);

    Flyway_Schema_History selectByPrimaryKey(Integer installedRank);

    int updateByPrimaryKeySelective(Flyway_Schema_History record);

    int updateByPrimaryKey(Flyway_Schema_History record);
}
