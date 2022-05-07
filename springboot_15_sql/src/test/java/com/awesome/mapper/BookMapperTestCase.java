package com.awesome.mapper;

import com.awesome.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class BookMapperTestCase {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void testSelectById() {
        System.out.println(bookMapper.selectById(1));
    }

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "select * from book";
        /*List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }*/

        RowMapper<Book> rm = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDescription(rs.getString("description"));
                book.setType(rs.getString("type"));

                return book;
            }
        };

        List<Book> books = jdbcTemplate.query(sql, rm);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void testJdbcTemplateInsert(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "insert into book values(2, 'education', 'education', 'education')";
        jdbcTemplate.update(sql);
    }
}
