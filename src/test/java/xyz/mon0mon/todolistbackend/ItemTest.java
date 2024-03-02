package xyz.mon0mon.todolistbackend;


import org.junit.jupiter.api.Test;
import xyz.mon0mon.todolistbackend.item.entity.Item;

public class ItemTest {
    @Test
    public void ItemInitTest() {
        Item item = Item.builder()
                .build();
    }
}
