package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.NewsDao;
import com.rimi.ls.oa.dao.RegulationDao;
import com.rimi.ls.oa.pojo.News;
import com.rimi.ls.oa.pojo.Regulation;
import com.rimi.ls.oa.service.INewService;
import com.rimi.ls.oa.service.IRegulationService;

import java.util.List;

public class RegulationService implements IRegulationService {

    private RegulationDao dao;

    public RegulationService() {
        this.dao = new RegulationDao();
    }

    @Override
    public List<Regulation> findAll() {
        String sql = "select * from regulation";
        List<Regulation> userList = dao.selectAll(sql, Regulation.class);
        return userList;
    }


    @Override
    public boolean deleteRegulationById(int id) {
        String sql="delete from regulation where id=?";
        int delete = dao.delete(sql, id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertRegulation(Regulation regulation) {
        String sql="insert into regulation(file) value(?)";
        String[] param={regulation.getFile()};
        int insert = dao.insert(sql, param);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRegulation(Regulation regulation) {
        String sql="update regulation set file=? where id=?";
        String[] param={regulation.getFile()};
        int update = dao.update(sql, param);
        if(update>0){
            return true;
        }

        return false;
    }
}
