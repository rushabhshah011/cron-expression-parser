package org.deliveroo.parsers;

import static org.deliveroo.utlis.CronConstants.MINUTE;

public class MinuteParser extends BaseParser {
    public MinuteParser() {
        super(0, 59, MINUTE);
    }
}
