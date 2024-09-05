package problem_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {
    private Delivery delivery;
    private Time startTime;
    private Time endTime;

    @BeforeEach
    void setUp() {
        // convert to seconds: 4830 secs
        startTime = new Time(1, 20, 30);
        // convert to seconds: 8548 secs
        endTime = new Time(2, 22, 28);
        delivery = new Delivery("405 Ave", "123 Main street", startTime, endTime);
    }

    @Test
    void getDuration() {
        Time Duration = delivery.getDuration();
        assertEquals(1, Duration.getHour());
        assertEquals(1, Duration.getMinute());
        assertEquals(58, Duration.getSecond());
    }

    @Test
    void getStartLocation() {
        assertEquals("405 Ave", delivery.getStartLocation());
    }

    @Test
    void setStartLocation() {
        delivery.setStartLocation("205 Ave");
        assertEquals("205 Ave", delivery.getStartLocation());
    }

    @Test
    void getEndLocation() {
        assertEquals("123 Main street", delivery.getEndLocation());
    }

    @Test
    void setEndLocation() {
        delivery.setEndLocation("145 Main Street");
        assertEquals("145 Main Street", delivery.getEndLocation());
    }

    @Test
    void getStartTime() {
        assertEquals(startTime, delivery.getStartTime());
    }

    @Test
    void setStartTime() {
        startTime = new Time(2, 30, 40);
        delivery.setStartTime(startTime);
        assertEquals(startTime, delivery.getStartTime());
    }

    @Test
    void getEndTime() {
        assertEquals(endTime, delivery.getEndTime());
    }

    @Test
    void setEndTime() {
        endTime = new Time(3, 22, 28);
        delivery.setEndTime(endTime);
        assertEquals(endTime, delivery.getEndTime());
    }

    @Test
    void testInvalidDuration() {
        Time invalidEndTime = new Time(1, 33, 28);
        Delivery invalidDelivery = new Delivery("205 Ave", "145 Main street", startTime, invalidEndTime);
        assertThrows(IllegalArgumentException.class, invalidDelivery::getDuration);
    }

}