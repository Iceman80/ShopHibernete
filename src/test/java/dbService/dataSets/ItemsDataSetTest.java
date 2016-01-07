package dbService.dataSets;

import dbService.HibernateUtil;
import org.junit.Test;


public class ItemsDataSetTest {
ItemDataSet serviceItem = new ItemDataSet();
    @Test
    public void testAddItem() throws Exception {
        System.out.println(serviceItem.addItem("iPad","планшет",5,13000.3,"шт"));
        System.out.println(serviceItem.addItem("iPhone5","смартфон",11,9000.65,"шт"));
        System.out.println(serviceItem.addItem("MacBookPro","ноутбук",2,53000.00,"шт"));

        System.out.println(serviceItem.itemContains("iPad"));;

        System.out.println(serviceItem.readAllItems());

        Items items = serviceItem.getItemForQuanity("MacBookPro");
        items.setUnit(1);
        items.setPrice(60000.50);
        serviceItem.updateItem(items);

        System.out.println(serviceItem.getItemForQuanity("MacBookPro"));

        System.out.println(serviceItem.itemDel("MacBookPro"));

        System.out.println(serviceItem.readAllItems());

        HibernateUtil.shutdown();
    }
}