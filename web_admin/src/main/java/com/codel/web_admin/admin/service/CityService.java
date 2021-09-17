package com.codel.web_admin.admin.service;


import com.codel.web_admin.admin.bean.City;


public interface CityService {

     City getById(Long id);

     void saveCity(City city);

}
