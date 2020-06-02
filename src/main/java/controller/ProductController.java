package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductManager;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductManager productManager;


    @GetMapping("/")
    public ModelAndView showList() {
        List<Product> list = productManager.getAll();
        ModelAndView modelAndView = new ModelAndView("showList");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/product/add")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("showAdd");
        modelAndView.addObject("product", new Product());
        return modelAndView;

    }

    @PostMapping("/product/addProduct")
    public String addProduct(@ModelAttribute Product product){
        productManager.add(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    ModelAndView showEditForm(@PathVariable int id){
        Product product = productManager.get(id);
        ModelAndView modelAndView = new ModelAndView("showEdit");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @PostMapping("/product/edit")
    String editProduct(@ModelAttribute Product product){
        productManager.update(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    ModelAndView showDeleteForm(@PathVariable int id){
        Product product = productManager.get(id);
        ModelAndView modelAndView = new ModelAndView("showDelete");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @PostMapping("/product/delete")
    String deleteProduct(@ModelAttribute Product product){
        productManager.delete(product);
        return "redirect:/";
    }
}
