package org.ruiscoder.vhr.mapper;

import org.ruiscoder.vhr.model.Mail_Send_Log;

public interface Mail_Send_LogMapper {
    int insert(Mail_Send_Log record);

    int insertSelective(Mail_Send_Log record);
}