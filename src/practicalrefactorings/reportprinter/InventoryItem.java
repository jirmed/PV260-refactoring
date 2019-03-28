/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.reportprinter;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

import java.util.List;

public class InventoryItem implements Printable {

    public static final String TITLE = "ITEM    REPORT";
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

    public static void main(String[] args) {
        MyCompanyPrinter printer = new MyCompanyPrinter();
        System.out.println(printer.print(
                new InventoryItem("1", new BigDecimal("1.99"), asList("Red", "Blue"))));
    }

    @Override
    public String title() {
        return TITLE;
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

