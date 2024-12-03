package org.deliveroo.parsers;

import static org.deliveroo.utlis.CronConstants.HOUR;

public class HourParser extends BaseParser {
    public HourParser() {
        super(0, 23, HOUR);
    }
}