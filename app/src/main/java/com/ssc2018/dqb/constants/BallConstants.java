package com.ssc2018.dqb.constants;

/**
 * 作者：MrXu on 2017/12/27 11:02
 * 邮箱：17610872621@163.com
 */
public class BallConstants {
    public static String[] spf = {"主胜", "平", "客胜"};
    public static String[] spfNum = {"3", "1", "0"};
    public static String[] spfObbs = {"主胜$odds", "平$odds", "客胜$odds"};

    public static String[] bf = {"1:0", "2:0", "2:1", "3:0", "3:1", "3:2", "4:0", "4:1", "4:2", "5:0", "5:1", "5:2", "胜其他",
            "0:0", "1:1", "2:2", "3:3", "平其他",
            "0:1", "0:2", "1:2", "0:3", "1:3", "2:3", "0:4", "1:4", "2:4", "0:5", "1:5", "2:5", "负其他"};
    public static String[] bfNum = {"10", "20", "21", "30", "31", "32", "40", "41", "42", "50", "51", "52", "90",
            "00", "11", "22", "33", "99",
            "01", "02", "12", "03", "13", "23", "04", "14", "24", "05", "15", "25", "09"};

    public static String[] zjq = {"0", "1", "2", "3", "4", "5", "6", "7+"};
    public static String[] zjqNum = {"0", "1", "2", "3", "4", "5", "6", "7"};

    public static String[] bcq = {"胜胜", "胜平", "胜负", "平胜", "平平", "平负", "负胜", "负平", "负负"};
    public static String[] bcqNum = {"33", "31", "30", "13", "11", "10", "03", "01", "00"};

    public static String[] sf = {"客胜", "主胜"};
    public static String[] sfNum = {"0", "3"};
    public static String[] sfObbs = {"客胜$odds","主胜$odds"};


    public static String[] rfsf = {"让分客胜", "让分主胜"};
    public static String[] rfsfNum = {"0", "3"};
    public static String[] rfsfObbs = {"让分客胜$odds", "让分主胜$odds"};

    public static String[] dxf = {"大分", "小分"};
    public static String[] dxfNum = {"3", "0"};

    public static String[] sfc = {"客胜1-5", "客胜6-10", "客胜11-15", "客胜16-20", "客胜21-25", "客胜26+",
            "主胜1-5", "主胜6-10", "主胜11-15", "主胜16-20", "主胜21-25", "主胜26+",};

    public static String[] sfcNum = {"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12",};

    public static String[] betType = {"单关","2串1","3串1","4串1","5串1","6串1","7串1","8串1"};
    public static String[] betTypeFlag = {"1_1","2_1","3_1","4_1","5_1","6_1","7_1","8_1"};
    public static int[] betTypeNum = {1,2,3,4,5,6,7,8};

    //0负 1平 3胜
    public static Integer[] threeNum = {0,1, 2, 3, 4, 5, 6,
            7, 8, 9};

    public static String[] elevenFiveNum = {"01", "02", "03", "04", "05", "06",
            "07", "08", "09","10","11"};


    public static String FOOTBALL_ZB="http://nlive.159cai.com/live";
    public static String BASKETBALL_ZB="http://nlive.159cai.com/live/basketball";

}
