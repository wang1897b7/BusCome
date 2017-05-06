package com.wsd.sun.my_application;


public class Constants {
    public Constants() {
    }

    //统计相关
    /**
     * 全局统计代码
     */
    public static String sAllSc = "";

    /**
     *
     */
    public static String EXTRA_USER_CACHE="user_info";

    //extra-activity
    public static final String EXTRA_SELECT_CITY = "from";
    public static final String EXTRA_TYPE = "type";
    public static final String EXTRA_ID = "id";
    public static final String EXTRA_PREPARE_ID = "prepare_id";
    public static final String EXTRA_BILL_TYPE = "bill_type";
    public static final String EXTRA_SHOP_LIST = "shop_list";
    public static final String EXTRA_BUY_INSTANTLY = "buy_instantly";
    public static final String EXTRA_SHOP_ID = "shop_id";
    public static final String EXTRA_IDS = "ids";
    public static final String EXTRA_INFO_TITLE = "title";
    public static final String EXTRA_INFO_URL = "url";
    public static final String EXTRA_INFO_HIDE_BACK = "hideBack";
    public static final String EXTRA_EXPO_DETAIL = "expo_detail";
    public static final String EXTRA_EXPO_ID = "expo_id";
    public static final String EXTRA_SALE_ID = "sale_id";
    public static final String EXTRA_EXPO_ZXINGCODE = "code";
    public static final String EXTRA_EXPO_TYPE = "type";
    public static final String EXTRA_EXPO_IMAGES = "images";
    public static final String EXTRA_EXPO_MAP_LAT = "lat";
    public static final String EXTRA_EXPO_MAP_LNG = "lng";
    public static final String EXTRA_EXPO_ADDRESS = "shipping_id";
    public static final String EXTRA_EXPO_GOTOVIP = "vip";
    public static final String EXTRA_EXPO_NAME = "expo_name";
    public static final String EXTRA_MARKET_PROD_ID = "prod_id";
    public static final String EXTRA_MARKET_SKU_ID = "sku_id";
    public static final String EXTRA_MARKET_CAT_ID = "cat_id";
    public static final String EXTRA_MARKET_NEED_SELECT = "need_select";
    public static final String EXTRA_MARKET_KEY_WORDS = "key_words";
    public static final String EXTRA_SHOP_NAME = "shop_name";
    public static final String EXTRA_PERSONAL_MODIFYPHONE = "code";
    public static final String EXTRA_MAP_ADDRESS = "map_address";
    public static final String EXTRA_BILL_BILLTYPE = "type";
    public static final String EXTRA_BILL_BILLORDERID = "order_id";
    public static final String EXTRA_BILL_BILLORDERTYPE = "order_type";
    public static final String EXTRA_SC = "extra_sc";
    public static final String EXTRA_ACTIVITY_TITLE = "title";
    public static final String EXTRA_SHOP_LIST_STRING = "shop_list_string";
    public static final String EXTRA_COUPON_ACTIVITY_SC="sc";
    public static final String EXTRA_COUPON_ACTIVITY_ID="coupon";
    //extra_fragment
    public static final String EXTRA_SKU_ID = "sku_id";
    public static final String EXTRA_GOODS_DETAIL = "detail";
    public static final String EXTRA_WEB_URL = "url";
    public static final String EXTRA_WEB_NEED_BACK = "detail";
    public static final String EXTRA_MYBILL_TYPE = "type";
    public static final String EXTRA_OVERAGE_INFO = "info";
    public static final String EXTRA_QRCODE_URL = "url";


    public static final String EXTRA_EXPO_TITLE = "expo_title";

    /**
     * 提现
     */
    public static final String EXTRA_EXPO_UPDATA = "expo_ticket";
    public static final String EXTRA_WITHDRAW_MONEY = "money";
    public static final String EXTRA_WITHDRAW_PAYWAY = "payway";
    public static final String EXTRA_WITHDRAW_ACCOUNTID = "accountId";
    public static final String EXTRA_WITHDRAW_PAYACCOUNT = "pay_account";
    public static final String EXTRA_WITHDRAW_BALANCE= "balance";
    public static final String EXTRA_WITHDRAW_PAYMONEY= "pay_money";
    public static final String EXTRA_WITHDRAW_DEFAULTMONEY= "0.01";//默认充值提现金额为0.1
    public static final String EXTRA_WITHDRAW_WITHDRAWSHOW= "showMoney";//可提现金额
    public static final String EXTRA_WITHDRAW_WITHDRAWLIMIT= "limitMoney";//最少可金额
    public static final String EXTRA_HINT_MESSAGE = "message";
    /**
     * 支付方式
     */
    public static final int EXTRA_WITHDRAW_WITHDRAW_WECHAT=1;
    public static final int EXTRA_WITHDRAW_WITHDRAW_ALIPAY=2;

    public static final int EXTRA_UNSELECTOR=0;
    public static final int EXTRA_SELECTOR =1;

    public static final String  EXTRA_SHOP_INFO="info";

    public static final String  EXTRA_FOLLOW_TYPE="type";
    public static final String  EXTRA_FOLLOW_HISTORY="history";
    public static final String  EXTRA_FOLLOW_FOLLOW="follow";
    public static final String  EXTRA_FOLLOW_GOOFLIST="list";

    /**
     * 订单类型
     */
    public static final String  EXTRA_BILL_COMBO="COMBO";//套餐
    public static final String  EXTRA_BILL_PRESELL="PRESELL";//预订单

    /**
     *倒计时类型
     */
    public static final String EXTRA_HOMECOUNTDOWN2_TYPE = "item2";
    public static final String EXTRA_HOMECOUNTDOWN3_TYPE  = "item3";

    /**
     * 搜索页面 或者 全部商品
     */
    public static final int EXTRA_GOODS_SHOWUI_SEARCH = 1;//搜索界面
    public static final int EXTRA_GOODS_SHOWUI_GOODS = 2;//商品界面

    /**
     * 二维码请求的type
     */
    public static final String REQUEST_SCAN_TYPE="type";
    /**
     * 普通类型，扫完即关闭
     */
    public static final int REQUEST_SCAN_TYPE_COMMON=0;
    /**
     * 服务商登记类型，扫描
     */
    public static final int REQUEST_SCAN_TYPE_REGIST=1;


    /**
     * 扫描类型
     * 条形码或者二维码：REQUEST_SCAN_MODE_ALL_MODE
     * 条形码： REQUEST_SCAN_MODE_BARCODE_MODE
     * 二维码：REQUEST_SCAN_MODE_QRCODE_MODE
     *
     */
    public static final String REQUEST_SCAN_MODE="ScanMode";
    /**
     * 条形码： REQUEST_SCAN_MODE_BARCODE_MODE
     */
    public static final int REQUEST_SCAN_MODE_BARCODE_MODE = 0X100;
    /**
     * 二维码：REQUEST_SCAN_MODE_ALL_MODE
     */
    public static final int REQUEST_SCAN_MODE_QRCODE_MODE = 0X200;
    /**
     * 条形码或者二维码：REQUEST_SCAN_MODE_ALL_MODE
     */
    public static final int REQUEST_SCAN_MODE_ALL_MODE = 0X300;

    /**
     * webView 缓存路径
     */
    public static final String APP_CACAHE_DIRNAME = "/webviewCache";

}
