/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalrefactorings.reportprinter;

import java.util.Date;

public class MyCompanyPrinter implements Printer {

	@Override
	public String print(Printable subject) {
		StringBuilder output = new StringBuilder();
		output.append("/------------------------------------\\\n");
		output.append("|            PERSON REPORT           |\n");
		output.append("\\------------------------------------/\n");
		output.append("   Some company logo here\n");
		output.append("   Some contact info here\n");
		output.append("   Date: " + new Date() + "\n");
		output.append(">------------------------------------<\n");
		output.append(subject.print());
		output.append(">------------------------------------<\n");
		output.append("   Some confidentiality notice\n");
		output.append("   Some more super important info\n");
		return output.toString();
	}

}
