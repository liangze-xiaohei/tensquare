package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    /**
     * 审核
     * Modifying增删改操作只要是设计线程安全的都需要加
     * ?1表示参数列表中的第一个
     * @param id
     */
    @Modifying
    @Query(value = "update tb_article set state =1 where id=?1",nativeQuery = true)
    public void examine(String id);

    /**
     * 文章点赞
     */
    @Modifying
    @Query(value = "update tb_article set thumbup = thumbup+1 where id=?1",nativeQuery = true)
    public int updateThumbup(String id);
}
