package it.prova.raccoltafilmspringbootservletspringdata.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Utility {

	public static Date parseDateFromString(String dataDiNascitaStringParam) {
		if (StringUtils.isBlank(dataDiNascitaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataDiNascitaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
	public static Integer parseNumberIntegerFromString(String numberStringParam) {
		if (!StringUtils.isBlank(numberStringParam)){
			if (NumberUtils.isCreatable(numberStringParam)) {
				return Integer.parseInt(numberStringParam);
			}
		}return null;
	}
	public static Long parseNumberLongFromString(String numberStringParam) {
		if (!StringUtils.isBlank(numberStringParam)){
			if (NumberUtils.isCreatable(numberStringParam)) {
				return Long.parseLong(numberStringParam);
			}
		}return null;
	}
}
