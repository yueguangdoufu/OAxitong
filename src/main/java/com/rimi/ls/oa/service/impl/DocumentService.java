package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.DocumentDao;
import com.rimi.ls.oa.dao.RegulationDao;
import com.rimi.ls.oa.pojo.Document;
import com.rimi.ls.oa.pojo.Regulation;
import com.rimi.ls.oa.service.IDocumentService;
import com.rimi.ls.oa.service.IRegulationService;

import java.util.List;

public class DocumentService implements IDocumentService {

    private DocumentDao dao;

    public DocumentService() {
        this.dao = new DocumentDao();
    }

    @Override
    public List<Document> findAll() {
        String sql = "select * from document";
        List<Document> userList = dao.selectAll(sql, Document.class);
        return userList;
    }


    @Override
    public boolean deleteDocumentById(int id) {
        String sql="delete from document where id=?";
        int delete = dao.delete(sql, id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertDocument(Document document) {
        String sql="insert into document(title,content,file,name,up_time) value(?,?,?,?,?)";
        String[] param={document.getTitle(),document.getContent(),document.getFile(),document.getName(),document.getUp_time()};
        int insert = dao.insert(sql, param);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDocument(Document document) {
        String sql="update document set title=?,content=?,file=?,name=?,up_time=? where id=?";
        String[] param={document.getTitle(),document.getContent(),document.getFile(),document.getName(),document.getUp_time(),document.getId()+""};
        int update = dao.update(sql, param);
        if(update>0){
            return true;
        }

        return false;
    }
}
