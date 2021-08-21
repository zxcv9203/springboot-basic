package org.prgrms.orderApp.CMDProgramForOrderApp.util;

import com.sun.tools.javac.Main;

public enum MainMenuPage {
    CREATE_VOUCHER(1, "CREATE_VOUCHER"),
    ALL_SHOW_VOUCHERS(2,"VOUCHER_LIST"),
    CREATE_ORDER(3,"CREATE_ORDER"),
    ALL_SHOW_ORDERS(4, "ORDER_LIST"),
    CONNECT_FILE_DB(5,"CONNECT_FILE_DB"),
    EXIT(6, "EXIT");


    private int menuNumber;
    private String menuName;

    MainMenuPage(int menuNumber, String menuName){
        this.menuNumber = menuNumber;
        this.menuName = menuName;
    }

    public String getMenuName(){
        return menuName;
    }

    public static String getMenuName(int menuNumber){
        if (menuNumber == MainMenuPage.CREATE_VOUCHER.menuNumber){
            return MainMenuPage.CREATE_VOUCHER.menuName;
        }else if(menuNumber == MainMenuPage.ALL_SHOW_VOUCHERS.menuNumber) {
            return MainMenuPage.ALL_SHOW_VOUCHERS.menuName;
        }else if(menuNumber == MainMenuPage.CREATE_ORDER.menuNumber){
            return MainMenuPage.CREATE_ORDER.menuName;
        }else if(menuNumber == MainMenuPage.ALL_SHOW_ORDERS.menuNumber){
            return MainMenuPage.CREATE_ORDER.menuName;
        }else if(menuNumber == MainMenuPage.CONNECT_FILE_DB.menuNumber){
            return MainMenuPage.CONNECT_FILE_DB.menuName;
        }else if(menuNumber == MainMenuPage.EXIT.menuNumber){
            return MainMenuPage.EXIT.menuName;
        }else {
            return "";
        }
    }

}
