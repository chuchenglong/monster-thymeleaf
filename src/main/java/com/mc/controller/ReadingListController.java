package com.mc.controller;

import com.mc.dao.ReadingListDao;
import com.mc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ChenglongChu
 * @description 书籍列表控制器
 * @create 2017/11/23 14:52
 * @since v0.1
 */
@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    @Autowired
    private ReadingListDao readingListDao;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListDao.findByReader(reader);
        if (null != readingList)
            model.addAttribute("books", readingList);
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListDao.save(book);
        return "redirect:/readingList/{reader}";
    }
}
