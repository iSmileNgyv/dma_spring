package com.example.spring_maven;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCApi {
    private static final String connectionString = "jdbc:postgresql://localhost:5499/dma_db";

    public String createTable(@NotNull String tableName, @NotNull Map<String, String> fields) {
        StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        query.append(tableName).append(" (");

        for (Map.Entry<String, String> entry : fields.entrySet()) {
            query.append(entry.getKey()).append(" ").append(entry.getValue()).append(", ");
        }

        query.setLength(query.length() - 2);
        query.append(");");

        return query.toString();
    }

    public String dropTable(@NotNull String tableName) {
        return "DROP TABLE " + tableName;
    }

    public void insertRecord(Connection conn, String tableName, Map<String, Object> values) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(tableName).append(" (");

        for (String column : values.keySet()) {
            query.append(column).append(", ");
        }

        query.setLength(query.length() - 2);
        query.append(") VALUES (");

        for (int i = 0; i < values.size(); i++) {
            query.append("?, ");
        }

        query.setLength(query.length() - 2);
        query.append(");");

        try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            int index = 1;
            for (Object value : values.values()) {
                pstmt.setObject(index++, value);
            }
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        } catch (SQLException ex) {
            System.err.println("Error during INSERT: " + ex.getMessage());
        }
    }

    public void updateRecord(Connection conn, String tableName, Map<String, Object> updates, String condition) {
        StringBuilder query = new StringBuilder("UPDATE ");
        query.append(tableName).append(" SET ");

        for (String column : updates.keySet()) {
            query.append(column).append(" = ?, ");
        }

        query.setLength(query.length() - 2);
        query.append(" WHERE ").append(condition).append(";");

        try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            int index = 1;
            for (Object value : updates.values()) {
                pstmt.setObject(index++, value); 
            }
            pstmt.executeUpdate();
            System.out.println("Record updated successfully.");
        } catch (SQLException ex) {
            System.err.println("Error during UPDATE: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "dma_user", "123456789");
            Statement st = conn.createStatement();
            JDBCApi jdbcApi = new JDBCApi();
            Map<String, String> fields = new HashMap<>();
            fields.put("id", "SERIAL PRIMARY KEY");
            fields.put("name", "VARCHAR(255)");
            fields.put("age", "INTEGER");

            String createTableQuery = jdbcApi.createTable("student", fields);
            st.execute(createTableQuery);
            System.out.println("Table created");
            Map<String, Object> values = new HashMap<>();
            values.put("name", "John Doe");
            values.put("age", 30);
            jdbcApi.insertRecord(conn, "student", values);

            Map<String, Object> updates = new HashMap<>();
            updates.put("name", "Jane Doe");
            updates.put("age", 28);
            jdbcApi.updateRecord(conn, "student", updates, "id = 5");

            st.close();

        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
