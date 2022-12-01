package br.com.challenge.test.environment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public final class EnvironmentGenerator {

    public static Integer[][] getInstance(EnvironmentMapType mapType) {
        return readMapFile(mapType);
    }

    private static Integer[][] readMapFile(EnvironmentMapType environmentMapType) {
        Integer[][] map = null;
        try {
            InputStream inputStream = getFileFromResourceAsStream(environmentMapType.getFilePath());
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            List<String> lines = reader.lines().collect(Collectors.toList());
            int countY = lines.size();
            int countX = lines.stream().findFirst().get().length();
            map = createMatrix(lines, countX, countY);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem to read map: " + environmentMapType.name());
        }
        return map;
    }

    private static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = EnvironmentGenerator.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    private static Integer[][] createMatrix(List<String> lines, int countX, int countY) {
        Integer[][] map = new Integer[countY][countX];;
        for(int y=0; y<countY; y++) {
            char[] columns = lines.get(y).toCharArray();
            for(int x=0; x<countX; x++) {
                map[y][x] = Integer.parseInt(new Character(columns[x]).toString());
            }
        }
        return map;
    }

}
