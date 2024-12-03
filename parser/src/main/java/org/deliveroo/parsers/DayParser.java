package org.deliveroo.parsers;

import static org.deliveroo.utlis.CronConstants.DAY_OF_MONTH;

public class DayParser extends BaseParser {
    public DayParser() {
        super(1, 31, DAY_OF_MONTH);
    }
}
