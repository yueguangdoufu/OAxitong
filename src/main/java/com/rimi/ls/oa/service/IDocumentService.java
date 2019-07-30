package com.rimi.ls.oa.service;

import com.rimi.ls.oa.pojo.Document;

import java.util.List;

public interface IDocumentService {

    //查询所有用户
    List<Document> findAll();

    //删除用户
    boolean deleteDocumentById(int id);
    //插入用户
    boolean insertDocument(Document document);
    //修改用户
    boolean updateDocument(Document document);

}
