package com.example.hydroponics_major_project;

public class cropModel {

    private int id;
    private String cropName;
    private String cropType;
    private int MaxTemp;
    private int MinTemp;
    private int MaxPH;
    private int MinPH;
    private int MaxRH;
    private int MinRH;
    private int LightDuration;
    private int Nutrients;

    public cropModel(int id, String cropName, String cropType, int maxTemp, int minTemp, int maxPH, int minPH,
                        int maxRH, int minRH, int lightDuration, int nutrients) {
        this.id = id;
        this.cropName = cropName;
        this.cropType = cropType;
        MaxTemp = maxTemp;
        MinTemp = minTemp;
        MaxPH = maxPH;
        MinPH = minPH;
        MaxRH = maxRH;
        MinRH = minRH;
        LightDuration = lightDuration;
        Nutrients = nutrients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public int getMaxTemp() {
        return MaxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        MaxTemp = maxTemp;
    }

    public int getMinTemp() {
        return MinTemp;
    }

    public void setMinTemp(int minTemp) {
        MinTemp = minTemp;
    }

    public int getMaxPH() {
        return MaxPH;
    }

    public void setMaxPH(int maxPH) {
        MaxPH = maxPH;
    }

    public int getMinPH() {
        return MinPH;
    }

    public void setMinPH(int minPH) {
        MinPH = minPH;
    }

    public int getMaxRH() {
        return MaxRH;
    }

    public void setMaxRH(int maxRH) {
        MaxRH = maxRH;
    }

    public int getMinRH() {
        return MinRH;
    }

    public void setMinRH(int minRH) {
        MinRH = minRH;
    }

    public int getLightDuration() {
        return LightDuration;
    }

    public void setLightDuration(int lightDuration) {
        LightDuration = lightDuration;
    }

    public int getNutrients() {
        return Nutrients;
    }

    public void setNutrients(int nutrients) {
        Nutrients = nutrients;
    }
}
