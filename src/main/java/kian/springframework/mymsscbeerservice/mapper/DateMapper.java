package kian.springframework.mymsscbeerservice.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author Kian
 * @created 4/2/2023 - 9:30 AM
 */
@Component
public class DateMapper {

    public OffsetDateTime asOffsetDAteTime(Timestamp ts) {
        if (ts == null)
            return null;
        return OffsetDateTime.of(
                ts.toLocalDateTime().getYear(),
                ts.toLocalDateTime().getMonthValue(),
                ts.toLocalDateTime().getDayOfMonth(),
                ts.toLocalDateTime().getHour(),
                ts.toLocalDateTime().getMinute(),
                ts.toLocalDateTime().getSecond(),
                ts.toLocalDateTime().getNano(),
                ZoneOffset.UTC
        );
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null)
            return null;
        return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
    }
}
