package com.yijava.orm.core;

/**
 * 所有约束名称
 * 
 * @author vincent
 *
 */
public interface RestrictionNames {
	
	/**
	 * 等于查询（from Object o where o.property = ?）
	 */
	public static String EQ = "EQ";
	
	/**
	 * 非等于查询（from Object o where o.property <> ?）
	 */
	public static String NE = "NE";
	
	/**
	 * 大于等于查询（from Object o where o.property >= ?）
	 */
	public static String GE = "GE";
	
	/**
	 * 大于查询（from Object o where o.property > ?）
	 */
	public static String GT = "GT";
	
	/**
	 * 小于等于查询（from Object o where o.property <= ?）
	 */
	public static String LE = "LE";
	
	/**
	 * 小于查询（from Object o where o.property < ?）
	 */
	public static String LT = "LT";
	
	/**
	 * 包含查询（from Object o where o.property in(?,?,?)）
	 */
	public static String IN = "IN";
	
	/**
	 * 非包含查询（from Object o where o.property not in(?,?,?)）
	 */
	public static String NIN = "NIN";
	
	/**
	 * 左模糊查询（from Object o where o.property like %?）
	 */
	public static String LLIKE = "LLIKE";
	
	/**
	 * 右模糊查询（from Object o where o.property like ?%)
	 */
	public static String RLIKE= "RLIKE";
	
	/**
	 * 模糊查询（from Object o where o.property like %?%)
	 */
	public static String LIKE = "LIKE";
}
