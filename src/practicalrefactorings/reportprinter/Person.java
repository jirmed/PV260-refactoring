/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.reportprinter;

import java.io.PrintStream;
import java.math.BigDecimal;

import static java.util.Arrays.asList;

import java.util.Date;
import java.util.List;

public class Person implements Printable {

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

    public void printPerson() {
        System.out.println("/------------------------------------\\");
        System.out.println("|            PERSON REPORT           |");
        System.out.println("\\------------------------------------/");
        System.out.println("   Some company logo here");
        System.out.println("   Some contact info here");
        System.out.println("   Date: " + new Date()) ;
        System.out.println(">------------------------------------<");
        System.out.print(print());
        System.out.println(">------------------------------------<");
        System.out.println("   Some confidentiality notice");
        System.out.println("   Some more super important info");
    }

    public static void main(String[] args) {
        MyCompanyPrinter printer = new MyCompanyPrinter();
        System.out.println(printer.print(
                new Person("1", "Pete", asList("CEO", "Janitor"))));
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
