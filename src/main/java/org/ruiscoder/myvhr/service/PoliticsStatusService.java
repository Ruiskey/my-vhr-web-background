package org.ruiscoder.myvhr.service;

import org.ruiscoder.myvhr.mapper.PoliticsStatusMapper;
import org.ruiscoder.myvhr.model.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsStatusService {
    @Autowired
    PoliticsStatusMapper politicsStatusMapper;
    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsStatusMapper.getAllPoliticsStatus();
    }
}
