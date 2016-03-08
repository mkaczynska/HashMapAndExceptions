/**
 *
 * Head interface of HashMap implementation.
 */
public interface IMap<KeyType,ValueType>{

    /**
     * Method delete all Elements in Hashmap.
     */
    void clear();

    /**
     * Method returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key
     */
    ValueType get(KeyType key) throws NullKeyException;

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings.
     */
    boolean isEmpty();

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return true or false if value with key is added or not.
     */
    Element put(KeyType key, ValueType value)throws NullKeyException;

    /**
     * Returns the number of key-value mappings in this map.
     * @return Returns the number of key-value mappings in this map.
     */
    int size();

    /**
     *  Removes the mapping for the specified key from this map if present.
     * @param key key whose mapping is to be removed from the map
     * @return true if there was no mapping for key
     */
    boolean remove(KeyType key) throws NullKeyException;


}