package com.convotis.converter.model;

/**
 * Factory class to instantiate correct Converter Class for selected file types
 */
public class ConverterFactory {

	/**
	 * creates specific converter Class
	 *
	 * @param fromFileType
	 * @param toFileType
	 * @return
	 */
	public static ConverterIntf getConverter(ConvertableFileType fromFileType, ConvertableFileType toFileType){
		switch (fromFileType){
			case JSON:
				switch (toFileType){
					case CSV:
						return new JsonToCsvConverter();
				}

		}
		return null;
	}


}
