//JAVAPRACTICAL EXAM -> CIA COMPONENT - II
//COURSE DETAILS -> PROGRAMMING IN JAVA - MCA272
//PROGRAM -> II

//AUTHOR -> SUVAJIT KARMAKAR
//REGISTRATION NUMBER -> 2347261

//DATE -> 12-12-23

import java.util.ArrayList;
import java.util.Scanner;

class Advertisement {
    static int counter = 1000;

    int advertisementId;
    String clientName;
    String startDate;

    Advertisement(String clientName, String startDate) {
        this.advertisementId = counter++;
        this.clientName = clientName;
        this.startDate = startDate;
    }
}

class Commercial_Add extends Advertisement {
    double sizeOfAdd;
    double pricePerCm;

    Commercial_Add(String clientName, String startDate, double sizeOfAdd, double pricePerCm) {
        super(clientName, startDate);
        this.sizeOfAdd = sizeOfAdd;
        this.pricePerCm = pricePerCm;
    }

    double addCost() {
        return sizeOfAdd * pricePerCm;
    }
}

class Free_Add extends Advertisement {
    int freeAddTimeDuration;

    Free_Add(String clientName, String startDate, int freeAddTimeDuration) {
        super(clientName, startDate);
        this.freeAddTimeDuration = freeAddTimeDuration;
    }
}

public class AdvertisementManagement {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        ArrayList<Advertisement> adsList = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("----------------------------- MENU ------------------------------------");
            System.out.println();
            System.out.println("OPTIONS ->");
            System.out.println("1. CREATE COMMERCIAL ADD");
            System.out.println("2. CREATE FREE ADD");
            System.out.println("3. DISPLAY COMMERCIAL ADD AND FREEE ADD DETAILS");
            System.out.println("4. DISPLAY ADD COST FOR A COMMERCIAL ADD");
            System.out.println("5. DISPLAY FREE ADDS WITH DURATION MORE THAN 3 MONTHS");
            System.out.println("6. DISPLAY TOTAL INCOME FROM COMMERCIAL ADDS");
            System.out.println("7. EXIT");
            System.out.println();
            System.out.println("----------------------------- MENU ------------------------------------");

            System.out.println();
            System.out.println("----------------------------- CHOICE ----------------------------------");
            System.out.print("ENTER YOUR CHOICE -> ");
            int choice = input.nextInt();
            System.out.println("----------------------------- CHOICE ----------------------------------");

