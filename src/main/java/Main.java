/**
 *
 *  Created by user on 03.03.2016.
 */
public class Main{

    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new MyHashMap();
        //SortedMap<String, Integer> map = new SortedMap<String, Integer>();
//        map.put(null,20);
//        for(int i=0;i<4;i++){
//            map.put(i,i+i);
//        }
////        map.
//        printWholeMap(map);

    }
    static void printWholeMap(HashMap map){
        for (int i = 0; i<map.size();i++)
            try {
                System.out.println("key:"+i+" value:"+map.get(i));
            } catch (NullKeyException e) {
                e.printStackTrace();
            }
    }

}