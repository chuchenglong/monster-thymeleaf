package com.mc.dao;

import com.mc.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChenglongChu
 * @description 书籍仓库，repository，数据存储
 * @create 2017/11/23 14:54
 * @since v0.1
 */
@Repository
public interface ReadingListDao extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
