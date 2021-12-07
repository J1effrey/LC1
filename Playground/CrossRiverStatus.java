package com.yyf.mock;

import java.util.*;


/**
 * @author j1effrey
 */
public class CrossRiverStatus {
    public static final int FARMER_INDEX = 0;
    public static final int FOX_INDEX = 1;
    public static final int CHICKEN_INDEX = 2;
    public static final int RICE_INDEX = 3;

    boolean[] bank1;
    boolean[] bank2;
    public CrossRiverStatus() {
        this.bank1 = new boolean[4];
        Arrays.fill(this.bank1, true);
        this.bank2 = new boolean[4];
    }

    public CrossRiverStatus(boolean[] bank1, boolean[] bank2) {
        this.bank1 = bank1;
        this.bank2 = bank2;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CrossRiverStatus crossRiverStatus = new CrossRiverStatus();
        System.out.println(isGoal(crossRiverStatus));
        System.out.println(isValid(crossRiverStatus));
//        System.out.println(getNextStatus(status));
        getNextStatus(crossRiverStatus).forEach(s -> {
            System.out.println(Arrays.toString(s.bank1));
            System.out.println(Arrays.toString(s.bank2));
            System.out.println("=================");
        });
    }


    public static boolean isGoal(CrossRiverStatus crossRiverStatus) {
        for (boolean flag : crossRiverStatus.bank2) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(CrossRiverStatus crossRiverStatus) {
        return isValidOnOneSide(crossRiverStatus.bank1) && isValidOnOneSide(crossRiverStatus.bank2);
    }

    public static boolean isValidOnOneSide(boolean[] bank) {
        if (bank[FARMER_INDEX]) {
            return true;
        } else {
            return !bank[CHICKEN_INDEX] || (!bank[FOX_INDEX] && !bank[RICE_INDEX]);
        }
    }

    public static List<CrossRiverStatus> getNextStatus(CrossRiverStatus crossRiverStatus) {
        List<CrossRiverStatus> crossRiverStatuses = new ArrayList<>();
        boolean[] from = crossRiverStatus.bank1[FARMER_INDEX] ? crossRiverStatus.bank1 : crossRiverStatus.bank2;
        boolean[] to = from == crossRiverStatus.bank1 ? crossRiverStatus.bank2 : crossRiverStatus.bank1;

        for (int i = 0; i < 4; i++) {
            if (!from[i]) {
                continue;
            }
            crossRiverStatuses.add(changeStatus(from, to, i));
        }
        return crossRiverStatuses;
    }

    public static CrossRiverStatus changeStatus(boolean[] from, boolean[] to, int itemIndex) {
        boolean[] fromCopy = Arrays.copyOf(from, 4);
        boolean[] toCopy = Arrays.copyOf(to, 4);
        fromCopy[FARMER_INDEX] = false;
        toCopy[FARMER_INDEX] = true;
        if (itemIndex != FARMER_INDEX) {
            fromCopy[itemIndex] = false;
            toCopy[itemIndex] = true;
        }
        return new CrossRiverStatus(fromCopy, toCopy);
    }
}
