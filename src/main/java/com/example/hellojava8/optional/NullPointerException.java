package com.example.hellojava8.optional;

public class NullPointerException {

    public static void main(String[] args) {
        try {
            String insuranceName = getInsuranceName(new Person());
            System.out.println(insuranceName);
        } catch (Exception e) {
            System.out.println("NullPointerException");
        }


        String insuranceName = getInsuranceNameByDeepDoubts(new Person());
        System.out.println(insuranceName);

        insuranceName = getInsuranceNameByMultiExit(new Person());
        System.out.println(insuranceName);
    }

    private static String getInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    //1
    private static String getInsuranceNameByDeepDoubts(Person person) {
        if (null != person) {
            Car car = person.getCar();
            if (null != car) {
                Insurance insurance = car.getInsurance();
                if (insurance != null)
                    return insurance.getName();
            }
        }
        return "UNKOWN";
    }

    //2
    private static String getInsuranceNameByMultiExit(Person person) {
        final String defaultValue = "UNKOWN";
        if (person == null)
            return defaultValue;
        Car car = person.getCar();
        if (null == null)
            return defaultValue;
        Insurance insurance = car.getInsurance();
        if (insurance == null)
            return defaultValue;
        return insurance.getName();
    }


}
