package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService queryServiceMaxProjectCountClient = new DatabaseQueryService();
        List<MaxProjectCountClient> maxProjectCountClients = queryServiceMaxProjectCountClient.findMaxProjectsClient();

        for (MaxProjectCountClient client : maxProjectCountClients) {
            System.out.println("Client Name: " + client.getName() + ", Project Count: " + client.getProjectCount());
        }

        System.out.println("==================================================");

        DatabaseQueryService queryServiceLongestMonthsProject = new DatabaseQueryService();
        List<LongestMonthsProject> longestMonthsProject = queryServiceLongestMonthsProject.findLongestProject();

        for (LongestMonthsProject project : longestMonthsProject) {
            System.out.println("Project Name: " + project.getName() + ", Month Count: " + project.getMonthCount());
        }

        System.out.println("==================================================");

        DatabaseQueryService queryServiceMaxSalaryAmountWorker = new DatabaseQueryService();
        List<MaxSalaryAmountWorker> maxSalaryAmountWorker = queryServiceMaxSalaryAmountWorker.findMaxSalaryWorker();

        for (MaxSalaryAmountWorker worker : maxSalaryAmountWorker) {
            System.out.println("Worker Name: " + worker.getName() + ", Salary Amount: " + worker.getSalaryAmount());
        }

        System.out.println("==================================================");

        DatabaseQueryService queryServiceYoungestEldestBirthdayWorkers = new DatabaseQueryService();
        List<YoungestEldestBirthdayWorkers> youngestEldestBirthdayWorkers = queryServiceYoungestEldestBirthdayWorkers.findYoungestEldestWorkers();

        for (YoungestEldestBirthdayWorkers worker : youngestEldestBirthdayWorkers) {
            System.out.println("Type: " + worker.getType() + ", Worker Name: " + worker.getName() + ", Birthday Date: " + worker.getBirthdayDate());
        }

        System.out.println("==================================================");

        DatabaseQueryService queryServicePrintProjectAmountPrices = new DatabaseQueryService();
        List<PrintProjectAmountPrices> printProjectAmountPrices = queryServicePrintProjectAmountPrices.findPrintProjectPrices();

        for (PrintProjectAmountPrices project : printProjectAmountPrices) {
            System.out.println("Project Name: " + project.getName() + ", Project Price: " + project.getPriceAmount());
        }
    }
}
