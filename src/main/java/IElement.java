/**
 *
 * Created by user on 03.03.2016.
 */
public interface IElement<TypeKey,TypeValue> {

    /**
     *  Method return key of element.
     * @return return key of element.
     */
    TypeKey getKey();

    /**
     * Method return value of element.
     * @return return value of element.
     */
    TypeValue getValue();

//    /**
//     *
//     * @param key
//     * @return
//     */
//    boolean setKey(TypeKey key);

    /**
     * Method setValue to element.
     * @param value value of element;
     * @return return true if value was set;
     */
    boolean setValue(TypeValue value);

}