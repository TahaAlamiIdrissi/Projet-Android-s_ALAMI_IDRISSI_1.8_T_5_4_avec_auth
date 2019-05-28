package com.example.newSpriteGame.dummygame.Database;

import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;

public class GameAssets {
    private String app_id;
    private String exercice_id;
    private String level_id;
    private String game_date_id;
    private String successful_attempts;
    private String failed_attempts;
    private String min_tim_succed;
    private String avg_tim_succed;
    private String longitude;
    private String lattitude;
    private String device;
    private String flag;

    public GameAssets(String app_id, String exercice_id, String level_id, String game_date_id, String successful_attempts, String failed_attempts, String min_tim_succed, String avg_tim_succed, String longitude, String lattitude, String device, String flag) {
        this.app_id = app_id;
        this.exercice_id = exercice_id;
        this.level_id = level_id;
        this.game_date_id = game_date_id;
        this.successful_attempts = successful_attempts;
        this.failed_attempts = failed_attempts;
        this.min_tim_succed = min_tim_succed;
        this.avg_tim_succed = avg_tim_succed;
        this.longitude = longitude;
        this.lattitude = lattitude;
        this.device = device;
        this.flag = flag;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getExercice_id() {
        return exercice_id;
    }

    public void setExercice_id(String exercice_id) {
        this.exercice_id = exercice_id;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getGame_date_id() {
        return game_date_id;
    }

    public void setGame_date_id(String game_date_id) {
        this.game_date_id = game_date_id;
    }

    public String getSuccessful_attempts() {
        return successful_attempts;
    }

    public void setSuccessful_attempts(String successful_attempts) {
        this.successful_attempts = successful_attempts;
    }

    public String getFailed_attempts() {
        return failed_attempts;
    }

    public void setFailed_attempts(String failed_attempts) {
        this.failed_attempts = failed_attempts;
    }

    public String getMin_tim_succed() {
        return min_tim_succed;
    }

    public void setMin_tim_succed(String min_tim_succed) {
        this.min_tim_succed = min_tim_succed;
    }

    public String getAvg_tim_succed() {
        return avg_tim_succed;
    }

    public void setAvg_tim_succed(String avg_tim_succed) {
        this.avg_tim_succed = avg_tim_succed;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public GameStat returnGameAssets(){
        GameStat gameStat = new GameStat();

        gameStat.setApp_id(getApp_id());
        gameStat.setExercise_id(getExercice_id());
        gameStat.setLevel_id(getLevel_id());
        gameStat.setUpdated_at("none");
        gameStat.setCreated_at("none");
        gameStat.setGame_date_id("a");
        gameStat.setSuccessful_attempts(String.valueOf(getSuccessful_attempts()));
        gameStat.setFailed_attempts(String.valueOf(getFailed_attempts()));
        gameStat.setMin_time_succeed_sec("none");
        gameStat.setAvg_time_succeed_sec("none");
        gameStat.setLongitude("none");
        gameStat.setLatitude("none");
        gameStat.setDevice("none");
        gameStat.setFlag("none");
        return gameStat;
    }
}
