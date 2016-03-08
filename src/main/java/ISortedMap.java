import java.util.Comparator;

/**
 *
 *  Created by user on 03.03.2016.
 */
public interface ISortedMap<KeyType,ValueType>{

    enum Order{
        ASC,DESC
    }
    ISortedMap<KeyType,ValueType> sort(Comparator<? super ValueType > comp);






}
