package pl.coderslab.solution;

import pl.coderslab.DatabaseUtils;

import java.sql.*;
import java.util.Arrays;

public class SolutionDao {
    private static final String CREATE_USER_QUERY = "INSERT INTO solution(created, updated, description, exerciseid, usersid) VALUES (?, ?, ?, ?, ?)";
    private static final String READ_USER_QUERY = "SELECT * FROM solution where id = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE solution SET created = ?, updated = ?, description = ?, exerciseid = ?, usersid = ? where id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM solution";

    public Solution create(Solution solution) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpadated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExerciseId());
            statement.setInt(5, solution.getUsersId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Solution read(int id) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement = conn.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpadated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExerciseId(resultSet.getInt("exerxciseId"));
                solution.setUsersId(resultSet.getInt("exerxciseId"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Solution solution) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpadated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getId());
            statement.setInt(5, solution.getExerciseId());
            statement.setInt(5, solution.getUsersId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement = conn.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Solution[] addToArray(Solution s, Solution[] solutions) {
        Solution[] tmpSolutions = Arrays.copyOf(solutions, solutions.length + 1);
        tmpSolutions[solutions.length] = s;
        return tmpSolutions;
    }

    public Solution[] findAll() {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            Solution[] solutions = new Solution[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpadated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("descritpion"));
                solution.setExerciseId(resultSet.getInt("exerciseId"));
                solution.setUsersId(resultSet.getInt("usersId"));
                solutions = addToArray(solution, solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace(); return null;
        }
    }
}
