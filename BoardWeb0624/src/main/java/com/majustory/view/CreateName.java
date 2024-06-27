package com.majustory.view;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateName {
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
	String k = sdf.format(now);

	int ran=(int)(Math.random()*100)+101 ;
}
