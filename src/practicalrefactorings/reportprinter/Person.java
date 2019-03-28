/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.reportprinter;

import java.io.PrintStream;
import java.math.BigDecimal;

import static java.util.Arrays.asList;

import java.util.List;

public class Person implements Printable {

    public static final String TITLE = "PERSON REPORT";
    private String id;
    private String name;
    private List<String> jobs;

    public Person(String id, String name, List<String> jobs) {
        this.id = id;
        this.name = name;
        this.jobs = jobs;
    }

    public void doWork() {
        //some regular responsibility of the person
    }

    public void getPaid(BigDecimal money) {
        //other person specific responsibility
    }

    public static void main(String[] args) {
        MyCompanyPrinter printer = new MyCompanyPrinter();
        System.out.println(printer.print(
                new Person("1", "Pete", asList("CEO", "Janitor"))));
    }

    @Override
    public String title() {
        return TITLE;
    }

    @Override
    public String print() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NAME: " + name + '\n');
        stringBuilder.append("ID  : " + id + '\n');
        stringBuilder.append("JOBS:" + '\n');
        for (String job : jobs) {
            stringBuilder.append("    -" + job + '\n');
        }
        return stringBuilder.toString();
    }


}
