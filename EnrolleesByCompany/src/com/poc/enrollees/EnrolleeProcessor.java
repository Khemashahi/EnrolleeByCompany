package com.poc.enrollees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EnrolleeProcessor {

	public void seperateEnrollesByCompanyName(String inputFile, String outputDir) throws FileNotFoundException {
        Map<String, List<Enrollee>> enrolleesByInsurance = new TreeMap<>();

        try (Scanner scanner = new Scanner(new File(inputFile))) {
			String header = scanner.nextLine();
        	String line;
        	while (scanner.hasNextLine()) {
				String[] columns = scanner.nextLine().split(",");
				String userId = columns[0];
				String firstAndLastName = columns[1];
				Integer version = Integer.parseInt(columns[2]);
				String insuranceCompany = columns[3];
                Enrollee enrollee = new Enrollee(userId, firstAndLastName,  version, insuranceCompany);

                if (!enrolleesByInsurance.containsKey(insuranceCompany)) {
                    enrolleesByInsurance.put(insuranceCompany, new ArrayList<>());
                }
                enrolleesByInsurance.get(insuranceCompany).add(enrollee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, List<Enrollee>> entry : enrolleesByInsurance.entrySet()) {
            String insuranceCompany = entry.getKey();
            List<Enrollee> enrollees = entry.getValue();
            Collections.sort(enrollees);

            Map<String, Enrollee> uniqueEnrollees = new LinkedHashMap<>();
            for (Enrollee enrollee : enrollees) {
            	 uniqueEnrollees.put(enrollee.getUserId(), enrollee);
            }

            String outputFile = outputDir+File.separatorChar+ insuranceCompany + ".csv";
            System.out.println();
            System.out.println("\t*** "+outputFile+" ***");
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write("User ID,First and Last Name, Version,Insurance Company\n");
                for (Enrollee enrollee : uniqueEnrollees.values()) {
                    writer.write(enrollee.toString() + "\n");
                    System.out.println("\t"+enrollee.toString());
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   
}
