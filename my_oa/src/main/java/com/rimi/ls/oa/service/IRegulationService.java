package com.rimi.ls.oa.service;

import com.rimi.ls.oa.pojo.Regulation;

import java.util.List;

public interface IRegulationService {

    //查询所有用户
    List<Regulation> findAll();

    //删除用户
    boolean deleteRegulationById(int id);
    //插入用户
    boolean insertRegulation(Regulation regulation);
    //修改用户
    boolean updateRegulation(Regulation regulation);

}
