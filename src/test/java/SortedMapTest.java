
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 *
 * Created by user on 04.03.2016.
 */
public class SortedMapTest {

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void shouldReturnElementOfKeyValue() throws Exception{
        //given
        SortedMap<String,Integer> map = new SortedMap<String, Integer>();
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        //when
        int valueOfGet = map.get("BlaBla");
        //then
        assertEquals(1,valueOfGet);
    }
    @Test
    public void shouldReturNullOfKeyValueIfEmptyMap() throws Exception{
        //given
        SortedMap<String,Integer> map1 = new SortedMap<String, Integer>();
        //when
        Integer valueOfGet = map1.get("BlaBla");
        //then
        assertEquals(null,valueOfGet);

    }

    @Test
    public void shouldReturnNulloFKeyValue() throws Exception{
        //given
        SortedMap<String,Integer> map = new SortedMap<String, Integer>();
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        //when
        Integer valueOfGet = map.get("ABC");
        //then
        assertEquals(null,valueOfGet);
    }
    @Test
    public void shouldReturnOneOnDepth() throws Exception{
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        map.put("BlaBla3",13);
        map.put("BlaBla4",12);
        map.put("BlaBla5",144);
        map.put("BlaBla6",136);
        map.put("BlaBla7",12);
        map.put("BlaBla8",144);
        map.put("BlaBla9",136);

        //when
        int depth = map.getDepthOfLine(map.findElement("BlaBla"));
        //then
        assertEquals(3,depth);
    }
    @Test
    public void shouldReturnZeroAsDepth() throws Exception{
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        //when
        int depth = map.getDepthOfLine(map.findElement("BlaBla"));
        //then
        assertEquals(0,depth);
    }
    @Test
    public void shouldReturnNullOfEmptyArrayDepth() throws Exception{
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        //when
        int[] depth = map.getDepthOfEachIndexInMap();
        //then
        assertEquals(null,depth);
    }
    @Test
    public void ShouldReturnArrayOfEachRowDepth() throws NullKeyException {
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        int[] array = {1,1,1,1};
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        map.put("BlaBla3",13);
        //when
        int[] depth = map.getDepthOfEachIndexInMap();
        //then
        assertArrayEquals(array, depth);
    }
    @Test
    public void ShouldOneArrayOfMapElements() throws NullKeyException {
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        map.put("BlaBla3",13);
        map.put("BlaBla4",12);
        map.put("BlaBla5",144);
        map.put("BlaBla6",136);
        map.put("BlaBla7",12);
        map.put("BlaBla8",144);
        map.put("BlaBla9",136);
        Element<String,Integer>[] arrayOfElements =  new Element[10];
        arrayOfElements[0] = map.findElement("BlaBla");
        arrayOfElements[1] = map.findElement("BlaBla4");
        arrayOfElements[2] = map.findElement("BlaBla8");
        arrayOfElements[3] = map.findElement("BlaBla1");
        arrayOfElements[4] = map.findElement("BlaBla5");
        arrayOfElements[5] = map.findElement("BlaBla9");
        arrayOfElements[6] = map.findElement("BlaBla2");
        arrayOfElements[7] = map.findElement("BlaBla6");
        arrayOfElements[8] = map.findElement("BlaBla3");
        arrayOfElements[9] = map.findElement("BlaBla7");
        //when
        Element<String,Integer>[] elements = map.mapToArray();
        //then
        assertArrayEquals(arrayOfElements,elements);
    }
    @Test
    public void shouldReturnNullForEmptyMapToArray()
    {
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        //when
        Element<String,Integer>[] elements = map.mapToArray();
        assertEquals(null,elements);
    }
    @Test
    public void shouldReturnSortedArrayByKey() throws NullKeyException {
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        map.put("BlaBla",1);
        map.put("BlaBla5",2);
        map.put("BlaBla8",14);
        map.put("BlaBla7",13);
        map.put("BlaBla4",12);
        map.put("BlaBla1",144);
        map.put("BlaBla6",136);
        map.put("BlaBla9",12);
        map.put("BlaBla2",144);
        map.put("BlaBla3",136);
        Element<String,Integer>[] arrayOfElements =  new Element[10];
        arrayOfElements[0] = map.findElement("BlaBla");
        arrayOfElements[1] = map.findElement("BlaBla1");
        arrayOfElements[2] = map.findElement("BlaBla2");
        arrayOfElements[3] = map.findElement("BlaBla3");
        arrayOfElements[4] = map.findElement("BlaBla4");
        arrayOfElements[5] = map.findElement("BlaBla5");
        arrayOfElements[6] = map.findElement("BlaBla6");
        arrayOfElements[7] = map.findElement("BlaBla7");
        arrayOfElements[8] = map.findElement("BlaBla8");
        arrayOfElements[9] = map.findElement("BlaBla9");
        Element<String,Integer>[] arrayOfElementsInMap = map.mapToArray();
        Comparator<Element<String,Integer>> compByKey = new Comparator<Element<String, Integer>>() {
            @Override
            public int compare(Element<String, Integer> o1, Element<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        //when
        Element<String,Integer>[] sortedArray = map.bubbleSort(arrayOfElementsInMap,compByKey);
        map.sort(compByKey);
        //then
        assertArrayEquals(arrayOfElements,sortedArray);
    }
    @Test
    public void shouldReturnNullForSortingEmptyArray() throws Exception{
        //given
        SortedMap<String, Integer> map = new SortedMap<String, Integer>();
        Comparator<Element<String,Integer>> compByKey = new Comparator<Element<String, Integer>>() {
            @Override
            public int compare(Element<String, Integer> o1, Element<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        Element<String,Integer>[] arrayOfElementsInMap = map.mapToArray();
        //when
        Element<String,Integer>[] sortedArray = map.bubbleSort(arrayOfElementsInMap,compByKey);
        //then
        assertArrayEquals(null,sortedArray);
    }

    @Test(expected=NullKeyException.class)
    public void testGetShouldThrowNullKeyException() throws NullKeyException {
        //given
        SortedMap<Integer,Integer> map = new SortedMap<>();
            map.put(1, 1);
            map.get(null);
    }

    @Test(expected=NullKeyException.class)
    public void testFindValueOfKeyInChildsShouldThrowNullKeyException() throws NullKeyException {
        //given
        SortedMap<Integer,Integer> map = new SortedMap<>();
        map.put(1, 1);
        map.findValueOfKeyInChilds(null, 1);
    }


}