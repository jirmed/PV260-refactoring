/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.reportprinter;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

import java.util.Date;
import java.util.List;

public class InventoryItem implements Printable {

    private String id;
    private BigDecimal price;
    private List<String> colors;

    public InventoryItem(String id, BigDecimal price, List<String> colors) {
        this.id = id;
        this.price = price;
        this.colors = colors;
    }

    public void sellOne() {
        //item specific responsibility
    }

    public void printItem() {
        System.out.println("/------------------------------------\\");
        System.out.println("|            ITEM   REPORT           |");
        System.out.println("\\------------------------------------/");
        System.out.println("   Some company logo here");
        System.out.println("   Some contact info here");
        System.out.println("   Date: " + new Date());
        System.out.println(">------------------------------------<");
        System.out.println("ID    : " + id);
        System.out.println("PRICE : " + price);
        System.out.println("COLORS:");
        for (String color : colors) {
            System.out.println("    -" + color);
        }
        System.out.println(">------------------------------------<");
        System.out.println("   Some confidentiality notice");
        System.out.println("   Some more super important info");
    }

    public static void main(String[] args) {
        MyCompanyPrinter printer = new MyCompanyPrinter();
        System.out.println(printer.print(
                new InventoryItem("1", new BigDecimal("1.99"), asList("Red", "Blue"))));
    }

    @Override
    public String print() {
        StringBuilder output = new StringBuilder();
        output.append("ID    : " + id + "\n");
        output.append("PRICE : " + price + "\n");
        output.append("COLORS:" + "\n");
        for (String color : colors) {
            output.append("    -" + color + "\n");
        }
        return output.toString();
    }
}

