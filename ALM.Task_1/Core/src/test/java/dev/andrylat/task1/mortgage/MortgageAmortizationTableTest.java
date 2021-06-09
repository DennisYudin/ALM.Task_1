package dev.andrylat.task1.mortgage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.andrylat.task1.domain.Data;

class MortgageAmortizationTableTest {
    Table amortizationTable = new MortgageAmortizationTable();
    
    @Test
    void printTable_ShouldPrintAmortizationTable_WhenInputIs() {
        
        StringBuilder expected = new StringBuilder();
        
        expected.append("Month: 1 Startingbalance: 25 000,00 ₽ Monthly Payment: 599,55 ₽ Interest: 125,00 ₽ Principal: 474,55 ₽ Endingbalance: 24 525,45 ₽").append("\n");
        expected.append("Month: 2 Startingbalance: 24 525,45 ₽ Monthly Payment: 599,55 ₽ Interest: 122,63 ₽ Principal: 476,92 ₽ Endingbalance: 24 048,53 ₽").append("\n");
        expected.append("Month: 3 Startingbalance: 24 048,53 ₽ Monthly Payment: 599,55 ₽ Interest: 120,24 ₽ Principal: 479,31 ₽ Endingbalance: 23 569,22 ₽").append("\n");
        expected.append("Month: 4 Startingbalance: 23 569,22 ₽ Monthly Payment: 599,55 ₽ Interest: 117,85 ₽ Principal: 481,70 ₽ Endingbalance: 23 087,52 ₽").append("\n");
        expected.append("Month: 5 Startingbalance: 23 087,52 ₽ Monthly Payment: 599,55 ₽ Interest: 115,44 ₽ Principal: 484,11 ₽ Endingbalance: 22 603,40 ₽").append("\n");
        expected.append("Month: 6 Startingbalance: 22 603,40 ₽ Monthly Payment: 599,55 ₽ Interest: 113,02 ₽ Principal: 486,53 ₽ Endingbalance: 22 116,87 ₽").append("\n");
        expected.append("Month: 7 Startingbalance: 22 116,87 ₽ Monthly Payment: 599,55 ₽ Interest: 110,58 ₽ Principal: 488,97 ₽ Endingbalance: 21 627,90 ₽").append("\n");
        expected.append("Month: 8 Startingbalance: 21 627,90 ₽ Monthly Payment: 599,55 ₽ Interest: 108,14 ₽ Principal: 491,41 ₽ Endingbalance: 21 136,49 ₽").append("\n");
        expected.append("Month: 9 Startingbalance: 21 136,49 ₽ Monthly Payment: 599,55 ₽ Interest: 105,68 ₽ Principal: 493,87 ₽ Endingbalance: 20 642,63 ₽").append("\n");
        expected.append("Month: 10 Startingbalance: 20 642,63 ₽ Monthly Payment: 599,55 ₽ Interest: 103,21 ₽ Principal: 496,34 ₽ Endingbalance: 20 146,29 ₽").append("\n");
        expected.append("Month: 11 Startingbalance: 20 146,29 ₽ Monthly Payment: 599,55 ₽ Interest: 100,73 ₽ Principal: 498,82 ₽ Endingbalance: 19 647,47 ₽").append("\n");
        expected.append("Month: 12 Startingbalance: 19 647,47 ₽ Monthly Payment: 599,55 ₽ Interest: 98,24 ₽ Principal: 501,31 ₽ Endingbalance: 19 146,16 ₽").append("\n");
        expected.append("Month: 13 Startingbalance: 19 146,16 ₽ Monthly Payment: 599,55 ₽ Interest: 95,73 ₽ Principal: 503,82 ₽ Endingbalance: 18 642,34 ₽").append("\n");
        expected.append("Month: 14 Startingbalance: 18 642,34 ₽ Monthly Payment: 599,55 ₽ Interest: 93,21 ₽ Principal: 506,34 ₽ Endingbalance: 18 136,00 ₽").append("\n");
        expected.append("Month: 15 Startingbalance: 18 136,00 ₽ Monthly Payment: 599,55 ₽ Interest: 90,68 ₽ Principal: 508,87 ₽ Endingbalance: 17 627,13 ₽").append("\n");
        expected.append("Month: 16 Startingbalance: 17 627,13 ₽ Monthly Payment: 599,55 ₽ Interest: 88,14 ₽ Principal: 511,41 ₽ Endingbalance: 17 115,72 ₽").append("\n");
        expected.append("Month: 17 Startingbalance: 17 115,72 ₽ Monthly Payment: 599,55 ₽ Interest: 85,58 ₽ Principal: 513,97 ₽ Endingbalance: 16 601,75 ₽").append("\n");
        expected.append("Month: 18 Startingbalance: 16 601,75 ₽ Monthly Payment: 599,55 ₽ Interest: 83,01 ₽ Principal: 516,54 ₽ Endingbalance: 16 085,20 ₽").append("\n");  
        expected.append("Month: 19 Startingbalance: 16 085,20 ₽ Monthly Payment: 599,55 ₽ Interest: 80,43 ₽ Principal: 519,12 ₽ Endingbalance: 15 566,08 ₽").append("\n"); 
        expected.append("Month: 20 Startingbalance: 15 566,08 ₽ Monthly Payment: 599,55 ₽ Interest: 77,83 ₽ Principal: 521,72 ₽ Endingbalance: 15 044,36 ₽").append("\n"); 
        expected.append("Month: 21 Startingbalance: 15 044,36 ₽ Monthly Payment: 599,55 ₽ Interest: 75,22 ₽ Principal: 524,33 ₽ Endingbalance: 14 520,03 ₽").append("\n"); 
        expected.append("Month: 22 Startingbalance: 14 520,03 ₽ Monthly Payment: 599,55 ₽ Interest: 72,60 ₽ Principal: 526,95 ₽ Endingbalance: 13 993,08 ₽").append("\n"); 
        expected.append("Month: 23 Startingbalance: 13 993,08 ₽ Monthly Payment: 599,55 ₽ Interest: 69,97 ₽ Principal: 529,58 ₽ Endingbalance: 13 463,50 ₽").append("\n"); 
        expected.append("Month: 24 Startingbalance: 13 463,50 ₽ Monthly Payment: 599,55 ₽ Interest: 67,32 ₽ Principal: 532,23 ₽ Endingbalance: 12 931,27 ₽"); 

        int principal = 25_000;
        float annualInterest = 6;
        byte years = 2;
        double monthlyPayment = 599.55;
        
        Data data = new Data(monthlyPayment, principal, annualInterest, years);
                    
        StringBuilder actual = amortizationTable.printTable(data);
        
        assertEquals(expected.toString(), actual.toString());   
    }    
}

