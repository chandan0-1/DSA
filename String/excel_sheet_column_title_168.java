class Solution {
    public String convertToTitle(int columnNumber) {
        String s = "";
        int temp = 64;
        while (columnNumber > 26){
            int i = (columnNumber % 26);
            if (i == 0){
                s = (char)(temp + 26) + s;
                columnNumber /= 26;
                columnNumber--;
                continue;
                
            }else{
                i += 64;
            }
            s = (char)i + s;
            columnNumber /= 26;
        }
        if (columnNumber > 0){
            s = (char)(columnNumber + 64) + s;
        }
        return s;       
    }
}
