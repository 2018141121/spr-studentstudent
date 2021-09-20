package com.codel.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codel.mybatis_plus.mapper.LeaveMapper;
import com.codel.mybatis_plus.pojo.Leave;
import com.codel.mybatis_plus.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public boolean saveBatch(Collection<Leave> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Leave> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Leave> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Leave entity) {
        return false;
    }

    @Override
    public Leave getOne(Wrapper<Leave> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Leave> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Leave> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Leave> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Leave> getEntityClass() {
        return null;
    }
}
