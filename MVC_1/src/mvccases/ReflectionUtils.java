package mvccases;
 
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
 
public class ReflectionUtils {
 
    /**
     * 通过反射获得Class中声明的父类的泛型参数类型
     * @param clazz
     * @param <T>
     * @return
     */
    public static<T> Class<T> getSuperGenericType(Class clazz){
        return getSuperGenericType(clazz, 0);
    }
 
    /**
     * 通过反射，获得定义Class时声明的父类的泛型参数的类型
     * @param clazz
     * @param index
     * @param <T>
     * @return
     */
    public static Class getSuperGenericType(Class clazz, int index) {
        //获得父类泛型类型
        Type genType = clazz.getGenericSuperclass();
 
        //未被参数化
        if(!(genType instanceof ParameterizedType)){
            return Object.class;
        }
 
        //当被参数化之后 获取实际的泛型类型参数数组 注意括号
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
 
        if(index >= params.length || index < 0){
            return Object.class;
        }
 
        if(!(params[index] instanceof Class)){
            return Object.class;
        }
        return (Class)params[index];
 
    }
}
