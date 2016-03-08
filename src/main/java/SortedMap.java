import java.util.Comparator;

public class SortedMap<KeyType,ValueType> extends HashMap<KeyType,ValueType>
        implements ISortedMap {

    private int[] depthOfEachIndexInMap;

    @Override
    public ISortedMap<KeyType, ValueType> sort(Comparator comp) {
        depthOfEachIndexInMap = getDepthOfEachIndexInMap();
        Element<KeyType,ValueType>[] elementsInMap = mapToArray();
        Element<KeyType,ValueType>[] sortedElements =  bubbleSort(elementsInMap,comp);
        fillSortedMap(sortedElements);

        return null;
    }
    @Override
    public ValueType get(KeyType key) throws NullKeyException{
        if (key == null) {
            throw new NullKeyException();
        }
        int i = 0;
        if (table[0] == null) {
            return null;
        }
        Element<KeyType, ValueType> tmpElement = table[0];
        while (i < table.length) {
            if (table[i] != null && table[i].getKey() == key)
                return table[i].getValue();
            if (table[i] != null && table[i].getNextElement() == null && table[i].getKey() == key) {
                return table[i].getValue();
            }
            if (table[i] != null && table[i].getNextElement() != null && table[i].getKey() != key) {
                ValueType foundedElement = findValueOfKeyInChilds(key, i);
                if (foundedElement != null) {
                    return foundedElement;
                }
            }
            i++;
        }
        return null;
    }

    protected ValueType findValueOfKeyInChilds(KeyType key, int i) throws NullKeyException {
        if (key == null) {
            throw new NullKeyException();
        }
        Element<KeyType, ValueType> tmpElement = table[i];
        while (tmpElement.getNextElement() != null) {
            if (tmpElement.getKey() == key)
                return tmpElement.getValue();
            else
                tmpElement = tmpElement.getNextElement();
        }
        return null;
    }

    public Element<KeyType,ValueType>[] mapToArray(){
        if(size() != 0){
            Element<KeyType,ValueType> tmpElement ;
            Element<KeyType,ValueType>[] arrayOfElements = new Element[size()];
            int j=0;
            for(int i=0;i<INITIAL_CAPACITY;i++) {
                tmpElement = table[i];
                arrayOfElements[j] = tmpElement;
                j++;
                while (tmpElement.getNextElement() != null) {
                    arrayOfElements[j] = tmpElement.getNextElement();
                    tmpElement = tmpElement.getNextElement();
                    j++;
                }
            }
            return arrayOfElements;
        }
        return null;
    }

    public int getDepthOfLine(Element<KeyType, ValueType> element) {
        int depth = 1;
        if (element == null) {
            return 0;
        }
        while (element.getNextElement() != null) {
            depth++;
            element = element.getNextElement();
        }
        return depth;
    }

    public int[] getDepthOfEachIndexInMap() {
        if(size() > 0) {
            int[] array = new int[table.length];
            int j = 0;
            for (Element<KeyType, ValueType> i : table) {
                array[j] = getDepthOfLine(i);
                j++;
            }
            return array;
        }
        return null;
    }
    public Element<KeyType,ValueType>[] bubbleSort(Element<KeyType, ValueType>[] inArray,Comparator comparator) {
        int out, in;
        if(inArray == null){
            return null;}
        Element<KeyType,ValueType>[] tmpInArray = null;
        for (out = inArray.length - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (comparator.compare(inArray[in],inArray[in + 1]) > 0){
                    tmpInArray = swap(inArray, in, in + 1);
                }
            }
        }
        return tmpInArray;
    }
    private Element<KeyType, ValueType>[] swap(Element<KeyType, ValueType>[] inArray, int one, int two) {
        Element<KeyType, ValueType> temp = inArray[one];
        inArray[one] = inArray[two];
        inArray[two] = temp;
        return inArray;
    }
    private void fillSortedMap(Element<KeyType,ValueType>[] sortedArray) {
        int indexInSortedArray = 0;
        for(int i =0; i< table.length;i++)
        {
            indexInSortedArray = makeChildsReference(sortedArray,i,table,indexInSortedArray);
        }
    }


    private int makeChildsReference(Element<KeyType, ValueType>[] sortedArray,
                                     int position,
                                     Element<KeyType,ValueType>[] arrayOfElementReference,
                                                              int indexInSortedArray)
    {
        int depth = depthOfEachIndexInMap[position];
        Element<KeyType, ValueType> positionInLine = arrayOfElementReference[position];
        for(int i=position;i<position + depth;i++)
        {
            if(i == position){
                arrayOfElementReference[position] = sortedArray[indexInSortedArray];
                positionInLine = arrayOfElementReference[position];
                indexInSortedArray++;}
            else{
                positionInLine.setNextElement(sortedArray[indexInSortedArray]);
                positionInLine = positionInLine.getNextElement();
                indexInSortedArray++;
                if(i == (position + depth) - 1)
                {
                    positionInLine.setNextElement(null);
                }
            }

        }
        return indexInSortedArray;
    }
}
