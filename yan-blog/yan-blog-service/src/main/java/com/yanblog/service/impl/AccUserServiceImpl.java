package com.yanblog.service.impl;

import com.yanblog.model.dao.AccUserMapper;
import com.yanblog.model.domain.AccUser;
import com.yanblog.model.domain.AccUserExample;
import com.yanblog.service.AccUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xujingyan on 2017/12/13.
 */
@Service
public class AccUserServiceImpl implements AccUserService {

    @Autowired
    private AccUserMapper accUserMapper;

    @Override
    public int countByExample(AccUserExample example) {
        return accUserMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long accUserId) {
        return accUserMapper.deleteByPrimaryKey(accUserId);
    }

    @Override
    public int insert(AccUser record) {
        return accUserMapper.insert(record);
    }

    @Override
    public int insertSelective(AccUser record) {
        return accUserMapper.insertSelective(record);
    }

    @Override
    public List<AccUser> selectByExample(AccUserExample example) {
        return accUserMapper.selectByExample(example);
    }

    @Override
    public AccUser selectByPrimaryKey(Long accUserId) {
        return accUserMapper.selectByPrimaryKey(accUserId);
    }

    @Override
    public int updateByPrimaryKeySelective(AccUser record) {
        return accUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AccUser record) {
        return accUserMapper.updateByPrimaryKey(record);
    }
}
