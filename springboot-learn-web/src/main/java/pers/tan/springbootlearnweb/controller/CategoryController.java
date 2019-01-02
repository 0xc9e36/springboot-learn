package pers.tan.springbootlearnweb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.tan.springbootlearnweb.mapper.CategoryMapper;
import pers.tan.springbootlearnweb.pojo.Category;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

//    @RequestMapping("listCategory")
//    public String listCategory(Model model) {
//        List<Category> list = categoryMapper.findAll();
//        model.addAttribute("cs", list);
//        return "listCategory";
//    }


    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size, "id desc");
        List<Category> list = categoryMapper.findAll();
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        model.addAttribute("page", pageInfo);
        return "listCategory";
    }

    @RequestMapping(value = "categories", method = RequestMethod.POST)
    public String addCategory(Category category) {
        categoryMapper.save(category);
        return "redirect:categories";
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.PUT)
    public String updateCategory(Category category) {

        System.out.println("小明挖");

        categoryMapper.update(category);
        return "redirect:/categories";
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public String getCategory(@PathVariable("id") int id,Model m) {
        Category category = categoryMapper.get(id);
        m.addAttribute("c", category);
        return "editCategory";
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("id") int id) {
        categoryMapper.delete(id);
        return "redirect:/categories";
    }

    @RequestMapping(value = "insert", method = RequestMethod.PUT)
    public String insert(@RequestBody Category category) {
        System.out.println("haha");
        categoryMapper.save(category);
        return "success1";
    }
}


