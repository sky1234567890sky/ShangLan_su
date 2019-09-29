package com.cumulus.xts.paydemo;

/**
 * Created by xts on 2018/9/26.
 */

public class Bean {

    /**
     * code : 0
     * desc :
     * result : {"sign":"app_id=2017071807800448&method=alipay.trade.app.pay&version=1.0&format=JSON&charset=utf8&sign_type=RSA2&timestamp=2018-09-26%2010%3A57%3A36&notify_url=https%3A%2F%2Fapi.banmi.com%2Fapi%2Fapp%2Fv3%2Fpayments%2Falibaba&biz_content=%7B%22subject%22%3A%22%E4%BC%B4%E7%B1%B3%E6%97%85%E8%A1%8C%22%2C%22out_trade_no%22%3A%22APP1537930656210ALIPAY761401%22%2C%22total_amount%22%3A%221.00%22%2C%22timeout_express%22%3A%2215m%22%7D&sign=RSzjxs6A4ZuRQEwcVACozcdMjD4R2DywNHEZh8FZlpCMzmonGTFU1perEhgWEQrEOuyOHoUZJgqoXSiigA0Dztwwaj3j%2Fmmdpbvj9Gep%2FoRpO88PGmjAnYayARH6Nz3U2SSCMjM1DhquNIpFxfRoTN4%2BSIwh10idaitiVe%2BEu0PG3xwe1Q%2F2SbXN%2B4J0ntthDCa%2F8fzHnbO3NQygXN6DAhd%2Bb3f9FOukwn2VHRk0NGNwXG5Dlhev9pM0QGJDWobRyqhTB0zxtLKvDXoUrt57jc%2FMXOaZGgxon1dxsYuduDs5M5jHsWbSxcoAYSWPfAqbqGi90jh3tFI2UpesBmkFEA%3D%3D","id":9458}
     */

    private int code;
    private String desc;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sign : app_id=2017071807800448&method=alipay.trade.app.pay&version=1.0&format=JSON&charset=utf8&sign_type=RSA2&timestamp=2018-09-26%2010%3A57%3A36&notify_url=https%3A%2F%2Fapi.banmi.com%2Fapi%2Fapp%2Fv3%2Fpayments%2Falibaba&biz_content=%7B%22subject%22%3A%22%E4%BC%B4%E7%B1%B3%E6%97%85%E8%A1%8C%22%2C%22out_trade_no%22%3A%22APP1537930656210ALIPAY761401%22%2C%22total_amount%22%3A%221.00%22%2C%22timeout_express%22%3A%2215m%22%7D&sign=RSzjxs6A4ZuRQEwcVACozcdMjD4R2DywNHEZh8FZlpCMzmonGTFU1perEhgWEQrEOuyOHoUZJgqoXSiigA0Dztwwaj3j%2Fmmdpbvj9Gep%2FoRpO88PGmjAnYayARH6Nz3U2SSCMjM1DhquNIpFxfRoTN4%2BSIwh10idaitiVe%2BEu0PG3xwe1Q%2F2SbXN%2B4J0ntthDCa%2F8fzHnbO3NQygXN6DAhd%2Bb3f9FOukwn2VHRk0NGNwXG5Dlhev9pM0QGJDWobRyqhTB0zxtLKvDXoUrt57jc%2FMXOaZGgxon1dxsYuduDs5M5jHsWbSxcoAYSWPfAqbqGi90jh3tFI2UpesBmkFEA%3D%3D
         * id : 9458
         */

        private String sign;
        private int id;

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
