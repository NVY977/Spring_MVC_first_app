package ru.nvy.springmvc.controllers.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nvy.springmvc.dao.item.ItemDAO;
import ru.nvy.springmvc.model.item.Item;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemDAO itemDAO;

    @Autowired
    public ItemsController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //получаем все предметы из DAO и передаем все в представление
        model.addAttribute("items", itemDAO.index());
        return "items/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //получаем конкретный предмет по id из DAO и передаем в представление
        model.addAttribute("item", itemDAO.show(id));
        return "items/show";
    }

    @GetMapping("/new")
    public String newItem(Model model){
        model.addAttribute("item", new Item());
        return "items/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("item") Item item){
        itemDAO.save(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("item", itemDAO.show(id));
        return "items/edit";
    }

    @PatchMapping("/{id}")
    public String Update(@ModelAttribute("item") Item item, @PathVariable("id") int id){
        itemDAO.update(id, item);
        return "redirect:/items";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        itemDAO.delete(id);
        return "redirect:/items";
    }
}
