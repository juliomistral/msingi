package org.cleanarchitecture.test.runners;


import java.lang.reflect.Method;

public class RSpecTestNameGenerator {
    public static String generateTestName(Method method) {
        String methodName = method.getName();
        StringBuffer output = new StringBuffer();

        boolean isFirstCharactor = true;
        for (char currentChar : methodName.toCharArray()) {
            if (isFirstCharactor) {
                currentChar = Character.toUpperCase(currentChar);
                isFirstCharactor = false;
            } else if (Character.isUpperCase(currentChar)) {
                currentChar = Character.toLowerCase(currentChar);
                output.append(' ');
            }

            output.append(currentChar);
        }

        return output.toString();
    }

}
