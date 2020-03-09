package com.pankaj.restapidemo.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Utility {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

	public static String getCurrentTimestamp(long currentTimeMillis) {
		String currentTimestamp = "";

		try {
			currentTimestamp = sdf.format(new Timestamp(currentTimeMillis));
		} catch (Exception e) {
			log.debug(Constants.EXCEPTION + e.toString()); // printStackTrace();
		}
		return currentTimestamp;
	}

}
