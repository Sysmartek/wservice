package br.com.wservices.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

public class GpvWSHelper {

	public static String gerarSchemaJSON(Class clazz) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);

		SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		mapper.acceptJsonFormatVisitor(mapper.constructType(clazz), visitor);
		String schemaJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(visitor.finalSchema());
		return schemaJson;
	}

}
