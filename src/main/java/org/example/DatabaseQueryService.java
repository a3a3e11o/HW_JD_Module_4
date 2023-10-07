package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    Connection conn = Database.getInstance().getConnection();

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_projects_client.sql"));
            StringBuilder sqlStatement = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlStatement.append(line).append("\n");
            }

            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("CLIENT_NAME"));
                client.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                result.add(client);
            }

            resultSet.close();
            preparedStatement.close();
            reader.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<LongestMonthsProject> findLongestProject() {
        List<LongestMonthsProject> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sql/find_longest_project.sql"));
            StringBuilder sqlStatement = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlStatement.append(line).append("\n");
            }

            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LongestMonthsProject project = new LongestMonthsProject();
                project.setName(resultSet.getString("PROJECT_ID"));
                project.setMonthCount(resultSet.getInt("MONTH_COUNT"));
                result.add(project);
            }

            resultSet.close();
            preparedStatement.close();
            reader.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MaxSalaryAmountWorker> findMaxSalaryWorker() {
        List<MaxSalaryAmountWorker> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sql/find_max_salary_worker.sql"));
            StringBuilder sqlStatement = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlStatement.append(line).append("\n");
            }

            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MaxSalaryAmountWorker worker = new MaxSalaryAmountWorker();
                worker.setName(resultSet.getString("NAME"));
                worker.setSalaryAmount(resultSet.getInt("SALARY"));
                result.add(worker);
            }

            resultSet.close();
            preparedStatement.close();
            reader.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<YoungestEldestBirthdayWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestBirthdayWorkers> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sql/find_youngest_eldest_workers.sql"));
            StringBuilder sqlStatement = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlStatement.append(line).append("\n");
            }

            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                YoungestEldestBirthdayWorkers worker = new YoungestEldestBirthdayWorkers();
                worker.setType(resultSet.getString("TYPE"));
                worker.setName(resultSet.getString("NAME"));
                worker.setBirthdayDate(resultSet.getString("BIRTHDAY"));
                result.add(worker);
            }

            resultSet.close();
            preparedStatement.close();
            reader.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<PrintProjectAmountPrices> findPrintProjectPrices() {
        List<PrintProjectAmountPrices> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("sql/print_project_prices.sql"));
            StringBuilder sqlStatement = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlStatement.append(line).append("\n");
            }

            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PrintProjectAmountPrices project = new PrintProjectAmountPrices();
                project.setName(resultSet.getString("PROJECT_ID"));
                project.setPriceAmount(resultSet.getInt("PRICE"));
                result.add(project);
            }

            resultSet.close();
            preparedStatement.close();
            reader.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}