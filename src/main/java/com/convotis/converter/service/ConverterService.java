package com.convotis.converter.service;


import org.springframework.stereotype.Service;

import com.convotis.converter.model.ConvertableFileType;
import com.convotis.converter.model.ConverterException;
import com.convotis.converter.model.ConverterFactory;
import com.convotis.converter.model.ConverterIntf;

@Service
public class ConverterService {

	public String convert(String fromValue, ConvertableFileType fromFileType, ConvertableFileType toFileType) throws ConverterException {

		//get specific converter implementation class
		ConverterIntf converter = ConverterFactory.getConverter(fromFileType, toFileType);
		if (converter == null){
			//undefined conversion -> throw error
			throw new ConverterException("Undefined Converter. Please check fromFileType and toFileType.");
		}

		//do conversion
		return converter.convert(fromValue);

	}

}
