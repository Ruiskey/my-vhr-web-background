package org.ruiscoder.myvhr.service;

import org.ruiscoder.myvhr.mapper.NationMapper;
import org.ruiscoder.myvhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
