# 1. Input validation
```
public static void main(String[] args) {
    WaterAthlete testcase = new WaterAthlete("Vincent", "1989-11-20", 145.0, 135.0);
    try{
        testcase.validateWeight(testcase.getWeight());
    catch (InvalidAthleteInformationException e){
        System.out.println(e.getMessage());   
```
# 2. Inheritance
```
public class Swimmer extends WaterAthlete{
......
super(athletesName, dateOfBirth, height, weight);
```
# 3. Overriding
```
@Override
  public String toString() {
    return "Diver{" +
        "favoriteDivingLocation='" + favoriteDivingLocation + '\'' +
        ", dateOfDivingCertification=" + dateOfDivingCertification +
        ", athletesName=" + athletesName +
        ", dateOfBirth=" + dateOfBirth +
        ", height=" + height +
        ", weight=" + weight +
        '}';
  }
```
# 4. Casting
```
......
Diver diver = (Diver) o;
......
```
# 5. Exception throwing
```
private Boolean validateWeight(Double weight) throws InvalidAthleteInformationException {
    if ((WEIGHT_MIN < weight) && (weight <= WEIGHT_MAX))
      return Boolean.TRUE;
    else throw new InvalidAthleteInformationException("This is not a valid weight for this sports discipline!");
  }
```