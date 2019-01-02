package pers.tan.springbootlearnweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.tan.springbootlearnweb.mapper.CategoryMapper;
import pers.tan.springbootlearnweb.pojo.Category;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearnWebApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void test() {
        List<Category> cs=  categoryMapper.findAll();
        for (Category c : cs) {
            System.out.println("c.getName():"+ c.getName());
        }

    }

}

