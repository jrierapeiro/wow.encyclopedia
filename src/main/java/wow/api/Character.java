package wow.api;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Character {
    private Date lastModified;
    private String name;
    private String realm;
    private String battlegroup;
    private String thumbnail;
    private String calcClass;
    private Integer classType;
    private Integer race;
    private Integer gender;
    private Integer level;
    private Integer achievementPoints;
    private Integer totalHonorableKills;
    private Integer faction;

    public Character() {
        // Jackson deserialization
    }

    @JsonProperty
    public Date getLastModified() {
        return lastModified;
    }

    @JsonProperty
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getRealm() {
        return realm;
    }

    @JsonProperty
    public void setRealm(String realm) {
        this.realm = realm;
    }

    @JsonProperty
    public String getBattlegroup() {
        return battlegroup;
    }

    @JsonProperty
    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    @JsonProperty
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty
    public String getCalcClass() {
        return calcClass;
    }

    @JsonProperty
    public void setCalcClass(String calcClass) {
        this.calcClass = calcClass;
    }

    @JsonProperty("class")
    public Integer getClassType() {
        return classType;
    }

    @JsonProperty("class")
    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    @JsonProperty
    public Integer getRace() {
        return race;
    }

    @JsonProperty
    public void setRace(Integer race) {
        this.race = race;
    }

    @JsonProperty
    public Integer getGender() {
        return gender;
    }

    @JsonProperty
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonProperty
    public Integer getLevel() {
        return level;
    }

    @JsonProperty
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty
    public Integer getAchievementPoints() {
        return achievementPoints;
    }

    @JsonProperty
    public void setAchievementPoints(Integer achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    @JsonProperty
    public Integer getTotalHonorableKills() {
        return totalHonorableKills;
    }

    @JsonProperty
    public void setTotalHonorableKills(Integer totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }

    @JsonProperty
    public Integer getFaction() {
        return faction;
    }

    @JsonProperty
    public void setFaction(Integer faction) {
        this.faction = faction;
    }
}
