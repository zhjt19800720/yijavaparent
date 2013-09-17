package com.yijava.common;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.util.StdDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.Assert;

public class JacksonObjectMapperFactory implements FactoryBean<ObjectMapper> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 使用国际标准化组织的<a href="http://zh.wikipedia.org/wiki/ISO_8601" >国际标准ISO</a>
	 * 8601是日期和时间的表示方法，全称为
	 * 《数据存储和交换形式·信息交换·日期和时间的表示方法》。目前是第三版ISO8601:2004以替代第一版ISO8601:1988
	 * 与第二版ISO8601:2000
	 */

	private ObjectMapper objectMapper;

	private List<JsonSerializer<?>> jsonSerializers = new ArrayList<JsonSerializer<?>>(
			5);

	// private JsonSerializer<StoreId> jsonStoreIdSerializer;
	//
	// public void setJsonStoreIdSerializer(JsonSerializer<StoreId>
	// jsonStoreIdSerializer) {
	// this.jsonStoreIdSerializer = jsonStoreIdSerializer;
	// }

	/**
	 * 设置自定义的Json序列化类
	 * 
	 * @param jsonSerializers
	 */
	public void setJsonSerializers(List<JsonSerializer<?>> jsonSerializers) {
		Assert.notNull(jsonSerializers,
				"you must set the json serilizers for Objectmppaer facotry.");
		this.jsonSerializers = jsonSerializers;
	}

	@Override
	public ObjectMapper getObject() throws Exception {
		if (objectMapper != null) {
			// logger.debug("==========return a object mapper================ with address: {}"
			// , objectMapper);
			return objectMapper;
		}
		// final JsonFactory factory = new JsonFactory();
		// factory.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
		objectMapper = new ObjectMapper();

		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,
				true);
		objectMapper
				.configure(
						JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,
						true);
		objectMapper.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT,
				false);

		SerializationConfig serializationConfig = objectMapper
				.getSerializationConfig();
		serializationConfig = serializationConfig
				.withSerializationInclusion(Inclusion.NON_NULL);
		serializationConfig = serializationConfig.withDateFormat(StdDateFormat
				.getBlueprintISO8601Format());
		serializationConfig = serializationConfig
				.without(Feature.WRITE_DATES_AS_TIMESTAMPS);
		serializationConfig = serializationConfig
				.without(Feature.WRITE_NULL_MAP_VALUES);// 禁止Map的空值序列化
		serializationConfig = serializationConfig
				.without(Feature.FAIL_ON_EMPTY_BEANS);

		objectMapper.setSerializationConfig(serializationConfig);

		DeserializationConfig deserializationConfig = objectMapper
				.getDeserializationConfig();
		deserializationConfig = deserializationConfig
				.without(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		deserializationConfig = deserializationConfig
				.without(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES);//
		deserializationConfig = deserializationConfig
				.with(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		objectMapper.setDeserializationConfig(deserializationConfig);

		// 添加对地理Point的序列化类
		SimpleModule module = new SimpleModule("Map Point Serializer",
				new Version(1, 0, 0, "Final"));

		// if(jsonStoreIdSerializer != null){
		// module.addSerializer(StoreId.class, jsonStoreIdSerializer);
		// }
		for (JsonSerializer<?> serializer : jsonSerializers) {
			logger.debug("ready to register JsonSerializer:{}", serializer);
			module.addSerializer(serializer);
		}

		objectMapper.registerModule(module);

		// logger.debug("==========return a object mapper================ with address: {}"
		// , objectMapper);
		return objectMapper;
	}

	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
