package com.codel.web_admin.admin.service.impl;


import com.codel.web_admin.admin.bean.City;
import com.codel.web_admin.admin.mapper.CityMapper;
import com.codel.web_admin.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("cityService.saveCity.count");
    }


    public City getById(Long id) {
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);

    }
}
