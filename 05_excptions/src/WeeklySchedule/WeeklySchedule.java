package WeeklySchedule;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class WeeklySchedule {
    private LocalDate startDay;
    private Duration partDuration;
    private int partCount;
    public final static int PARTS_START_TIME = 7;
    public final static DayOfWeek[] WEEK_DAYS = {DayOfWeek.SATURDAY, DayOfWeek.SUNDAY, DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
         DayOfWeek.THURSDAY, DayOfWeek.FRIDAY};
    private Map<DayOfWeek, String[]> schedule;

    public WeeklySchedule(LocalDate startDay, Duration partDuration, int partCount) {
        this.startDay = startDay;
        this.partCount = partCount;
        this.partDuration = partDuration;
        this.schedule = new HashMap<>();

        for(DayOfWeek day: WEEK_DAYS) {
            this.schedule.put(day, new String[partCount]);
        }
    }

    public boolean setPartForDay(DayOfWeek day, int index, String partName) {
        String[] parts = this.schedule.get(day);
        if(parts[index] != null)
            return false;
        parts[index] = partName;
        this.schedule.put(day, parts);
        return true;
    }

    public String getPartForDay(DayOfWeek day, int index) {
        return this.schedule.get(day)[index];
    }

    public LocalTime getTimeOfPartInDay(String partName, DayOfWeek day) {
        String[] parts = this.schedule.get(day);
        for(int i = 0; i < this.partCount; i++) {
            if(parts[i].equals(partName)){
                return LocalTime.of(PARTS_START_TIME, 0).plus(this.partDuration.multipliedBy(i));
            }
        }
        return null;
    }

    public LocalDateTime getDateTimeForPart(String partName) {
        for(int i = 0; i < WEEK_DAYS.length; i++) {
            LocalTime time = this.getTimeOfPartInDay(partName, WEEK_DAYS[i]);
            if(time != null) {
                return this.startDay.plusDays(i).atTime(time);
            }
        }
        return null;
    }

    public Duration getLongestFreeTimeInDay(DayOfWeek day) {
        int max = 0;
        String[] parts = this.schedule.get(day);

        for(int i = 0; i < this.partCount; i++) {
            int len = 0;
            for(len = 0; i + len < this.partCount && parts[i + len] == null; len++);
            if(len > max)
                max = len;
        }
         return this.partDuration.multipliedBy(max);
    }
}
