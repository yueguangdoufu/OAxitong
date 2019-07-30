package com.rimi.ls.oa.dao;

import com.rimi.ls.oa.pojo.Document;
import com.rimi.ls.oa.utils.BaseDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class DocumentDaoTest extends BaseDao {

    private DocumentDao dao;

    @Before
    public void inti(){
        dao = new DocumentDao();
    }

    @Test
    public void selectTest(){
        String sql = "select * from document";
        List<Document> list = dao.selectAll(sql,Document.class);
        Assert.assertEquals(0,list.size());
    }
}