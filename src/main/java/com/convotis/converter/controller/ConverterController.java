package com.convotis.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.convotis.converter.model.ConvertableFileType;
import com.convotis.converter.model.ConverterException;
import com.convotis.converter.service.ConverterService;

@RestController
public class ConverterController {

	@Autowired
	private ConverterService converterService;

	@RequestMapping(value = "/converter/json2csv", method = RequestMethod.POST)
	public @ResponseBody String convertFromJsonToCsv(@RequestParam String fromValue){
		String csvReturnValue = null;
		try {
			csvReturnValue = converterService.convert(fromValue, ConvertableFileType.JSON, ConvertableFileType.CSV);
		}catch (ConverterException e){
			//TODO exception handling
			e.printStackTrace();
		}
		return  csvReturnValue;
	}


}
