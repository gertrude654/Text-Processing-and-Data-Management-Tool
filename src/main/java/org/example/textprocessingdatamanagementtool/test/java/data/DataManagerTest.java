package org.example.textprocessingdatamanagementtool.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataManagerTest {

    private DataManager<String> dataManager;

    @BeforeEach
    void setUp() {
        dataManager = new DataManager<>();
    }

    // List operations tests
    @Test
    void testAddToList() {
        dataManager.addToList("item1");
        List<String> list = dataManager.getArrayList();
        assertEquals(1, list.size());
        assertTrue(list.contains("item1"));
    }

    @Test
    void testUpdateList() {
        dataManager.addToList("item1");
        dataManager.updateList(0, "item2");
        List<String> list = dataManager.getArrayList();
        assertEquals(1, list.size());
        assertEquals("item2", list.get(0));
    }

    @Test
    void testDeleteFromList() {
        dataManager.addToList("item1");
        dataManager.deleteFromList(0);
        List<String> list = dataManager.getArrayList();
        assertTrue(list.isEmpty());
    }

    @Test
    void testClearList() {
        dataManager.addToList("item1");
        dataManager.clearList();
        List<String> list = dataManager.getArrayList();
        assertTrue(list.isEmpty());
    }

    @Test
    void testFindInList() {
        dataManager.addToList("item1");
        assertTrue(dataManager.findInList("item1"));
        assertFalse(dataManager.findInList("item2"));
    }

    // Set operations tests
    @Test
    void testAddToSet() {
        dataManager.addToSet("item1");
        Set<String> set = dataManager.getHashSet();
        assertEquals(1, set.size());
        assertTrue(set.contains("item1"));
    }

    @Test
    void testUpdateSet() {
        dataManager.addToSet("item1");
        dataManager.updateSet("item1", "item2");
        Set<String> set = dataManager.getHashSet();
        assertEquals(1, set.size());
        assertTrue(set.contains("item2"));
    }

    @Test
    void testDeleteFromSet() {
        dataManager.addToSet("item1");
        dataManager.deleteFromSet("item1");
        Set<String> set = dataManager.getHashSet();
        assertTrue(set.isEmpty());
    }

    @Test
    void testClearSet() {
        dataManager.addToSet("item1");
        dataManager.clearSet();
        Set<String> set = dataManager.getHashSet();
        assertTrue(set.isEmpty());
    }

    @Test
    void testFindInSet() {
        dataManager.addToSet("item1");
        assertTrue(dataManager.findInSet("item1"));
        assertFalse(dataManager.findInSet("item2"));
    }

    // Map operations tests
    @Test
    void testAddToMap() {
        dataManager.addToMap("key1", "value1");
        Map<String, String> map = dataManager.getHashMap();
        assertEquals(1, map.size());
        assertEquals("value1", map.get("key1"));
    }

    @Test
    void testUpdateMap() {
        dataManager.addToMap("key1", "value1");
        dataManager.updateMap("key1", "value2");
        Map<String, String> map = dataManager.getHashMap();
        assertEquals(1, map.size());
        assertEquals("value2", map.get("key1"));
    }

    @Test
    void testDeleteFromMap() {
        dataManager.addToMap("key1", "value1");
        dataManager.deleteFromMap("key1");
        Map<String, String> map = dataManager.getHashMap();
        assertTrue(map.isEmpty());
    }

    @Test
    void testClearMap() {
        dataManager.addToMap("key1", "value1");
        dataManager.clearMap();
        Map<String, String> map = dataManager.getHashMap();
        assertTrue(map.isEmpty());
    }

    @Test
    void testFindInMap() {
        dataManager.addToMap("key1", "value1");
        assertTrue(dataManager.findInMap("key1"));
        assertFalse(dataManager.findInMap("key2"));
    }
}
