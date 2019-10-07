package pl.coderslab.solution;

import java.util.Date;

public class Solution {
    private int id;
    private String created;
    private String upadated;
    private String description;
    private int exerciseId;
    private int usersId;

    public Solution() {
    }

    public Solution(String created, String upadated, String description, int exerciseId, int usersId) {
        this.created = created;
        this.upadated = upadated;
        this.description = description;
        this.exerciseId = exerciseId;
        this.usersId = usersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpadated() {
        return upadated;
    }

    public void setUpadated(String upadated) {
        this.upadated = upadated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", created=" + created +
                ", upadate=" + upadated +
                ", description='" + description + '\'' +
                ", exerciseid=" + exerciseId +
                ", usersid=" + usersId +
                '}';
    }
}
