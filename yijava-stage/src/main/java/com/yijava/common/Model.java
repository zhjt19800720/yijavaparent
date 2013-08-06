package com.yijava.common;

import java.io.Serializable;
import java.util.Map;

import com.google.common.collect.Maps;

public class Model implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 561299843507002456L;

	private Map<String, Object> modelMap;

	public Model() {
		modelMap = Maps.newHashMap();
	}
	
	 /**
     * 设置属性，
     * @param <T>
     * @param key
     * @param value
     */
    public void setProperty(String key, Object value) {
        if( value != null){//设置的value不为空的时候，才去处理
            modelMap.put(key, value);
        }//如果值为空，直接返回，不处理
    }
    
    public void setProperty(Enum<?> key, Object value) {
        this.setProperty(key.toString(), value);
    }
    
    /**
     * 获得已有的属性，如果为空，返回null
     * @param <T>
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProperty(String key){
        return (T) modelMap.get(key);
    }
    
    /**
     * 获得已有的属性，如果为空，返回null
     * @param <T>
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProperty(Enum<?> key){
        return (T) getProperty(key.toString());
    }
    
    
    /**
     * 清空某属性
     * @param key
     */
    public void clearProperty(String key){
        modelMap.remove(key);
    }
    
    /**
     * 是否含有某个属性
     * @param key
     * @return
     */
    public boolean containsKey(String key) {
        return modelMap.containsKey(key);
    }
    
    /**
     * 是否含有某个属性
     * @param key
     * @return
     */
    public boolean containsKey(Enum<?> key) {
        return this.containsKey(key.toString());
    }
    
    /**
     * 通过Key清空某个属性
     * @param key
     */
    public void eraseProperty(String key){
        if (containsKey(key)){
            modelMap.remove(key);
        }
    }

    /**
     * 是否包括某个值
     * @param value
     * @return
     */
    public boolean containsValue(Object value) {
        return modelMap.containsValue(value);
    }
        
   
    /**
     * 只有在所有值设置好了之后，才能调用，否则会抛非法参数异常
     * 检查 扩展属性 已经设置完毕，如果还没有设置，抛出异常
     * @param keys 需要被检查的Keys
     * @return 是否合法
     */
    public boolean checkRequiredFilled(String... keys) {
        if (keys.length == 0) {// 如果没有传进来任何key，表示没有必须的key
            return true;
        }

        if (getData() == null || getData().isEmpty()) {// 如果数据Map为空
            return false;
        }

        for (String key : keys) {// keys 如果没有传任何值，也不会为空，是一个 长度为0的空数组
            if (!getData().containsKey(key)) {// 如果不包含Key
                return false;
            }
            if (getData().get(key) == null) {// 如果该Key 的值为空，都不是合法的
                return false;
            }
        }
        return true;
    }

    public Map<String, Object> getData() {
        return modelMap;
    }
    
    @Override
    public String toString() {
        return this.modelMap.toString();
    }
    
    /**
     * 检查参数是否已经设置完毕,如果没有设置完毕，应该是不能进行下面发送邮件的操作
     * @return
     */
    public boolean isRequiredFilled(){
        return true;
    }
    
        
    /**
     * Save the state of the <tt>ArrayList</tt> instance to a stream (that
     * is, serialize it).
     *
     * @serialData The length of the array backing the <tt>ArrayList</tt>
     *             instance is emitted (int), followed by all of its elements
     *             (each an <tt>Object</tt>) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream out)
        throws java.io.IOException{
        
        
        out.defaultWriteObject();
        out.writeInt(modelMap.size());
        for (Map.Entry<String, Object> entry : modelMap.entrySet()) {
            out.writeObject(entry.getKey());
            out.writeObject(entry.getValue());
        }
    }

    /**
     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream in)
        throws java.io.IOException, ClassNotFoundException {
       
        // Read in size, and any hidden stuff
        in.defaultReadObject();

        
        int size = in.readInt();
      
        
        for (int i = 0; i < size; i++) {
            String key = (String) in.readObject();
            Object value = in.readObject();
            modelMap.put(key, value);
        }
    }
    
    @Override
    public int hashCode() {
        return modelMap.hashCode();
    }
    
  
    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getMessage());
        }
    }

}
