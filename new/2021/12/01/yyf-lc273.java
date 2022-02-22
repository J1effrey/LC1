// T: O(N)
// S: O(1) extra space

class Solution {
    public String numberToWords(int num) {
        if (num < 0) {
            return "";
        }        
        
        if (num == 0) {
            return "Zero";
        }
        
        int billion = num / 1000000000;
        
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000 ;
        int remain = num - billion * 1000000000 - million * 1000000 - thousand * 1000;
        
        StringBuilder sb = new StringBuilder();
        
        if (billion != 0) {
            sb.append(convertB(billion));
        }
        
        if (million != 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(convertM(million));
        }
        
        if (thousand != 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(convertT(thousand));
        }
        
        if (remain != 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(convertThreeDigits(remain));
        }
        
        return sb.toString();
    }
    
    private String convertB(int billion) {
        if (billion == 0) {
            return "";
        }
        
        return convertThreeDigits(billion) + " Billion";
    }
    
    private String convertM(int million) {
        if (million == 0) {
            return "";
        }
        
        return convertThreeDigits(million) + " Million";
    }
    
    private String convertT(int thousand) {
        if (thousand == 0) {
            return "";
        }
        
        return convertThreeDigits(thousand) + " Thousand";
    }
    
    private String convertThreeDigits(int num) {
        int hundred = num / 100;
        int remain = num - hundred * 100;
        
        if (hundred == 0) {
            return convertTwoDigits(remain);
        } 
        
        if (hundred > 0 && remain == 0) {
            return convertOneDigit(hundred) + " Hundred";
        }
        
        return convertOneDigit(hundred) + " Hundred " + convertTwoDigits(remain);
    }
    
    private String convertTwoDigits(int num) {
        int ten = num / 10;
        int remain = num - ten * 10;
        
        if (ten == 0) {
            return convertOneDigit(remain);
        }  
        
        if (ten == 1) {
            return convertLessThanTwenty(num);
        }
        
        if (ten > 1 && remain == 0) {
           return convertMoreThanTwenty(ten);
        } 
        
        return convertMoreThanTwenty(ten) + " " + convertOneDigit(remain);
    }
    
    private String convertMoreThanTwenty(int num) {
        switch(num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5: 
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "";
        }
    }
    
    private String convertLessThanTwenty(int num) {
        switch(num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            default:
                return "";
        }
    }
    
    private String convertOneDigit(int num) {
        switch(num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }
}

/*
class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String words = "";
        int i = 0;
        while (num != 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            } 
            num /= 1000;
            i++;
        }
        return words.trim();
    }
    
    public String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
*/
