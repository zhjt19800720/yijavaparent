package com.yijava.common.mapper;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 借助Cxf对Jax生成接口的工具类
 * 
 * @author vincent
 *
 */
@SuppressWarnings("unchecked")
public class JaxWsFactoryBeanMapper {
	
	//Ws代理工厂
	private JaxWsProxyFactoryBean jaxWsProxyFactoryBean;
	
	//Ws动态客服端工厂
	private JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();

	/**
	 * 共组奥方法
	 */
	public JaxWsFactoryBeanMapper() {
		this.jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
	}
	
	/**
	 * 创建实例
	 * 
	 * @return {@link JaxWsFactoryBeanMapper}
	 */
	public static JaxWsFactoryBeanMapper newInstance() {
		return new JaxWsFactoryBeanMapper();
	}
	
	/**
	 * 根据serviceClass类型和ws地址,创建一个可以调用的接口类
	 * 
	 * <pre>
	 * 例子:
	 * WebService ws = JaxWsProxyFactoryBeanMapper.newInstance().getProxyFactoryBean(WebService.class,"http://192.168.0.63:8080/CXF_Server_01/cxf/WebService");
	 * ws.method();
	 * </pre>
	 * 
	 * @param serviceClass ws的接口类
	 * @param address ws地址
	 * 
	 * @return Object
	 */
	public <T> T getProxyFactoryBean(Class<T> serviceClass,String address) {
		jaxWsProxyFactoryBean.setServiceClass(serviceClass);
		jaxWsProxyFactoryBean.setAddress(address);
		return (T) jaxWsProxyFactoryBean.create(); 
	}
	
	/**
	 * 执行web service方法
	 * <pre>
	 * 例子:
	 * Object result = JaxWsProxyFactoryBeanMapper.newInstance().invokeDynamicMethod("http://192.168.0.63:8080/CXF_Server_01/cxf/WebService","method");
	 * System.out.println(result[0]);
	 * </pre>
	 * 
	 * @param wsdlUrl web service地址
	 * @param operationName 要执行的方法名
	 * @param params 方法中的参数值
	 * 
	 * @return Object[]
	 * 
	 * @throws Exception
	 */
	public Object[] invokeDynamicMethod(String wsdlUrl, String operationName, Object...params) throws Exception {
		return createDynamicClient(wsdlUrl).invoke(operationName, params);
	}
	
	/**
	 * 创建动态客户端对象
	 * 
	 * @param wsdlUrl web service地址
	 * 
	 * @return {@link Client}
	 */
	public Client createDynamicClient(String wsdlUrl) {
		return jaxWsDynamicClientFactory.createClient(wsdlUrl);
	}
	
	/**
	 * 获取Jax代理工厂
	 * 
	 * @return {@link JaxWsProxyFactoryBean}
	 */
	public JaxWsProxyFactoryBean getJaxWsProxyFactoryBean() {
		return jaxWsProxyFactoryBean;
	}

	/**
	 * 获取Jax动态客服端工厂
	 * 
	 * @return {@link JaxWsDynamicClientFactory}
	 */
	public JaxWsDynamicClientFactory getJaxWsDynamicClientFactory() {
		return jaxWsDynamicClientFactory;
	}
	
	
}
