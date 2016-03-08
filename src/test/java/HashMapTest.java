import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Created by user on 04.03.2016.
 */
public class HashMapTest {

    @Before
    public void setUp() throws Exception{
        MyHashMap<String, Integer> map = new MyHashMap<String,Integer>();
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        map.put("BlaBla3",13);
        map.put("BlaBla4",111);
        map.put("BlaBla4",13);
        map.put("BlaBla4",12);
        map.put("BlaBla5",144);
        map.put("BlaBla6",136);
        map.put("BlaBla7",12);
        map.put("BlaBla8",144);
        map.put("BlaBla9",136);
    }
    @Test
    public void testIsEmptyEmptyMap() throws Exception {
        MyHashMap<String,Integer> hashMap = new MyHashMap<String, Integer>();
        assertEquals(hashMap.isEmpty(),true);
    }
    @Test
    public void testIsEmptySingleElement() throws Exception {
        MyHashMap<String,Integer> hashMap = new MyHashMap<String, Integer>();
        hashMap.put("seven",7);
        assertEquals(hashMap.isEmpty(), false);
    }

    @Test(expected=NullKeyException.class)
    public void testPutShouldThrowNullKeyException() throws NullKeyException {
        //given
        HashMap<Integer,Integer> map = new MyHashMap();
        map.put(1,1);

        //then
        map.put(null, 2);
    }

    @Test(expected=NullKeyException.class)
    public void testRemoveShouldThrowNullKeyException() throws NullKeyException {
        //given
        HashMap<Integer,Integer> map = new MyHashMap();
        map.put(1,1);

        //then
        map.remove(null);
    }

    @Test(expected=NullKeyException.class)
    public void testFindElementShouldThrowNullKeyException() throws NullKeyException {
        //given
        HashMap<Integer,Integer> map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);

        //then
        map.findElement(null);
    }

    @Test(expected=NullKeyException.class)
    public void testHashShouldThrowNullKeyException() throws NullKeyException {
        //given
        HashMap<Integer,Integer> map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);

        //then
        map.hash(null);
    }


}