package ru.nvy.springmvc.dao.item;

import org.springframework.stereotype.Component;
import ru.nvy.springmvc.model.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NVY
 */
@Component
public class ItemDAO {
    private static int ITEM_COUNT;
    private  List<Item> items;
    {
        //блок инициализации
        items = new ArrayList<>();
        items.add(new Item(++ITEM_COUNT, 500, "Paper"));
        items.add(new Item(++ITEM_COUNT, 35, "Pencil"));
        items.add(new Item(++ITEM_COUNT, 60, "Pen"));
        items.add(new Item(++ITEM_COUNT, 130, "Pen-box"));
    }
    public List<Item> index(){
        return items;
    }

    public Item show(int id){
        //лямбда выражение
        //найти человека по id если не нашли вернуть null
        return items.stream().filter(items->items.getId() == id).findAny().orElse(null);
    }

    public void save(Item item){
        item.setId(++ITEM_COUNT); // устанавливаем Id, ибо человек не должен сам вводить id
        items.add(item);
    }

    public void update(int id, Item updateItem){
        Item itemToBeUpdated = show(id);
        itemToBeUpdated.setCost(updateItem.getCost());
        itemToBeUpdated.setName(updateItem.getName());
    }

    public void delete(int id){
        items.removeIf(item->item.getId() == id);
    }
}