            switch (choice) {
                case 1 -> {
                    System.out.println();
                    System.out.println("---------------------- CREATE COMMERCIAL ADD --------------------------");
                    System.out.println();
                    
                    System.out.print("ENTER CLIENT NAME:");
                    String commercialClientName = input.next();
                    System.out.print("ENTER START DATE:");
                    String commercialStartDate = input.next();
                    System.out.print("ENTER SIZE OF ADD IN CM: ");
                    double sizeOfAdd = input.nextDouble();
                    System.out.print("ENTER PRICE PER CM: ");
                    double pricePerCm = input.nextDouble();

                    Commercial_Add commercialAdd = new Commercial_Add(commercialClientName, commercialStartDate, sizeOfAdd, pricePerCm);
                    adsList.add(commercialAdd);

                    System.out.println();
                    System.out.println("---------------------- CREATE COMMERCIAL ADD --------------------------");
                    break;
                }


                case 2 -> {
                    System.out.println();
                    System.out.println("------------------------- CREATING FREE ADD ---------------------------");
                    System.out.println();
                    
                    System.out.print("ENTER CLIENT NAME: ");
                    String freeClientName = input.next();
                    System.out.print("ENTER START DATE: ");
                    String freeStartDate = input.next();
                    System.out.print("ENTER FREE ADD TIME DURATION IN MONTHS:");
                    int freeAddTimeDuration = input.nextInt();

                    Free_Add freeAdd = new Free_Add(freeClientName, freeStartDate, freeAddTimeDuration);
                    adsList.add(freeAdd);

                    System.out.println();
                    System.out.println("------------------------- CREATING FREE ADD ---------------------------");
                    break;
                }


                case 3 -> {
                    System.out.println();
                    System.out.println("----------- DISPLAYING COMMERCIAL ADD AND FREE ADD DETAILS ------------");
                    System.out.println();
                    
                    System.out.println("ADVERTISEMENT DETAILS ->");
                    System.out.println();
                    for (Advertisement ad : adsList) {
                        System.out.println("ADVERTISEMENT ID: " + ad.advertisementId);
                        System.out.println("CLIENT NAME: " + ad.clientName);
                        System.out.println("START DATE: " + ad.startDate);

                        if (ad instanceof Commercial_Add) {
                            Commercial_Add commercialAd = (Commercial_Add) ad;
                            System.out.println("SIZE OF THE ADVERTISEMENT: " + commercialAd.sizeOfAdd + " cm");
                            System.out.println("PRIZE PER CM: $" + commercialAd.pricePerCm);
                        } else if (ad instanceof Free_Add) {
                            Free_Add freeAd = (Free_Add) ad;
                            System.out.println("FREE ADD DURATION: " + freeAd.freeAddTimeDuration + " months");
                        }

                        System.out.println();
                    }

                    System.out.println();
                    System.out.println("----------- DISPLAYING COMMERCIAL ADD AND FREE ADD DETAILS ------------");
                    break;
                }


                case 4 -> {
                    System.out.println();
                    System.out.println("--------------- DISPLAYING ADD COST FOR A COMMERCIAL ADD --------------");
                    System.out.println();
                    
                    System.out.print("ENTER ADVERTISEMENT ID FOR COMMERCIAL ADD:");
                    int commercialAdId = input.nextInt();

                    for (Advertisement ad : adsList) {
                        if (ad instanceof Commercial_Add && ad.advertisementId == commercialAdId) {
                            Commercial_Add commercialAd = (Commercial_Add) ad;
                            System.out.println("ADVERTISEMENT ID: " + commercialAd.advertisementId);
                            System.out.println("CLIENT NAME: " + commercialAd.clientName);
                            System.out.println("START DATE: " + commercialAd.startDate);
                            System.out.println("COST OF COMMERCIAL ADD: $" + commercialAd.addCost());
                            break;
                        }
                    }

                    System.out.println();
                   System.out.println("--------------- DISPLAYING ADD COST FOR A COMMERCIAL ADD --------------");
                    break;
                }


                case 5 -> {
                    System.out.println();
                    System.out.println("-------- DISPLAYING FREE ADDS WITH DURATION MORE THAN 3 MONTHS --------");
                    System.out.println();

                    System.out.println("FREE ADDS WITH DURATION MORE THAN 3 MONTHS:");
                    for (Advertisement ad : adsList) {
                        if (ad instanceof Free_Add && ((Free_Add) ad).freeAddTimeDuration > 3) {
                            System.out.println("ADVERTISEENT ID: " + ad.advertisementId);
                            System.out.println("CLIENT NAME: " + ad.clientName);
                            System.out.println("START DATE: " + ad.startDate);
                            System.out.println("FREE ADD DURATION: " + ((Free_Add) ad).freeAddTimeDuration + " MONTHS");
                            System.out.println();
                        }
                    }

                    System.out.println();
                    System.out.println("-------- DISPLAYING FREE ADDS WITH DURATION MORE THAN 3 MONTHS --------");
                    break;
                }


                case 6 -> {
                    System.out.println();
                    System.out.println("-------------- DISPLAY TOTAL INCOME FROM COMMERCIAL ADDS --------------");
                    System.out.println();

                    double totalIncome = 0;
                    for (Advertisement ad : adsList) {
                        if (ad instanceof Commercial_Add) {
                            totalIncome += ((Commercial_Add) ad).addCost();
                        }
                    }
                    System.out.println("TOTAL INCOME FROM COMMERCIAL ADDS: $" + totalIncome);

                    System.out.println();
                    System.out.println("-------------- DISPLAY TOTAL INCOME FROM COMMERCIAL ADDS --------------");

                    break;
                }


                case 7 -> {
                    System.out.println();
                    System.out.println("-------------------------------- EXIT ---------------------------------");
                    System.out.println();

                    System.out.println("EXITING THE PROGRAM ...");

                    System.out.println();
                    System.out.println("-------------------------------- EXIT ---------------------------------");

                    input.close();
                    System.exit(0);

                }


                default -> {
                    System.out.println("INVALID CHOICE! PLEASE ENTER A VALID OPTION TO PROCEED.");
                }

            }
        }
    }
}

