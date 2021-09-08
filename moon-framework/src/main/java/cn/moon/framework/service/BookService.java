package cn.moon.framework.service;

import cn.moon.framework.entity.Book;
import cn.moon.framework.entity.Category;
import cn.moon.framework.mapper.BookMapper;
import cn.moon.framework.mapper.CategoryMapper;
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

    public List<Book> search(String keywords) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", keywords).or().like("author", keywords);
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
