package ru.perm.v.family.simplejava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumTest {
    /**
     * Enum  можно рассматривать как особый вид класса Java. Enum обладает рядом уникальных особенностей, таких как:
     * Возможность реализации интерфейсов;
     * Собственное пространство имен;
     * Неявная реализация интерфейсов Serializable и Comparable;
     * Для сравнения значений Enum можно использовать операторы == и equals()
     */
    @Test
    public void testValueOf() {
        enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
        ;

        assert (Day.MONDAY == Day.valueOf("MONDAY"));
        assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
        // или так:
        assertEquals(Day.MONDAY, Enum.valueOf(Day.class, "MONDAY"));
    }

    @Test
    public void testOrdinal() {
        enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
        ;

        assertEquals(4, Day.FRIDAY.ordinal());
    }

    @Test
    public void testGetName() {
        enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
        ;

        assertEquals("FRIDAY", Day.FRIDAY.name());
    }

    @Test
    public void exceptionOnNonValue() {
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }
        ;
        boolean isException = false;

        try {
            Day.valueOf("NON_EXISTENT");
        } catch (IllegalArgumentException e) {
            isException = true;
        }

        assertTrue(isException);
    }

    @Test
    public void testEquals() {
        enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
        ;

        assertEquals(Day.FRIDAY, Day.FRIDAY);
    }

    @Test
    public void testSwitch() {
        enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
        Day currentDay = Day.FRIDAY;
        boolean result = false;

        switch (currentDay) {
            case MONDAY:
                result = false;
                break;
            case TUESDAY:
                result = false;
                break;
            case WEDNESDAY:
                result = false;
                break;
            case THURSDAY:
                result = false;
                break;
            case FRIDAY:
                result = true;
                break;
        }

        assertTrue(result);
    }
}
