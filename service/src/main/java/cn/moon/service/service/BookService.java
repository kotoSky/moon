package cn.moon.service.service;

import cn.moon.service.entity.Book;
import cn.moon.service.entity.Category;
import cn.moon.service.mapper.BookMapper;
import cn.moon.service.mapper.CategoryMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CategoryMapper categoryMapper;


    public List<Book> list() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return bookMapper.selectList(queryWrapper);
    }

    public void addOrUpdate(Book book) {
        bookMapper.insert(book);
    }

    public void deleteById(int id) {
        bookMapper.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryMapper.selectById(cid);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid", category.getId());
        return bookMapper.selectList(queryWrapper);
    }

}
