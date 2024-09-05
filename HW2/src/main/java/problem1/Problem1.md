## Problem 1:Code Snippets Demonstrating Inheritance and Exceptions

### Author: Qiyuan Zhu

### Date: 5/28/2024

### Summary
#### Inheritance
In the code for the catering company's booking system, inheritance is used to create specific types
of events (Brunch and Dinner) from a general Event class. Here is an example of
how inheritance is implemented:

```
public class Brunch extends Event {
```

The 'Brunch' class inherits from the 'Event' class, which encapsulates the general information of an
event. The Event class includes the following
fields:

```
scheduleDate - LocalDate, representing event's date using built-in data type
schedulePerson - String, representing the name of the scheduler
numAttendees - Int, representing the number of attendees
```

By inheriting from the Event class, Brunch class leverage these common fields to maintain
consistency in event details.
In addition to inheriting these fields, the Brunch class introduce its own specific fields to
capture details unique to a brunch event.

```
 private final int omelets;
 private final int pancakes;
 private final int fruitBowls;
```

#### Exception
In this demo, exception is used to handle various error conditions. For example:
```
if (numAttendees < 15 || numAttendees > 75) {
      throw new IllegalArgumentException(
          "Number of attendees for a dinner event must be between 15 and 75.");
          }
```
In the code above, The 'Dinner' constructor checks if the numebr of attendees is within the allowed range.

If not, it throws an IllegalArgumentException.