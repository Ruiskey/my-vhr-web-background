package org.ruiscoder.myvhr.service;

import org.ruiscoder.myvhr.mapper.HrMapper;
import org.ruiscoder.myvhr.model.Hr;
import org.ruiscoder.myvhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在！！");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs() {
        //将当前用户的Id传过去
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId());
    }
}
