## Problem 2:Code Snippets Demonstrating Inheritance and Exceptions

### Author: Qiyuan Zhu

### Date: 5/28/2024

### Summary
#### Inheritance
In this problem, the inheritance is not directly used.

#### Exception
In the code, we use exception handling to manage various error conditions. 
For example, in the Locker class:
```
public Locker(int maxWidth, int maxHeight, int maxDepth) {
    if (maxWidth > 15 || maxHeight > 25 || maxDepth > 10) {
      throw new IllegalArgumentException("Invalid locker dimensions.");
    }
```
We use IllegalArgumentException to handle invalid dimensions and attempts to add mail items that exceed the size limits.


Another example is:
```
public mailItem(Recipient someRecipient, int width, int depth, int height) {
    if (width < 1.5 || depth < 1 || height < 2) {
      throw new IllegalArgumentException("Invalid mail item dimensions.");
    }
```
In the 'mailItem' class, we use 'Exception' to handle those invalid dimensions
for a certain mail item. 