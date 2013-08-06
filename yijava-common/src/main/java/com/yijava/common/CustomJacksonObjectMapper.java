package com.yijava.common;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.util.StdDateFormat;

public class CustomJacksonObjectMapper extends ObjectMapper {

	public CustomJacksonObjectMapper() {
		super();
		this.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, false);
		this.configure(
				JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
		this.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);

		SerializationConfig serializationConfig = this.getSerializationConfig();
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

		this.setSerializationConfig(serializationConfig);

	}
}
