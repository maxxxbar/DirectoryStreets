package utils;

import entities.Item;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StreetSet {
    private static final int START_INDEX = 2;
    public static final String ITEM_TAG_VALUE = "item";
    public static final String CITY_ATTRIBUTE_VALUE = "city";
    public static final String STREET_ATTRIBUTE_VALUE = "street";
    public static final String HOUSE_ATTRIBUTE_VALUE = "house";
    public static final String FLOOR_ATTRIBUTE_VALUE = "floor";
    private final File file;
    private final Set<Item> itemSet;
    private final Map<Item, Integer> repeatingItems;
    private final DocumentBuilderFactory documentBuilderFactory;

    public StreetSet(@Nullable File file) {
        this.file = file;
        itemSet = new HashSet<>();
        repeatingItems = new HashMap<>();
        documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
    }

    private Item createItemFromElement(Element element) {
        String cityName = element.getAttribute(CITY_ATTRIBUTE_VALUE);
        String street = element.getAttribute(STREET_ATTRIBUTE_VALUE);
        String house = element.getAttribute(HOUSE_ATTRIBUTE_VALUE);
        String floor = element.getAttribute(FLOOR_ATTRIBUTE_VALUE);
        return new Item(cityName, street, house, floor);
    }

    private NodeList createNodeList() throws IOException, SAXException, ParserConfigurationException, IllegalArgumentException {
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        return document.getElementsByTagName(ITEM_TAG_VALUE);
    }

    private void findRepeatedItems(Node node) {
        Element element = (Element) node;
        Item item = createItemFromElement(element);
        boolean added = itemSet.add(item);
        if (!added) {
            boolean exists = repeatingItems.containsKey(item);
            if (!exists) {
                repeatingItems.put(item, START_INDEX);
            } else {
                int index = repeatingItems.get(item);
                repeatingItems.put(item, ++index);
            }
        }
    }

    public Set<Item> getData() {
        try {
            NodeList nodeList = createNodeList();
            for (int i = 0; i <= nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    findRepeatedItems(node);
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException | IllegalArgumentException exception) {
            System.out.println(exception.getLocalizedMessage());
        } catch (NullPointerException nullPointerException) {
            System.out.println("Finished reading");
        }
        return itemSet;
    }

    public Map<Item, Integer> getRepeatingItems() {
        return repeatingItems;
    }

}
