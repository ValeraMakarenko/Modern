package by.modern.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public final class StringUtils {

    private StringUtils() {
        throw new AssertionError("Class contains static methods only. You should not instantiate it!");
    }

    public static String getRandomString(List<String> allNameImageList) {
        String randomString;
        do {
            randomString = RandomStringUtils.randomAlphanumeric(16);
        }
        while (existRandomStringInStringList(randomString, allNameImageList));
        return randomString;
    }

    private static boolean existRandomStringInStringList(String randomString, List<String> stringList) {
        return stringList.stream().anyMatch(randomString::equalsIgnoreCase);
    }
}
