package com.hashedin.csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CSVReader {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String fileName = "/Users/santonayak/Downloads/NetfllixBingeWatch/src/main/resources/netflix.csv";
		List<Netflix> showList = new ArrayList<>();
//		String line = "";
//
//		BufferedReader reader = new BufferedReader(new FileReader(file));
//		while ((line = reader.readLine()) != null) {
//			String[] rows = line.split(",");
//			Netflix netflix = new Netflix(rows[0], rows[1], rows[2], rows[3], rows[4], rows[5], rows[6], rows[7],
//					rows[8], rows[9], rows[10], rows[11]);
//			showList.add(netflix);
//		}

		Path pathToFile = Paths.get(fileName);
		List<List<String>> results = null;
		try {
			results = Files.readAllLines(pathToFile)
					.stream()
					.map(line -> Arrays.asList(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 0;
		for (List<String> result : results) {
			if (i != 0) {
				showList.add(new Netflix(result.get(0),result.get(1),result.get(2),result.get(3),result.get(4),result.get(5),result.get(6),result.get(7),result.get(8),result.get(9),result.get(10),result.get(11)));
			}
			i++;
		}
			getInput(showList);
	}

	public static List<Netflix> filterBySearch(List<Netflix> list, String filter,String type) {
		if(type.equals("tv")) {
			return list.stream().filter(s -> s.getType().matches("(.*)" + filter + "(.*)")).collect(Collectors.toList());
		}else if(type.equals("horror")) {
			return list.stream().filter(s -> s.getName().matches("(.*)" + filter + "(.*)")).collect(Collectors.toList());
		}else if(type.equals("country")) {
			return list.stream().filter(s -> s.getCountry().equalsIgnoreCase(filter )).collect(Collectors.toList());
		}else if(type.equals("date")) {
			return list.stream().filter(s -> s.getDate_added().matches("(.*)" + filter + "(.*)")).collect(Collectors.toList());
		}else {
			return list.stream().filter(s -> s.getName().matches("(.*)" + filter + "(.*)")).collect(Collectors.toList());
		}
		
	}

	public static void printList(List<Netflix> list) {
		for (Netflix s : list) {
			System.out.println("[" + s.getCast() + "," + s.getCategory() + "," + s.getCountry() + ","
					+ s.getDate_added() + "," + s.getDescription() + "," + s.getDirector() + "," + s.getName() + ","
					+ s.getRelease_year() + "," + s.getSeason_code() + "," + s.getType() + "]");
		}
	}

	public static void getInput(List<Netflix> list) {
		System.out.println("Enter search criteria:");
		System.out.println("Find by TV show press 1");
		System.out.println("Find by Horror movie press 2");
		System.out.println("Find by movie country press 3");
		System.out.println("FInd by date: press 4");

		int nextInt = sc.nextInt();

		switch (nextInt) {

		case 1:
			System.out.println("Enter TV show :");
			String next = sc.next();
			List<Netflix> search = filterBySearch(list, next, "tv");
			printList(search);
			getInput(list);
			break;
		case 2:
			System.out.println("Enter Horror movie name :");
			String movie = sc.next();
			List<Netflix> list1 = filterBySearch(list, movie, "horror");
			printList(list1);
			getInput(list);
			break;
		case 3:
			System.out.println("Enter  country name :");
			String country = sc.next();
			List<Netflix> list2 = filterBySearch(list, country, "country");
			printList(list2);
			getInput(list);
			break;
		case 4:
			System.out.println("Enter  date  :");
			String date = sc.next();
			List<Netflix> list3 = filterBySearch(list, date, "date");
			printList(list3);
			getInput(list);
			break;
		default:
			getInput(list);
			break;
		}
	}
}
