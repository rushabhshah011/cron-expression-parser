package org.deliveroo.parsers;

import static org.deliveroo.utlis.CronConstants.DAY_OF_WEEK;

public class WeekParser extends BaseParser {
    public WeekParser() {
        super(0, 6, DAY_OF_WEEK);
    }
}