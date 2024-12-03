package org.deliveroo.parsers;

import static org.deliveroo.utlis.CronConstants.MONTH;

public class MonthParser extends BaseParser {
    public MonthParser() {
        super(1, 12, MONTH);
    }
}