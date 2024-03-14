package com.abs.wfs.workman.util;

import com.abs.wfs.workman.util.code.WorkManScenarioList;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class FisCommonUtil {


    public static String generateClientName(String groupName, String siteName, String envType, String processSeq){
        return String.format("%s-%s-%s-", groupName, siteName, envType) + String.format("%04d", Integer.valueOf(processSeq) );
    }

    public static String generateObjKey(){
        String keyValueString = null;
        UUID uuid = UUID.randomUUID();
        String randomUuidString = uuid.toString();
        keyValueString = CommonDate.getCurrentDateTimeToString() + "-" + randomUuidString;
        return keyValueString;
    }


    public static String[] extractColumns(String query) {
        String regex = "\\((.*?)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(query);

        if (matcher.find()) {
            String columnSection = matcher.group(1);
            String[] columns = columnSection.split("\\s*,\\s*");
            for (int i = 0; i < columns.length; i++) {
                columns[i] = columns[i].replaceAll("\\s", ""); // Remove all whitespaces
            }
            return columns;
        } else {
            return new String[0]; // Pattern not found, return an empty array
        }
    }

    // , 와 - 로 입력된 값들을 하나의 배열로 변환 ex) B,D,F-H > B,D,F,G,
    // TODO 전체선택 (*)도 여기서 대응
    public static String[] parsingArrayStringValues(String info) {
        String[] ps = null;
        String result = "";

        if (info.indexOf(",") != -1 && info.indexOf("-") != -1) {
            // header info 에 ',' 와  '-' 함께 있을 때
            ps = info.split(",");
            String[] split = null;
            for(int i = 0 ; i < ps.length ; i ++) {
                String oldInfo = ps[i];
                String newInfo = "";
                if( oldInfo.indexOf("-") != -1 ) {
                    // , ,의 값 사이에 있는   - 영역을 파싱 해옴
                    split = FisCommonUtil.parsingRangeInfos(oldInfo);

                    // 파싱해 온 값을 해당 열에 , 어레이 String 으로 저장
                    for (String c : split) {
                        newInfo += c.concat(",");
                    }

                    result += newInfo;
                } else {
                    result += oldInfo+",";
                }

//                log.info("******************************* "+oldInfo);
//                log.info("++++++++++++++++++++++++++++++ "+newInfo);
//                log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ "+result);
            }

            result = result.substring(0, result.length()-1);
            log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+result);
            // 변경 저장된 값으로 다시 나눔
            ps = result.split(",");
            // haeder info를 다시 String으로

        } else if ( info.indexOf(",") != -1 ) {

            // header info ',' 를 배열로 나눔,
            ps = info.split(",");

        } else if ( info.indexOf("-") != -1 ) {

            // header info 에 - 만 있을 경우
            ps = FisCommonUtil.parsingRangeInfos(info);

        } else {
            log.error("## Not Informations param : "+info);
        }

        return ps;
    }

    // 문자열 파싱 컬럼 정보를 정수의 순차 정보로 변경하여 배열 변환 - 컬럼 정보 배열화 할 때에만
    public static int[] columnSequence(String[] parsingTitles) {
        int[] colSeqs = new int[parsingTitles.length];

        for (int i=0 ; i < parsingTitles.length ; i++ ) {
            colSeqs[i] = (int)parsingTitles[i].charAt(0) - (int)'A';
        }

        return colSeqs;
    }

    public static int[] setRowNumList(String[] parsingRows) {
        int[] rowList = new int[parsingRows.length];

        for ( int i = 0 ; i< parsingRows.length ; i++ )
            rowList[i] = Integer.valueOf(parsingRows[i]);

        return rowList;
    }

    // 값이 a-g 일 때 a ~ g 까지의  값을 모두 갖는 문자 배열을 리턴함  - 컬럼정보, 로우정보 둘다 배열화 할 때
    private static String[] parsingRangeInfos(String info) {
        // 'AD-AG' 값을 array[] = {'D', '-', 'G'} 로 변환 info = 'D-G' , '0-10000'

        log.info(">> "+info);
        String[] infos = info.split("-");

        int size = 0;
        String[] result = null;

        // 정수 String
        try  {
            int parsIntS = Integer.parseInt( infos[0] );
            int parsIntE = Integer.parseInt(infos[1]);

            log.info(">> parsIntS "+parsIntS+" parsIntE "+parsIntE);
            size =  parsIntE - parsIntS;
            log.info(">> size "+size);
            result = new String[size];

            for ( int i = 0 ; i < size ; i++) {
                result[i] = i+Integer.valueOf(infos[0])+"";
            }
        } catch (NumberFormatException nfe) {
            // 알파벳 일 때,
            int s = cvsCmlStrToInt(infos[0]);
            int e = cvsCmlStrToInt(infos[1])+1;
            size = e - s;
            result = new String[size];
            for (int i = s ; i < e ; i++) {
                result[i-s] = cvsCmlIntToStr( i );
            }
        }

        return result;
    }

    private static int cvsCmlStrToInt(String clm) {
        int val = 0;
        for (char ch : clm.toUpperCase().toCharArray())
            val = val * 26 + (ch -'A'+1);
        return val;
    }

    private static String cvsCmlIntToStr(int val) {
        String str = "";
        while ( val > 0 ) {
            int idx = (val - 1) % 26;
            str = (char)(idx + 'A') + str;
            val = ( val -1 )/ 26;
        }

        return str;
    }

    public static boolean isNumber(String str) {
        return str!=null && str.matches("[0-9.]+");// str.matches("[-+]?\\d#\\.?\\d+");
    }

    // 파일 유형당 쿼리 생성

    public static int changeClmTitlVal(String clmVal) {
        int input, aVal = Integer.valueOf('A'), num = 0;
        int cycleMax = Integer.valueOf('Z') - aVal;

        if (clmVal.length() < 2 ) {
            input = Integer.valueOf( clmVal.charAt(0) );
            num = input - aVal;
        } else {
            int val0 = Integer.valueOf( clmVal.charAt(0));
            int val1 = Integer.valueOf( clmVal.charAt(1));

            for (int i = 0 ; i < val0-aVal ; i ++ ) {
                num += cycleMax;
            }
            num += (val1-aVal)+1;
        }

        return num;
    }


    public static boolean checkDataInList(int[] dataTypeList, int val) {

        if ( dataTypeList != null ) {
            for (int i = 0 ; i < dataTypeList.length ; i ++) {
                if ( dataTypeList[i] == val)
                    return true;
                else
                    continue;
            }
        }
        return false;
    }


    public static int[] convertToIntArray(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        int[] intArray = new int[size];

        for (int i = 0; i < size; i++) {
            intArray[i] = arrayList.get(i);
        }

        return intArray;
    }
    public static String convertDateFormat(String inputDate) {

        log.info(inputDate);

        try {
            // Parse the input date string
//			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
//			Date parsedDate = inputFormat.parse(inputDate);

            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date parsedDate = inputFormat.parse(inputDate);

            // Format the date into the desired format
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDate = outputFormat.format(parsedDate);

            // Print the formatted date
            log.info(formattedDate);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Timestamp stringToTimestamp(String value) throws ParseException {

        Timestamp timestamp = Timestamp.valueOf(value);

        return timestamp;

    }


    public static void main(String[] args) {

//    	String str = "123abc456def";
//
//        // 정규식을 사용하여 숫자를 찾습니다.
//        boolean containsNumber = str.matches(".*[a-zA-Z].*");
//        System.out.println("test 1 : " +containsNumber); // true
//
//        // 숫자로 변환할 수 있는지 확인합니다.
//        boolean canParseNumber = Integer.parseInt(str) != 0;
//        System.out.println(canParseNumber); // true

        for (int i = 0 ; i < 26; i++ )
            System.out.println(generateObjKey());
    }



}
