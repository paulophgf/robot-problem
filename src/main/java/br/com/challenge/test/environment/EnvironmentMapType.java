package br.com.challenge.test.environment;

public enum EnvironmentMapType {

    MAP_1("Map1.txt"),
    MAP_2("Map2.txt"),
    MAP_3("Map3.txt"),
    MAP_4("Map4.txt"),
    MAP_5("Map5.txt");

    private String filePath;

    EnvironmentMapType(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

}
