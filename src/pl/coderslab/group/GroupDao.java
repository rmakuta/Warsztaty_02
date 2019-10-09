package pl.coderslab.group;

import pl.coderslab.DatabaseUtils;

import java.sql.*;
import java.util.Arrays;

public class GroupDao {
    private static final String CREATE_GROUP_QUERY = "INSERT INTO user_group(name) VALUES (?)";
    private static final String READ_GROUP_QUERY = "SELECT * FROM user_group where id = ?";
    private static final String UPDATE_GROUP_QUERY = "UPDATE user_group SET name = ? where id = ?";
    private static final String DELETE_GROUP_QUERY = "DELETE FROM user_group WHERE id = ?";
    private static final String FIND_ALL_GROUPS_QUERY = "SELECT * FROM user_group";

    public Group create(Group group) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Group read(int id) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement = conn.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Group group) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            PreparedStatement statement = conn.prepareStatement(DELETE_GROUP_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Group[] addToArray(Group g, Group[] groups) {
        Group[] tmpGroups = Arrays.copyOf(groups, groups.length + 1);
        tmpGroups[groups.length] = g;
        return tmpGroups;
    }

    public Group[] findAll() {
        try (Connection conn = DatabaseUtils.getConnection("java-warsztat-02")) {
            Group[] groups = new Group[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_GROUPS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
                groups = addToArray(group, groups);
            }
            return groups;
        } catch (SQLException e) {
            e.printStackTrace(); return null;
        }
    }
}
